package com.digitalojt.web.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

        @Query("SELECT s FROM StockInfo s WHERE " +
                        "(:classification IS NULL OR s.classification = :classification) AND " +
                        "(:name IS NULL OR s.name LIKE %:name%) AND " +
                        "(:amount IS NULL OR s.amount <= :amount)")
        Page<StockInfo> findByCriteria(@Param("classification") String classification,
                        @Param("name") String name,
                        @Param("amount") Integer amount,
                        Pageable pageable);
}
