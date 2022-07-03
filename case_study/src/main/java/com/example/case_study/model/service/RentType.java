package com.example.case_study.model.service;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "rent_type")
public class RentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name  = "rent_type_id")
    private Integer rentTypeId;

    @Column(name = "rent_type_name")
    private String rentTypeName;

    @Column(name = "rent_type_cost")
    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> service;
    public RentType() {
    }

    public RentType(Integer rentTypeId, String rentTypeName, Double rentTypeCost, Set<Service> service) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
        this.service = service;
    }

    public RentType(Integer rentTypeId, String rentTypeName, Double rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public Integer getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Integer rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }

    public Set<Service> getService() {
        return service;
    }

    public void setService(Set<Service> service) {
        this.service = service;
    }
}
