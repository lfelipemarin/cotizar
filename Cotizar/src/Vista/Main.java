/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.Modelo;
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

        Modelo modelo = new Modelo();
        FrmPrincipal vista = new FrmPrincipal();
        Controlador controlador = new Controlador(modelo, vista);
        controlador.getVista().setVisible(true);
        controlador.getModelo().crearConexion();
        controlador.accionLogin();

 
    }

}
