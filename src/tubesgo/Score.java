/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ACER-PC
 */
public class Score extends javax.swing.JFrame {

    /**
     * Creates new form Score
     */
    Connection conn;
    Statement stat;
    ResultSet rs;
    String sql;
    
    public Score() {
        initComponents();
        this.setLocationRelativeTo(null);
        Koneksi DB = new Koneksi();
        DB.config();
        conn = DB.con;
        stat = DB.stm;
        
        tampilskor();
    }
     void tampilskor(){
   try{
       
            String sql = "SELECT * FROM score natural join player order by id_score desc limit 7";
            rs = stat.executeQuery(sql);
            DefaultTableModel table = (DefaultTableModel) tabelskor.getModel();
            int i = 0;
            while(rs.next()){
                table.addRow(new Object[]{ (rs.getString("nama_player1")),(rs.getInt("skor_1")),(rs.getString("nama_player2")), (rs.getInt("skor_2"))});
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Gagal menampilkan" + e.getMessage());
        }
   }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kembali = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelskor = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(480, 340));
        getContentPane().setLayout(null);

        kembali.setFont(new java.awt.Font("Yu Gothic", 1, 14)); // NOI18N
        kembali.setForeground(new java.awt.Color(102, 255, 51));
        kembali.setText("KEMBALI");
        kembali.setBorderPainted(false);
        kembali.setContentAreaFilled(false);
        kembali.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        getContentPane().add(kembali);
        kembali.setBounds(10, 260, 99, 31);

        jLabel2.setFont(new java.awt.Font("Yu Gothic Medium", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 204, 0));
        jLabel2.setText("RIWAYAT");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(210, 30, 70, 23);

        tabelskor.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        tabelskor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "PEMAIN 1", "SKOR", "PEMAIN 2", "SKOR"
            }
        ));
        jScrollPane1.setViewportView(tabelskor);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 100, 290, 140);

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\ACER-PC\\OneDrive\\Documents\\NetBeansProjects\\TUBESGO\\src\\img\\25462_ebccf7ef3916599d636a18f7d91e58b3.png")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 480, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        Music.clip.stop();
        this.setVisible(false);
        MenuAwal menu = new MenuAwal();
        menu.setVisible(true);
    }//GEN-LAST:event_kembaliActionPerformed

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
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Score.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Score().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton kembali;
    public javax.swing.JTable tabelskor;
    // End of variables declaration//GEN-END:variables
}