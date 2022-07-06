package com.example.case_study.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "education_degree")
public class EducationDegree {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "education_degree_id")
    private int educationDegreeId;
    private String educationDegreeName;


    @OneToMany(mappedBy = "educationDegree")
    @JsonBackReference(value = "educationDegree")
    private Set<Employee> employee;

    public EducationDegree() {
    }

    public EducationDegree(int educationDegreeId, String educationDegreeName, Set<Employee> employee) {
        this.educationDegreeId = educationDegreeId;
        this.educationDegreeName = educationDegreeName;
        this.employee = employee;
    }

    public int getEducationDegreeId() {
        return educationDegreeId;
    }

    public void setEducationDegreeId(int educationDegreeId) {
        this.educationDegreeId = educationDegreeId;
    }

    public String getEducationDegreeName() {
        return educationDegreeName;
    }

    public void setEducationDegreeName(String educationDegreeName) {
        this.educationDegreeName = educationDegreeName;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
