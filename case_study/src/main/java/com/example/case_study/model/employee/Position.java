package com.example.case_study.model.employee;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int positionId;
    private String positionName;

    @OneToMany(mappedBy = "position")
    @JsonBackReference(value = "position")
    private Set<Employee> employee;


    public Position() {
    }

    public Position(int positionId, String positionName, Set<Employee> employee) {
        this.positionId = positionId;
        this.positionName = positionName;
        this.employee = employee;
    }

    public int getPositionId() {
        return positionId;
    }

    public void setPositionId(int positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Set<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(Set<Employee> employee) {
        this.employee = employee;
    }
}
