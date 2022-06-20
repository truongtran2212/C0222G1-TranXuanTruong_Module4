package cg.wbd.grandemonstration.controller;

import cg.wbd.grandemonstration.model.Music;
import cg.wbd.grandemonstration.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MusicController {
    @Autowired
    private MusicService musicService;

    @GetMapping
    public String showListMusic(Model model) {
        model.addAttribute("musicList", musicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    //
    @PostMapping("/create")
    public String create(Music music) {
        musicService.create(music);
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music music) {
        musicService.delete(music.getId());
        return "redirect:/list";
    }

    @GetMapping("/{id}/update")
    public String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(Music music) {
        musicService.update(music);
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(String nameSinger, Model model) {
        model.addAttribute("musicList", musicService.search(nameSinger));
        return "list";
    }
}
