/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.projekakhir;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Quiz extends javax.swing.JFrame {

    private ArrayList<Question> questions;
    private int currentQuestionIndex;
    private int score;
    private int[] selectedAnswers; // Array untuk menyimpan jawaban yang dipilih
    
    public Quiz() {
        initComponents();
        loadQuestions();
        selectedAnswers = new int[questions.size()]; // Inisialisasi array dengan ukuran sesuai jumlah pertanyaan
        for (int i = 0; i < selectedAnswers.length; i++) {
            selectedAnswers[i] = -1; // Inisialisasi semua jawaban sebagai tidak dipilih
        }
        displayQuestion();
        jLabel1.setForeground(Color.WHITE);
        jLabel2.setForeground(Color.WHITE);
        jLabel8.setForeground(Color.WHITE);
        jRadioButton1.setForeground(Color.WHITE);
        jRadioButton2.setForeground(Color.WHITE);
        jRadioButton3.setForeground(Color.WHITE);
        jRadioButton4.setForeground(Color.WHITE);
        jButton2.setForeground(Color.WHITE);
    }

    private void loadQuestions() {
        questions = new ArrayList<>();
        questions.add(new Question("Apa itu tabungan?",
                new String[]{"Alat untuk meminjam uang dari bank.",
                    "Akun di mana kita bisa menyimpan uang dan memperoleh bunga.",
                    "Metode untuk menghabiskan uang.",
                    "Cara untuk berinvestasi di saham."},
                1));

        questions.add(new Question("Keuntungan memiliki rekening tabungan?",
                new String[]{"Mengurangi pengeluaran bulanan.",
                    "Mendapatkan bunga dari uang yang disimpan.",
                    "Menjamin kerugian dari investasi.",
                    "Mengurangi risiko kehilangan uang karena pencurian."},
                1));

        questions.add(new Question("Perbedaan antara rekening tabungan dan rekening giro?",
                new String[]{"Rekening tabungan tidak menghasilkan bunga, sementara rekening giro menghasilkan bunga.",
                    "Rekening tabungan = transaksi harian, rekening giro menyimpan uang jangka panjang.",
                    "Rekening tabungan menghasilkan bunga, rekening giro digunakan untuk transaksi harian.",
                    "Rekening tabungan punya kartu debit, sementara rekening giro tidak."},
                0));

        questions.add(new Question("Apa itu bunga majemuk?",
                new String[]{"Bunga yang hanya dihitung berdasarkan simpanan awal.",
                    "Bunga dihitung berdasarkan simpanan awal dan bunga yang telah diperoleh sebelumnya.",
                    "Bunga hanya diberikan pada akhir tahun.",
                    "Bunga diberikan pada simpanan yang lebih dari Rp 1 juta."},
                1));

        questions.add(new Question("Pentingnya dana darurat?",
                new String[]{"Untuk membayar pajak tambahan.",
                    "Untuk mengantisipasi pengeluaran tak terduga.",
                    "Untuk menginvestasikan uang tersebut di saham.",
                    "Untuk mendapatkan potongan harga di bank."},
                1));

        questions.add(new Question("Keuntungan deposito berjangka?",
                new String[]{"Bunga lebih rendah tetapi lebih aman.",
                    "Bunga lebih tinggi tetapi uang tidak bisa diambil kapan saja.",
                    "Tidak ada keuntungan khusus, keduanya sama saja.",
                    "Uang bisa diambil kapan saja tanpa penalti."},
                1));

        questions.add(new Question("Tentang rekening tabungan online :",
                new String[]{"Rekening tabungan online selalu memiliki biaya administrasi yang tinggi.",
                    "Rekening tabungan online bunga lebih tinggi dibandingkan rekening tabungan tradisional.",
                    "Rekening tabungan online tidak dapat digunakan untuk transaksi harian.",
                    "Rekening tabungan online tidak aman karena tidak ada proteksi dari bank."},
                1));

        questions.add(new Question("Risiko inflasi terhadap tabungan?",
                new String[]{"Risiko kehilangan uang karena pencurian.",
                    "Risiko nilai uang berkurang karena kenaikan harga barang dan jasa.",
                    "Risiko bunga tabungan turun drastis.",
                    "Risiko bank bangkrut dan kehilangan semua uang."},
                1));

        questions.add(new Question("Strategi keuangan mahasiswa?",
                new String[]{"Menghabiskan semua uang yang dimiliki sebelum akhir bulan.",
                    "Menyisihkan sebagian pendapatan untuk ditabung setiap bulannya.",
                    "Menggunakan kartu kredit untuk semua pembelian.",
                    "Tidak perlu menyimpan uang karena masih ditanggung oleh orang tua."},
                1));

        questions.add(new Question("Menabung jangka panjang?",
                new String[]{"Menyimpan uang di bawah kasur.",
                    "Membuka deposito berjangka.",
                    "Menyimpan uang di rekening giro.",
                    "Mengambil pinjaman untuk investasi."},
                1));

        currentQuestionIndex = 0;
        score = 0;
    }
    
    private void displayQuestion() {
        if (currentQuestionIndex < questions.size()) {
            Question currentQuestion = questions.get(currentQuestionIndex);
            jLabel1.setText(currentQuestion.getQuestionText());
            jRadioButton1.setText(currentQuestion.getOptions()[0]);
            jRadioButton2.setText(currentQuestion.getOptions()[1]);
            jRadioButton3.setText(currentQuestion.getOptions()[2]);
            jRadioButton4.setText(currentQuestion.getOptions()[3]);

            // Reset selection
            buttonGroup1.clearSelection();

            // Menampilkan jawaban yang telah dipilih sebelumnya
            if (selectedAnswers[currentQuestionIndex] != -1) {
                switch (selectedAnswers[currentQuestionIndex]) {
                    case 0:
                        jRadioButton1.setSelected(true);
                        break;
                    case 1:
                        jRadioButton2.setSelected(true);
                        break;
                    case 2:
                        jRadioButton3.setSelected(true);
                        break;
                    case 3:
                        jRadioButton4.setSelected(true);
                        break;
                }
            }
        } else {
            JOptionPane.showMessageDialog(this, "Quiz selesai! Skor Anda: " + score);

            // Menambahkan tombol kembali ke halaman utama
            JButton backButton = new JButton("LOGOUT");
            backButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    // Tutup frame kuis
                    dispose();
                    // Buka kembali halaman utama dengan menyertakan skor
                    new App().setVisible(true);
                }
            });
            // Menampilkan tombol kembali di pesan dialog
            Object[] options = {backButton};
            JOptionPane.showOptionDialog(this, "Klik tombol untuk LOGOUT", "Quiz Selesai",
                    JOptionPane.PLAIN_MESSAGE, JOptionPane.INFORMATION_MESSAGE, null, options, null);
        }
    }
    
    private void handleNextButton() {
        int selectedAnswer = -1;
        if (jRadioButton1.isSelected()) {
            selectedAnswer = 0;
        } else if (jRadioButton2.isSelected()) {
            selectedAnswer = 1;
        } else if (jRadioButton3.isSelected()) {
            selectedAnswer = 2;
        } else if (jRadioButton4.isSelected()) {
            selectedAnswer = 3;
        }

        if (selectedAnswer == -1) {
            JOptionPane.showMessageDialog(this, "Pilih satu jawaban!");
            return;
        }

        // Simpan jawaban yang dipilih
        if (selectedAnswers[currentQuestionIndex] == -1) {
            selectedAnswers[currentQuestionIndex] = selectedAnswer;
            if (selectedAnswer == questions.get(currentQuestionIndex).getCorrectAnswerIndex()) {
                score++;
            }
        } else {
            selectedAnswers[currentQuestionIndex] = selectedAnswer;
        }

        currentQuestionIndex++;
        displayQuestion();
    }

    private void handleBackButton() {
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            displayQuestion();
        } else {
            JOptionPane.showMessageDialog(this, "Ini adalah pertanyaan pertama!");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(153, 153, 255));
        jLabel1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("jLabel1");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setName(""); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 36, 525, 100));

        jRadioButton1.setFont(new java.awt.Font("Century Schoolbook", 1, 10)); // NOI18N
        jRadioButton1.setText("jRadioButton1");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 525, 40));

        jRadioButton2.setFont(new java.awt.Font("Century Schoolbook", 1, 10)); // NOI18N
        jRadioButton2.setText("jRadioButton2");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 525, 40));

        jRadioButton3.setFont(new java.awt.Font("Century Schoolbook", 1, 10)); // NOI18N
        jRadioButton3.setText("jRadioButton3");
        getContentPane().add(jRadioButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 525, 30));

        jRadioButton4.setFont(new java.awt.Font("Century Schoolbook", 1, 10)); // NOI18N
        jRadioButton4.setText("jRadioButton4");
        getContentPane().add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 525, 30));

        jButton1.setBackground(new java.awt.Color(0, 0, 51));
        jButton1.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("NEXT");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, -1, -1));

        jButton2.setBackground(new java.awt.Color(0, 0, 51));
        jButton2.setFont(new java.awt.Font("Century Schoolbook", 1, 14)); // NOI18N
        jButton2.setText("BACK");
        jButton2.setToolTipText("");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 310, -1, -1));

        jLabel8.setFont(new java.awt.Font("Century Schoolbook", 1, 24)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("QUIZ");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, 30));

        jLabel2.setIcon(new javax.swing.ImageIcon("D:\\Projek Akhir\\ProjekAkhir\\src\\main\\java\\com\\mycompany\\projekakhir\\background\\quiz uiz.jpg")); // NOI18N
        jLabel2.setText("jLabel2");
        jLabel2.setPreferredSize(new java.awt.Dimension(578, 352));
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        handleNextButton();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        handleBackButton();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Quiz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Quiz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JRadioButton jRadioButton4;
    // End of variables declaration//GEN-END:variables
}
