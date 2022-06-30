package com.example.case_study.model.customer.dto;

import com.example.case_study.model.customer.CustomerType;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class CustomerDto {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Pattern(regexp = "^KH-[0-9]{4}$", message = "Sai định dạng và không được để trống")
    private String customerCode;

    @Pattern(regexp = "([\\p{Lu}][\\p{Ll}]{0,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){1,10}",
            message = "Viết bằng tiếng Việt có dấu và không được để trống")

    private String customerName;

    @NotBlank(message = "Không được đê trống")
    private String customerBirthday;

    @NotNull(message = "Không được đê trống")
    private int customerGender;

    @Pattern(regexp = "^[0-9]{9}|[0-9]{11}$", message = "Nhập 1 dãy số gồm 9 hoặc 11 số")
    private String customerIdCard;

    @Pattern(regexp = "^090[0-9]{7}|091[0-9]{7}|\\(84\\)\\+90[0-9]{7}|\\(84\\)\\+91[0-9]{7}$",
            message = "Số điện thoại phải đúng định dạng 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")

    private String customerPhone;

    @Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Sai định dạng và không được để trống")
    private String customerEmail;

    @NotBlank(message = "Không được đê trống")
    private String customerAddress;

    // Không được đặt regex cho khóa ngoại
    private CustomerType customerTypeId;

    public CustomerDto() {
    }

    public CustomerDto(int id,
                       String customerCode,
                       String customerName,
                       String customerBirthday,
                       int customerGender,
                       String customerIdCard,
                       String customerPhone,
                       String customerEmail,
                       String customerAddress,
                       CustomerType customerTypeId) {
        this.id = id;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerBirthday = customerBirthday;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.customerTypeId = customerTypeId;
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

    public CustomerType getCustomerTypeId() {
        return customerTypeId;
    }

    public void setCustomerTypeId(CustomerType customerTypeId) {
        this.customerTypeId = customerTypeId;
    }
}
