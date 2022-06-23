package com.example.validateproduct.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name_product")
    @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng")
    @NotBlank(message = "Không được để trống")
    private String nameProduct;

    @Column(name = "price_product")
    @Min(value = 1, message = "Không được nhập giá trị bé hơn 1")
    private double priceProduct;

    @Column(name = "detail_product")
    @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng")
    @NotBlank(message = "Không được để trống")
    private String detailProduct;

    @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng")
    @NotBlank(message = "Không được để trống")
    private String production;

    @ColumnDefault("0")
    private int status;

    public Product() {
    }

    public Product(int id, @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng và không được để trống") String nameProduct,
                   @Min(value = 1, message = "Không được nhập giá trị bé hơn 1") double priceProduct,
                   @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng và không được để trống") String detailProduct,
                   @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng và không được để trống") String production,
                   int status) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.detailProduct = detailProduct;
        this.production = production;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public String getDetailProduct() {
        return detailProduct;
    }

    public void setDetailProduct(String detailProduct) {
        this.detailProduct = detailProduct;
    }

    public String getProduction() {
        return production;
    }

    public void setProduction(String production) {
        this.production = production;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
