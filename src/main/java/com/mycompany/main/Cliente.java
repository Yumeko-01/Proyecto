/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

/**
 *
 * @author medin
 */
public class Cliente {
    private String nombre;
    private String cedula;
    private TipoSilla tipoSilla;
    private int fila;
    private int columna;

    public Cliente(String nombre, String cedula, TipoSilla tipoSilla) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.tipoSilla = tipoSilla;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
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

    public void setFila(int fila) {
        this.fila = fila;
    }

    public void setColumna(int columna) {
        this.columna = columna;
    }
}




