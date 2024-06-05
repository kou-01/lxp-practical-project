package com.digitalojt.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalojt.web.entity.StockInfo;

/**
 * 商品情報リポジトリー
 *
 * @author kijima
 * 
 */
@Repository
public interface StockInfoRepository extends JpaRepository<StockInfo, String> {
  @SuppressWarnings("null")
  Page<StockInfo> findAll(Pageable pageable);
}
