/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Repositorios;

import com.example.banco.Modelos.Persona;
import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Jorge
 */

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{

   // public abstract  ArrayList<Persona> findById(Integer identificacion);
  
}
