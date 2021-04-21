/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aulajpa.treinamento.controllers;

import com.aulajpa.treinamento.entities.User;
import com.aulajpa.treinamento.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author elisson
 */
@RestController
@RequestMapping(value = "/users")
public class UserController {
    
    @Autowired
    private UserRepository repository;
    
    @GetMapping
    public ResponseEntity<List<User>> findAll(){
        List<User> result = repository.findAll();
        return ResponseEntity.ok(result);
    }
    
}
