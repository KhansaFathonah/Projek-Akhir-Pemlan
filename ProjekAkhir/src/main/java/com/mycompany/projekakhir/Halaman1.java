/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projekakhir;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
/**
 *
 * @author Asus
 */
public class Halaman1 extends javax.swing.JFrame {
    private final BigDecimal[] pemasukan = new BigDecimal[100];
    private final BigDecimal[] pengeluaran = new BigDecimal[100];
    private final BigDecimal[] pemindahanSaldo = new BigDecimal[100];
    private final String[] kategoriPemasukan = new String[100];
    private final String[] kategoriPengeluaran = new String[100];
    private final String[] namaBank = new String[100];
    private final BigDecimal[] sisaSaldo = new BigDecimal[100];
    private int jumlahTransaksi = 0;
    private final HashMap<String, BigDecimal> saldoBank = new HashMap<>();
    private static String username;
    private final DecimalFormat formatter = new DecimalFormat("#,###");
    private BigDecimal selisih = BigDecimal.ZERO;
    
    public BigDecimal getSelisih() {
        return selisih;
    }

    public void setSelisih(BigDecimal newSelisih) {
        selisih = newSelisih;
    }
   
    public Halaman1(String username) {
        Halaman1.username = username;
        initComponents();
        
        jLabel1.setForeground(Color.WHITE);
        jLabel4.setForeground(Color.WHITE);
        jLabel5.setForeground(Color.WHITE);
        jLabel6.setForeground(Color.WHITE);
        
        jButton8.setForeground(Color.WHITE);
        jButton6.setForeground(Color.WHITE);
        jButton7.setForeground(Color.WHITE);
     
        // Inisialisasi saldo bank
        saldoBank.put("BNI       ", BigDecimal.ZERO);
        saldoBank.put("BRI       ", BigDecimal.ZERO);
        saldoBank.put("BCA       ", BigDecimal.ZERO);
        saldoBank.put("MANDIRI   ", BigDecimal.ZERO);
        saldoBank.put("GOPAY     ", BigDecimal.ZERO);
        saldoBank.put("OVO       ", BigDecimal.ZERO);
        saldoBank.put("Lain-lain ", BigDecimal.ZERO);
        
        for (int i = 0; i < 100; i++) {
            pemasukan[i] = BigDecimal.ZERO;
            pengeluaran[i] = BigDecimal.ZERO;
            namaBank[i] = "";
            sisaSaldo[i] = BigDecimal.ZERO;
        }
    }

    private void tampilkanDataTransaksi() {
        StringBuilder dataTransaksi = new StringBuilder();
        dataTransaksi.append("Data Transaksi :\n");
        for (int i = 0; i < jumlahTransaksi; i++) {
            dataTransaksi.append("Transaksi ").append(i + 1).append(":\n");
            dataTransaksi.append(" - Pemasukan                 : Rp").append(formatter.format(pemasukan[i])).append("\n");
            dataTransaksi.append(" - Pengeluaran               : Rp").append(formatter.format(pengeluaran[i])).append("\n");
            dataTransaksi.append(" - Kategori Pemasukan  : ").append(kategoriPemasukan[i]).append("\n");
            dataTransaksi.append(" - Kategori Pengeluaran : ").append(kategoriPengeluaran[i]).append("\n");
            dataTransaksi.append(" - Nama Bank                 : ").append(namaBank[i]).append("\n");
            dataTransaksi.append(" - Saldo Bank                 : Rp").append(formatter.format(saldoBank.get(namaBank[i]))).append("\n");
            dataTransaksi.append(" - Sisa Saldo                  : Rp").append(formatter.format(sisaSaldo[i])).append("\n\n");
        }
        
        JTextArea textArea = new JTextArea(dataTransaksi.toString());
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new java.awt.Dimension(400, 250));
        JOptionPane.showMessageDialog(this, scrollPane, "Data Transaksi", JOptionPane.INFORMATION_MESSAGE);
    }
    
    private void simpanTransaksi(BigDecimal pemasukanInput, BigDecimal pengeluaranInput, BigDecimal pemindahanSaldo, String kategoriPemasukan, String kategoriPengeluaran, String selectedBank) {
        BigDecimal saldoBankTerpilih = saldoBank.getOrDefault(selectedBank, BigDecimal.ZERO);
        saldoBankTerpilih = saldoBankTerpilih.subtract(pengeluaranInput);
        saldoBankTerpilih = saldoBankTerpilih.add(pemasukanInput);
        saldoBank.put(selectedBank, saldoBankTerpilih);

        BigDecimal sisaSaldoTransaksiSebelumnya = jumlahTransaksi > 0 ? sisaSaldo[jumlahTransaksi - 1] : BigDecimal.ZERO;
        BigDecimal sisaSaldoTransaksiIni = sisaSaldoTransaksiSebelumnya.subtract(pengeluaranInput);
        sisaSaldoTransaksiIni = sisaSaldoTransaksiIni.add(pemasukanInput);
        sisaSaldo[jumlahTransaksi] = sisaSaldoTransaksiIni;

        this.pemasukan[jumlahTransaksi] = pemasukanInput;
        this.pengeluaran[jumlahTransaksi] = pengeluaranInput;
        this.pemindahanSaldo[jumlahTransaksi] = pemindahanSaldo;
        this.kategoriPemasukan[jumlahTransaksi] = kategoriPemasukan;
        this.kategoriPengeluaran[jumlahTransaksi] = kategoriPengeluaran;
        this.namaBank[jumlahTransaksi] = selectedBank;
        jumlahTransaksi++;

        JOptionPane.showMessageDialog(this, "Data transaksi berhasil disimpan!");
    }
    
    private BigDecimal hitungTotalPemasukan() {
        BigDecimal totalPemasukan = BigDecimal.ZERO;
        for (int i = 0; i < jumlahTransaksi; i++) {
            totalPemasukan = totalPemasukan.add(pemasukan[i]);
        }
        return totalPemasukan;  
    }

    private BigDecimal hitungTotalPengeluaran() {
        BigDecimal totalPengeluaran = BigDecimal.ZERO;
        for (int i = 0; i < jumlahTransaksi; i++) {
            totalPengeluaran = totalPengeluaran.add(pengeluaran[i]);
        }
        return totalPengeluaran;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jColorChooser1 = new javax.swing.JColorChooser();
        jToggleButton1 = new javax.swing.JToggleButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        jComboBox2 = new javax.swing.JComboBox<>();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setBackground(new java.awt.Color(0, 0, 102));
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pemasukan", "Gaji Bulanan", "Saku Harian", "Sampingan", "Lain-lain", "-" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 120, -1));

        jComboBox2.setBackground(new java.awt.Color(0, 0, 102));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pengeluaran", "E-Wallet", "Kuliah", "Belanja", "Transportasi", "Makan & Minum", "Lain-lain", "-", " " }));
        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 210, 120, -1));

        jComboBox3.setBackground(new java.awt.Color(0, 0, 102));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pilih Bank", "BNI ", "BRI ", "BCA ", "MANDIRI ", "Permata", "CIMB Niaga", "Danamon", "BTN", "Panin", "OCBC NISP", "Lain-lain ", " ", " ", " " }));
        jComboBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox3ActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 120, -1));

        jLabel4.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel4.setText("Masukkan pengeluaran Anda                   : ");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, -1, 25));

        jLabel5.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel5.setText("Masukkan nama bank Anda                      : ");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, 25));

        jLabel6.setFont(new java.awt.Font("Century Schoolbook", 1, 12)); // NOI18N
        jLabel6.setText("Masukkan pemasukan Anda                     : ");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, -1, 25));

        jButton6.setBackground(new java.awt.Color(0, 0, 51));
        jButton6.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton6.setText("SIMPAN");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 114, -1));

        jButton7.setBackground(new java.awt.Color(0, 0, 51));
        jButton7.setFont(new java.awt.Font("Century Schoolbook", 0, 14)); // NOI18N
        jButton7.setText("SELISIH");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 114, -1));

        jTextField1.setBackground(new java.awt.Color(153, 153, 255));
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 170, 180, 30));

        jTextField2.setBackground(new java.awt.Color(153, 153, 255));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 210, 180, 30));

        jButton8.setBackground(new java.awt.Color(0, 0, 51));
        jButton8.setFont(new java.awt.Font("Century Schoolbook", 1, 18)); // NOI18N
        jButton8.setText("LOG OUT");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 300, 130, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\Projek Akhir\\ProjekAkhir\\src\\main\\java\\com\\mycompany\\projekakhir\\background\\transaksi.jpg")); // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setPreferredSize(new java.awt.Dimension(578, 352));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 578, 352));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) jComboBox1.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Anda memilih pemasukan: " + selectedItem);
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) jComboBox2.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Anda memilih pengeluaran: " + selectedItem);
    }//GEN-LAST:event_jComboBox2ActionPerformed

    private void jComboBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox3ActionPerformed
        // TODO add your handling code here:
        String selectedItem = (String) jComboBox3.getSelectedItem();
        JOptionPane.showMessageDialog(this, "Anda memilih penambahan saldo ke bank: " + selectedItem);
    }//GEN-LAST:event_jComboBox3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        BigDecimal pemasukanInput = new BigDecimal(jTextField1.getText());
        BigDecimal pengeluaranInput = new BigDecimal(jTextField2.getText());
        String kategoriPemasukan = jComboBox1.getSelectedItem().toString();
        String kategoriPengeluaran = jComboBox2.getSelectedItem().toString();
        String selectedBank = jComboBox3.getSelectedItem().toString();
        BigDecimal pemindahanSaldo = BigDecimal.ZERO; // Belum diimplementasikan

        // Validasi pengeluaran hanya jika saldo sudah dimasukkan
        BigDecimal saldoBankTerpilih = saldoBank.getOrDefault(selectedBank, BigDecimal.ZERO);
        if (saldoBankTerpilih.compareTo(BigDecimal.ZERO) == 0 && pengeluaranInput.compareTo(BigDecimal.ZERO) > 0) {
            JOptionPane.showMessageDialog(this, "Saldo di bank " + selectedBank.trim() + " belum dimasukkan. Silakan lakukan pemasukan terlebih dahulu.");
            return; // Hentikan proses penyimpanan transaksi
        }

        // Lanjutkan proses penyimpanan transaksi jika validasi berhasil
        simpanTransaksi(pemasukanInput, pengeluaranInput, pemindahanSaldo, kategoriPemasukan, kategoriPengeluaran, selectedBank);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        tampilkanDataTransaksi();
        BigDecimal totalPemasukan = hitungTotalPemasukan();
        BigDecimal totalPengeluaran = hitungTotalPengeluaran();
        BigDecimal selisih = totalPemasukan.subtract(totalPengeluaran);

        JOptionPane.showMessageDialog(this, "Total Pemasukan   : Rp" + formatter.format(totalPemasukan)
                + "\nTotal Pengeluaran : Rp" + formatter.format(totalPengeluaran)
                + "\nSelisih : Rp" + formatter.format(selisih));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        JButton logoutButton = new JButton("INGIN LOGOUT");
        logoutButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new halamanQuiz().setVisible(true);
            }
        });
        Object[] options = {logoutButton};
        JOptionPane.showOptionDialog(this, "AKUN ANDA AKAN HILANG APABILA LOGOUT", "LOGOUT",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, null);
    }//GEN-LAST:event_jButton8ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Halaman1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Halaman1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Halaman1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Halaman1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Halaman1(username).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JColorChooser jColorChooser1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JToggleButton jToggleButton1;
    // End of variables declaration//GEN-END:variables

}
