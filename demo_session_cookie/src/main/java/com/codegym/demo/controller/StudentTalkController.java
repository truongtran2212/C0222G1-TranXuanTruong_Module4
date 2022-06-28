package com.codegym.demo.controller;

import com.codegym.demo.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentTalkController {

    @GetMapping("talk")
    public ModelAndView goTalkList(@SessionAttribute("studentTalkList") List<Student> studentList){
        return new ModelAndView("student-talk", "studentTalkList", studentList);
    }
}
