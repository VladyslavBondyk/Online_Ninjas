package com.teamchallenge.online_store.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.math.BigDecimal;

import static io.swagger.v3.oas.annotations.media.Schema.AccessMode.READ_ONLY;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(accessMode = READ_ONLY)
    private Long id;

    private String name;

    private String description;

    private BigDecimal price;
    @Column(name = "season_novelties", nullable = false)
    boolean seasonNovelties = false;

    @Column(name = "popular_products", nullable = false)
    boolean popularProducts = false;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    public boolean isSeasonNovelties() {
        return seasonNovelties;
    }

    public void setSeasonNovelties(boolean seasonNovelties) {
        this.seasonNovelties = seasonNovelties;
    }

    public boolean isPopularProducts() {
        return popularProducts;
    }

    public void setPopularProducts(boolean popularProducts) {
        this.popularProducts = popularProducts;
    }


    public Product(Long id, String name, String description, BigDecimal price, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.category = category;
    }

    public Product() {
    }

    public Product(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

