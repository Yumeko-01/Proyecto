/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author medin
 */
public class Silla {
    private TipoSilla tipoSilla;
    private int fila;
    private int columna;
    private boolean ocupada;
    int numero;

    public Silla(TipoSilla tipoSilla, int fila, int columna) {
        this.tipoSilla = tipoSilla;
        this.fila = fila;
        this.columna = columna;
        this.ocupada = false;
    }

    public TipoSilla getTipoSilla() {
        return tipoSilla;
    }

    public int getFila() {
        return fila;
    }

    public int getColumna() {
        return columna;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void ocupar() {
        ocupada = true;
    }

    public void desocupar() {
        ocupada = false;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    void setOcupada(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}





