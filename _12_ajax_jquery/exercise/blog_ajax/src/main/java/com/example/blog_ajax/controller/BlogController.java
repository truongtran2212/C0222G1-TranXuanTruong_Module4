package com.example.blog_ajax.controller;

import com.example.blog_ajax.model.Blog;
import com.example.blog_ajax.model.BlogDto;
import com.example.blog_ajax.service.BlogDetailService;
import com.example.blog_ajax.service.BlogService;
import com.example.blog_ajax.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogDetailService blogDetailService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    private String showListBlog(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("create_day");
        Page<Blog> list = blogService.findAllBlog(PageRequest.of(page, 1, sort));
        model.addAttribute("blogList", list);
        return "list";
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blogDto", new BlogDto());
        return "create";
    }

    @PostMapping("/create")
    private String create(BlogDto blogDTO) {
        blogDetailService.createDetail(blogDTO.getContent());
        int idDetail = blogDetailService.findAllBlogDetail().size();
        blogService.create(blogDTO.getTitle(), blogDTO.getCreateDay(), idDetail, blogDTO.getIdCategory());

        //Gửi lại cho @GetMapping("/list")
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

        //Gửi lại cho @GetMapping("/list")
        return "redirect:/list";
    }

    @GetMapping("/{id}/update")
    private String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    private String update(BlogDto blogDTO, Blog blog) {
        blogService.update(blogDTO.getTitle(), blogDTO.getCreateDay(), blog.getCategory().getId(), blog.getId());

        //Gửi lại cho @GetMapping("/list")
        return "redirect:/list";
    }

    @GetMapping
    private String showCategory(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        return "category";
    }

    @GetMapping("/search")
    private String search(@RequestParam(name = "page", defaultValue = "0") int page, String title, Model model) {
        model.addAttribute("blogList", blogService.search(title, PageRequest.of(page, 2)));
        return "list";
    }

    // Sử dụng onchange ở category.html
    @GetMapping("/searchCategory")
    private String searchCategory(@RequestParam(name = "page", defaultValue = "0") int page,
                                  @RequestParam(name = "idCategory") int idCategory, Model model) {
        model.addAttribute("blogList", blogService.searchCategory(idCategory, PageRequest.of(page, 2)));
        return "list";
    }
}
