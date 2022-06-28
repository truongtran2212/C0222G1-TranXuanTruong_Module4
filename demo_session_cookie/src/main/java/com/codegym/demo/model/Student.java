package com.codegym.demo.model;

import com.codegym.demo.annotation.NameConstraint;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity(name = "student")
public class Student implements Validator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "code_student")
    private Integer codeStudent;
    @NameConstraint
    @Column(name = "name_student")
    @NotBlank(message = "Tên không được để trống!")
    private String nameStudent;
    @Min(value = 0, message = "Point không dược nhỏ hơn 0")
    @Max(value = 10, message = "Point không được lớn hơn 0")
    private Double point;
    private Integer gender;
    @ManyToOne
    @JoinColumn(name = "id_class")
    private Classroom classroom;

    public Student() {
    }

    public Student(Integer codeStudent, String nameStudent, Double point, Integer gender) {
        this.codeStudent = codeStudent;
        this.nameStudent = nameStudent;
        this.point = point;
        this.gender = gender;
    }

    public Classroom getClassroom() {
        return classroom;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public Integer getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(Integer codeStudent) {
        this.codeStudent = codeStudent;
    }

    public String getNameStudent() {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent) {
        this.nameStudent = nameStudent;
    }

    public Double getPoint() {
        return point;
    }

    public void setPoint(Double point) {
        this.point = point;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
             Student student = (Student) target;
             if(!student.nameStudent.matches("^[A-Za-z ]{4,}$")){
                 errors.rejectValue("nameStudent","nameStudent.invalidFormat");
             }
    }
}
