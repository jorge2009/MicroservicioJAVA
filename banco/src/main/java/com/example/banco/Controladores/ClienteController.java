/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Controladores;

import com.example.banco.Modelos.Cliente;
import com.example.banco.Modelos.Persona;

import com.example.banco.Servicios.ClienteServicio;

import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteServicio clienteServicio;
    
    @GetMapping
    public ArrayList<Cliente> ObtenerCliente(){
    return clienteServicio.obtenerClientes();
    }
    
    @PostMapping
    public Cliente GuardarCliente(@RequestBody Cliente cliente){
    return this.clienteServicio.guardarCliente(cliente);
    }
    
    @GetMapping(path="/{id}")
    public ArrayList<Cliente> ObtenerClienteId(@PathVariable("id") Integer id){
    return clienteServicio.ObtenerPorId(id);
    }
    
    
    @GetMapping("/query")
    public ArrayList<Cliente> ObtnerListaCliente(@RequestParam("estado") String estado){
    return clienteServicio.ObtenerClientePorEstado(estado);
    }
    
     @DeleteMapping(path="/{id}")
    public String EliminarPorId(@PathVariable("id") Integer id){
    boolean ok = this.clienteServicio.eliminarCliente(id);
    if(ok){
    return "Se elimino el cliente con id "+id;
    }else{
    return "No se pudo eliminar el cliente con id "+id;
    }
    
    }
}
