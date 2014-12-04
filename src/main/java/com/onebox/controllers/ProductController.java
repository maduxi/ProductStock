package com.onebox.controllers;

import com.onebox.controllers.exceptions.ResourceNotFoundException;
import com.onebox.model.Product;
import com.onebox.service.ProductService;
import com.onebox.validationGroups.Create;
import com.onebox.validationGroups.Edit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    /**
     * Returns a list of products, can be filtered by category
     *
     * @param category Non mandatory parameter to filter results
     * @return The list of products
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Product> list(@RequestParam(value = "category", required = false) String category) {
        return productService.getAll(category);
    }

    /**
     * Finds a particular product by id
     * @param id The id of the product
     * @return A JSON description of the product or a 404
     * @throws ResourceNotFoundException
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Product find(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return productService.find(id);
    }

    /**
     * Deletes a product by its id
     * @param id The id to be deleted
     * @return true, or 404 if the product cannot be found
     * @throws ResourceNotFoundException 
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public boolean delete(@PathVariable("id") Long id) throws ResourceNotFoundException {
        return productService.delete(id);
    }

    /**
     * Creates a new product
     * @param entity Description of the product. 
     * @return The created entity, with its id
     */
    @RequestMapping(method = RequestMethod.POST)
    public Product create(@Validated(Create.class) @RequestBody final Product entity) {
        return productService.create(entity);
    }

    /**
     * Edit a specific product. Id is mandatory
     * @param entity Product to edit.
     * @return The edited product
     * @throws ResourceNotFoundException 
     */
    @RequestMapping(method = RequestMethod.PUT)
    public Product edit(@Validated(Edit.class) @RequestBody final Product entity) throws ResourceNotFoundException {
        return productService.edit(entity);
    }
}
