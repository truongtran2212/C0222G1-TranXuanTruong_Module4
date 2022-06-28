package com.codegym.demo.controller;

import com.codegym.demo.model.Student;
import com.codegym.demo.service.IClassroomService;
import com.codegym.demo.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("studentTalkList")
public class StudentController {

    @ModelAttribute("studentTalkList")
    public List<Student> createTalkList() {
        return new ArrayList<>();
    }

    @GetMapping("addTalk/{id}")
    public String addToTalkList(@PathVariable("id") Integer codeStudent,
                                @ModelAttribute("studentTalkList") List<Student> students,
                                RedirectAttributes redirectAttributes) {
        Student student = iStudentService.findById(codeStudent);
        students.add(student);
        redirectAttributes.addFlashAttribute("msg","Add talk ẩn danh thành công");
        return "redirect:/list";
    }

    @Autowired
    @Qualifier("studentService")
    private IStudentService iStudentService;

    @Autowired
    private IClassroomService iClassroomService;

//    @RequestMapping(method = RequestMethod.GET, value = "/list")
//    @GetMapping(value = "/list")
//    public String getAllStudent(Model model) {
//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
//        return "list";
//    }

    @GetMapping(value = "/list")
    public String getAllStudent(@RequestParam(name = "page", defaultValue = "0") int page, Model model, @CookieValue(value = "cookieValue", defaultValue = "0") Integer cookieValue) {
        Sort sort = Sort.by("point").ascending().and(Sort.by("name_student"));
        Page<Student> list = iStudentService.getAll(PageRequest.of(page, 2, sort));
        model.addAttribute("cookieValue", cookieValue);
        model.addAttribute("listStudent", list);
        return "list";
    }

    @GetMapping("/create")
    public String movePageCreate(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("listClass", iClassroomService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createStudent(@ModelAttribute("student") Student student, BindingResult bindingResult,
                                RedirectAttributes redirectAttributes, Model model,
                                @CookieValue(value = "cookieValue", defaultValue = "0") Integer countStudent,
                                HttpServletResponse response) {
//        Student student = new Student(studentAccountDTO.getCodeStudent(), studentAccountDTO.getNameStudent(),
//                studentAccountDTO.getPoint(), studentAccountDTO.getGender());
//        Account account = new Account(studentAccountDTO.getUsername(), studentAccountDTO.getPassword());
//        new Student().validate(student, bindingResult);
//        if(bindingResult.hasErrors()) {
//            model.addAttribute("listClass", iClassroomService.findAll());
//            return "create";
//        }
        iStudentService.save(student);
        Cookie cookie = new Cookie("cookieValue", countStudent + 1 + "");
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);

//        List<Student> list = iStudentService.getAll();
//        model.addAttribute("listStudent", list);
        redirectAttributes.addFlashAttribute("msg", "Thêm mới thành công");
        return "redirect:/list";
    }

    @GetMapping("/detail/{codeStudent}")
    public String moveDetail(@PathVariable(value = "codeStudent", required = false) Integer codeStudent) {
        System.out.println(codeStudent);
        return "detail";
    }

    @ExceptionHandler(Exception.class)
    public String handleException() {
        return "error";
    }

}
