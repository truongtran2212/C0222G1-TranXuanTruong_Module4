package com.example.controller;

import com.example.service.DictionaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    @Autowired
    private DictionaryService dictionaryService;
    @GetMapping
    public String showList(){
        return "list";
    }

    @PostMapping("/dictionary")
    public String dictionary(@RequestParam(name = "word") String word, Model model){
        model.addAttribute("translate", dictionaryService.getDictionary(word));
        model.addAttribute("english", word);
        return "list";
    }
}
