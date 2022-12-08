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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class FPeminjaman extends javax.swing.JFrame {
    
    Connection conn;
    
    DefaultTableModel tabModel;

    /**
     * Creates new form FPeminjaman
     */
    public FPeminjaman() {
        initComponents();
        setupConnection();
        setupBookDataTable();
    }
    
    private void setupConnection() {
        conn = Koneksi.getConnection();
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNoPinjam = new javax.swing.JTextField();
        txtNoAnggota = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtTglPinjam = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        bookCodeField = new javax.swing.JTextField();
        bookTitleField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        bookStatusField = new javax.swing.JTextField();
        addBookButton = new javax.swing.JButton();
        deleteBookButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookDataTable = new javax.swing.JTable();
        addLoanButton = new javax.swing.JButton();
        saveLoanButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 204, 0));

        jPanel1.setBackground(new java.awt.Color(255, 204, 153));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("No Pinjam");

        txtNoAnggota.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNoAnggotaKeyPressed(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("No Anggota");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nama");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Tgl Pinjam");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNoAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(txtTglPinjam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNoAnggota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(153, 153, 153));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Kode Buku");

        bookCodeField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bookCodeFieldKeyPressed(evt);
            }
        });

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Judul");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Status");

        addBookButton.setText("Tambah");
        addBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBookButtonActionPerformed(evt);
            }
        });

        deleteBookButton.setText("Hapus");
        deleteBookButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBookButtonActionPerformed(evt);
            }
        });

        bookDataTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(bookDataTable);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(addBookButton)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(deleteBookButton)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(bookCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(141, 141, 141)
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bookStatusField, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(18, 18, 18))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookCodeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(bookStatusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bookTitleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deleteBookButton)
                    .addComponent(addBookButton))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        addLoanButton.setText("Tambah");
        addLoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addLoanButtonActionPerformed(evt);
            }
        });

        saveLoanButton.setText("Simpan");
        saveLoanButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveLoanButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Batal");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Tutup");
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(addLoanButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveLoanButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(closeButton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addLoanButton)
                    .addComponent(saveLoanButton)
                    .addComponent(cancelButton)
                    .addComponent(closeButton))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBookButtonActionPerformed
        String KodeBuku;
        boolean ketemu = false;
        int jum = tabModel.getRowCount();
        
        if (bookStatusField.getText().equalsIgnoreCase("Tersedia")) {
            for (int i=0; i < jum; i++) {
                KodeBuku = tabModel.getValueAt(i, 0).toString();
                if (KodeBuku.equalsIgnoreCase(bookCodeField.getText())) {
                    JOptionPane.showMessageDialog(this,"Buku Sudah Ada Pada List Pinjaman");
                    ketemu=true;
                    bookDataTable.setRowSelectionInterval(i, i);
                    break;
                }
            }
            if (ketemu == false) {
                String Data[] = {bookCodeField.getText(), bookTitleField.getText()};
                tabModel.addRow(Data);
                bookCodeField.setText("");
                bookTitleField.setText("");
                bookStatusField.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Buku ini sedang dipinjam","Informasi",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_addBookButtonActionPerformed

    private void deleteBookButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBookButtonActionPerformed
        int row = bookDataTable.getSelectedRow();
        if(row >= 0)
            tabModel.removeRow(row);
        else
            JOptionPane.showMessageDialog(this, "Hapus Gagal");
    }//GEN-LAST:event_deleteBookButtonActionPerformed

    private void addLoanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addLoanButtonActionPerformed
        Date tgl_sekarang=new Date();
        SimpleDateFormat format=new SimpleDateFormat("y-m-d");
        String tgl=format.format(tgl_sekarang);
        txtTglPinjam.setText(tgl);
        txtNoPinjam.setEnabled(true);
        txtNoAnggota.setEnabled(true);
        bookCodeField.setEnabled(true);
    }//GEN-LAST:event_addLoanButtonActionPerformed

    private void saveLoanButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveLoanButtonActionPerformed
        try {
            if (txtNama.getText().isEmpty() || tabModel.getRowCount()==0 ) {
                JOptionPane.showMessageDialog(this,"Silahkan Input Anggota dan Buku");
            } else {
                // Menyimpan ke Tabel Pinjam
                String sql="INSERT  INTO pinjam VALUES(?, ?, ?)";
                PreparedStatement st=conn.prepareStatement(sql);
                st.setString(1,txtNoPinjam.getText());
                st.setString(2,txtTglPinjam.getText());
                st.setString(3,txtNoAnggota.getText());
                int rs = st.executeUpdate();
                String KodeBuku; 
                int rs2 = 0;
                int jum = tabModel.getRowCount();
                for (int i=0; i < jum; i++) {
                    // Menyimpan Ke detail Pinjam
                    String sql2 = "INSERT INTO detail_pinjam VALUES(?, ?, ?)";
                    PreparedStatement st2 = conn.prepareStatement(sql2);
                    KodeBuku = tabModel.getValueAt(i, 0).toString();
                    st2.setString(1,txtNoPinjam.getText());
                    st2.setString(2,KodeBuku);
                    st2.setString(3,"0");
                    rs2= st2.executeUpdate();
                    // Merubah status Buku
                    
                    String sql3="UPDATE buku SET status = ? WHERE kode_buku = ?";
                    PreparedStatement st3 = conn.prepareStatement(sql3);
                    st3.setString(1,"Tidak Tersedia");
                    st3.setString(2,KodeBuku);
                    st3.executeUpdate();
                }
                if ((rs > 0) && (rs2 > 0)) {
                    JOptionPane.showMessageDialog(this,"Input Berhasil");
                    clearTextField();
                } else {
                    JOptionPane.showMessageDialog(this,"Input Gagal");
                    conn.close();
                }
            }
        } catch (HeadlessException | SQLException e) {
            System.out.println("Exception " +e );
        }
    }//GEN-LAST:event_saveLoanButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        clearTextField();
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.setVisible(false);
    }//GEN-LAST:event_closeButtonActionPerformed

    private void txtNoAnggotaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNoAnggotaKeyPressed
        if (evt.getKeyCode() == 10) {
            try { 
                String sql="SELECT * FROM anggota WHERE no_anggota = ?";
                PreparedStatement st = conn.prepareStatement(sql);
                st.setString(1,txtNoAnggota.getText());
                ResultSet rs= st.executeQuery();
                if( rs.next()){
                    String Nama = rs.getString("nama");
                    txtNama.setText(Nama);
                } else{
                    JOptionPane.showMessageDialog(this, "No Anggota Tidak Ada","Informasi",JOptionPane.INFORMATION_MESSAGE);
                    txtNama.setText("");
                }
            } catch(HeadlessException | SQLException e){
                System.out.println("Koneksi Gagal " +e.getMessage());
            }
        }
    }//GEN-LAST:event_txtNoAnggotaKeyPressed

    private void bookCodeFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bookCodeFieldKeyPressed
        if (evt.getKeyCode() == 10) { 
            try {
                String sql="SELECT * FROM buku WHERE kode_buku = ?";
                PreparedStatement st=conn.prepareStatement(sql);
                st.setString(1, bookCodeField.getText());
                ResultSet rs= st.executeQuery();
                if (rs.next()) {
                    String Judul = rs.getString("judul_buku");
                    String Status = rs.getString("status");
                    bookTitleField.setText(Judul);
                    bookStatusField.setText(Status);
                } else {
                    JOptionPane.showMessageDialog(this, "Kode Buku Tidak Ada","Informasi",JOptionPane.INFORMATION_MESSAGE);
                    bookTitleField.setText("");
                    bookStatusField.setText("");
                }
            } catch(HeadlessException | SQLException e) {
                System.out.println("Exception : " +e);
            }
        }
    }//GEN-LAST:event_bookCodeFieldKeyPressed

    private void setupBookDataTable() {
        String[] columnTitle = {"Kode Buku","Judul"};
        tabModel = new DefaultTableModel(null, columnTitle ) {
            boolean[] canEdit = new boolean [] { false, false };
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        bookDataTable.setModel(tabModel);
        bookDataTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        bookDataTable.getColumnModel().getColumn(1).setPreferredWidth(200);
    }
    
    private void clearTextField() {
        txtNoPinjam.setText("");
        txtNoAnggota.setText("");
        txtTglPinjam.setText("");
        txtNama.setText("");
        bookCodeField.setText("");
        bookTitleField.setText("");
        bookStatusField.setText("");
        
        int row=tabModel.getRowCount();
        for(int i = 0; i < row; i++) {
            tabModel.removeRow(0);
        }
        
        txtNoPinjam.setEnabled(false);
        txtNoAnggota.setEnabled(false);
        bookCodeField.setEnabled(false);
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
            java.util.logging.Logger.getLogger(FPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FPeminjaman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FPeminjaman().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookButton;
    private javax.swing.JButton addLoanButton;
    private javax.swing.JTextField bookCodeField;
    private javax.swing.JTable bookDataTable;
    private javax.swing.JTextField bookStatusField;
    private javax.swing.JTextField bookTitleField;
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton closeButton;
    private javax.swing.JButton deleteBookButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton saveLoanButton;
    private javax.swing.JTextField txtNama;
    private javax.swing.JTextField txtNoAnggota;
    private javax.swing.JTextField txtNoPinjam;
    private javax.swing.JTextField txtTglPinjam;
    // End of variables declaration//GEN-END:variables
}
