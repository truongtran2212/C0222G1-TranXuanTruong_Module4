package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CurrentServiceImpl implements  CurrentService{
    @Override
    public double current(String usd) {
        double vnd = Double.parseDouble(usd) * 23000;
        return vnd;
    }
}
