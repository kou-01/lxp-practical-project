package com.digitalojt.web.form;

import lombok.Getter;
import lombok.Setter;

/**
 * 在庫一覧画面 フォームクラス
 * 
 * @author kijima
 *
 */
@Getter
@Setter
public class StockListForm {
  private String classification;
  private String name;
  private Integer amount;

  public boolean isEmpty() {
    return (classification == null || classification.isEmpty()) &&
        (name == null || name.isEmpty()) &&
        (amount == null);
  }
}
