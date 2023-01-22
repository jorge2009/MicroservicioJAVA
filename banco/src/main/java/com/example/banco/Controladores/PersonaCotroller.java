/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Controladores;

import com.example.banco.Modelos.Persona;
import com.example.banco.Servicios.PersonaService;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jorge
 */
@RestController
@RequestMapping("/persona")
public class PersonaCotroller {
    @Autowired
    PersonaService personaService;
    
    @GetMapping
    public ArrayList<Persona> ObtenerPersona(){
    return personaService.obtenerPersonas();
    }
    
    @PostMapping
    public Persona GuardarPersona(@RequestBody Persona persona){
    return this.personaService.guardarPersona(persona);
    }
    
    @GetMapping(path="/{id}")
    public Optional<Persona> ObtenerPersonaId(@PathVariable("id") Long id){
    return personaService.ObtenerPorId(id);
    }
    
       
    @GetMapping("/query")
    public ArrayList<Persona> ObtnerPorIdentificacion(@RequestParam("identificacion") Integer identificacion){
    return personaService.ObtenerPersonaPorIdentificacion(identificacion);
    }
   
    @DeleteMapping(path="/{id}")
    public String EliminarPorId(@PathVariable("id") Long id){
    boolean ok = this.personaService.eliminarPersona(id);
    if(ok){
    return "Se elimino la persona con id "+id;
    }else{
    return "No se pudo eliminar la Persona con id "+id;
    }
    
    }

}
