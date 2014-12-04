/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.onebox.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception to be thrown in case the resource cannot be found.
 * @author madhava
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException  extends Exception {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
