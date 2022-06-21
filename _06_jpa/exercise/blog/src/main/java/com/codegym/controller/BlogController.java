package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.BlogDto;
import com.codegym.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping("/list")
    private String showListBlog(Model model) {
        model.addAttribute("blogList", blogService.findAll());
        return "list";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("blogDto", new BlogDto());
        return "create";
    }

    @PostMapping("/create")
    private String create(BlogDto blogDTO) {
        blogService.create(blogDTO.getContent());
        blogService.create(blogDTO.getTitle(), blogDTO.getCreateDay());
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    private String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    private String delete(Blog blog) {
        blogService.delete(blog.getId());
        return "redirect:/list";
    }

    @GetMapping("/{id}/update")
    private String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    private String update(BlogDto blogDTO, Blog blog) {
        blogService.update(blogDTO.getTitle(), blogDTO.getContent(), blogDTO.getCreateDay(), blog.getId());
        return "redirect:/list";
    }
}
