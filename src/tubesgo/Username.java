/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Username extends javax.swing.JFrame {

    /**
     * Creates new form Username
     */
    Connection con;
    Statement stat;
    ResultSet rs;
    public static String sql,Namapemain1,Namapemain2;
    
    
    public Username() {
        initComponents();
        this.setLocationRelativeTo(null);
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NamaPengguna = new javax.swing.JLabel();
        NamaPemainSatu = new javax.swing.JLabel();
        NamaPemainDua = new javax.swing.JLabel();
        NamaP2 = new javax.swing.JTextField();
        NamaP1 = new javax.swing.JTextField();
        Mulai = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 360));
        getContentPane().setLayout(null);

        NamaPengguna.setFont(new java.awt.Font("Bodoni MT", 0, 24)); // NOI18N
        NamaPengguna.setForeground(new java.awt.Color(102, 255, 51));
        NamaPengguna.setText("NAMA PEMAIN");
        NamaPengguna.setAutoscrolls(true);
        getContentPane().add(NamaPengguna);
        NamaPengguna.setBounds(160, 30, 176, 29);

        NamaPemainSatu.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        NamaPemainSatu.setForeground(new java.awt.Color(102, 255, 51));
        NamaPemainSatu.setText("PEMAIN PERTAMA");
        getContentPane().add(NamaPemainSatu);
        NamaPemainSatu.setBounds(60, 140, 120, 16);

        NamaPemainDua.setFont(new java.awt.Font("Sitka Subheading", 1, 12)); // NOI18N
        NamaPemainDua.setForeground(new java.awt.Color(102, 255, 51));
        NamaPemainDua.setText("PEMAIN KEDUA");
        getContentPane().add(NamaPemainDua);
        NamaPemainDua.setBounds(300, 140, 100, 16);

        NamaP2.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        NamaP2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaP2ActionPerformed(evt);
            }
        });
        getContentPane().add(NamaP2);
        NamaP2.setBounds(260, 170, 190, 30);

        NamaP1.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 0, 18)); // NOI18N
        NamaP1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NamaP1ActionPerformed(evt);
            }
        });
        getContentPane().add(NamaP1);
        NamaP1.setBounds(20, 170, 190, 30);

        Mulai.setBackground(new java.awt.Color(102, 255, 51));
        Mulai.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        Mulai.setForeground(new java.awt.Color(102, 255, 51));
        Mulai.setText("MULAI");
        Mulai.setContentAreaFilled(false);
        Mulai.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Mulai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MulaiActionPerformed(evt);
            }
        });
        getContentPane().add(Mulai);
        Mulai.setBounds(190, 250, 90, 31);

        Background.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER-PC\\OneDrive\\Documents\\NetBeansProjects\\TUBESGO\\src\\img\\25462_ebccf7ef3916599d636a18f7d91e58b3.png")); // NOI18N
        Background.setText("jLabel1");
        getContentPane().add(Background);
        Background.setBounds(0, 0, 500, 320);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NamaP1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaP1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaP1ActionPerformed

    private void NamaP2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NamaP2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NamaP2ActionPerformed

    private void MulaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MulaiActionPerformed
        Namapemain1=NamaP1.getText();
        Namapemain2=NamaP2.getText();
        
        try {
            sql = "INSERT INTO player (nama_player1,nama_player2) VALUES ('"+Namapemain1+"','"+Namapemain2+"')";
            int i = stat.executeUpdate(sql);
            if(i!=0){
            this.setVisible(false);
            new Pong().setVisible(true);
            }
        } catch (Exception e) {
        }
        
        
    }//GEN-LAST:event_MulaiActionPerformed

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
            java.util.logging.Logger.getLogger(Username.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Username.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Username.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Username.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Username().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    public javax.swing.JButton Mulai;
    private javax.swing.JTextField NamaP1;
    private javax.swing.JTextField NamaP2;
    private javax.swing.JLabel NamaPemainDua;
    private javax.swing.JLabel NamaPemainSatu;
    private javax.swing.JLabel NamaPengguna;
    // End of variables declaration//GEN-END:variables
}
