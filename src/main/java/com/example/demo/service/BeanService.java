package com.example.demo.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class BeanService {
    @Value("${localData.name}")
    private String name;
}
