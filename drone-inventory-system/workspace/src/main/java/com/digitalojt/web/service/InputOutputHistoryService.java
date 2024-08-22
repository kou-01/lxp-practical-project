package com.digitalojt.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.digitalojt.web.entity.InputOutputHistory;
import com.digitalojt.web.repository.InputOutputHistoryRepository;

@Service
public class InputOutputHistoryService {

    @Autowired
    private InputOutputHistoryRepository repository;

    public List<InputOutputHistory> findAll() {
        return repository.findAll();
    }
}
