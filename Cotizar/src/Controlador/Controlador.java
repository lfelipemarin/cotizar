/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Properties;
import javax.swing.JDialog;
import javax.swing.JFrame;

/**
 *
 * @author FelipeWin
 */
public class Controlador {

    private Modelo modelo;
    private JFrame vista;

    public Controlador(Modelo modelo, JFrame vista) {
        this.modelo = modelo;
        this.vista = vista;
    }

    /**
     * @return the modelo
     */
    public Modelo getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(Modelo modelo) {
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

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        modelo.setConexion(conexion);
    }

    /**
     * @return the validar
     */
    public Validacion getValidar() {
        return modelo.getValidar();
    }

    /**
     * @param validar the validar to set
     */
    public void setValidar(Validacion validar) {
        modelo.setValidar(validar);
    }

    /**
     * @return the host
     */
    public String getUrl() {
        return modelo.getUrl();
    }

    /**
     * @param url the host to set
     */
    public void setUrl(String url) {
        modelo.setUrl(url);
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return modelo.getUsuario();
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        modelo.setUsuario(usuario);
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return modelo.getContraseña();
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        modelo.setContraseña(contraseña);
    }

    /**
     * @return the config
     */
    public Properties getConfig() {
        return modelo.getConfig();
    }

    /**
     * @param config the config to set
     */
    public void setConfig(Properties config) {
        modelo.setConfig(config);
    }

    public void eventoConfig(final String url, final String usuario, final String contraseña) {
        if (modelo.crearConexion() == false) {
            modelo.configConexion(url, usuario, contraseña);
        }
//            modelo.crearConexion();

    }

}
