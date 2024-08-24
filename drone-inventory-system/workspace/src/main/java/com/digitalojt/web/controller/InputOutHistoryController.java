package com.digitalojt.web.controller;

import java.util.List;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalojt.web.entity.InputOutputHistory;
import com.digitalojt.web.entity.StockInfo;
import com.digitalojt.web.service.InputOutputHistoryService;
import com.digitalojt.web.service.StockListService;
import com.digitalojt.web.service.dto.InputOutputHistoryDto;

@Controller
@RequestMapping("history")
public class InputOutHistoryController extends AbstractController {

	private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

	@Autowired
	private InputOutputHistoryService inputOutputHistoryService;

	/**
	 * 出庫管理
	 */
	@GetMapping("/out")
	public String getOutHistories(Model model) {
		List<InputOutputHistoryDto> dtoList = inputOutputHistoryService.findAll();
		model.addAttribute("outHistories", dtoList);
		return "inputouthistory/out";
	}

	@Autowired
	private StockListService stockListService;

	/**
	 * 申請登録画面表示
	 */
	@GetMapping("/register")
	public String getInputOutRegister(Model model) {
		List<StockInfo> stockInfoList = stockListService.getStockListData();
		model.addAttribute("stockInfoList", stockInfoList);
		return "inputouthistory/register";
	}

	/**
	 * 申請登録
	 */
	@PostMapping("/register")
	public String setInputOutRegister(Model model,
			@RequestParam("stockId") int stockId,
			@RequestParam("date") String date,
			@RequestParam("amount") int amount) {

		// 1以上であるかチェック
		if (amount < 1) {
			model.addAttribute("error", "数量は1以上の整数で入力してください。");
			List<StockInfo> stockInfoList = stockListService.getStockListData();
			model.addAttribute("stockInfoList", stockInfoList);
			// stockIdが存在するかチェック
			boolean stockExists = stockInfoList.stream().anyMatch(stock -> stock.getStockId() == stockId);
			model.addAttribute("selectedStockId", stockExists ? stockId : null);
			model.addAttribute("enteredDate", date);
			return "inputouthistory/register";
		}
		InputOutputHistory newEntry = new InputOutputHistory();

		newEntry.setStockId(stockId);
		newEntry.setAmount(amount);
		try {
			Timestamp timestamp = new Timestamp(DATE_FORMAT.parse(date).getTime());
			newEntry.setDate(timestamp);
		} catch (ParseException e) {
			model.addAttribute("error", "日付の形式が正しくありません。");
			List<StockInfo> stockInfoList = stockListService.getStockListData();
			model.addAttribute("stockInfoList", stockInfoList);
			// stockIdが存在するかチェック
			boolean stockExists = stockInfoList.stream().anyMatch(stock -> stock.getStockId() == stockId);
			model.addAttribute("selectedStockId", stockExists ? stockId : null);
			model.addAttribute("enteredAmount", amount);

			return "inputouthistory/register";
		}

		newEntry.setInOutIndex("1");
		newEntry.setStatus("0");
		newEntry.setDeleteFlag("0");
		newEntry.setCreateDate(new Timestamp(System.currentTimeMillis()));
		newEntry.setUpdateDate(new Timestamp(System.currentTimeMillis()));

		// エンティティをデータベースに保存
		inputOutputHistoryService.save(newEntry);

		return "redirect:/history/out";
	}
}
