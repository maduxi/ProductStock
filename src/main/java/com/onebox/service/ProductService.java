/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onebox.service;

import com.onebox.controllers.exceptions.ResourceNotFoundException;
import com.onebox.model.Product;
import com.onebox.repositories.ProductEntity;
import com.onebox.repositories.ProductRepository;
import java.util.ArrayList;
import java.util.List;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Service to perform the transformation and logic between data and API objects.
 *
 * @author madhava
 */
@Component
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private Mapper mapper;

    public List<Product> getAll(String category) {

        Iterable<ProductEntity> items;

        if (category == null || category.isEmpty()) {
            items = productRepository.findAll();
        } else {
            items = productRepository.findByCategory(category);
        }

        List<Product> result = getProductListFromEntities(items);

        return result;
    }

    public Product find(Long id) throws ResourceNotFoundException {
        ProductEntity findOne = productRepository.findOne(id);
        if (findOne == null) {
            throw new ResourceNotFoundException("This product is not in our lists!");
        }
        return getProductFromEntity(findOne);
    }

    public Product create(Product entity) {

        ProductEntity entityFromProduct = getEntityFromProduct(entity);

        ProductEntity save = productRepository.save(entityFromProduct);

        return getProductFromEntity(save);

    }

    public Product edit(Product product) throws ResourceNotFoundException {

        ProductEntity find = productRepository.findOne(product.getId());

        if (find == null) {
            throw new ResourceNotFoundException("This product is not in our lists!");
        }

        ProductEntity entityFromProduct = getEntityFromProduct(product);

        productRepository.save(entityFromProduct);

        product = find(product.getId());

        return product;
    }

    public boolean delete(Long id) throws ResourceNotFoundException {
        ProductEntity find = productRepository.findOne(id);
        if (find == null) {
            throw new ResourceNotFoundException("This product is not in our lists!");
        }
        productRepository.delete(id);
        return true;
    }

    private List<Product> getProductListFromEntities(Iterable<ProductEntity> items) {
        List<Product> result = new ArrayList<Product>();
        for (ProductEntity pentity : items) {
            result.add(getProductFromEntity(pentity));
        }
        return result;
    }

    private Product getProductFromEntity(ProductEntity pentity) {
        return mapper.map(pentity, Product.class);
    }

    private ProductEntity getEntityFromProduct(Product product) {
        return mapper.map(product, ProductEntity.class);
    }
}
