/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aulajpa.treinamento.repository;

import com.aulajpa.treinamento.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author elisson
 */
public interface UserRepository extends JpaRepository<User, Long>{

    @Query("SELECT obj FROM  User obj WHERE obj.salary >= :minSalary AND obj.salary <= :maxSalary")
    public Page<User> searchSalary(Double minSalary, Double maxSalary, Pageable pageable);

    @Query("SELECT obj FROM User obj WHERE LOWER(obj.name) LIKE LOWER(CONCAT('%', :name, '%') ) ")
    public Page<User> searchName(String name, Pageable pageable);
    
    public Page<User> findByNameContainingIgnoreCase(String name, Pageable pageable);
    
}
