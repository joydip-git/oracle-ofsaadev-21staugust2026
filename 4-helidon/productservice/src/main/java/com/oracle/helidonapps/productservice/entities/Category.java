package com.oracle.helidonapps.productservice.entities;

import jakarta.persistence.*;

@Entity(name = "Category")
@Table(name = "categories")
@Access(AccessType.FIELD)
@NamedQueries({
        @NamedQuery(name = "getCategories", query = "SELECT c FROM Category c"),
        @NamedQuery(name = "getCategoryById", query = "SELECT c FROM Category c WHERE c.categoryId=:id")
})
public class Category {

    @Id
    @Column(name = "category_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categoryId;

    //@Basic(optional = false)
    @Column(name = "category_name", nullable = false)
    private String categoryName;

    public Category() {
    }

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }
}
