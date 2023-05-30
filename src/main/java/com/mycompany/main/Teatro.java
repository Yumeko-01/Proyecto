/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;
import java.util.ArrayList;
import java.util.List;

public class Teatro {
    private static final int FILAS_PREFERENCIALES = 2;
    private static final int COLUMNAS_PREFERENCIALES = 4;
    private static final int FILAS_GENERALES = 7;
    private static final int COLUMNAS_GENERALES = 6;

    private Silla[][] sillasPreferenciales;
    private Silla[][] sillasGenerales;
    private List<Cliente> listaClientes;

    public Teatro() {
        sillasPreferenciales = new Silla[FILAS_PREFERENCIALES][COLUMNAS_PREFERENCIALES];
        sillasGenerales = new Silla[FILAS_GENERALES][COLUMNAS_GENERALES];
        listaClientes = new ArrayList<>();

        inicializarSillas();
    }

    private void inicializarSillas() {
        // Inicializar sillas preferenciales
        for (int fila = 0; fila < FILAS_PREFERENCIALES; fila++) {
            for (int columna = 0; columna < COLUMNAS_PREFERENCIALES; columna++) {
                sillasPreferenciales[fila][columna] = new Silla(TipoSilla.PREFERENCIAL, fila, columna);
            }
        }

        // Inicializar sillas generales
        for (int fila = 0; fila < FILAS_GENERALES; fila++) {
            for (int columna = 0; columna < COLUMNAS_GENERALES; columna++) {
                sillasGenerales[fila][columna] = new Silla(TipoSilla.GENERAL, fila, columna);
            }
        }
    }

    public boolean registrarCliente(Cliente cliente) {
        if (buscarClientePorCedula(cliente.getCedula()) != null) {
            return false; // El cliente ya está registrado
        }

        listaClientes.add(cliente);
        return true;
    }

    public Cliente buscarClientePorCedula(String cedula) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCedula().equals(cedula)) {
                return cliente;
            }
        }
        return null; // No se encontró el cliente con la cédula proporcionada
    }

    public boolean asignarSilla(Cliente cliente, int fila, int columna) {
        Silla[][] sillas;
        if (cliente.getTipoSilla() == TipoSilla.PREFERENCIAL) {
            sillas = sillasPreferenciales;
        } else {
            sillas = sillasGenerales;
        }

        if (esSillaValida(sillas, fila, columna) && !sillas[fila][columna].isOcupada()) {
            cliente.setFila(fila);
            cliente.setColumna(columna);
            sillas[fila][columna].setOcupada(true);
            return true;
        }

        return false;
    }

    private boolean esSillaValida(Silla[][] sillas, int fila, int columna) {
        return fila >= 0 && fila < sillas.length && columna >= 0 && columna < sillas[0].length;
    }

    public boolean eliminarCliente(String cedula) {
        Cliente cliente = buscarClientePorCedula(cedula);
        if (cliente != null) {
            Silla[][] sillas;
            if (cliente.getTipoSilla() == TipoSilla.PREFERENCIAL) {
                sillas = sillasPreferenciales;
            } else {
                sillas = sillasGenerales;
            }

            int fila = cliente.getFila();
            int columna = cliente.getColumna();
            if (esSillaValida(sillas, fila, columna)) {
                sillas[fila][columna].setOcupada(false);
            }

            listaClientes.remove(cliente);
            return true;
        }

        return false; // No se encontró el cliente con la cédula proporcionada
    }

    public Silla buscarSillaPorNumero(int numero) {
    // Buscar en sillas preferenciales
    for (int fila = 0; fila < FILAS_PREFERENCIALES; fila++) {
        for (int columna = 0; columna < COLUMNAS_PREFERENCIALES; columna++) {
            if (sillasPreferenciales[fila][columna].numero == numero) {
                return sillasPreferenciales[fila][columna];
            }
        }
    }

    // Buscar en sillas generales
    for (int fila = 0; fila < FILAS_GENERALES; fila++) {
        for (int columna = 0; columna < COLUMNAS_GENERALES; columna++) {
            if (sillasGenerales[fila][columna].numero == numero) {
                return sillasGenerales[fila][columna];
            }
        }
    }

    return null; // No se encontró una silla con el número proporcionado
}

    public boolean cambiarUbicacionSilla(Cliente cliente, int nuevaFila, int nuevaColumna) {
        Silla[][] sillas;
        if (cliente.getTipoSilla() == TipoSilla.PREFERENCIAL) {
            sillas = sillasPreferenciales;
        } else {
            sillas = sillasGenerales;
        }

        int filaActual = cliente.getFila();
        int columnaActual = cliente.getColumna();

        if (esSillaValida(sillas, nuevaFila, nuevaColumna) && !sillas[nuevaFila][nuevaColumna].isOcupada()) {
            sillas[filaActual][columnaActual].setOcupada(false);
            cliente.setFila(nuevaFila);
            cliente.setColumna(nuevaColumna);
            sillas[nuevaFila][nuevaColumna].setOcupada(true);
            return true;
        }

        return false;
    }

    public double calcularPorcentajeOcupacion() {
        int sillasPreferencialesOcupadas = contarSillasOcupadas(sillasPreferenciales);
        int sillasGeneralesOcupadas = contarSillasOcupadas(sillasGenerales);
        int sillasTotales = FILAS_PREFERENCIALES * COLUMNAS_PREFERENCIALES + FILAS_GENERALES * COLUMNAS_GENERALES;

        return (double) (sillasPreferencialesOcupadas + sillasGeneralesOcupadas) / sillasTotales * 100;
    }

    private int contarSillasOcupadas(Silla[][] sillas) {
        int contador = 0;
        for (int fila = 0; fila < sillas.length; fila++) {
            for (int columna = 0; columna < sillas[0].length; columna++) {
                if (sillas[fila][columna].isOcupada()) {
                    contador++;
                }
            }
        }
        return contador;
    }
}







