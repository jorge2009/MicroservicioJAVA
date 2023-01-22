/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Servicios;

import com.example.banco.Modelos.Persona;
import com.example.banco.Repositorios.PersonaRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class PersonaService {
    @Autowired
    PersonaRepository personaReporitory;
    public ArrayList<Persona> obtenerPersonas(){
    return (ArrayList<Persona>)personaReporitory.findAll();
    }
    
    public Persona guardarPersona(Persona persona){
    return personaReporitory.save(persona);
    }
    
    public Optional<Persona> ObtenerPorId(Long id){
    return personaReporitory.findById(id);
    }
    
    public ArrayList<Persona> ObtenerPersonaPorIdentificacion(Integer id){
        ArrayList<Persona> ListaPersona=new ArrayList<>();
         ArrayList<Persona> ListaNPersona=new ArrayList<>();
         
    ListaPersona= (ArrayList<Persona>)personaReporitory.findAll();
    for(int i=0;i<ListaPersona.size();i++){
    Persona per=new Persona();
    per.setIdentificacion(ListaPersona.get(i).getIdentificacion());
    if(per.getIdentificacion().equals(id)){
        per=new Persona();
        per.setIdPersona(ListaPersona.get(i).getIdPersona());
        per.setNombre(ListaPersona.get(i).getNombre());
        per.setEdad(ListaPersona.get(i).getEdad());
        per.setGenero(ListaPersona.get(i).getGenero());
        per.setDireccion(ListaPersona.get(i).getDireccion());
        per.setTelefono(ListaPersona.get(i).getTelefono());
        per.setIdentificacion(ListaPersona.get(i).getIdentificacion());
        ListaNPersona.add(per);
    }
    
    }
    
    return ListaNPersona;
    }
    
    
    public boolean eliminarPersona(Long id){
        try {
            personaReporitory.deleteById(id);
            return true;
        } catch (Exception e) {
        return false;
        }
    }

    
    
}
