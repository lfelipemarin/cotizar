/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.Modelo;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Administrador
 */
public class Main {

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("fallo");
        }
//        Modelo bd = new Modelo("localhost", "sis_sa", "root", "root");
        Modelo modelo = new Modelo();
        JFrame vista = new FrmPrincipal();
        final Controlador controlador = new Controlador(modelo, vista);
//        controlador.setUrl(controlador.getConfig().getProperty("url"));
//        controlador.setUsuario(controlador.getConfig().getProperty("username"));
//        controlador.setContraseña(controlador.getConfig().getProperty("password"));
        controlador.getVista().setVisible(true);
        controlador.getModelo().crearConexion();
//        while (controlador.getModelo().crearConexion() == false) {
//            final DlConfigConexion configConex;
//            configConex = new DlConfigConexion(null, true);
//
//            configConex.getBtnConfig().addActionListener(new ActionListener() {
//
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    String url = configConex.getTxtUrl().getText();
//                    String usuario = configConex.getTxtUsuario().getText();
//                    String contraseña = configConex.getTxtContraseña().getText();
//
//                    if (url.equals("")) {
//                        controlador.getValidar().mensajeAlerta("Url no puede estar vacío", "Alerta");
//                        return;
//                    }
//
//                    url = controlador.getConfig().getProperty("url");
//                    usuario = controlador.getConfig().getProperty("username");
//                    contraseña = controlador.getConfig().getProperty("password");
//                    controlador.setUrl(url);
//                    controlador.setUsuario(usuario);
//                    controlador.setContraseña(contraseña);
//                    controlador.getModelo().crearConexion();
//                }
//                
//            }
//            );
//            
//            configConex.setVisible(true);
//
//        }
//        controlador.getModelo().guardarDatosBdArchivo("url", url);
//            controlador.getModelo().guardarDatosBdArchivo("username", usuario);
//            controlador.getModelo().guardarDatosBdArchivo("password", contraseña);

    }

}
