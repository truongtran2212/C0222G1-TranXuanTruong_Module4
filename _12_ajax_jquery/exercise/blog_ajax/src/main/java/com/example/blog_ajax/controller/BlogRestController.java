package com.example.blog_ajax.controller;

import com.example.blog_ajax.model.Blog;
import com.example.blog_ajax.model.BlogDto;
import com.example.blog_ajax.model.Category;
import com.example.blog_ajax.service.BlogDetailService;
import com.example.blog_ajax.service.BlogService;
import com.example.blog_ajax.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @Autowired
    private BlogDetailService blogDetailService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/list-blog")
    private ResponseEntity<List<Blog>> showListBlog() {

        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<?> create(@RequestBody BlogDto blogDTO) {
        blogDetailService.createDetail(blogDTO.getContent());
        int idDetail = blogDetailService.findAllBlogDetail().size();
        blogService.create(blogDTO.getTitle(), blogDTO.getCreateDay(), idDetail, blogDTO.getIdCategory());

        //Gửi lại cho @GetMapping("/list")
        return new ResponseEntity<>(blogDTO, HttpStatus.CREATED);
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

    @PutMapping("{id}/update")
    private ResponseEntity<Blog> update(@PathVariable int id, @RequestBody BlogDto blogDTO) {
        Blog blog = blogService.findById(id);

        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        blogService.update(blogDTO.getTitle(), blogDTO.getCreateDay(), blog.getCategory().getId(), blog.getId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/category")
    private ResponseEntity<List<Category>> showCategory() {
//        model.addAttribute("categoryList", categoryService.findAll());
        List<Category> categoryList = categoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

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

    @GetMapping("/search/{title}")
    private ResponseEntity<List<Blog>> search(@PathVariable(name = "title") String title) {
        List<Blog> blogList = blogService.search(title);

        if (blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping("/upload/{size}")
    private ResponseEntity<?> showListBlog(@RequestParam(name = "page", defaultValue = "0") int page, @PathVariable int size) {
        Sort sort = Sort.by("create_day");
        Page<Blog> list = blogService.findAllBlog(PageRequest.of(page, size, sort));
        return new ResponseEntity<>(list.getContent(), HttpStatus.OK);
    }
}
