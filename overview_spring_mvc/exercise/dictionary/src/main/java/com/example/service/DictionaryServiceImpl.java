package com.example.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
@Service
public class DictionaryServiceImpl implements DictionaryService {

    static Map<String, String> dictionary = new LinkedHashMap<>();

    static {
        dictionary.put("cat", "mèo");
        dictionary.put("dog", "chó");
        dictionary.put("duck", "vịt");
        dictionary.put("fish", "cá");
        dictionary.put("frog", "ếch");

    }
    @Override
    public String getDictionary(String word) {
        if(dictionary.get(word) != null){
            return dictionary.get(word);
        }else{
            return "Can't find word";
        }
    }
}
