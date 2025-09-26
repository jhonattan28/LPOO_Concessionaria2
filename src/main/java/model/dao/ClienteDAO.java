/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.dao;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;

/**
 *
 * @author vanessalagomachado
 */
public class ClienteDAO {
    List<Cliente> lista;

    public ClienteDAO() {
        lista  = new ArrayList<>();
    }
    
    public void addCliente(Cliente cliente){
        lista.add(cliente);
    }
    
    public void removerCliente(Cliente cliente){
        lista.remove(cliente);
    }
    
    public List<Cliente> listaClientes(){
        return lista;
    }
    
}
