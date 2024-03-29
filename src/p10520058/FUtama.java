/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package p10520058;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author admin
 */
public class FUtama extends javax.swing.JFrame {
    
    Connection conn;

    /**
     * Creates new form FUtama
     */
    public FUtama() {
        initComponents();
        setupConnection();
        initializeState();
    }
    
    private void setupConnection() {
        conn = Koneksi.getConnection();
    }
    
    private void initializeState() {
        jMenu2.setVisible(false); // menu Data
        jMenu3.setVisible(false); // menu Pelayanan
        jMenu4.setVisible(false); // menu Laporan
        menuItemLogin.setEnabled(true); // menu item Login
        menuItemLogout.setEnabled(false); // menu item Logout
        jPanel1.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        loginButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        txtUsername = new javax.swing.JTextField();
        txtPassword = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        menuItemLogin = new javax.swing.JMenuItem();
        menuItemLogout = new javax.swing.JMenuItem();
        menuItemExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        menuItemMember = new javax.swing.JMenuItem();
        menuItemBook = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuItemBorrowing = new javax.swing.JMenuItem();
        menuItemReturning = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        menuItemBorrowingReport = new javax.swing.JMenuItem();
        menuItemReturningReport = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 0, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN");

        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Username");

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Password");

        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Cancel");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(143, 143, 143)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loginButton)
                .addGap(18, 18, 18)
                .addComponent(cancelButton)
                .addGap(101, 101, 101))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(45, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(loginButton)
                    .addComponent(cancelButton))
                .addContainerGap(44, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("APLIKASI SISTEM INFORMASI PERPUSTAKAAN");

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/p10520058/WIN_20220723_18_27_42_Pro (2) - resized(1).jpg"))); // NOI18N

        jLabel6.setText("IRSHAL FIRDEANSYAH");

        jLabel8.setText("10520058");

        jMenu1.setText("File");

        menuItemLogin.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemLogin.setText("Login");
        menuItemLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLoginActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLogin);

        menuItemLogout.setText("Logout");
        menuItemLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemLogoutActionPerformed(evt);
            }
        });
        jMenu1.add(menuItemLogout);

        menuItemExit.setText("Exit");
        jMenu1.add(menuItemExit);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Data");

        menuItemMember.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemMember.setText("Anggota");
        menuItemMember.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemMemberActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemMember);

        menuItemBook.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        menuItemBook.setText("Buku");
        menuItemBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBookActionPerformed(evt);
            }
        });
        jMenu2.add(menuItemBook);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Pelayanan");

        menuItemBorrowing.setText("Peminjaman");
        menuItemBorrowing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBorrowingActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemBorrowing);

        menuItemReturning.setText("Pengembalian");
        menuItemReturning.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReturningActionPerformed(evt);
            }
        });
        jMenu3.add(menuItemReturning);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Laporan");

        menuItemBorrowingReport.setText("Peminjaman");
        menuItemBorrowingReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemBorrowingReportActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemBorrowingReport);

        menuItemReturningReport.setText("Pengembalian");
        menuItemReturningReport.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemReturningReportActionPerformed(evt);
            }
        });
        jMenu4.add(menuItemReturningReport);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel4))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel5)))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8))
                            .addComponent(jLabel7)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jLabel4)))
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLoginActionPerformed
        jPanel1.setVisible(true);
    }//GEN-LAST:event_menuItemLoginActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        String sql;
        String username = txtUsername.getText();
        String password = txtPassword.getText();
        try { 
            sql ="SELECT * FROM pengguna WHERE username ='" + txtUsername.getText() + "'";
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs =st.executeQuery(); 
            if (rs.next()) {
                String pass = rs.getString("password");
                String bagian = rs.getString("bagian");
                if (password.equals(pass)){
                    JOptionPane.showMessageDialog(this, "Login Berhasil");
                    if (bagian.equals("Sirkulasi")) {
                        jMenu2.setVisible(false); // menu Data
                        jMenu3.setVisible(true); // menu Pelayanan
                        jMenu4.setVisible(true); // menu Laporan
                        menuItemLogin.setEnabled(false); // menu item Login
                        menuItemLogout.setEnabled(true); // menu item Logout
                        jPanel1.setVisible(false);
                    } else {
                        jMenu2.setVisible(true); // menu Data
                        jMenu3.setVisible(true); // menu Pelayanan
                        jMenu4.setVisible(true); // menu Laporan
                        menuItemLogin.setEnabled(false); // menu item Login
                        menuItemLogout.setEnabled(true); // menu item Logout
                        jPanel1.setVisible(false);
                    }
                    txtUsername.setText("");
                    txtPassword.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Password tidak sesuai");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Username " + username + " tidak ditemukan!");
            }
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(this,e.getMessage());
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
         jPanel1.setVisible(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void menuItemMemberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemMemberActionPerformed
        FAnggota a = new FAnggota();
        a.setVisible(true);
    }//GEN-LAST:event_menuItemMemberActionPerformed

    private void menuItemBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBookActionPerformed
        FBuku fBuku = new FBuku();
        fBuku.setVisible(true);
    }//GEN-LAST:event_menuItemBookActionPerformed

    private void menuItemBorrowingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBorrowingActionPerformed
        FPeminjaman fPeminjaman = new FPeminjaman();
        fPeminjaman.setVisible(true);
    }//GEN-LAST:event_menuItemBorrowingActionPerformed

    private void menuItemLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemLogoutActionPerformed
        initializeState();
    }//GEN-LAST:event_menuItemLogoutActionPerformed

    private void menuItemReturningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReturningActionPerformed
        FPengembalian fPengembalian = new FPengembalian();
        fPengembalian.setVisible(true);
    }//GEN-LAST:event_menuItemReturningActionPerformed

    private void menuItemBorrowingReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemBorrowingReportActionPerformed
        previewBorrowingData();
    }//GEN-LAST:event_menuItemBorrowingReportActionPerformed

    private void menuItemReturningReportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemReturningReportActionPerformed
        previewReturningData();
    }//GEN-LAST:event_menuItemReturningReportActionPerformed

    private void previewBorrowingData() {
        try {
            String reportPath = "/home/irlfdyh/JaspersoftWorkspace/MyReports/Peminjaman.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            // Do something here
        }
    }
    
    private void previewReturningData() {
        try {
            String reportPath = "/home/irlfdyh/JaspersoftWorkspace/MyReports/Pengembalian.jrxml";
            JasperReport jr = JasperCompileManager.compileReport(reportPath);
            JasperPrint jp = JasperFillManager.fillReport(jr,null, conn);
            JasperViewer.viewReport(jp, false);
        } catch (JRException e) {
            // Do something here
        }
    }
    
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
            java.util.logging.Logger.getLogger(FUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginButton;
    private javax.swing.JMenuItem menuItemBook;
    private javax.swing.JMenuItem menuItemBorrowing;
    private javax.swing.JMenuItem menuItemBorrowingReport;
    private javax.swing.JMenuItem menuItemExit;
    private javax.swing.JMenuItem menuItemLogin;
    private javax.swing.JMenuItem menuItemLogout;
    private javax.swing.JMenuItem menuItemMember;
    private javax.swing.JMenuItem menuItemReturning;
    private javax.swing.JMenuItem menuItemReturningReport;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtUsername;
    // End of variables declaration//GEN-END:variables
}
