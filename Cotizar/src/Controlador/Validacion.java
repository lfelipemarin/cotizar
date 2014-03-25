/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author FelipeWin
 */
public class Validacion {

    public void mensajeError(String mensaje, String Titulo) {
        JOptionPane.showMessageDialog(null, mensaje, Titulo, JOptionPane.ERROR_MESSAGE);
    }

    public void mensajeInformacion(String mensaje, String Titulo) {
        JOptionPane.showMessageDialog(null, mensaje, Titulo, JOptionPane.INFORMATION_MESSAGE);
    }

    public void mensajeAlerta(String mensaje, String Titulo) {
        JOptionPane.showMessageDialog(null, mensaje, Titulo, JOptionPane.WARNING_MESSAGE);
    }

    public void mensajeInterrogante(String mensaje, String Titulo) {
        JOptionPane.showMessageDialog(null, mensaje, Titulo, JOptionPane.QUESTION_MESSAGE);
    }

    public void mensajeSinImagen(String mensajea, String Titulo) {
        JOptionPane.showMessageDialog(null, mensajea, Titulo, JOptionPane.PLAIN_MESSAGE);
    }

    public void mensajeOk(String mensajea, String Titulo) {
        Icon icono = new ImageIcon("E:\\Aplicaciones indec\\SICEINDEC\\SICEINDEC\\src\\imagenes\\iconos\\Ok.png");
        JOptionPane.showMessageDialog(null, mensajea, Titulo, JOptionPane.PLAIN_MESSAGE, icono);
    }

    public boolean validarSeleccion(String texto, String mensaje) {
        if (texto.equals("Seleccione")) {
            mensajeAlerta(mensaje, "Alerta");
            return true;
        } else {
            return false;
        }
    }

    public String check(JCheckBox dato) {
        if (dato.isSelected()) {
            return "Si";
        } else {
            return "No";
        }
    }

    public boolean validarCampo(String texto, String mensaje) {
        if (texto.equals("")) {
            mensajeAlerta(mensaje, "Alerta");
            return true;
        } else {
            return false;
        }
    }

    public boolean validarCampo(String texto) {
        if (texto.equals("")) {
            return true;
        } else {
            return false;
        }
    }

    public boolean validarCampoRep(String con1, String con2, String mensaje) {
        if (con1.equals(con2)) {
            return false;
        } else {
            mensajeAlerta(mensaje, "Alerta");
            return true;
        }
    }

    public boolean retornaCheck(String valor) {
        if (valor.equals("Si")) {
            return true;
        } else {
            return false;
        }
    }

//    public java.util.Date fechaSQLAJava(java.sql.Date sql) {
//
//        Date fecha = new java.util.Date(sql.getYear(), sql.getMonth(), sql.getDate());
//        return fecha;
//
//    }

    public java.sql.Date fechaJavaASQL(java.util.Date fecha) {
        java.sql.Date date;

        date = new java.sql.Date(fecha.getYear(), fecha.getMonth(), fecha.getDate());
        return date;

    }

    public boolean validarFecha() {
        return false;

    }
}
