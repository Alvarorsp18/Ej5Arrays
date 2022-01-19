/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5arrays;

import fechas.Fecha;
import numeros.NumerosEnteros;
import numeros.NumerosReales;
import texto.Textos;

/**
 *
 * @author dam
 */
public class Empresa {

    Cliente[] clientes;
    Descuento[] descuentos;

    public Empresa(int nClientes) {
        clientes = new Cliente[nClientes];
        descuentos = new Descuento[]{
            new Descuento(30, 0.1f),
            new Descuento(90, 0.1f),
            new Descuento(120, 0.1f),
            new Descuento(180, 0.1f),
            new Descuento(Integer.MAX_VALUE, 0.1f)
        };
    }

    public void inicializarClientes() {
        String cif, nombre;
        int dven;
        float importe;
        Fecha fechaFra;
        for (int ncliente = 0; ncliente < clientes.length; ncliente++) {
            cif = Textos.pedirTextoTrim("Introduce el CIF");
            nombre = Textos.pedirTextoTrim("Introduce el nombre");
            fechaFra = Textos.pedirFecha("Introduce la fecha");
            dven = NumerosEnteros.pedirNumero("Introduce el numero de dias de vencimiento", 0);
            importe = NumerosReales.pedirNumero("Introduce el importe de la factura", 0);
            clientes[ncliente] = new Cliente(cif, nombre, fechaFra, dven, importe);
        }
    }
    public void informe(){
        Fecha hoy=new Fecha();
        System.out.println("\t\t\t\tINFORME DE FACTURAS");
    }
}
