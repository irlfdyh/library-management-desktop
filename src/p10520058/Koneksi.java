/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p10520058;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Mahasiswa
 */
public class Koneksi {
    private static final String HOST="localhost";
    private static final String DB="perpus_10520058";
    private static final String USER="root";
    private static final String PASS="";
    private static Connection conn;

    public static Connection getConnection(){
        if (conn == null) {
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                conn = DriverManager.getConnection("jdbc:mysql://"+HOST+"/"+DB,USER,PASS);
            }catch(ClassNotFoundException cnfe){
                System.out.println("Driver Tidak Ditemukan ="+ cnfe);
            } catch(SQLException ex) {
                System.out.println("Koneksi Gagal ="+ ex);
            }
        }
        return conn;
    }

}
