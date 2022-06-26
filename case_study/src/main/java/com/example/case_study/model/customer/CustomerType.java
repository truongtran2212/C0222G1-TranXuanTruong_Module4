package com.example.case_study.model.customer;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customer_type")
public class CustomerType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_type_id")
    private int customerTypeId;

    @Column(name = "customer_type_name")
    private String customerTypeName;

    @OneToMany(mappedBy = "customerType")
    private Set<Customer> customer;

    public CustomerType() {
    }

    public CustomerType(int customerTypeId, String customerTypeName, Set<Customer> customer) {
        this.customerTypeId = customerTypeId;
        this.customerTypeName = customerTypeName;
        this.customer = customer;
    }

    public int getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(int customerTypeId) {
        this.customerTypeId = customerTypeId;
    }

    public String getCustomerTypeName() {
        return customerTypeName;
    }

    public void setCustomerTypeName(String customerTypeName) {
        this.customerTypeName = customerTypeName;
    }

    public Set<Customer> getCustomer() {
        return customer;
    }

    public void setCustomer(Set<Customer> customer) {
        this.customer = customer;
    }
}
