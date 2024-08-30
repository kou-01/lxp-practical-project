package com.digitalojt.web.service.dto;

import lombok.Data;

@Data
public class InputOutputHistoryDto {
  private int historyId;
  private String stockName;
  private int amount;
  private String date;
  private String status;
}
