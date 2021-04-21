/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aulajpa.treinamento.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author elisson
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends Exception{
    
     public UserNotFoundException(String name) {
        super(String.format("User with name %s not found in the system.", name));
    }

    public UserNotFoundException(Long id) {
        super(String.format("User with id %s not found in the system.", id));
    }
    
}
