/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubesgo;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Koneksi {
    Connection con;
    Statement stm;
    Statement stat;
    ResultSet rs;
    String sql;
    
    public void config(){
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/pingpong?serverTimezone=UTC", "root", "");
            stm = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public  void buatSkor(int skor1,int skor2,String nama1,String nama2){
        
        int id = ambil_id(nama1,nama2);
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
         try {
            sql = "INSERT INTO score (skor_1,skor_2,id_player) VALUES ("+ skor1 +" ,"+ skor2 +" , "+ id +")";
            int i = stat.executeUpdate(sql);
                if (i != 0) {
                    System.out.println("Skor berhasil diinput");
                } else {
                    System.out.println("Gagal insert skor");
                }
        }catch (HeadlessException | SQLException e) {
            System.out.println("Skor Gagal Dimasukan" + e.getMessage());
        }       
    }
    
    
    public int ambil_id(String nama1,String nama2){
        int nilai = 0;
        Koneksi DB = new Koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;
        try {
            sql = "SELECT id_player FROM player WHERE nama_player1 = '"+ nama1 +"' AND nama_player2 = '"+nama2+"' LIMIT 1" ;
            rs = stat.executeQuery(sql);
            while(rs.next()){
                nilai = rs.getInt("id_player");    
                System.out.println("nilai");
            }

        }catch (HeadlessException | SQLException e) {
            System.out.println("Id Gagal diambil" + e.getMessage());
        }
        return nilai;
    }
   
    
   
}