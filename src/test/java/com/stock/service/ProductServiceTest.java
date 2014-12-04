/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stock.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.TransactionDbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.stock.model.Product;
import java.util.List;
import javax.transaction.Transactional;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;

/**
 *
 * @author madhava
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=com.stock.Application.class,loader=AnnotationConfigContextLoader.class)
@Transactional
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionDbUnitTestExecutionListener.class,
        DbUnitTestExecutionListener.class})
public class ProductServiceTest {
    
    @Autowired
    ProductService productService;

    /**
     * Test of getAll method, of class ProductService.
     */
    @Test
    @DatabaseSetup("sampleData.xml")
    public void testGetAll() {
        System.out.println("getAll");
        List<Product> result = productService.getAll(null);
        assertEquals(3l, result.size());
    }

    /**
     * Test of find method, of class ProductService.
     */
    //@Test
    public void testFind() throws Exception {
        System.out.println("find");
        Long id = null;
        ProductService instance = new ProductService();
        Product expResult = null;
        Product result = instance.find(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ProductService.
     */
   // @Test
    public void testCreate() {
        System.out.println("create");
        Product entity = null;
        ProductService instance = new ProductService();
        Product expResult = null;
        Product result = instance.create(entity);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of edit method, of class ProductService.
     */
   // @Test
    public void testEdit() throws Exception {
        System.out.println("edit");
        Product product = null;
        ProductService instance = new ProductService();
        Product expResult = null;
        Product result = instance.edit(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ProductService.
     */
    //@Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        Long id = null;
        ProductService instance = new ProductService();
        boolean expResult = false;
        boolean result = instance.delete(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
