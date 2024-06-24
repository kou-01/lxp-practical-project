package com.digitalojt.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.digitalojt.web.entity.StockInfo;
import com.digitalojt.web.repository.StockInfoRepository;
// import com.digitalojt.web.service.dto.StockListDto;

/**
 * 在庫一覧画面 サービスクラス
 * 
 * @author kijima
 *
 */
@Service
public class StockListService {

	@Autowired
	private StockInfoRepository repository;

	/**
	 * 在庫一覧画面に表示するデータを一括取得
	 * 
	 * @return
	 */
	public List<StockInfo> getStockListData() {
		return repository.findAll();
	}

	/**
	 * 在庫一覧画面に表示するデータを一括取得
	 * 
	 * @param page 取得するページ番号
	 * @param size 1ページあたりのデータ件数
	 * @return
	 */
	public Page<StockInfo> getStocks(int page, int size) {
		return repository.findAll(PageRequest.of(page, size));
	}

	public Page<StockInfo> searchStocks(int page, int size, String classification, String name, Integer amount) {
		return repository.findByCriteria(classification, name, amount, PageRequest.of(page, size));
	}
}
