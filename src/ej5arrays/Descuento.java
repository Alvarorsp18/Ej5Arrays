/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej5arrays;

/**
 *
 * @author dam
 */
public class Descuento {
    private int limite;
    private Float descuento;

    public Descuento(int limite, Float descuento) {
        this.limite = limite;
        this.descuento = descuento;
    }

    public int getLimite() {
        return limite;
    }

    public Float getDescuento() {
        return descuento;
    }
    
}
