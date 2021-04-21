/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aulajpa.treinamento.controllers;

import com.aulajpa.treinamento.entities.User;
import com.aulajpa.treinamento.exception.UserNotFoundException;
import com.aulajpa.treinamento.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public ResponseEntity<List<User>> findAll() {
        List<User> result = repository.findAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/page")
    public ResponseEntity<Page<User>> findAll(Pageable pageable) {
        Page<User> result = repository.findAll(pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/seach-salary")
    public ResponseEntity<Page<User>> searchBySalary(
            @RequestParam(defaultValue = "0") Double minSalary,
            @RequestParam(defaultValue = "100000000") Double maxSalary,
            @PageableDefault(size = 40) Pageable pageable) {
        Page<User> result = repository.searchSalary(minSalary, maxSalary, pageable);
        return ResponseEntity.ok(result);
    }

    @GetMapping(value = "/seach-name")
    public ResponseEntity<Page<User>> searchByName(
            @RequestParam(defaultValue = "") String name,
            @PageableDefault(size = 40) Pageable pageable) {
        Page<User> result = repository.findByNameContainingIgnoreCase(name, pageable);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) throws UserNotFoundException {
        repository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
