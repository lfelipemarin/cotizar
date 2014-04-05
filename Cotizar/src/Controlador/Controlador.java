/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Modelo;
import Vista.FrmPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
//import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

/**
 *
 * @author FelipeWin
 */
public class Controlador {

    private Modelo modelo;
    private FrmPrincipal vista;
    private final Validacion validar = new Validacion();
    BListener accion = new BListener();

    public Controlador(Modelo modelo, FrmPrincipal vista) {
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
    public FrmPrincipal getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(FrmPrincipal vista) {
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

    public void accionLogin() {
        JButton aceptar = vista.getLogin().getBtnAceptar();
        JButton cancelar = vista.getLogin().getBtnCancelar();
        aceptar.addActionListener(accion);
        cancelar.addActionListener(accion);
    }

    public void accionAgregarUsuario() {
        JMenuItem mostrarAgregarUsuario = vista.getMenAgregarUsuario();
        mostrarAgregarUsuario.addActionListener(accion);
        JButton agregar = vista.getAgregarUsuario().getBtnAgregar();
        agregar.addActionListener(accion);
    }

    private class BListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton aceptar = vista.getLogin().getBtnAceptar();
            JButton cancelar = vista.getLogin().getBtnCancelar();
            JMenuItem mostrarAgregarUsuario = vista.getMenAgregarUsuario();
            JButton agregar = vista.getAgregarUsuario().getBtnAgregar();
            if (e.getSource() == aceptar) {
                try {
                    System.out.println("aceptar");
//                System.out.println("Bienvenido " + vista.getLogin().getTxtUsuario().getText());
                    ResultSet usuario = modelo.ejecutarSQLSelect("SELECT 1 FROM login WHERE usuario = '"
                            + vista.getLogin().getTxtUsuario().getText() + "'AND clave = '"
                            + vista.getLogin().getPssLogin().getText() + "'");
                    if (usuario.next()) {
                        System.out.println("Bienvenido " + vista.getLogin().getTxtUsuario().getText());
                    } else {
                        validar.mensajeAlerta("Nombre de usuario ó contraseña invalidos.", "Alerta");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                    validar.mensajeError("Mensaje " + ex, "Error");

                }
            } else if (e.getSource() == cancelar) {
                int seleccion = JOptionPane.showOptionDialog(
                        vista, //Componente padre
                        "Desea salir del programa",
                        "Seleccione una opción", //titulo
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null, //null para icono por defecto
                        new Object[]{"Si", "No"}, //null para yes, No y Cancel
                        "Si");
                if (seleccion != -1) {
                    if ((seleccion + 1) == 1) {
                        //Si
                        System.exit(0);
                    } else {
                        //No
                    }
                }
            } else if (e.getSource() == mostrarAgregarUsuario) {
                vista.getAgregarUsuario().setVisible(true);
            } else if (e.getSource() == agregar) {
                try {
                    String query = "INSERT INTO login (nombre_completo, usuario, clave, tipo_usuario, fecha_ingreso) VALUES (?, ?, ?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = modelo.getConexion().prepareStatement(query);
                    preparedStmt.setString(1, vista.getAgregarUsuario().getTxtNombreCompleto().getText());
                    preparedStmt.setString(2, vista.getAgregarUsuario().getTxtNuevoUsuario().getText());
                    preparedStmt.setString(3, vista.getAgregarUsuario().getTxtContraseñaUsuario().getText());
                    preparedStmt.setString(4, vista.getAgregarUsuario().getCmbTipoUsuario().getSelectedItem().toString());
                    preparedStmt.setTimestamp(5, new Timestamp(System.currentTimeMillis()));

                    // execute the preparedstatement
                    preparedStmt.execute();

                    modelo.getConexion().close();
                } catch (SQLException ex) {
                    Logger.getLogger(Controlador.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        }
    }
}
