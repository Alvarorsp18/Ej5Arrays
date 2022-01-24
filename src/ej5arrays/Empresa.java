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
            new Descuento(90, 0.07f),
            new Descuento(120, 0.05f),
            new Descuento(180, 0.02f),
            new Descuento(Integer.MAX_VALUE, 0f)
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

    public void informe() {
        Fecha hoy = new Fecha();
        float descuento, importeNeto;
        int pos;
        int mesSig=hoy.getMes()+1;
        int annoSig=hoy.getAnno();
        if(mesSig>11){
            annoSig++;
            mesSig=0;
        }
        System.out.println("\t\t\t\tINFORME DE FACTURAS");
        System.out.println("Fecha:" + hoy.fechaCompleta());
        System.out.println("CIF \t NOMBRE \t FECHA \t FACTURA \t IMPORTE BRUTO \t FECHA VECIMIENTO \t IMPORTE NETO");
        for (int ncliente = 0; ncliente < clientes.length; ncliente++) {
            pos = busqueda(clientes[ncliente].getDiasVen());
            if (pos == -1) {
                descuento = 0;
            } else {
                descuento = clientes[ncliente].getImporte() * descuentos[pos].getDescuento();
            }
            importeNeto = clientes[ncliente].getImporte() - descuento;
            Fecha vencimiento = new Fecha(
                    clientes[ncliente].getFechaFra().getDia(),
                    clientes[ncliente].getFechaFra().getMes(),
                    clientes[ncliente].getFechaFra().getAnno());
            vencimiento.calcularVencimiento(clientes[ncliente].getDiasVen());
            if(importeNeto>10000 && vencimiento.getMes()==mesSig && vencimiento.getAnno()==annoSig){
            System.out.print(clientes[ncliente].getCif());
            System.out.print("\t" + clientes[ncliente].getNombre());
            System.out.print("\t" + clientes[ncliente].getFechaFra().fechaCompleta());
            System.out.print("\t" + clientes[ncliente].getImporte());
            System.out.print("\t" + vencimiento.fechaCompleta());
            System.out.print("\t" + importeNeto);
            }
        }
    }

    /**
     *
     * @param valor del elemento a buscar
     * @return posicion del valor encontrad
     */
    public int busqueda(int valor) {
        int pos = 0;
        boolean encontrado = false;
        while (!encontrado && pos < descuentos.length) {
            if (valor > descuentos[pos].getLimite()) 
                pos++;
            else 
                encontrado = true;
            }
            if (!encontrado) {
                pos = -1;
        }
        return pos;
    }
}
