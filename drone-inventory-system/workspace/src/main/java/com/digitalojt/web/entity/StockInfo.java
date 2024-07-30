package com.digitalojt.web.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 在庫情報Entity
 * 
 * @author kijima
 *
 */
@Data
@Entity
@Getter
@Setter
public class StockInfo {

	/**
	 * 在庫ID
	 */
	@Id
	private int stockId;

	/**
	 * 在庫名
	 */
	private String name;

	/**
	 * 在庫分類
	 */
	private String classification;

	/**
	 * 在庫説明
	 */
	private String description;

	/**
	 * 在庫個数
	 */
	private int amount;

	/**
	 * 在庫保管ID
	 */
	private String placeId;

	/**
	 * 論理削除フラグ
	 */
	private String deleteFlag;

	/**
	 * 更新日
	 */
	private Timestamp updateDate;

	/**
	 * 登録日
	 */
	private Timestamp createDate;
}
