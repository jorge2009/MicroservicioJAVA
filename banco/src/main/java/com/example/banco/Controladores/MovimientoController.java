/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Controladores;

import com.example.banco.Modelos.Cuenta;
import com.example.banco.Modelos.Movimientos;
import com.example.banco.Servicios.CuentaServicio;
import com.example.banco.Servicios.MovimientoServicio;
import java.util.ArrayList;
import java.util.Date;
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
@RequestMapping("/movimiento")
public class MovimientoController {
     @Autowired
    MovimientoServicio movimientoServicio;
    
    @GetMapping
    public ArrayList<Movimientos> ObtenerCuenta(){
    return movimientoServicio.obtenerMovimientos();
    }
    
    @PostMapping
    public String GuardarMovimiento(@RequestBody Movimientos movimiento){
    
      boolean resultado=this.movimientoServicio.guardarMovimiento(movimiento);
    if(resultado){
    return "Operacion realizada correctamente";
    }else
    {
        return "Su saldo es menor o igual a cero";
    }
      
    }
    
    @GetMapping(path="/{id}")
    public ArrayList<Movimientos> ObtenerMovimientoId(@PathVariable("id") Integer id){
    return movimientoServicio.ObtenerPorId(id);
    }
    
    @GetMapping("/query")
    public ArrayList<Movimientos> ObtnerListaMovimientos(@RequestParam("fecha") Date fecha,@RequestParam("fecha2") Date fecha2){
    return movimientoServicio.ObtenerMovimientoPorFecha(fecha,fecha2);
    }
    
     @DeleteMapping(path="/{id}")
    public String EliminarPorId(@PathVariable("id") Integer id){
    boolean ok = this.movimientoServicio.eliminarMovimiento(id);
    if(ok){
    return "Se elimino el cuenta con id "+id;
    }else{
    return "No se pudo eliminar el cuenta con id "+id;
    }
    
    }
    
}
