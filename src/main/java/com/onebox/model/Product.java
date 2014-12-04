/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onebox.model;

import com.onebox.validationGroups.Create;
import com.onebox.validationGroups.Edit;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

/**
 * Model to be parsed from requests and sent back
 * @author madhava
 */
public class Product {
    
    @Null(groups=Create.class)
    @NotNull(groups=Edit.class)
    private Long id;
    
    @NotNull(groups=Create.class)
    private Long quantity;
    
    @NotNull(groups=Create.class)
    private String name;
    
    private String description;
    
    private String category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    
}
