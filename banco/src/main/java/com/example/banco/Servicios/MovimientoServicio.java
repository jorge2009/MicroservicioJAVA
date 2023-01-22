/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Servicios;

import com.example.banco.Modelos.Cliente;
import com.example.banco.Modelos.Cuenta;
import com.example.banco.Modelos.Movimientos;
import com.example.banco.Modelos.Persona;
import com.example.banco.Repositorios.CuentaRepositorio;
import com.example.banco.Repositorios.MovimientoRepositorio;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jorge
 */
@Service
public class MovimientoServicio {
     @Autowired
    MovimientoRepositorio movimientoRepositorio;
    public ArrayList<Movimientos> obtenerMovimientos(){
    return (ArrayList<Movimientos>)movimientoRepositorio.findAll();
    }
    
    public boolean  guardarMovimiento(Movimientos movimiento){
        boolean resultado=false;
        Cuenta cue=new Cuenta();
        Cliente cli=new Cliente();
        Persona per=new Persona();
        cue.setIdCuenta(movimiento.getCuenta().getIdCuenta());
        cue.setEstado(movimiento.getCuenta().getEstado());
        cue.setNumero_cuenta(movimiento.getCuenta().getNumero_cuenta());
        cli.setContraseña(movimiento.getCuenta().getCliente().getContraseña());
        cli.setEstado(movimiento.getCuenta().getCliente().getEstado());
        cli.setIdCliente(movimiento.getCuenta().getCliente().getIdCliente());
        
        per.setDireccion(movimiento.getCuenta().getCliente().getPersona().getDireccion());
        per.setEdad(movimiento.getCuenta().getCliente().getPersona().getEdad());
        per.setGenero(movimiento.getCuenta().getCliente().getPersona().getGenero());
        per.setIdPersona(movimiento.getCuenta().getCliente().getPersona().getIdPersona());
        per.setIdentificacion(movimiento.getCuenta().getCliente().getPersona().getIdentificacion());
        per.setNombre(movimiento.getCuenta().getCliente().getPersona().getNombre());
        per.setTelefono(movimiento.getCuenta().getCliente().getPersona().getTelefono());
        cli.setPersona(per);
        cue.setCliente(cli);
        
        
        movimiento.setCuenta(cue);
        Date date=new Date();
        DateFormat datef= new SimpleDateFormat("yy-M-dd");
        datef.format(date);
        movimiento.setFecha(date);
        movimiento.setIdMonimiento(movimiento.getIdMonimiento());
        double valor=0;
        movimiento.setTipo_movimiento(movimiento.getTipo_movimiento());
        if(movimiento.getTipo_movimiento().equals("deposito")){
        valor=movimiento.getSaldo()+movimiento.getValor();
        cue.setSaldo_inicial(valor);
        movimiento.setCuenta(cue);
        }else
        {
        valor=movimiento.getSaldo();
        resultado=true;
        }
        if(movimiento.getTipo_movimiento().equals("debito")){
        valor=movimiento.getSaldo()-movimiento.getValor();
        cue.setSaldo_inicial(valor);
        movimiento.setCuenta(cue);
          if(valor<=0){
          valor=0;
          resultado=false;
          }
        }else
        {
        valor=movimiento.getSaldo();
        }
        movimiento.setSaldo(valor);
        movimiento.setTipo_movimiento(movimiento.getTipo_movimiento());
        movimiento.setValor(movimiento.getValor());
        
      movimientoRepositorio.save(movimiento);
      return resultado;  
    
    }
    
    public ArrayList<Movimientos> ObtenerPorId(Integer id){
    ArrayList<Movimientos> ListaMovimiento=new ArrayList<>();
         ArrayList<Movimientos> ListaNMovimiento=new ArrayList<>();
         ListaMovimiento=(ArrayList<Movimientos>)movimientoRepositorio.findAll();
        Cliente cli=new Cliente();
        Persona per=new Persona();
        Cuenta cue=new Cuenta();
        Movimientos mov=new Movimientos();
        int idMovimiento=0;
         for(int i=0;i<ListaMovimiento.size();i++){
         cli=new Cliente();
         per=new Persona();
         cue=new Cuenta();
         idMovimiento=ListaMovimiento.get(i).getIdMonimiento();
         cli.setIdCliente(ListaMovimiento.get(i).getIdMonimiento());
         per.setIdPersona(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getIdPersona());
         per.setNombre(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getNombre());
         cli.setPersona(per);
          if(idMovimiento==id){
          cue.setEstado(ListaMovimiento.get(i).getCuenta().getEstado());
          cue.setIdCuenta(ListaMovimiento.get(i).getCuenta().getIdCuenta());
          cue.setNumero_cuenta(ListaMovimiento.get(i).getCuenta().getNumero_cuenta());
          cue.setSaldo_inicial(ListaMovimiento.get(i).getCuenta().getSaldo_inicial());
          cue.setTipo_cuenta(ListaMovimiento.get(i).getCuenta().getTipo_cuenta());
          cue.setCliente(cli);
          mov.setCuenta(cue);
          mov.setFecha(ListaMovimiento.get(i).getFecha());
          mov.setIdMonimiento(ListaMovimiento.get(i).getIdMonimiento());
          mov.setSaldo(ListaMovimiento.get(i).getSaldo());
          mov.setTipo_movimiento(ListaMovimiento.get(i).getTipo_movimiento());
          mov.setValor(ListaMovimiento.get(i).getValor());
          ListaNMovimiento.add(mov);
          }
             
         }
    return ListaNMovimiento;
    }
    
    public ArrayList<Movimientos> ObtenerCuentaPorCliente(String clie){
        ArrayList<Movimientos> ListaMovimiento=new ArrayList<>();
        ArrayList<Movimientos> ListaNMovimiento=new ArrayList<>();
         
    ListaMovimiento= (ArrayList<Movimientos>)movimientoRepositorio.findAll();
    for(int i=0;i<ListaMovimiento.size();i++){
    Cliente cli=new Cliente();
    Cuenta cue=new Cuenta();
      if(cli.getPersona().getNombre().equals(clie)){
        Movimientos mov=new Movimientos();
        cue.setIdCuenta(mov.getCuenta().getIdCuenta());
        cue.setEstado(mov.getCuenta().getEstado());
        cue.setNumero_cuenta(mov.getCuenta().getNumero_cuenta());
        mov.setCuenta(cue);
        mov.setFecha(mov.getFecha());
        mov.setIdMonimiento(mov.getIdMonimiento());
        mov.setSaldo(mov.getSaldo());
        mov.setTipo_movimiento(mov.getTipo_movimiento());
        mov.setValor(mov.getValor());
        
                
        ListaNMovimiento.add(mov);
        
    }
    
    }
    
    return ListaNMovimiento;
    }
    
    public ArrayList<Movimientos> ObtenerMovimientoPorFecha(Date fecha,Date fecha2){
        ArrayList<Movimientos> ListaMovimiento=new ArrayList<>();
         ArrayList<Movimientos> ListaNMovimiento=new ArrayList<>();
         
    ListaMovimiento= (ArrayList<Movimientos>)movimientoRepositorio.findAll();
    for(int i=0;i<ListaMovimiento.size();i++){
    Cliente cli=new Cliente();
    Movimientos mov=new Movimientos();
      if(mov.getFecha().before(fecha) && mov.getFecha().after(fecha2)){
        cli=new Cliente();
        Persona per=new Persona();
        Cuenta cue=new Cuenta();
        cli.setContraseña(ListaMovimiento.get(i).getCuenta().getCliente().getContraseña());
        cli.setEstado(ListaMovimiento.get(i).getCuenta().getCliente().getEstado());
        cli.setIdCliente(ListaMovimiento.get(i).getCuenta().getCliente().getIdCliente());
        per.setDireccion(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getDireccion());
        per.setEdad(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getEdad());
        per.setGenero(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getGenero());
        per.setIdPersona(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getIdPersona());
        per.setIdentificacion(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getIdentificacion());
        per.setNombre(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getNombre());
        per.setTelefono(ListaMovimiento.get(i).getCuenta().getCliente().getPersona().getTelefono());
        cli.setPersona(per);
        cue.setCliente(cli);
        mov.setCuenta(cue);
        mov.setFecha(ListaMovimiento.get(i).getFecha());
        mov.setIdMonimiento(ListaMovimiento.get(i).getIdMonimiento());
        mov.setSaldo(ListaMovimiento.get(i).getSaldo());
        mov.setTipo_movimiento(ListaMovimiento.get(i).getTipo_movimiento());
        mov.setValor(ListaMovimiento.get(i).getValor());
                
        
        ListaNMovimiento.add(mov);
    }
    
    }
    
    return ListaNMovimiento;
    }
    
    
    
    public boolean eliminarMovimiento(Integer id){
        try {
            Movimientos mov=new Movimientos();
            mov.setIdMonimiento(id);
            movimientoRepositorio.delete(mov);
            return true;
        } catch (Exception e) {
        return false;
        }
    }
}
