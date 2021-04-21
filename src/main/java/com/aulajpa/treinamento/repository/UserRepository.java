/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aulajpa.treinamento.repository;

import com.aulajpa.treinamento.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author elisson
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
