package com.digitalojt.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalojt.web.entity.StockInfo;
import com.digitalojt.web.service.StockListService;

/**
 * 在庫一覧画面 コントローラークラス
 * 
 * @author kijima
 *
 */
@Controller
@RequestMapping("admin")
public class StockListController extends AbstractController {

	@Autowired
	private StockListService stockListService;

	/**
	 * 初期表示
	 * 
	 * @return String(path)
	 */
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("stockList", stockListService.getStockListData());
		return "admin/home/index";
	}

	/**
	 * 在庫一覧表示（ページング機能）
	 * 
	 * @return String(path)
	 */
	@GetMapping("/stocks")
	public String listStocks(Model model,
			@RequestParam(value = "page", defaultValue = "0") int page,
			@RequestParam(value = "size", defaultValue = "10") int size) {
		Page<StockInfo> stockPage = stockListService.getStocks(page, size);
		model.addAttribute("stockPage", stockPage);
		model.addAttribute("size", size);
		return "admin/home/stockList";
	}
}
