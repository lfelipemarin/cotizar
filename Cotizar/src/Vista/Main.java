/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Controlador;
import Modelo.BaseDatos;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 *
 * @author Administrador
 */
public class Main {

    public static void main(String args[]) {

        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e) {
            System.out.println("fallo");
        }
        BaseDatos bd = new BaseDatos();
        JFrame vista = new FrmPrincipal();
        Controlador controlador = new Controlador(bd, vista);
        controlador.getVista().setVisible(true);
    }

}
