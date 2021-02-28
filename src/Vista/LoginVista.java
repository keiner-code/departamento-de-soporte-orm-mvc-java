/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author KEINER
 */
public class LoginVista extends javax.swing.JFrame {

    /**
     * Creates new form LoginVista
     */
    public LoginVista() {
        initComponents();
       
    }

    @Override
    public Image getIconImage() {
       Image retValue = Toolkit.getDefaultToolkit().
                getImage(ClassLoader.getSystemResource("img/icono.png"));
       return retValue;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPasswordField1 = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1NombreLogin = new javax.swing.JTextField();
        jTextField2Contraseñalogin = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jButtoningresarlogin = new javax.swing.JButton();
        jButtonregistrarse = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jPasswordField1.setText("jPasswordField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setIconImage(getIconImage());
        setMinimumSize(new java.awt.Dimension(320, 460));
        getContentPane().setLayout(null);

        jPanel1.setLayout(null);

        jLabel3.setText("Iniciar Session");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(120, 180, 130, 14);

        jLabel1.setText("Nombre: ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(10, 216, 60, 14);

        jTextField1NombreLogin.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(jTextField1NombreLogin);
        jTextField1NombreLogin.setBounds(100, 210, 140, 20);

        jTextField2Contraseñalogin.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(jTextField2Contraseñalogin);
        jTextField2Contraseñalogin.setBounds(110, 260, 128, 20);

        jLabel2.setText("Contraseña");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 261, 70, 14);

        jButtoningresarlogin.setBackground(new java.awt.Color(204, 204, 255));
        jButtoningresarlogin.setText("Ingresar");
        jPanel1.add(jButtoningresarlogin);
        jButtoningresarlogin.setBounds(104, 328, 90, 23);

        jButtonregistrarse.setBackground(new java.awt.Color(204, 204, 255));
        jButtonregistrarse.setText("Registrarse");
        jPanel1.add(jButtonregistrarse);
        jButtonregistrarse.setBounds(183, 384, 110, 23);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo1.jpg"))); // NOI18N
        jPanel1.add(jLabel5);
        jLabel5.setBounds(70, 20, 170, 140);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/fondo.jpg"))); // NOI18N
        jPanel1.add(jLabel4);
        jLabel4.setBounds(0, 0, 310, 440);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 310, 440);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginVista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginVista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButtoningresarlogin;
    public javax.swing.JButton jButtonregistrarse;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPasswordField jPasswordField1;
    public javax.swing.JTextField jTextField1NombreLogin;
    public javax.swing.JPasswordField jTextField2Contraseñalogin;
    // End of variables declaration//GEN-END:variables
}
