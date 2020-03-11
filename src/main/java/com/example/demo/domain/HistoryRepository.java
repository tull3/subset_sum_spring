package com.example.demo.domain;

import org.springframework.data.repository.CrudRepository;

public interface HistoryRepository extends CrudRepository<History, Long> {
    History findFirstByTotalAndList(String total, String list);
}