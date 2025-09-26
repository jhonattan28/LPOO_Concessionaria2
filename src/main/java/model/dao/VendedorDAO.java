/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.Vendedor;

/**
 *
 * @author vanessalagomachado
 */
public class VendedorDAO {
    List<Vendedor> listaVendedores;

    public VendedorDAO() {
        listaVendedores = new ArrayList<>();
    }
    
    
    public List<Vendedor> listaVendedores(){
        return listaVendedores;
    }
    public void addVendedor(Vendedor obj){
        listaVendedores.add(obj);
    }
    public void removerVendedor(Vendedor obj){
        listaVendedores.remove(obj);
    }
    
}
