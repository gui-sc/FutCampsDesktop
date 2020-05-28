/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.view;

import java.util.Collections;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import model.bean.Campeonato;
import model.bean.Partida;
import model.bean.Time;
import model.dao.CampeonatoDAO;
import model.dao.PartidaDAO;
import model.dao.TimeDAO;

/**
 *
 * @author Cliente
 */
public class TelaJogos extends javax.swing.JFrame {

    Campeonato camp;

    /**
     * Creates new form TelaJogos
     */
    public TelaJogos(Campeonato camp) {
        initComponents();
        this.camp = camp;
        PartidaDAO partidaDAO = new PartidaDAO();
        List<Partida> partidas = partidaDAO.listar(camp);
        DefaultTableModel tbm = (DefaultTableModel) tbPartidas.getModel();
        for (Partida partida : partidas) {
            tbm.addRow(
                    new Object[]{
                        partida.getId(),
                        partida.getMandante(),
                        partida.getVisitante(),
                        partida.getFase(),
                        (partida.isCadastrada() == true) ? "sim" : "não"
                    });
        }
        boolean todasCadastradas = true;
        for (Partida partida : partidas) {
            if (todasCadastradas == false) {
                break;
            }
            if (partida.isCadastrada()) {
                todasCadastradas = true;
            } else {
                todasCadastradas = false;
            }
        }
        TimeDAO timeDAO = new TimeDAO();
        if (todasCadastradas == true && camp.isFinalizado()) {

            if (camp.isFaseDeGrupos()) {
                if (camp.getNumGrupos() == 4) {
                    List<Time> grupo1 = timeDAO.listarGrupoComCC(1, camp);
                    List<Time> grupo2 = timeDAO.listarGrupoComCC(2, camp);
                    List<Time> grupo3 = timeDAO.listarGrupoComCC(3, camp);
                    List<Time> grupo4 = timeDAO.listarGrupoComCC(4, camp);
                    timeDAO.primeiro(grupo1.get(0), camp);
                    timeDAO.primeiro(grupo2.get(0), camp);
                    timeDAO.primeiro(grupo3.get(0), camp);
                    timeDAO.primeiro(grupo4.get(0), camp);
                    timeDAO.eliminar(grupo1.get(3), camp);
                    timeDAO.eliminar(grupo2.get(3), camp);
                    timeDAO.eliminar(grupo3.get(3), camp);
                    timeDAO.eliminar(grupo4.get(3), camp);
                    List<Time> times = timeDAO.listar2e3(camp); // pega os times que não ficaram em primeiro
                    Collections.shuffle(times); // embaralha
                    Partida partida = new Partida();
                    partida.setCampeonato(camp);
                    partida.setFase("oitavas");
                    partida.setMandante(times.get(0));
                    partida.setVisitante(times.get(1));
                    partidaDAO.cadastrarPrevia(partida);
                    partida.setMandante(times.get(2));
                    partida.setVisitante(times.get(3));
                    partidaDAO.cadastrarPrevia(partida);
                    partida.setMandante(times.get(4));
                    partida.setVisitante(times.get(5));
                    partidaDAO.cadastrarPrevia(partida);
                    partida.setMandante(times.get(6));
                    partida.setVisitante(times.get(7));
                    partidaDAO.cadastrarPrevia(partida);
                    camp.setFaseDeGrupos(false);
                    camp.setOitavas(true);
                } else if (camp.getNumGrupos() == 2) {
                    List<Time> grupo1 = timeDAO.listarGrupoComCC(1, camp);
                    List<Time> grupo2 = timeDAO.listarGrupoComCC(2, camp);
                    timeDAO.primeiro(grupo1.get(0), camp);
                    timeDAO.primeiro(grupo2.get(0), camp);
                    timeDAO.eliminar(grupo1.get(2), camp);
                    timeDAO.eliminar(grupo1.get(3), camp);
                    timeDAO.eliminar(grupo2.get(2), camp);
                    timeDAO.eliminar(grupo2.get(3), camp);
                    List<Time> primeiros = timeDAO.listarPrimeiros(camp);
                    List<Time> segundos = timeDAO.listar2e3(camp);
                    Partida partida1 = new Partida();
                    Partida partida2 = new Partida();
                    partida1.setCampeonato(camp);
                    partida1.setFase("semi");
                    partida2.setCampeonato(camp);
                    partida2.setFase("semi");
                    if (primeiros.get(0).getGrupo() == 1) {
                        partida1.setMandante(primeiros.get(0));
                        partida2.setMandante(primeiros.get(1));
                    } else {
                        partida2.setMandante(primeiros.get(0));
                        partida1.setMandante(primeiros.get(1));
                    }
                    if (segundos.get(0).getGrupo() == 1) {
                        partida2.setVisitante(segundos.get(0));
                        partida1.setVisitante(segundos.get(1));
                    } else {
                        partida2.setVisitante(segundos.get(1));
                        partida1.setVisitante(segundos.get(0));
                    }
                    partidaDAO.cadastrarPrevia(partida1);
                    partidaDAO.cadastrarPrevia(partida2);
                    camp.setFaseDeGrupos(false);
                    camp.setSemi(true);
                }

            } else if (camp.isOitavas()) {
                List<Time> times = timeDAO.listarClassificados(camp);
                Collections.shuffle(times);
                Partida partida = new Partida();
                partida.setCampeonato(camp);
                partida.setFase("quartas");
                partida.setMandante(times.get(0));
                partida.setVisitante(times.get(1));
                partidaDAO.cadastrarPrevia(partida);
                partida.setMandante(times.get(2));
                partida.setVisitante(times.get(3));
                partidaDAO.cadastrarPrevia(partida);
                partida.setMandante(times.get(4));
                partida.setVisitante(times.get(5));
                partidaDAO.cadastrarPrevia(partida);
                partida.setMandante(times.get(6));
                partida.setVisitante(times.get(7));
                partidaDAO.cadastrarPrevia(partida);
                camp.setOitavas(false);
                camp.setQuartas(true);
            } else if (camp.isQuartas()) {
                List<Time> times = timeDAO.listarClassificados(camp);
                Collections.shuffle(times);
                Partida partida = new Partida();
                partida.setCampeonato(camp);
                partida.setFase("semi");
                partida.setMandante(times.get(0));
                partida.setVisitante(times.get(1));
                partidaDAO.cadastrarPrevia(partida);
                partida.setMandante(times.get(2));
                partida.setVisitante(times.get(3));
                partidaDAO.cadastrarPrevia(partida);
                camp.setQuartas(false);
                camp.setSemi(true);
            } else if (camp.isSemi()) {
                List<Time> times = timeDAO.listarClassificados(camp);
                Partida partida = new Partida();
                partida.setCampeonato(camp);
                partida.setFase("final");
                partida.setMandante(times.get(0));
                partida.setVisitante(times.get(1));
                partidaDAO.cadastrarPrevia(partida);
                camp.setSemi(false);
                camp.setFinal(true);
            }else if(camp.isFinal()){
                camp.setFinal(false);
                camp.setFinalizado(true);
            }
            CampeonatoDAO campDAO = new CampeonatoDAO();
            campDAO.passarDeFase(camp);
            int linhas = tbm.getRowCount();
            for (int i = linhas; i > 0; i--) {
                tbm.removeRow(i - 1);
            }
            List<Partida> partidas2 = partidaDAO.listar(camp);
            for (Partida partida : partidas2) {
                tbm.addRow(
                        new Object[]{
                            partida.getId(),
                            partida.getMandante(),
                            partida.getVisitante(),
                            partida.getFase(),
                            (partida.isCadastrada() == true) ? "sim" : "não"
                        });
            }
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPartidas = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbPartidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbPartidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "", "Mandante", "Visitante", "Fase", "finalizada"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbPartidas.setSelectionBackground(new java.awt.Color(0, 153, 0));
        tbPartidas.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbPartidas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, 290));

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Cadastrar/ Ver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 450, -1, -1));

        jButton2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/view/7.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 500));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        DefaultTableModel tbm = (DefaultTableModel) tbPartidas.getModel();
        int id = Integer.valueOf(String.valueOf(tbm.getValueAt(tbPartidas.getSelectedRow(), 0)));
        Partida partida = new PartidaDAO().buscar(id);
        if (partida.isCadastrada()) {
            TelaSumula ts = new TelaSumula(partida);
            ts.setVisible(true);
        } else {
            TelaCadastrarPartida tcp = new TelaCadastrarPartida(camp, partida);
            tcp.setVisible(true);
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        if (camp.isFaseDeGrupos() == true) {
            if (camp.getNumGrupos() == 2) {
                TelaDoisGrupos tdg = new TelaDoisGrupos(camp);
                tdg.setVisible(true);
            } else if (camp.getNumGrupos() == 4) {
                TelaQuatroGrupos tqg = new TelaQuatroGrupos(camp);
                tqg.setVisible(true);
            }
            
        } else if(camp.isOitavas()){
            TelaOitavas t = new TelaOitavas(camp);
            t.setVisible(true);
        }else if(camp.isQuartas()){
            TelaQuartas t = new TelaQuartas(camp);
            t.setVisible(true);
        }else if(camp.isSemi()){
            TelaSemi t = new TelaSemi(camp);
            t.setVisible(true);
        }else if(camp.isFinal()){
            TelaFinal t = new TelaFinal(camp);
            t.setVisible(true);
        }else if(camp.isFinalizado()){
            TelaPremios t = new TelaPremios(camp);
            t.setVisible(true);
        }
        dispose();

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
            java.util.logging.Logger.getLogger(TelaJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new TelaJogos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPartidas;
    // End of variables declaration//GEN-END:variables
}
