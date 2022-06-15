package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorServiceImpl implements CalculatorService {

    @Override
    public double calculator(double firstNumber, double secondNumber, char check) {
        switch (check) {
            case '+':
                return firstNumber + secondNumber;

            case '-':
                return firstNumber - secondNumber;

            case '*':
                return firstNumber * secondNumber;

            case '/':
                if (secondNumber != 0) {
                    return firstNumber / secondNumber;
                } else {
                    throw new RuntimeException("Calculation Invalid ");
                }
            default:
                throw new RuntimeException("Calculation Invalid ");
        }
    }
}
