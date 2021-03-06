/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.model;

import com.stock.validationGroups.Create;
import com.stock.validationGroups.Edit;
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
    private String name;
    
    private String description;
    
    private String category;

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
