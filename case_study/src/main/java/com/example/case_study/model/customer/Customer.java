package com.example.case_study.model.customer;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.UniqueElements;

import javax.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    private String customerCode;

    private String customerName;

    private String customerBirthday;

    private int customerGender;

    private String customerIdCard;

    private String customerPhone;

    private String customerEmail;

    private String customerAddress;

    @ManyToOne
    @JoinColumn(name = "customer_type_id",referencedColumnName = "customer_type_id")
    private CustomerType customerType;

    @ColumnDefault("0")
    private int status;

    public Customer() {
    }

    public Customer(int customerId,
                    @UniqueElements String customerCode,
                    String customerName,
                    String customerBirthday,
                    int customerGender,
                    String customerIdCard,
                    String customerPhone,
                    String customerEmail,
                    String customerAddress,
                    CustomerType customerType,
                    int status) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerType = customerType;
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public int getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(int customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
