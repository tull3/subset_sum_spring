package com.example.demo.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;

@Data
@Entity
public class History {
    @Id
    @GeneratedValue
    private Long id;
    private String total;
    private String list;
    @Lob
    private String result;
}