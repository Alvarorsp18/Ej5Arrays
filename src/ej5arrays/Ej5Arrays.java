/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5arrays;

import numeros.NumerosEnteros;

/**
 *
 * @author dam
 */
public class Ej5Arrays {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int nClientes;
        nClientes=NumerosEnteros.pedirNumero("Introduce el número de clientes", 1);
        Empresa miEmpresa;
        miEmpresa=new Empresa(nClientes);
        miEmpresa.inicializarClientes();
        miEmpresa.informe();
    }
    
}
