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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class FBuku extends javax.swing.JFrame {

    Connection conn;
    
    DefaultTableModel tabModel;
    
    /**
     * Creates new form FBuku
     */
    public FBuku() {
        initComponents();
        setupConnection();
        setupDataTable();
    }
    
    private void setupConnection() {
        conn = Koneksi.getConnection();
    }
    
    private void setupDataTable() {
        String[] columnTitle = {"Kode Buku", "Judul Buku", "Penulis", "Penerbit", "Tahun Terbit", "Status"};
        tabModel = new DefaultTableModel(null, columnTitle){
            boolean[] canEdit = new boolean [] { false, false, false, false};
            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        };
        
        bookDataTable.setModel(tabModel);
        bookDataTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        bookDataTable.getColumnModel().getColumn(0).setPreferredWidth(100);
        bookDataTable.getColumnModel().getColumn(1).setPreferredWidth(200);
        bookDataTable.getColumnModel().getColumn(2).setPreferredWidth(100);
        bookDataTable.getColumnModel().getColumn(3).setPreferredWidth(100);
        bookDataTable.getColumnModel().getColumn(4).setPreferredWidth(100);
        bookDataTable.getColumnModel().getColumn(5).setPreferredWidth(100);
        getBooks();
    }
    
    private void assignDataTableFromResult(ResultSet rs) throws SQLException {
        String bookCode, bookTitle, bookWriter, bookPublisher, bookPublishYear, bookStatus;
        bookCode = rs.getString("kode_buku");
        bookTitle = rs.getString("judul_buku");
        bookWriter = rs.getString("penulis");
        bookPublisher = rs.getString("penerbit");
        bookPublishYear = rs.getString("tahun_terbit");
        bookStatus = rs.getString("status");
        Object Data[] = {bookCode, bookTitle, bookWriter, bookPublisher, bookPublishYear, bookStatus};
        tabModel.addRow(Data);   
    }
    
    private void clearDataTable() {
        int row = tabModel.getRowCount();
        for (int i = 0; i < row; i++) {
            tabModel.removeRow(0);
        }
    }
    
     private void getDataFromDataTable() {        
        int row = bookDataTable.getSelectedRow();
        String bookCode = tabModel.getValueAt(row, 0).toString();
        String bookTitle = tabModel.getValueAt(row, 1).toString();
        String bookWriter = tabModel.getValueAt(row, 2).toString();
        String bookPublisher = tabModel.getValueAt(row, 3).toString();
        String bookPublishYear = tabModel.getValueAt(row, 4).toString();
        String bookStatus = tabModel.getValueAt(row, 5).toString();
    
        codeField.setText(bookCode);
        titleField.setText(bookTitle);
        writerField.setText(bookWriter);
        publisherField.setText(bookPublisher);
        publishYearField.setText(bookPublishYear);
        statusField.setSelectedItem(bookStatus);
    }
    
    /**
     * Database connection call
     */
    
    private void getBooks() {
        try {
            String query = "SELECT * FROM buku";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                assignDataTableFromResult(rs);
            }
        } catch (SQLException sqlE) {
            System.out.println("Proses Query Gagal = " + sqlE);
            System.exit(0);
        } catch (Exception e) {
            System.out.println("Koneksi Access Gagal " + e.getMessage());
            System.exit(0);
        }
    }
    
    private void addBook() {
        try {
            String command = "INSERT INTO buku VALUES(?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(command);
            statement.setString(1, codeField.getText());
            statement.setString(2, titleField.getText());
            statement.setString(3, writerField.getText());
            statement.setString(4, publisherField.getText());
            statement.setString(5, publishYearField.getText());
            statement.setString(6, statusField.getSelectedItem().toString());
            int rs = statement.executeUpdate();
            if (rs > 0) {
               JOptionPane.showMessageDialog(this,"Input Berhasil");
               setupDataTable(); 
            }
            clearTextField();
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(this,"Input Gagal = " + sqle.getMessage());
        } catch (HeadlessException e) {
            JOptionPane.showMessageDialog(this,"Koneksi Gagal " + e.getMessage());
        }
    }
    
    private void updateBook() {
        int ok = JOptionPane.showConfirmDialog(this,
        "Anda Yakin Ingin Mengubah Data\n Dengan Kode Buku = '" + codeField.getText() +
        "'", "Konfirmasi ",JOptionPane.YES_NO_OPTION);
        if (ok == 0) {
            try {
                String command = "UPDATE buku SET judul_buku = ?, penulis = ?, penerbit = ?, tahun_terbit = ?, status = ? WHERE kode_buku = ?";
                PreparedStatement statement = conn.prepareStatement(command);
                
                statement.setString(1, titleField.getText());
                statement.setString(2, writerField.getText());
                statement.setString(3, publisherField.getText());
                statement.setString(4, publishYearField.getText());
                statement.setString(5, statusField.getSelectedItem().toString());
                statement.setString(6, codeField.getText());
                
                int rs = statement.executeUpdate();
                if (rs > 0) {
                    JOptionPane.showMessageDialog(this,"Edit Data Berhasil");
                    setupDataTable();
                }
                clearTextField();
                
            } catch (SQLException sqle) {
                JOptionPane.showMessageDialog(this,"Input Gagal = " + sqle.getMessage());
            } catch (HeadlessException e) {
                JOptionPane.showMessageDialog(this,"Koneksi Gagal " + e.getMessage());
            }
        }
    }
    
    private void deleteBook() {
        getDataFromDataTable();
        
        int ok = JOptionPane.showConfirmDialog(
                this,
                "Anda Yakin Ingin Menghapus Data\nDengan Kode Buku = '" + codeField.getText() +"'",
                "Konfirmasi Menghapus Data",
                JOptionPane.YES_NO_OPTION
        );
        
        if (ok == 0) {
            try {
                String command = "DELETE FROM buku WHERE kode_buku = ?";
                PreparedStatement st = conn.prepareStatement(command);
                st.setString(1, codeField.getText());
                int rs=st.executeUpdate();
                if(rs > 0) {
                    setupDataTable();
                    JOptionPane.showMessageDialog(this,"Data Berhasil dihapus");
                }
                clearTextField();
            } catch (HeadlessException | SQLException se) {
                JOptionPane.showMessageDialog(this,"Gagal Hapus Data.. ");
            }
        }   
    }
    
    private void searchBooks() {
        String query;
        int selectedOption = cbQueryType.getSelectedIndex();
        
        try {
            switch (selectedOption) {
                case 0: {
                    query = "SELECT * FROM buku WHERE kode_buku = '"+ searchField.getText() +"'";
                    break;
                }
                case 1: {
                    query = "SELECT * FROM buku WHERE judul_buku LIKE '%"+ searchField.getText() +"%'";
                    break;
                }
                case 2: {
                    query = "SELECT * FROM buku WHERE penulis LIKE '%"+ searchField.getText() +"%'";
                    break;
                }
                default: {
                    query = "SELECT * FROM buku WHERE kode_buku = '"+ searchField.getText() +"'";
                    break;
                }
            }
            
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet rs = statement.executeQuery();
            clearDataTable();
            while (rs.next()) {
                assignDataTableFromResult(rs);
            }
        } catch (SQLException e) {

        }
    }
    
    /**
     * Text field modifier
     */
    
    private void clearTextField() {
        codeField.setText("");
        titleField.setText("");
        writerField.setText("");
        publisherField.setText("");
        publishYearField.setText("");
        statusField.setSelectedIndex(0);
    }
    
    private void enableTextField() {
        codeField.setEnabled(true);
        titleField.setEnabled(true);
        writerField.setEnabled(true);
        publisherField.setEnabled(true);
        publishYearField.setEnabled(true);
        statusField.setEnabled(true);
    }
    
    private void disableTextField() {
        codeField.setEnabled(false);
        titleField.setEnabled(false);
        writerField.setEnabled(false);
        publisherField.setEnabled(false);
        publishYearField.setEnabled(false);
        statusField.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        codeField = new javax.swing.JTextField();
        saveButton = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        titleField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        writerField = new javax.swing.JTextField();
        publisherField = new javax.swing.JTextField();
        publishYearField = new javax.swing.JTextField();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        bookDataTable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        cbQueryType = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();
        searchButton = new javax.swing.JButton();
        statusField = new javax.swing.JComboBox<>();
        refreshButton = new javax.swing.JButton();

        jLabel7.setText("jLabel7");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Kode Buku");

        saveButton.setText("Simpan");
        saveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveButtonActionPerformed(evt);
            }
        });

        jLabel2.setText("Judul Buku");

        jLabel3.setText("Penulis");

        jLabel4.setText("Penerbit");

        jLabel5.setText("Tahun Terbit");

        jLabel6.setText("Status");

        addButton.setText("Tambah");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setText("Edit");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        cancelButton.setText("Batal");
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        deleteButton.setText("Hapus");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        closeButton.setText("Tutup");

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

        jLabel8.setText("Cari Berdasarkan");

        cbQueryType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kode Buku", "Judul Buku", "Penulis" }));

        searchButton.setText("Cari");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        statusField.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tersedia", "Tidak Tersedia" }));

        refreshButton.setText("Refresh");
        refreshButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbQueryType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(searchButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(titleField, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                                    .addComponent(writerField))))
                        .addGap(90, 90, 90)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(publisherField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(publishYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(refreshButton, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addButton)
                        .addGap(18, 18, 18)
                        .addComponent(editButton)
                        .addGap(18, 18, 18)
                        .addComponent(saveButton)
                        .addGap(18, 18, 18)
                        .addComponent(deleteButton)
                        .addGap(18, 18, 18)
                        .addComponent(cancelButton)
                        .addGap(18, 18, 18)
                        .addComponent(closeButton))
                    .addComponent(jScrollPane1))
                .addContainerGap(13, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(codeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(publisherField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(titleField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(publishYearField, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(writerField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(statusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(editButton)
                    .addComponent(cancelButton)
                    .addComponent(closeButton)
                    .addComponent(addButton)
                    .addComponent(saveButton)
                    .addComponent(deleteButton))
                .addGap(26, 26, 26)
                .addComponent(refreshButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cbQueryType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveButtonActionPerformed
        if (saveButton.getText().equalsIgnoreCase("Simpan")) {
            addBook();
        } else {
            updateBook();
        }
        
        disableTextField();
        
        addButton.setEnabled(true);
        saveButton.setEnabled(false);
        editButton.setEnabled(true);
        cancelButton.setEnabled(false);
        deleteButton.setEnabled(true);
        closeButton.setEnabled(true); 
    }//GEN-LAST:event_saveButtonActionPerformed

    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        enableTextField();
        clearTextField();  
        
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        editButton.setEnabled(false);
        cancelButton.setEnabled(true);
        deleteButton.setEnabled(false);
        closeButton.setEnabled(false);
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        getDataFromDataTable();
        enableTextField();
        saveButton.setText("Update");
        
        addButton.setEnabled(false);
        saveButton.setEnabled(true);
        editButton.setEnabled(false);
        cancelButton.setEnabled(true);
        deleteButton.setEnabled(false);
        closeButton.setEnabled(false);
        
        getDataFromDataTable();
    }//GEN-LAST:event_editButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        enableTextField();
        clearTextField();
        saveButton.setText("Simpan");
        
        addButton.setEnabled(true);
        saveButton.setEnabled(false);
        editButton.setEnabled(true);
        cancelButton.setEnabled(false);
        deleteButton.setEnabled(true);
        closeButton.setEnabled(false);
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        deleteBook();
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        searchBooks();
    }//GEN-LAST:event_searchButtonActionPerformed

    private void refreshButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshButtonActionPerformed
        getBooks();
    }//GEN-LAST:event_refreshButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FBuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FBuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addButton;
    private javax.swing.JTable bookDataTable;
    private javax.swing.JButton cancelButton;
    private javax.swing.JComboBox<String> cbQueryType;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextField codeField;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField publishYearField;
    private javax.swing.JTextField publisherField;
    private javax.swing.JButton refreshButton;
    private javax.swing.JButton saveButton;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchField;
    private javax.swing.JComboBox<String> statusField;
    private javax.swing.JTextField titleField;
    private javax.swing.JTextField writerField;
    // End of variables declaration//GEN-END:variables
}
