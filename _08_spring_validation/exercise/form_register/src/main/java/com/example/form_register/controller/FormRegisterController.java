package com.example.form_register.controller;

import com.example.form_register.model.User;
import com.example.form_register.service.FormRegisterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class FormRegisterController {
    @Autowired
    private FormRegisterService formRegisterService;

    @GetMapping("/list")
    public String showFormRegister(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        model.addAttribute("userList", formRegisterService.findAll(PageRequest.of(page, 2)));
        return "index";
    }

    @GetMapping("/create")
    public String showFormCreate(Model model) {
        model.addAttribute("user", new User());
        return "create";
    }

    @PostMapping("/create")
    public String create(@Valid @ModelAttribute(name = "user") User user, BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            return "create";
        }
        formRegisterService.create(user.getFirstName(),
                user.getLastName(),
                user.getPhoneNumber(),
                user.getAge(),
                user.getEmail());
        redirectAttributes.addFlashAttribute("msg", "Đã thêm mới thành công");
        return "redirect:/list";
    }
}
