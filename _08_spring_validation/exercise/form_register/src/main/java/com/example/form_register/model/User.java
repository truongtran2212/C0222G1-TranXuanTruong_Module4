package com.example.form_register.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "first_name")
    @Pattern(regexp = "^[A-Za-z]*$", message = "Sai định dạng")
    @Size(min = 5, max = 45, message = "Không đúng format")
    private String firstName;

    @Column(name = "last_name")
    @Pattern(regexp = "^[A-Za-z ]*$", message = "Sai định dạng")
    @Size(min = 5, max = 45, message = "Không đúng format")
    private String lastName;


    @Column(name = "phone_number")
    @Pattern(regexp = "^(09)[0-9]{8}$", message = "Sai định dạng và không được để trống")
    private String phoneNumber;


    @NotNull(message = "Không được để trống")
    @Min(value = 18, message = "Tuổi không được nhỏ hơn 18")
    @Max(value = 120, message = "Tuổi không được trên 120 ")
    private int age;

    @Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Sai định dạng và không được để trống")
    private String email;

    @ColumnDefault("0")
    private int status;

    public User(Integer id, @Pattern(regexp = "^[A-Za-z]*$", message = "Sai định dạng") @Size(min = 5, max = 45) String firstName,
                @Pattern(regexp = "^[A-Za-z ]*$", message = "Sai định dạng") @Size(min = 5, max = 45) String lastName,
                @Pattern(regexp = "^(09)[0-9]{8}$", message = "Sai định dạng") String phoneNumber,
                @NotNull int age,
                @Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Sai định dạng") String email,
                int status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
        this.status = status;
    }

    public User() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User(Integer id,
                @Pattern(regexp = "^[A-Za-z]*$", message = "Sai định dạng") @Size(min = 5, max = 45) String firstName,
                @Pattern(regexp = "^[A-Za-z ]*$", message = "Sai định dạng") @Size(min = 5, max = 45) String lastName,
                @Pattern(regexp = "^(09)[0-9]{10}$", message = "Sai định dạng") String phoneNumber,
                @NotEmpty int age,
                @Pattern(regexp = "^[\\w\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Sai định dạng") String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
