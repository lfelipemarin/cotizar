/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.BaseDatos;
import javax.swing.JFrame;

/**
 *
 * @author FelipeWin
 */
public class Controlador {

    private BaseDatos modelo;
    private JFrame vista;

    public Controlador(BaseDatos modelo, JFrame vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    /**
     * @return the modelo
     */
    public BaseDatos getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(BaseDatos modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the vista
     */
    public JFrame getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(JFrame vista) {
        this.vista = vista;
    }

}
