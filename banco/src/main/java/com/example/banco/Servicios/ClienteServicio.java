/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Servicios;

import com.example.banco.Modelos.Cliente;
import com.example.banco.Modelos.Persona;
import com.example.banco.Repositorios.ClienteRepositorio;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class ClienteServicio {
    
     @Autowired
    ClienteRepositorio clienteRepositorio;
    public ArrayList<Cliente> obtenerClientes(){
    return (ArrayList<Cliente>)clienteRepositorio.findAll();
    }
    
    public Cliente guardarCliente(Cliente cliente){
        Persona per=new Persona();
        per.setIdPersona(cliente.getPersona().getIdPersona());
        per.setEdad(cliente.getPersona().getEdad());
        per.setGenero(cliente.getPersona().getGenero());
        per.setDireccion(cliente.getPersona().getDireccion());
        per.setNombre(cliente.getPersona().getNombre());
        per.setTelefono(cliente.getPersona().getTelefono());
        per.setIdentificacion(cliente.getPersona().getIdentificacion());
        cliente.setPersona(per);
    return clienteRepositorio.save(cliente);
    }
    
    public ArrayList<Cliente> ObtenerPorId(Integer id){
         ArrayList<Cliente> ListaCliente=new ArrayList<>();
         ArrayList<Cliente> ListaNCliente=new ArrayList<>();
         ListaCliente=(ArrayList<Cliente>)clienteRepositorio.findAll();
        Cliente cli=new Cliente();
        Persona per=new Persona();
        int idCliente=0;
         for(int i=0;i<ListaCliente.size();i++){
         cli=new Cliente();
         per=new Persona();
         idCliente=ListaCliente.get(i).getIdCliente();
         cli.setIdCliente(ListaCliente.get(i).getIdCliente());
         per.setIdPersona(ListaCliente.get(i).getPersona().getIdPersona());
         per.setNombre(ListaCliente.get(i).getPersona().getNombre());
         cli.setPersona(per);
          if(idCliente==id){
          ListaNCliente.add(cli);
          }
             
         }
    return ListaNCliente;
    }
    
    public ArrayList<Cliente> ObtenerClientePorNombre(String nom){
        ArrayList<Cliente> ListaCliente=new ArrayList<>();
         ArrayList<Cliente> ListaNCliente=new ArrayList<>();
         
    ListaCliente= (ArrayList<Cliente>)clienteRepositorio.findAll();
    for(int i=0;i<ListaCliente.size();i++){
    Cliente cli=new Cliente();
      if(cli.getPersona().getNombre().equals(nom)){
        cli=new Cliente();
        cli.setContraseña(ListaCliente.get(i).getContraseña());
        
        ListaNCliente.add(cli);
    }
    
    }
    
    return ListaNCliente;
    }
    
    public ArrayList<Cliente> ObtenerClientePorEstado(String est){
        ArrayList<Cliente> ListaCliente=new ArrayList<>();
         ArrayList<Cliente> ListaNCliente=new ArrayList<>();
         
    ListaCliente= (ArrayList<Cliente>)clienteRepositorio.findAll();
    for(int i=0;i<ListaCliente.size();i++){
    Cliente cli=new Cliente();
    Persona per=new Persona();
      if(cli.getEstado().equals(est)){
        cli=new Cliente();
        cli.setContraseña(ListaCliente.get(i).getContraseña());
        cli.setEstado(ListaCliente.get(i).getEstado());
        per.setNombre(ListaCliente.get(i).getPersona().getNombre());
        per.setDireccion(ListaCliente.get(i).getPersona().getDireccion());
        per.setTelefono(ListaCliente.get(i).getPersona().getTelefono());
        cli.setPersona(per);
        
        
        
        ListaNCliente.add(cli);
    }
    
    }
    
    return ListaNCliente;
    }
    
    
    
    public boolean eliminarCliente(Integer id){
        try {
            Cliente cli=new Cliente();
            cli.setIdCliente(id);
            clienteRepositorio.delete(cli);
            //clienteRepositorio.deleteById(id);
            return true;
        } catch (Exception e) {
        return false;
        }
    }

    
    
}
