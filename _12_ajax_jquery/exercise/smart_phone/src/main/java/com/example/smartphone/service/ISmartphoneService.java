package com.example.smartphone.service;

import com.example.smartphone.model.Smartphone;

import java.util.Optional;

public interface ISmartphoneService {
    Iterable<Smartphone> findAll();

    Smartphone findById(Long id);

    Smartphone save(Smartphone smartPhone);

    void remove(Long id);
}
