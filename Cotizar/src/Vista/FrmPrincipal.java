/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Dimension;

/**
 *
 * @author FelipeWin
 */
public class FrmPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FrmPrincipal
     */
    public FrmPrincipal() {
        initComponents();
        Dimension ScreenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize(ScreenSize);
        this.setExtendedState(FrmPrincipal.MAXIMIZED_BOTH);
        IfLogin Login = new IfLogin();
        pnlEscritorio.add(Login);
        Login.setLocation(this.getWidth() / 2 - Login.getWidth() / 2 - 20, this.getHeight() / 2 - Login.getHeight() / 2 - 80);
        Login.setVisible(true);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlEscritorio = new javax.swing.JDesktopPane();
        jLabel1 = new javax.swing.JLabel();
        lblUsuarioLogueado = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        barPrincipal = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        menAgregarUsuario = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FORMULARIO PRINCIPAL");

        pnlEscritorio.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Usuario logeuado:");

        lblUsuarioLogueado.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        lblUsuarioLogueado.setForeground(new java.awt.Color(255, 255, 255));
        lblUsuarioLogueado.setText("Usuario logeuado:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Hora de intreso:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha de ingreso:");

        javax.swing.GroupLayout pnlEscritorioLayout = new javax.swing.GroupLayout(pnlEscritorio);
        pnlEscritorio.setLayout(pnlEscritorioLayout);
        pnlEscritorioLayout.setHorizontalGroup(
            pnlEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlEscritorioLayout.createSequentialGroup()
                .addContainerGap(540, Short.MAX_VALUE)
                .addGroup(pnlEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlEscritorioLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblUsuarioLogueado, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(171, 171, 171))
        );
        pnlEscritorioLayout.setVerticalGroup(
            pnlEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlEscritorioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(pnlEscritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblUsuarioLogueado))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addContainerGap(393, Short.MAX_VALUE))
        );
        pnlEscritorio.setLayer(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlEscritorio.setLayer(lblUsuarioLogueado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlEscritorio.setLayer(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);
        pnlEscritorio.setLayer(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/BuscarLupa2.png"))); // NOI18N
        jMenu3.setText("Buscar");
        jMenu3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu3.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        barPrincipal.add(jMenu3);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Administrador2.png"))); // NOI18N
        jMenu1.setText("Administrador");
        jMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenu1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N

        menAgregarUsuario.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        menAgregarUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Asistencial1.png"))); // NOI18N
        menAgregarUsuario.setText("Agregar usuario al sistema");
        menAgregarUsuario.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        menAgregarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menAgregarUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(menAgregarUsuario);

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 2, 14)); // NOI18N
        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Vista/Imagenes/Administrador1.png"))); // NOI18N
        jMenuItem1.setText("Configurar la conexión");
        jMenuItem1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        barPrincipal.add(jMenu1);

        setJMenuBar(barPrincipal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEscritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlEscritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menAgregarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menAgregarUsuarioActionPerformed
        DlAgregarUsuario AgregarUsuario;
        AgregarUsuario = new DlAgregarUsuario(null, true);
        AgregarUsuario.setVisible(true);
    }//GEN-LAST:event_menAgregarUsuarioActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DlConfigConexion configurarconexion;
        configurarconexion = new DlConfigConexion(null, true);
        configurarconexion.setVisible(true);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barPrincipal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JLabel lblUsuarioLogueado;
    private javax.swing.JMenuItem menAgregarUsuario;
    public static javax.swing.JDesktopPane pnlEscritorio;
    // End of variables declaration//GEN-END:variables
}
