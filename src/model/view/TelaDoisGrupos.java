/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bean.Campeonato;
import model.bean.Time;
import model.dao.TimeDAO;

/**
 *
 * @author Cliente
 */
public class TelaDoisGrupos extends javax.swing.JFrame {

    Campeonato camp;

    /**
     * Creates new form TelaDoisGrupos
     */
    public TelaDoisGrupos(Campeonato camp) {
        initComponents();
        this.camp = camp;
        DefaultTableModel model1 = (DefaultTableModel) tbGrupo1.getModel();
        TimeDAO timeDAO = new TimeDAO();
        List<Time> times = timeDAO.listarGrupoComCC(1, camp);
        for (Time time : times) {
            model1.addRow(new Object[]{
                time.getNome(),
                time.getPontos()
            });
        }
        DefaultTableModel model2 = (DefaultTableModel) tbGrupo2.getModel();
        times = timeDAO.listarGrupoComCC(2, camp);
        for (Time time : times) {
            model2.addRow(new Object[]{
                time.getNome(),
                time.getPontos()
            });
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tbGrupo1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGrupo2 = new javax.swing.JTable();
        btnJogos = new javax.swing.JButton();
        btnArtilheiros = new javax.swing.JButton();
        btnSuspensos = new javax.swing.JButton();
        btnPendurados = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fase de Grupos");
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        tbGrupo1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbGrupo1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "pts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbGrupo1.setSelectionBackground(new java.awt.Color(0, 153, 0));
        tbGrupo1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbGrupo1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 130, 220, 212);

        tbGrupo2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbGrupo2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Time", "pts"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbGrupo2.setName(""); // NOI18N
        tbGrupo2.setSelectionBackground(new java.awt.Color(0, 153, 0));
        tbGrupo2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbGrupo2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(240, 130, 230, 212);

        btnJogos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnJogos.setText("Jogos");
        btnJogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogosActionPerformed(evt);
            }
        });
        getContentPane().add(btnJogos);
        btnJogos.setBounds(10, 420, 100, 23);

        btnArtilheiros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnArtilheiros.setText("Artilheiros");
        btnArtilheiros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArtilheiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArtilheirosActionPerformed(evt);
            }
        });
        getContentPane().add(btnArtilheiros);
        btnArtilheiros.setBounds(120, 420, 87, 23);

        btnSuspensos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSuspensos.setText("Suspensos");
        btnSuspensos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspensosActionPerformed(evt);
            }
        });
        getContentPane().add(btnSuspensos);
        btnSuspensos.setBounds(210, 420, 97, 23);

        btnPendurados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPendurados.setText("Pendurados");
        btnPendurados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPendurados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenduradosActionPerformed(evt);
            }
        });
        getContentPane().add(btnPendurados);
        btnPendurados.setBounds(310, 420, 100, 23);

        btnVoltar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnVoltar.setText("Voltar");
        btnVoltar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });
        getContentPane().add(btnVoltar);
        btnVoltar.setBounds(413, 420, 70, 23);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/view/7.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 500, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnJogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogosActionPerformed
        TelaJogos t = new TelaJogos(camp);
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnJogosActionPerformed

    private void btnArtilheirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArtilheirosActionPerformed
        this.dispose();
        TelaArtilheiros telaArtilheiros = new TelaArtilheiros(camp); //tem comentário aqui
        telaArtilheiros.setVisible(true);
    }//GEN-LAST:event_btnArtilheirosActionPerformed

    private void btnSuspensosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspensosActionPerformed
        TelaSuspensos ts = new TelaSuspensos(camp); // e nessa aqui também
        ts.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSuspensosActionPerformed

    private void btnPenduradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenduradosActionPerformed
        this.dispose();
        TelaPendurados tp = new TelaPendurados(camp); // tem comentário nessa tela
        tp.setVisible(true);
    }//GEN-LAST:event_btnPenduradosActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        this.dispose();
        TelaCarregarCamp telaCarregarCamp = new TelaCarregarCamp();
        telaCarregarCamp.setVisible(true);
    }//GEN-LAST:event_btnVoltarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaDoisGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaDoisGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaDoisGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaDoisGrupos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //              new TelaDoisGrupos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArtilheiros;
    private javax.swing.JButton btnJogos;
    private javax.swing.JButton btnPendurados;
    private javax.swing.JButton btnSuspensos;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbGrupo1;
    private javax.swing.JTable tbGrupo2;
    // End of variables declaration//GEN-END:variables
}
