/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.banco.Servicios;

import com.example.banco.Modelos.Cliente;
import com.example.banco.Modelos.Cuenta;
import com.example.banco.Modelos.Persona;
import com.example.banco.Repositorios.CuentaRepositorio;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 *
 * @author Jorge
 */
@Service
public class CuentaServicio {
    @Autowired
    CuentaRepositorio cuentaRepositorio;
    public ArrayList<Cuenta> obtenerCuentas(){
    return (ArrayList<Cuenta>)cuentaRepositorio.findAll();
    }
    
    public Cuenta guardarCuenta(Cuenta cuenta){
        
        Cliente cli=new Cliente();
        Persona per=new Persona();
        cli.setIdCliente(cuenta.getCliente().getIdCliente());
        cli.setEstado(cuenta.getCliente().getEstado());
        cli.setContraseña(cuenta.getCliente().getContraseña());
        per.setDireccion(cuenta.getCliente().getPersona().getDireccion());
        per.setEdad(cuenta.getCliente().getPersona().getEdad());
        per.setGenero(cuenta.getCliente().getPersona().getGenero());
        per.setIdPersona(cuenta.getCliente().getPersona().getIdPersona());
        per.setIdentificacion(cuenta.getCliente().getPersona().getIdentificacion());
        per.setNombre(cuenta.getCliente().getPersona().getNombre());
        per.setTelefono(cuenta.getCliente().getPersona().getTelefono());
        cli.setPersona(per);
        cuenta.setEstado(cuenta.getEstado());
        cuenta.setIdCuenta(cuenta.getIdCuenta());
        cuenta.setCliente(cli);
        cuenta.setNumero_cuenta(cuenta.getNumero_cuenta());
        cuenta.setSaldo_inicial(cuenta.getSaldo_inicial());
        
        return cuentaRepositorio.save(cuenta);
    
    }
    
    public ArrayList<Cuenta> ObtenerPorId(Integer id){
    ArrayList<Cuenta> ListaCuenta=new ArrayList<>();
         ArrayList<Cuenta> ListaNCuenta=new ArrayList<>();
         ListaCuenta=(ArrayList<Cuenta>)cuentaRepositorio.findAll();
        Cliente cli=new Cliente();
        Persona per=new Persona();
        Cuenta cue=new Cuenta();
        int idCuenta=0;
         for(int i=0;i<ListaCuenta.size();i++){
         cli=new Cliente();
         per=new Persona();
         idCuenta=ListaCuenta.get(i).getIdCuenta();
         cli.setIdCliente(ListaCuenta.get(i).getCliente().getIdCliente());
         per.setIdPersona(ListaCuenta.get(i).getCliente().getPersona().getIdPersona());
         per.setNombre(ListaCuenta.get(i).getCliente().getPersona().getNombre());
         cli.setPersona(per);
          if(idCuenta==id){
          cue.setEstado(ListaCuenta.get(i).getEstado());
          cue.setIdCuenta(ListaCuenta.get(i).getIdCuenta());
          cue.setNumero_cuenta(ListaCuenta.get(i).getNumero_cuenta());
          cue.setSaldo_inicial(ListaCuenta.get(i).getSaldo_inicial());
          cue.setTipo_cuenta(ListaCuenta.get(i).getTipo_cuenta());
          
          ListaNCuenta.add(cue);
          }
             
         }
    return ListaNCuenta;
    }
    
    public ArrayList<Cuenta> ObtenerCuentaPorCliente(String clie){
        ArrayList<Cuenta> ListaCuenta=new ArrayList<>();
        ArrayList<Cuenta> ListaNCuenta=new ArrayList<>();
         
    ListaCuenta= (ArrayList<Cuenta>)cuentaRepositorio.findAll();
    for(int i=0;i<ListaCuenta.size();i++){
    Cliente cli=new Cliente();
    Cuenta cue=new Cuenta();
      if(cli.getPersona().getNombre().equals(clie)){
        cli=new Cliente();
        cli.setContraseña(ListaCuenta.get(i).getCliente().getContraseña());
        
        
        ListaNCuenta.add(cue);
        
    }
    
    }
    
    return ListaNCuenta;
    }
    
     @GetMapping(path="/{id}")
    public ArrayList<Cuenta> ObtenerCuentaId(@PathVariable("id") Integer id){
    ArrayList<Cuenta> ListaCuenta=new ArrayList<>();
         ArrayList<Cuenta> ListaNCuenta=new ArrayList<>();
         ListaCuenta=(ArrayList<Cuenta>)cuentaRepositorio.findAll();
        Cliente cli=new Cliente();
        Persona per=new Persona();
        Cuenta cue=new Cuenta();
        int idCuenta=0;
         for(int i=0;i<ListaCuenta.size();i++){
        
        
          if(idCuenta==id){
         cli=new Cliente();
         per=new Persona();
         idCuenta=ListaCuenta.get(i).getIdCuenta();
         
         per.setIdPersona(ListaCuenta.get(i).getCliente().getPersona().getIdPersona());
         per.setNombre(ListaCuenta.get(i).getCliente().getPersona().getNombre());
         per.setDireccion(ListaCuenta.get(i).getCliente().getPersona().getNombre());
         per.setEdad(ListaCuenta.get(i).getCliente().getPersona().getEdad());
         per.setIdentificacion(ListaCuenta.get(i).getCliente().getPersona().getIdentificacion());
         per.setTelefono(ListaCuenta.get(i).getCliente().getPersona().getTelefono());
         
         
         cli.setIdCliente(ListaCuenta.get(i).getCliente().getIdCliente());
         cli.setContraseña(ListaCuenta.get(i).getCliente().getContraseña());
         cli.setEstado(ListaCuenta.get(i).getCliente().getEstado());
         cli.setPersona(per);
          cue.setEstado(id);
          cue.setIdCuenta(ListaCuenta.get(i).getIdCuenta());
          cue.setNumero_cuenta(ListaCuenta.get(i).getNumero_cuenta());
          cue.setSaldo_inicial(ListaCuenta.get(i).getSaldo_inicial());
          cue.setTipo_cuenta(ListaCuenta.get(i).getTipo_cuenta());
          cue.setCliente(cli);
          ListaNCuenta.add(cue);
          }
             
         }
    return ListaNCuenta;
    }
    
    public ArrayList<Cuenta> ObtenerCuentaPorTipo(String est){
        ArrayList<Cuenta> ListaCuenta=new ArrayList<>();
         ArrayList<Cuenta> ListaNCuenta=new ArrayList<>();
         
    ListaCuenta= (ArrayList<Cuenta>)cuentaRepositorio.findAll();
    for(int i=0;i<ListaCuenta.size();i++){
    Cliente cli=new Cliente();
    Cuenta cue=new Cuenta();
      if(cli.getEstado().equals(est)){
        cli=new Cliente();
        cli.setContraseña(ListaCuenta.get(i).getCliente().getContraseña());
        cli.setEstado(ListaCuenta.get(i).getCliente().getEstado());
        cue.setCliente(cli);
        cue.setEstado(ListaCuenta.get(i).getEstado());
        cue.setIdCuenta(ListaCuenta.get(i).getIdCuenta());
        cue.setNumero_cuenta(ListaCuenta.get(i).getNumero_cuenta());
        cue.setSaldo_inicial(ListaCuenta.get(i).getSaldo_inicial());
        cue.setTipo_cuenta(ListaCuenta.get(i).getTipo_cuenta());
                
        
        ListaNCuenta.add(cue);
    }
    
    }
    
    return ListaNCuenta;
    }
    
    
    
    public boolean eliminarCuenta(Integer id){
        try {
            Cuenta cue=new Cuenta();
            cue.setIdCuenta(id);
            cuentaRepositorio.delete(cue);
            return true;
        } catch (Exception e) {
        return false;
        }
    }

}
