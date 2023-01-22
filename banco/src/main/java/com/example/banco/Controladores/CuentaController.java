/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Controladores;

import com.example.banco.Modelos.Cliente;
import com.example.banco.Modelos.Cuenta;
import com.example.banco.Servicios.ClienteServicio;
import com.example.banco.Servicios.CuentaServicio;
import java.util.ArrayList;
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
@RequestMapping("/cuenta")
public class CuentaController {
     @Autowired
    CuentaServicio cuentaServicio;
    
    @GetMapping
    public ArrayList<Cuenta> ObtenerCuenta(){
    return cuentaServicio.obtenerCuentas();
    }
    
    @PostMapping
    public Cuenta GuardarCuenta(@RequestBody Cuenta cuenta){
    return this.cuentaServicio.guardarCuenta(cuenta);
    }
    
    @GetMapping(path="/{id}")
    public ArrayList<Cuenta> ObtenerCuentaId(@PathVariable("id") Integer id){
    return cuentaServicio.ObtenerPorId(id);
    }
    
    @GetMapping("/query")
    public ArrayList<Cuenta> ObtnerListaCuentas(@RequestParam("tipo") String tipo){
    return cuentaServicio.ObtenerCuentaPorTipo(tipo);
    }
    
    
     @DeleteMapping(path="/{id}")
    public String EliminarPorId(@PathVariable("id") Integer id){
    boolean ok = this.cuentaServicio.eliminarCuenta(id);
    if(ok){
    return "Se elimino el cuenta con id "+id;
    }else{
    return "No se pudo eliminar el cuenta con id "+id;
    }
    
    }
    
}
