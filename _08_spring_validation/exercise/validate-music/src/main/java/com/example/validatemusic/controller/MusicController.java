package com.example.validatemusic.controller;

import com.example.validatemusic.model.Music;
import com.example.validatemusic.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping("/list")
    public String showListMusic(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        model.addAttribute("musicList", musicService.findAll(PageRequest.of(page, 2)));
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(name = "music") Music music, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "create";
        }
        musicService.create(music.getNameMusic(), music.getSinger(), music.getTypeMusic());
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute(name = "music") Music music, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "update";
        }
        musicService.update(music.getNameMusic(), music.getSinger(), music.getTypeMusic(), music.getId());
        return "redirect:/list";
    }
}
