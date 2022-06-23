package com.example.validateproduct.controller;

import com.example.validateproduct.model.Product;
import com.example.validateproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;


@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public String showListProduct(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Sort sort = Sort.by("price_product");
        model.addAttribute("productList", productService.findAll(PageRequest.of(page, 2, sort)));
        return "index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(name = "product") Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "create";
        }
        productService.create(product.getNameProduct(),
                product.getPriceProduct(), product.getDetailProduct(), product.getProduction());
        return "redirect:/list";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Product product, RedirectAttributes redirect) {
        productService.delete(product.getId());
        redirect.addAttribute("message", "Removed customer successfully!");
        return "redirect:/list";
    }

    @GetMapping("/{id}/update")
    public String update(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "update";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute(name = "product") Product product, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            return "update";
        }

        productService.update(product.getNameProduct(),
                product.getPriceProduct(),
                product.getDetailProduct(),
                product.getProduction(),
                product.getId());
        return "redirect:/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "page", defaultValue = "0") int page, String nameProduct, Model model) {
        Sort sort = Sort.by("price_product");
        model.addAttribute("productList", productService.search(nameProduct, PageRequest.of(page, 2, sort)));
        return "index";
    }

    @GetMapping("/{id}/detail")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail";
    }
}
