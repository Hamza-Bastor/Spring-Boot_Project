package com.DeliveryApp.delivery.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    @NotNull
    @Size(min = 3,max = 1000)
    private String nameProduct;
    @NotNull
    @Min(value = 5)
    @Max(value = 10000)
    private Double priceProduct;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent
    private Date dateCreate;

    public Double calories;

    public Double protein;


    public Double fat;


    public Double carbs;
    public String description;
    private String sphoto;

    public Product(Double calories, Double protein, Double fat, Double carbs, String description , String sphoto) {
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;

        this.carbs = carbs;
        this.description = description;
        this.sphoto = sphoto;
    }

    @Override
    public String toString() {
        return "Product{" +
                "calories=" + calories +
                ", protein=" + protein +
                ", fat=" + fat +
                ", carbs=" + carbs +
                ", sphoto=" + sphoto +
                ", description='" + description + '\'' +
                '}';
    }

    public Product(String nameProduct, Double priceProduct,Double calories, Double protein, Double fat, Date dateCreate, Double carbs, String description , String sphoto) {
        super();
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.dateCreate = dateCreate;
        this.carbs = carbs;
        this.calories = calories;
        this.fat = fat;
        this.protein = protein;
        this.sphoto = sphoto;
        this.description = description;

    }

    public String getSphoto() {
        return sphoto;
    }

    public void setSphoto(String sphoto) {
        this.sphoto = sphoto;
    }

    public Double getCalories() {
        return calories;
    }

    public void setCalories(Double calories) {
        this.calories = calories;
    }

    public Double getProtein() {
        return protein;
    }

    public void setProtein(Double protein) {
        this.protein = protein;
    }

    public Double getFat() {
        return fat;
    }

    public void setFat(Double fat) {
        this.fat = fat;
    }


    public Double getCarbs() {
        return carbs;
    }

    public void setCarbs(Double carbs) {
        this.carbs = carbs;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {
        super();
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public Date getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate) {
        this.dateCreate = dateCreate;
    }
}


