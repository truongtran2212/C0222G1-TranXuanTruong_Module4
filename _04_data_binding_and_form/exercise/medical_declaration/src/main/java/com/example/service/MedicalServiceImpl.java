package com.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedicalServiceImpl implements MedicalService {

    @Override
    public List<Integer> year() {
        List<Integer> year = new ArrayList<>();
        year.add(1990);
        year.add(1991);
        year.add(1992);
        year.add(1993);
        year.add(1994);
        year.add(1995);
        year.add(1996);
        year.add(1997);
        year.add(1998);
        year.add(1999);
        return year;
    }

    @Override
    public List<String> gender() {
        List<String> gender = new ArrayList<>();

        gender.add("Nam");
        gender.add("Nữ");

        return gender;
    }

    @Override
    public List<String> nationality() {
        List<String> nationality = new ArrayList<>();

        nationality.add("Việt Nam");
        nationality.add("Trung Quốc");
        nationality.add("Hàn Quốc");
        nationality.add("Nhật Bản");
        nationality.add("Mỹ");
        nationality.add("Anh");

        return nationality;
    }

}
