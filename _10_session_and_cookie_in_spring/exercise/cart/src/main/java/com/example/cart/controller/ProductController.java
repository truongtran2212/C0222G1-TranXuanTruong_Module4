package com.example.cart.controller;

import com.example.cart.model.Cart;
import com.example.cart.model.Product;
import com.example.cart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("cart")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ModelAttribute("cart")
    public Cart productInCart() {
        return new Cart();
    }


    @GetMapping("{id}/detail")
    public String samsung(@PathVariable Integer id, Model model) {
        model.addAttribute("product", productService.findById(id));
        return "detail-product";
    }

    @GetMapping("/list")
    public String showList(Model model) {
        model.addAttribute("productList", productService.findAll());
        return "home";
    }

    @GetMapping("{id}/add-cart")
    // @ModelAttribute ở phương thức này phải giống với @ModelAttribute ở trên
    public String addToCart(@PathVariable int id,
                            @ModelAttribute("cart") Cart cart,
                            @RequestParam("action") String action
    ) {
        Product product = productService.findById(id);

        if (action.equals("show")) {
            cart.addProduct(product);
            return "redirect:/cart";
        }
        cart.addProduct(product);
        return "redirect:/list";
    }
}
