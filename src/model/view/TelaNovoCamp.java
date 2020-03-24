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
        bordaTexto = txtNomeCamp.getBorder();
        bordaCmb = cmbFormato.getBorder();
        LocalDateTime ldt = LocalDateTime.now();
        cmbAno.addItem(ldt.getYear());
        cmbAno.addItem(ldt.getYear()+1);
        cmbAno.addItem(ldt.getYear()+2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNome = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbFormato = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        cmbNumTimes = new javax.swing.JComboBox();
        txtCidade = new javax.swing.JTextField();
        txtNomeCamp = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbAno = new javax.swing.JComboBox();
        lblFormato = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtPremiacao = new javax.swing.JTextField();
        cmbGrupos = new javax.swing.JComboBox();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
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

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Nº Times: *");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(90, 210, 90, 17);

        cmbFormato.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbFormato.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Mata-Mata", "Fase de Grupos + Mata-Mata" }));
        cmbFormato.setBorder(null);
        cmbFormato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbFormatoActionPerformed(evt);
            }
        });
        getContentPane().add(cmbFormato);
        cmbFormato.setBounds(210, 170, 190, 19);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Cidade: *");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(90, 290, 70, 17);

        cmbNumTimes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbNumTimes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "4", "8", "16", "32" }));
        cmbNumTimes.setBorder(null);
        cmbNumTimes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNumTimesActionPerformed(evt);
            }
        });
        getContentPane().add(cmbNumTimes);
        cmbNumTimes.setBounds(210, 210, 190, 19);

        txtCidade.setBackground(new java.awt.Color(126, 217, 87));
        txtCidade.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtCidade.setBorder(null);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(210, 290, 190, 20);

        txtNomeCamp.setBackground(new java.awt.Color(126, 217, 87));
        txtNomeCamp.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNomeCamp.setBorder(null);
        getContentPane().add(txtNomeCamp);
        txtNomeCamp.setBounds(210, 130, 190, 20);

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Ano: *");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(90, 370, 50, 17);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Premiação:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(90, 330, 90, 17);

        cmbAno.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbAno.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cmbAno.setBorder(null);
        getContentPane().add(cmbAno);
        cmbAno.setBounds(210, 370, 190, 19);

        lblFormato.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblFormato.setForeground(new java.awt.Color(255, 255, 255));
        lblFormato.setText("Formato: *");
        getContentPane().add(lblFormato);
        lblFormato.setBounds(90, 170, 80, 17);

        jLabel9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Grupos: *");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(90, 250, 70, 17);

        txtPremiacao.setBackground(new java.awt.Color(126, 217, 87));
        txtPremiacao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPremiacao.setBorder(null);
        getContentPane().add(txtPremiacao);
        txtPremiacao.setBounds(210, 330, 190, 20);

        cmbGrupos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbGrupos.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione" }));
        cmbGrupos.setBorder(null);
        cmbGrupos.setEnabled(false);
        getContentPane().add(cmbGrupos);
        cmbGrupos.setBounds(210, 250, 190, 19);

        btnSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(30, 420, 69, 23);

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(363, 420, 100, 23);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(210, 350, 190, 10);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(210, 150, 190, 10);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(210, 310, 190, 10);

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
        }else if(cmbNumTimes.getSelectedIndex()==4){
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
            if(txtNomeCamp.getText().equals("")){
                txtNomeCamp.setBorder(bordaVermelha);
            }
            if(cmbFormato.getSelectedIndex() == 0){
                cmbFormato.setBorder(bordaVermelha);
            }
            if(cmbNumTimes.getSelectedIndex() == 0){
                cmbNumTimes.setBorder(bordaVermelha);
            }
            if(txtCidade.getText().equals("")){
                txtCidade.setBorder(bordaVermelha);
            }
            if(cmbAno.getSelectedIndex() == 0){
                cmbAno.setBorder(bordaVermelha);
            }
            if(cmbGrupos.isEnabled() == true && cmbGrupos.getSelectedIndex() == 0){
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
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblFormato;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtNomeCamp;
    private javax.swing.JTextField txtPremiacao;
    // End of variables declaration//GEN-END:variables
}
