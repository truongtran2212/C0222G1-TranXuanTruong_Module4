package com.codegym._11_spring_data_repository_json.controller;

import com.codegym._11_spring_data_repository_json.model.BlogDto;
import com.codegym._11_spring_data_repository_json.model.Blog;

import com.codegym._11_spring_data_repository_json.model.Category;
import com.codegym._11_spring_data_repository_json.service.BlogDetailService;
import com.codegym._11_spring_data_repository_json.service.BlogService;
import com.codegym._11_spring_data_repository_json.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogDetailService blogDetailService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list")
    private ResponseEntity<Page<Blog>> showListBlog(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("create_day");
        Page<Blog> list = blogService.findAllBlog(PageRequest.of(page, 10, sort));
        if (list.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/create")
    private String showFormCreate(Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blogDto", new BlogDto());
        return "create";
    }

    @PostMapping("/create")
    private ResponseEntity<?> create(@RequestBody BlogDto blogDTO) {
        blogDetailService.createDetail(blogDTO.getContent());
        int idDetail = blogDetailService.findAllBlogDetail().size();
        blogService.create(blogDTO.getTitle(), blogDTO.getCreateDay(), idDetail, blogDTO.getIdCategory());

        //Gửi lại cho @GetMapping("/list")
        return new ResponseEntity<>(blogDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}/delete")
    private String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("blog", blogService.findById(id));
        return "delete";
    }

    @DeleteMapping("{id}/delete")
    private ResponseEntity<Blog> delete(@PathVariable int id) {
        Blog blog = blogService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogService.delete(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);

    }

    @GetMapping("/{id}/update")
    private String showUpdate(@PathVariable int id, Model model) {
        model.addAttribute("categoryList", categoryService.findAll());
        model.addAttribute("blog", blogService.findById(id));
        return "update";
    }

    @PutMapping("{id}/update")
    private ResponseEntity<Blog> update(@PathVariable int id, @RequestBody BlogDto blogDTO) {
        Blog blog = blogService.findById(id);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        blogService.update(blogDTO.getTitle(), blogDTO.getCreateDay(), blog.getCategory().getId(), blog.getId());

        //Gửi lại cho @GetMapping("/list")
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<Category>> showCategory() {
//        model.addAttribute("categoryList", categoryService.findAll());
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/search")
    private String search(@RequestParam(name = "page", defaultValue = "0") int page, String title, Model model) {
        model.addAttribute("blogList", blogService.search(title, PageRequest.of(page, 2)));
        return "list";
    }

    // Sử dụng onchange ở category.html
    @GetMapping("/searchCategory/{idCategory}")
    private ResponseEntity<Page<Blog>> searchCategory(@RequestParam(name = "page", defaultValue = "0") int page,
                                                      @PathVariable(name = "idCategory") int idCategory) {
        Page<Blog> blogPage = blogService.searchCategory(idCategory, PageRequest.of(page, 10));
        if (blogPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogPage, HttpStatus.OK);
    }

    @GetMapping("/detail/{idCategory}")
    private ResponseEntity<Blog> detail(@PathVariable(name = "idCategory") int idCategory) {

        Blog blog = blogService.findById(idCategory);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
