/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Controlador.Validacion;
import Modelo.Modelo;
import com.mxrck.autocompleter.TextAutoCompleter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author JHON
 */
public class Dl_Agregar_Entidad extends javax.swing.JDialog {

    Modelo con = new Modelo();
    Validacion validar;

    /**
     * Creates new form Dl_Agregar_Entidad
     *
     * @param parent
     * @param modal
     */
    public Dl_Agregar_Entidad(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        validar = new Validacion();

        con.crearConexion();

        TextAutoCompleter txtentidad = new TextAutoCompleter(TxtNombreEntidad);
        txtentidad.setMode(0);
        // recorro toda la tabla para traer los datos al campo para autocompletar
        ResultSet autocompletarentidad = con.ejecutarSQLSelect("SELECT NombreEntidad FROM entidades_promotoras_salud ORDER BY NombreEntidad ASC ");
        try {
            while (autocompletarentidad.next()) {
                txtentidad.addItem(autocompletarentidad.getString("NombreEntidad"));
            }
        } catch (SQLException ex) {
            con.cerrarBd();
            validar.mensajeError("Error al tratar de traer los datos de la entidad. Error: " + ex, "Error");
            return;
        }

        ArrayList cabecera = new ArrayList();

        String Nombre = "NOMBRE";
        String cod = "CODIGO";
        String bool = "BOOL";

        cabecera.add(Nombre);
        cabecera.add(cod);
        cabecera.add(bool);

        final ResultSet datos = con.ejecutarSQLSelect("SELECT NombreEntidad, CodEntidad, bool FROM entidades_promotoras_salud ORDER BY NombreEntidad ASC ");
        con.ResultSetATabla(datos, cabecera, this.TblEntidadesAgregadas);
        this.TblEntidadesAgregadas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                con.crearConexion();
                if (e.getClickCount() == 1) {
                    try {
                        JTable target = (JTable) e.getSource();
                        int row = target.getSelectedRow();
                        int column0 = 0;
                        // do some action if appropriate column
                        String Nombre = target.getModel().getValueAt(row, column0).toString();
                        ResultSet res = con.ejecutarSQLSelect("SELECT * FROM entidades_promotoras_salud WHERE NombreEntidad = '" + Nombre + "'");
                        while (res.next()) {
                            TxtNombreEntidad.setText(res.getString("NombreEntidad"));
                            TxtCodEntidad.setText(res.getString("CodEntidad"));
                            BtnAgregar.setEnabled(false);
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(Dl_Agregar_Entidad.class.getName()).log(Level.SEVERE, null, ex);
                        validar.mensajeError("Error al seleccionar las Entidasdes promotoras almacenadas en el sistema", "Error");
                        con.cerrarBd();
                        return;
                    }
                }
                con.cerrarBd();

            }
        });
        con.cerrarBd();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TblEntidadesAgregadas = new javax.swing.JTable();
        TxtNombreEntidad = new javax.swing.JTextField();
        TxtCodEntidad = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        BtnAgregar = new javax.swing.JButton();
        BtnLimpiar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("AGREGAR ENTIDADES PROMOTORAS DE SALUD (EPS)");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Nombre de la entidad:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Código de la entidad (Opcional):");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Lista de entidades promotoras de salud agregadas al sistema");

        TblEntidadesAgregadas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TblEntidadesAgregadas);

        TxtNombreEntidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        TxtNombreEntidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TxtNombreEntidadKeyReleased(evt);
            }
        });

        TxtCodEntidad.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Agregar o modificar entedades del sistema");
        jLabel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        BtnAgregar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        BtnAgregar.setText("Agregar");
        BtnAgregar.setBorderPainted(false);
        BtnAgregar.setContentAreaFilled(false);
        BtnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnAgregar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnAgregar.setIconTextGap(-3);
        BtnAgregar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnAgregar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnAgregar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAgregarActionPerformed(evt);
            }
        });

        BtnLimpiar.setFont(new java.awt.Font("Tahoma", 3, 11)); // NOI18N
        BtnLimpiar.setText("Limpiar");
        BtnLimpiar.setBorderPainted(false);
        BtnLimpiar.setContentAreaFilled(false);
        BtnLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BtnLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        BtnLimpiar.setIconTextGap(-3);
        BtnLimpiar.setMargin(new java.awt.Insets(0, 0, 0, 0));
        BtnLimpiar.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        BtnLimpiar.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        BtnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(BtnLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BtnAgregar)
                    .addComponent(BtnLimpiar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(TxtCodEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(76, 76, 76)
                        .addComponent(TxtNombreEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(TxtNombreEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(TxtCodEntidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TxtNombreEntidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TxtNombreEntidadKeyReleased
        TxtNombreEntidad.setText(TxtNombreEntidad.getText().toUpperCase());
    }//GEN-LAST:event_TxtNombreEntidadKeyReleased

    private void BtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAgregarActionPerformed

        if (validar.validarCampo(this.TxtNombreEntidad.getText(), "Debe ingresar el nombre de la entidad promotra que desea registrar")) {
            this.TxtNombreEntidad.requestFocus();
            return;
        }
        con.crearConexion();
        ResultSet InsertEntediad = con.ejecutarSQLSelect("SELECT * FROM entidades_promotoras_salud WHERE NombreEntidad = '" + this.TxtNombreEntidad.getText() + "'");
        try {
            if (InsertEntediad.next()) {
                validar.mensajeInformacion("Esta entidad ya esta ingresda en el sistema", "Información");
                con.cerrarBd();
                return;
            } else {
                if (con.ejecutarSQL("INSERT INTO entidades_promotoras_salud (NombreEntidad, CodEntidad ) "
                        + " VALUES " + "('" + this.TxtNombreEntidad.getText() + "','" + this.TxtCodEntidad.getText() + "');")) {

                    validar.mensajeOk("La nueva entidad se ha ingresado en el sistema correctamente correctamente", "Registro");
                    con.cerrarBd();
                    this.dispose();
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(Dl_Agregar_Entidad.class.getName()).log(Level.SEVERE, null, ex);
            validar.mensajeError("Error al intentar guardar, verifique la información ingresada. y vuelva a intentarlo", "Error");
            con.cerrarBd();
            return;
        }
    }//GEN-LAST:event_BtnAgregarActionPerformed

    private void BtnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnLimpiarActionPerformed

        this.TxtCodEntidad.setText("");
        this.TxtNombreEntidad.setText("");
        this.BtnAgregar.setEnabled(true);

    }//GEN-LAST:event_BtnLimpiarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dl_Agregar_Entidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dl_Agregar_Entidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dl_Agregar_Entidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dl_Agregar_Entidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Dl_Agregar_Entidad dialog = new Dl_Agregar_Entidad(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAgregar;
    private javax.swing.JButton BtnLimpiar;
    private javax.swing.JTable TblEntidadesAgregadas;
    private javax.swing.JTextField TxtCodEntidad;
    private javax.swing.JTextField TxtNombreEntidad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
