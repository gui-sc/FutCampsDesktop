package model.view;

import java.awt.Color;
import java.time.LocalDateTime;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import model.dao.CampeonatoDAO;
import model.bean.Campeonato;

public class TelaNovoCamp extends javax.swing.JFrame {

    Border bordaVermelha = BorderFactory.createLineBorder(Color.RED);
    Border bordaTexto, bordaCmb;

    public TelaNovoCamp() {
        initComponents();
        lblFormato.setVisible(false);
        lblGrupos.setVisible(false);
        
        bordaTexto = txtNomeCamp.getBorder();
        bordaCmb = cmbFormato.getBorder();
        LocalDateTime ldt = LocalDateTime.now();
        cmbAno.addItem(ldt.getYear());
        cmbAno.addItem(ldt.getYear() + 1);
        cmbAno.addItem(ldt.getYear() + 2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        lblNumTimes = new javax.swing.JLabel();
        cmbFormato = new javax.swing.JComboBox();
        lblCidade = new javax.swing.JLabel();
        cmbNumTimes = new javax.swing.JComboBox();
        txtCidade = new javax.swing.JTextField();
        txtNomeCamp = new javax.swing.JTextField();
        lblAno = new javax.swing.JLabel();
        lblPremiacao = new javax.swing.JLabel();
        cmbAno = new javax.swing.JComboBox();
        lblFormato = new javax.swing.JLabel();
        lblGrupos = new javax.swing.JLabel();
        cmbGrupos = new javax.swing.JComboBox();
        txtPremiacao = new javax.swing.JTextField();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Novo Campeonato");
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        lblNome.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(255, 255, 255));
        lblNome.setText("Nome: *");
        getContentPane().add(lblNome);
        lblNome.setBounds(90, 130, 66, 17);

        lblNumTimes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNumTimes.setForeground(new java.awt.Color(255, 255, 255));
        lblNumTimes.setText("Nº Times: *");
        getContentPane().add(lblNumTimes);
        lblNumTimes.setBounds(90, 180, 90, 17);

        cmbFormato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbFormato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Mata-Mata", "Fase de Grupos + Mata-Mata" }));
        cmbFormato.setBorder(null);
        cmbFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFormatoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFormato);
        cmbFormato.setBounds(210, 130, 190, 25);

        lblCidade.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblCidade.setForeground(new java.awt.Color(255, 255, 255));
        lblCidade.setText("Cidade: *");
        getContentPane().add(lblCidade);
        lblCidade.setBounds(90, 180, 70, 17);

        cmbNumTimes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbNumTimes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "4", "8", "16", "32" }));
        cmbNumTimes.setBorder(null);
        cmbNumTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNumTimesActionPerformed(evt);
            }
        });
        getContentPane().add(cmbNumTimes);
        cmbNumTimes.setBounds(210, 180, 190, 25);

        txtCidade.setBackground(new java.awt.Color(126, 217, 87));
        txtCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCidade.setBorder(null);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(210, 180, 190, 20);

        txtNomeCamp.setBackground(new java.awt.Color(126, 217, 87));
        txtNomeCamp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNomeCamp.setBorder(null);
        getContentPane().add(txtNomeCamp);
        txtNomeCamp.setBounds(210, 130, 190, 20);

        lblAno.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblAno.setForeground(new java.awt.Color(255, 255, 255));
        lblAno.setText("Ano: *");
        getContentPane().add(lblAno);
        lblAno.setBounds(100, 260, 50, 17);

        lblPremiacao.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPremiacao.setForeground(new java.awt.Color(255, 255, 255));
        lblPremiacao.setText("Premiação:");
        getContentPane().add(lblPremiacao);
        lblPremiacao.setBounds(90, 220, 90, 17);

        cmbAno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cmbAno.setBorder(null);
        getContentPane().add(cmbAno);
        cmbAno.setBounds(210, 260, 190, 25);

        lblFormato.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFormato.setForeground(new java.awt.Color(255, 255, 255));
        lblFormato.setText("Formato: *");
        getContentPane().add(lblFormato);
        lblFormato.setBounds(90, 130, 80, 17);

        lblGrupos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGrupos.setForeground(new java.awt.Color(255, 255, 255));
        lblGrupos.setText("Grupos: *");
        getContentPane().add(lblGrupos);
        lblGrupos.setBounds(90, 220, 70, 17);

        cmbGrupos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbGrupos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cmbGrupos.setBorder(null);
        cmbGrupos.setEnabled(false);
        getContentPane().add(cmbGrupos);
        cmbGrupos.setBounds(210, 220, 190, 25);

        txtPremiacao.setBackground(new java.awt.Color(126, 217, 87));
        txtPremiacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPremiacao.setBorder(null);
        getContentPane().add(txtPremiacao);
        txtPremiacao.setBounds(210, 220, 190, 20);

        btnSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvar.setText("Próximo");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(396, 410, 80, 31);

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(30, 410, 100, 31);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(210, 240, 190, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(210, 150, 190, 10);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(210, 200, 190, 10);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(180, 420, 190, 12);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/view/2.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 500, 480);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbFormatoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbFormatoActionPerformed
        if (cmbNumTimes.getSelectedIndex() != 0 && cmbFormato.getSelectedIndex() == 2) {//se o usuário escolher fase de grupos+mata-mata
            cmbGrupos.setEnabled(true);//a escolha do grupos é habilitada

        } else {
            cmbGrupos.setEnabled(false);

        }
        if (cmbNumTimes.getSelectedIndex() == 1) { // de acordo com o número de times ele dá as opções
            cmbGrupos.removeAllItems();
            cmbGrupos.addItem("Selecione");
            cmbGrupos.addItem("Um grupo");
        } else if (cmbNumTimes.getSelectedIndex() == 2) {
            cmbGrupos.removeAllItems();
            cmbGrupos.addItem("Selecione");
            cmbGrupos.addItem("Dois grupos de 4 times");
        } else if (cmbNumTimes.getSelectedIndex() == 3) {
            cmbGrupos.removeAllItems();
            cmbGrupos.addItem("Selecione");
            cmbGrupos.addItem("Quatro grupos de 4 times");
            cmbGrupos.addItem("Dois grupos de 8 times");
        } else if (cmbNumTimes.getSelectedIndex() == 4) {
            cmbGrupos.removeAllItems();
            cmbGrupos.addItem("Selecione");
            cmbGrupos.addItem("Quatro grupos de 8 times");
            cmbGrupos.addItem("Dois grupos de 16 times");
        }
    }//GEN-LAST:event_cmbFormatoActionPerformed

    private void cmbNumTimesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbNumTimesActionPerformed
        if (cmbNumTimes.getSelectedIndex() != 0 && cmbFormato.getSelectedIndex() == 2) { // a mesma coisa
            cmbGrupos.setEnabled(true);

        } else {
            cmbGrupos.setEnabled(false);

        }
        if (cmbNumTimes.getSelectedIndex() == 1) {
            cmbGrupos.removeAllItems();
            cmbGrupos.addItem("Selecione");
            cmbGrupos.addItem("Um grupo");
        } else if (cmbNumTimes.getSelectedIndex() == 2) {
            cmbGrupos.removeAllItems();
            cmbGrupos.addItem("Selecione");
            cmbGrupos.addItem("Dois grupos de 4 times");
        } else if (cmbNumTimes.getSelectedIndex() == 3) {
            cmbGrupos.removeAllItems();
            cmbGrupos.addItem("Selecione");
            cmbGrupos.addItem("Quatro grupos de 4 times");
            cmbGrupos.addItem("Dois grupos de 8 times");
        }
    }//GEN-LAST:event_cmbNumTimesActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (btnSalvar.getText().equals("Salvar")) {
            txtNomeCamp.setBorder(bordaTexto);
            cmbFormato.setBorder(bordaCmb);
            cmbNumTimes.setBorder(bordaCmb);
            cmbGrupos.setBorder(bordaCmb);
            cmbAno.setBorder(bordaCmb);
            txtCidade.setBorder(bordaTexto);

            String nome = txtNomeCamp.getText();
            String local = txtCidade.getText();
            String premiacao = txtPremiacao.getText();

            String regras = null;
            boolean faseDeGrupos;
            if (cmbFormato.getSelectedIndex() == 1) {
                regras = "Mata-Mata";
                faseDeGrupos = false;
            } else {
                regras = "Fase de grupos + Mata-Mata";
                faseDeGrupos = true;
            }
            int numGrupos = 0;

            if (cmbGrupos.getSelectedItem().equals("Um grupo")) {
                numGrupos = 1;
            } else if (cmbGrupos.getSelectedItem().equals("Dois grupos de 4 times")) {
                numGrupos = 2;
            } else if (cmbGrupos.getSelectedItem().equals("Quatro grupos de 4 times")) {
                numGrupos = 4;
            } else if (cmbGrupos.getSelectedItem().equals("Dois grupos de 8 times")) {
                numGrupos = 2;
            } else if (cmbGrupos.getSelectedItem().equals("Quatro grupos de 8 times")) {
                numGrupos = 4;
            } else if (cmbGrupos.getSelectedItem().equals("Dois grupos de 16 times")) {
                numGrupos = 2;
            }

            int numTimes = 0;

            if (cmbNumTimes.getSelectedIndex() == 1) {
                numTimes = 4;
            } else if (cmbNumTimes.getSelectedIndex() == 2) {
                numTimes = 8;
            } else if (cmbNumTimes.getSelectedIndex() == 3) {
                numTimes = 16;
            }

            int ano = 0;

            if (cmbAno.getSelectedIndex() == 1) {
                ano = 2019;
            } else if (cmbAno.getSelectedIndex() == 2) {
                ano = 2020;
            } else if (cmbAno.getSelectedIndex() == 3) {
                ano = 2021;
            }

            if (txtNomeCamp.getText().equals("") || cmbFormato.getSelectedIndex() == 0
                    || cmbNumTimes.getSelectedIndex() == 0
                    || txtCidade.getText().equals("") || cmbAno.getSelectedIndex() == 0
                    || (cmbGrupos.isEnabled() == true && cmbGrupos.getSelectedIndex() == 0)) {
                // verifica se não tem nenhum campo vazio pra não dar erro
                JOptionPane.showMessageDialog(null, "Verifique os campos em branco");
                if (txtNomeCamp.getText().equals("")) {
                    txtNomeCamp.setBorder(bordaVermelha);
                }
                if (cmbFormato.getSelectedIndex() == 0) {
                    cmbFormato.setBorder(bordaVermelha);
                }
                if (cmbNumTimes.getSelectedIndex() == 0) {
                    cmbNumTimes.setBorder(bordaVermelha);
                }
                if (txtCidade.getText().equals("")) {
                    txtCidade.setBorder(bordaVermelha);
                }
                if (cmbAno.getSelectedIndex() == 0) {
                    cmbAno.setBorder(bordaVermelha);
                }
                if (cmbGrupos.isEnabled() == true && cmbGrupos.getSelectedIndex() == 0) {
                    cmbGrupos.setBorder(bordaVermelha);
                }
            } else {
                Campeonato camp = new Campeonato(regras, nome, local, premiacao, ano, numTimes, numGrupos, faseDeGrupos);
                camp.setIniciado(false);
                CampeonatoDAO campDAO = new CampeonatoDAO();
                int id = campDAO.inserir(camp); // insere o campeonato e pega o id que ele tem no banco de dados
                camp.setId(id);
                this.dispose();
                TelaCadastroTime telaCadastroTime = new TelaCadastroTime(camp); // chama a tela de cadastro passando o campeonato
                telaCadastroTime.setVisible(true);
            }
        }else{
            
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaNovoCamp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCamp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCamp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaNovoCamp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaNovoCamp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbAno;
    private javax.swing.JComboBox cmbFormato;
    private javax.swing.JComboBox cmbGrupos;
    private javax.swing.JComboBox cmbNumTimes;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblAno;
    private javax.swing.JLabel lblCidade;
    private javax.swing.JLabel lblFormato;
    private javax.swing.JLabel lblGrupos;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblNumTimes;
    private javax.swing.JLabel lblPremiacao;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtNomeCamp;
    private javax.swing.JTextField txtPremiacao;
    // End of variables declaration//GEN-END:variables
}
