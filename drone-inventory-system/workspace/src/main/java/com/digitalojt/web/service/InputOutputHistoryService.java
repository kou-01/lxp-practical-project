package com.digitalojt.web.service;

import java.util.List;
import java.util.stream.Collectors;
import java.text.SimpleDateFormat;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digitalojt.web.entity.InputOutputHistory;
import com.digitalojt.web.entity.StockInfo;
import com.digitalojt.web.repository.InputOutputHistoryRepository;
import com.digitalojt.web.service.dto.InputOutputHistoryDto;

@Service
public class InputOutputHistoryService {

    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy/MM/dd");

    @Autowired
    private InputOutputHistoryRepository repository;

    public List<InputOutputHistoryDto> findAll() {
        List<InputOutputHistory> histories = repository.findAll();
        return histories.stream().map(this::convertToDTO)
                .sorted(Comparator.comparingInt(InputOutputHistoryDto::getHistoryId)).collect(Collectors.toList());
    }

    @Autowired
    private StockListService stockListService;

    private InputOutputHistoryDto convertToDTO(InputOutputHistory history) {
        InputOutputHistoryDto dto = new InputOutputHistoryDto();
        dto.setHistoryId(history.getHistoryId());
        String stockIdString = String.valueOf(history.getStockId());
        StockInfo stockInfo = stockListService.getStockById(stockIdString);
        dto.setStockName(stockInfo != null ? stockInfo.getName() : "不明");
        dto.setAmount(history.getAmount());
        dto.setDate(DATE_FORMAT.format(history.getDate()));
        dto.setStatus(history.getStatus());
        return dto;
    }

    public void save(InputOutputHistory history) {
        repository.save(history);
    }
}
