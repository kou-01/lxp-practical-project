package com.digitalojt.web.entity;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@Getter
@Setter
public class InputOutputHistory {
    
    /**
     * 履歴ID
     */
    @Id
    private int historyId;
    
    /**
     * 在庫ID
     */
    private int stockId;

    /**
     * 入出庫インデックス
     */
    private String inOutIndex;

    /**
     * 数量
     */
    private int amount;

    /**
     * 日付
     */
    private Timestamp date;

    /**
     * 承認ステータス
     */
    private String status;

    /**
     * 削除フラグ
     */
    private String deleteFlag;

    /**
     * 作成日付
     */
    private Timestamp createDate;

    /**
     * 更新日付
     */
    private Timestamp updateDate;
    
}
