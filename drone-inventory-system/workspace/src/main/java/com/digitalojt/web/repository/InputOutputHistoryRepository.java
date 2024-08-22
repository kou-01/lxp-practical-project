package com.digitalojt.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.digitalojt.web.entity.InputOutputHistory;

@Repository
public interface InputOutputHistoryRepository extends JpaRepository<InputOutputHistory, Integer> {
    
}
