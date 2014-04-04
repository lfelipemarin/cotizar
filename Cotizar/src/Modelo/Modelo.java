/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Controlador.Validacion;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author FelipeWin
 */
public class Modelo {

    private Connection conexion;
    private Validacion validar;
    private String url;
    private String usuario;
    private String contraseña;
    private Properties config = new Properties();
    private FileInputStream in;
    FileOutputStream out;

    public Modelo() {
        try {
            in = new FileInputStream("propiedadesBd.properties");
            config = new Properties();
            config.load(in);
            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.url = config.getProperty("url");
        this.usuario = config.getProperty("username");
        this.contraseña = config.getProperty("password");

    }

    public Connection getConexion() {
        return conexion;
    }

    public boolean configConexion(String url, String usuario, String contraseña) {
        try {
            out = new FileOutputStream("propiedadesBd.properties");
            config.setProperty("url", url);
            config.setProperty("username", usuario);
            config.setProperty("password", contraseña);
            config.store(out, null);
            out.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        try {
            in = new FileInputStream("propiedadesBd.properties");
            config = new Properties();
            config.load(in);
            in.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }

        this.url = config.getProperty("url");
        this.usuario = config.getProperty("username");
        this.contraseña = config.getProperty("password");
        return this.crearConexion();
    }

    public boolean crearConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            setConexion(DriverManager.getConnection(getUrl(), getUsuario(), getContraseña()));
            System.out.println("conectado");
        } catch (SQLException | ClassNotFoundException ex) {
            setValidar(new Validacion());
            getValidar().mensajeError("No se pudo connectar a la base de datos, tenga en cuenta lo siguiente:"
                    + "\n*Vefique la conexión de su ordenador a la red o el internet e intente ingresar de nuevo a la aplicación."
                    + "\n*Verifique que el servidor este encendido."
                    + "\n*Ingrese al menu de administrador para configurar los parametros de conexión."
                    + "\n*Verifique que la aplicación Xampp este corriendo en el servidor. de no ser así, ejecutela e intente ingresar de nuevo a la aplicación"
                    + "\n\nDescripción del error: " + ex + ""
                    + "\n\nSI NO SE HA SOLUCIONADO EL PROBLEMA Y NO ENTIENDE EL ERROR, COMUNICARSE CON EL ADMINISTRADOR ", "ERROR");
            return false;
        }
        return true;
    }

    public boolean ejecutarSQL(String sql) {
        try {
            Statement sentencia = getConexion().createStatement();
            sentencia.executeUpdate(sql);
        } catch (SQLException ex) {
            return false;
        }
        return true;
    }

    /**
     *
     * Método utilizado para realizar la instrucción SELECT
     *
     * @param sql Cadena que contiene la instrucción SQL a ejecutar
     * @return resultado regresa los registros generados por la consulta
     *     
*/
    public ResultSet ejecutarSQLSelect(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException ex) {

            return null;
        }
        return resultado;
    }

    public void cerrarBd() {
        try {
            getConexion().close();
            System.out.print("desconectado");
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
            getValidar().mensajeError("Error: " + ex, "Error");
        }
    }

     public void ResultSetATabla(ResultSet rs, ArrayList cabecera, JTable tabla) {
        try {
            ResultSetMetaData md = rs.getMetaData();
            DefaultTableModel dm = new DefaultTableModel();
            int columnas = md.getColumnCount();
            for (int i = 0; i < cabecera.size(); i++) {
                dm.addColumn(cabecera.get(i).toString());
            }
            Object row[] = new Object[columnas];
           
            while (rs.next()) {
                for (int i = 0; i < columnas; i++) {
                    row[i] = rs.getString(i + 1);
                }
                dm.addRow(row);
            }
            RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(dm);
            tabla.setModel(dm);
            tabla.setRowSorter(sorter);
            tabla.setBorder(BorderFactory.createRaisedBevelBorder());
        } catch (SQLException ex) {
            Logger.getLogger(Modelo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param conexion the conexion to set
     */
    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    /**
     * @return the validar
     */
    public Validacion getValidar() {
        return validar;
    }

    /**
     * @param validar the validar to set
     */
    public void setValidar(Validacion validar) {
        this.validar = validar;
    }

    /**
     * @return the host
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    /**
     * @return the config
     */
    public Properties getConfig() {
        return config;
    }

    /**
     * @param config the config to set
     */
    public void setConfig(Properties config) {
        this.config = config;
    }
}
