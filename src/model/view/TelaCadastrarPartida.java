package model.view;

import java.awt.Color;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import model.bean.Campeonato;
import model.bean.Time;
import model.bean.Jogador;
import model.bean.Partida;
import model.dao.CAmareloDAO;
import model.dao.CVermelhoDAO;
import model.dao.CampeonatoDAO;
import model.dao.GolsDAO;
import model.dao.TimeDAO;
import model.dao.JogadorDAO;
import model.dao.PartidaDAO;

public class TelaCadastrarPartida extends javax.swing.JFrame {

    Campeonato camp;
    Partida partida;
    String fase;
    Border bordaEstadio, bordaDia, bordaMes, bordaMandante, bordaGols1, bordaGols2, bordaPenalti1, bordaPenalti2;
    Border bordaVermelha = BorderFactory.createLineBorder(Color.RED);
    Time mandante, visitante;
    TimeDAO timeDAO = new TimeDAO();
    CampeonatoDAO campDAO = new CampeonatoDAO();
    JogadorDAO jogadorDAO = new JogadorDAO();

    public TelaCadastrarPartida(Campeonato camp, Partida partida) {
        initComponents();
        
        this.bordaEstadio = txtEstadio.getBorder();
        this.bordaDia = cmbDia.getBorder();
        this.bordaMes = cmbMes.getBorder();
        this.bordaGols1 = txtGols1.getBorder();
        this.bordaGols2 = txtGols2.getBorder();
        this.bordaPenalti1 = txtPenalti1.getBorder();
        this.bordaPenalti2 = txtPenalti2.getBorder();

        lblPenalti.setVisible(false); // deixa tudo invisível
        txtPenalti1.setVisible(false);
        txtPenalti2.setVisible(false);
        lblX.setVisible(false);
        sepMandante.setVisible(false);
        sepVisitante.setVisible(false);
        this.camp = camp;
        this.partida = partida;
        this.fase = partida.getFase();
        this.mandante = partida.getMandante();
        this.visitante = partida.getVisitante();
        txtGols1.setText("0");
        txtGols2.setText("0");
        txtPenalti1.setText("0");
        txtPenalti2.setText("0");
        
        lblMandante.setText(partida.getMandante().getNome());
        lblVisitante.setText(partida.getVisitante().getNome());
        DefaultTableModel tbm1 = (DefaultTableModel) tbTime1.getModel();
        DefaultTableModel tbm2 = (DefaultTableModel) tbTime2.getModel();
        List<Jogador> jogadores1 = new JogadorDAO().listarNaoSuspensos(mandante);
        List<Jogador> jogadores2 = new JogadorDAO().listarNaoSuspensos(visitante);
        for (Jogador jogador : jogadores1) {
            tbm1.addRow(
                    new Object[]{
                        jogador.getApelido(), 0, 0, 0
                    });
        }
        for (Jogador jogador : jogadores2) {
            tbm2.addRow(new Object[]{jogador.getApelido(), 0, 0, 0});
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbDia = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        txtEstadio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTime1 = new javax.swing.JTable();
        btnCancelar = new javax.swing.JButton();
        lblPenalti = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTime2 = new javax.swing.JTable();
        btnSalvar = new javax.swing.JButton();
        txtGols2 = new javax.swing.JTextField();
        txtGols1 = new javax.swing.JTextField();
        cmbMes = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        txtObservacoes = new javax.swing.JTextField();
        txtPenalti1 = new javax.swing.JTextField();
        txtPenalti2 = new javax.swing.JTextField();
        lblX = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblVisitante = new javax.swing.JLabel();
        lblMandante = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        sepVisitante = new javax.swing.JSeparator();
        sepMandante = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nova Partida");
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        cmbDia.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbDia.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Dia", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        cmbDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbDiaActionPerformed(evt);
            }
        });
        getContentPane().add(cmbDia);
        cmbDia.setBounds(340, 60, 60, 21);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Data:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(280, 60, 50, 17);

        txtEstadio.setBackground(new java.awt.Color(126, 217, 87));
        txtEstadio.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtEstadio.setForeground(new java.awt.Color(255, 255, 255));
        txtEstadio.setBorder(null);
        getContentPane().add(txtEstadio);
        txtEstadio.setBounds(90, 60, 150, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Estádio:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 60, 70, 17);

        tbTime1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTime1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador", "Gols", "CA", "CV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTime1.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tbTime1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 140, 210, 260);

        btnCancelar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(380, 440, 95, 25);

        lblPenalti.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti.setText("Penaltis");
        getContentPane().add(lblPenalti);
        lblPenalti.setBounds(220, 110, 60, 10);

        tbTime2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tbTime2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Jogador", "Gols", "CA", "CV"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTime2.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbTime2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(270, 140, 210, 260);

        btnSalvar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(20, 440, 77, 25);

        txtGols2.setBackground(new java.awt.Color(126, 217, 87));
        txtGols2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtGols2.setForeground(new java.awt.Color(255, 255, 255));
        txtGols2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGols2.setBorder(null);
        getContentPane().add(txtGols2);
        txtGols2.setBounds(260, 90, 30, 15);

        txtGols1.setBackground(new java.awt.Color(126, 217, 87));
        txtGols1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtGols1.setForeground(new java.awt.Color(255, 255, 255));
        txtGols1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtGols1.setBorder(null);
        getContentPane().add(txtGols1);
        txtGols1.setBounds(210, 90, 30, 15);

        cmbMes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        cmbMes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Mês", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        getContentPane().add(cmbMes);
        cmbMes.setBounds(410, 60, 70, 20);

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Observações:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(20, 410, 100, 17);

        txtObservacoes.setBackground(new java.awt.Color(126, 217, 87));
        txtObservacoes.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtObservacoes.setForeground(new java.awt.Color(255, 255, 255));
        txtObservacoes.setBorder(null);
        getContentPane().add(txtObservacoes);
        txtObservacoes.setBounds(120, 410, 190, 15);

        txtPenalti1.setBackground(new java.awt.Color(126, 217, 87));
        txtPenalti1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPenalti1.setForeground(new java.awt.Color(255, 255, 255));
        txtPenalti1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPenalti1.setBorder(null);
        getContentPane().add(txtPenalti1);
        txtPenalti1.setBounds(210, 120, 30, 15);

        txtPenalti2.setBackground(new java.awt.Color(126, 217, 87));
        txtPenalti2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtPenalti2.setForeground(new java.awt.Color(255, 255, 255));
        txtPenalti2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtPenalti2.setBorder(null);
        getContentPane().add(txtPenalti2);
        txtPenalti2.setBounds(260, 120, 30, 15);

        lblX.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblX.setForeground(new java.awt.Color(255, 255, 255));
        lblX.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblX.setText("X");
        getContentPane().add(lblX);
        lblX.setBounds(230, 120, 40, 17);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(230, 90, 40, 17);

        lblVisitante.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblVisitante.setForeground(new java.awt.Color(255, 255, 255));
        lblVisitante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblVisitante.setText("Visitante");
        getContentPane().add(lblVisitante);
        lblVisitante.setBounds(320, 90, 150, 20);

        lblMandante.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblMandante.setForeground(new java.awt.Color(255, 255, 255));
        lblMandante.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMandante.setText("Mandante");
        getContentPane().add(lblMandante);
        lblMandante.setBounds(30, 90, 150, 20);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(260, 105, 30, 10);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(120, 430, 190, 10);
        getContentPane().add(jSeparator4);
        jSeparator4.setBounds(210, 105, 30, 10);
        getContentPane().add(sepVisitante);
        sepVisitante.setBounds(260, 135, 30, 10);
        getContentPane().add(sepMandante);
        sepMandante.setBounds(210, 135, 30, 10);
        getContentPane().add(jSeparator5);
        jSeparator5.setBounds(90, 80, 150, 10);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/view/7.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 500, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    public void cadastro() {

        CAmareloDAO amareloDAO = new CAmareloDAO();
        CVermelhoDAO vermelhoDAO = new CVermelhoDAO();
        GolsDAO golDAO = new GolsDAO();
        List<Jogador> jogadores1 = jogadorDAO.listarSuspensosTime(mandante); // pega todos que estavam suspensos
        List<Jogador> jogadores2 = jogadorDAO.listarSuspensosTime(visitante);

        for (Jogador jogador : jogadores1) {
            jogadorDAO.cumpriuSuspensao(jogador, camp); // e tira a suspensão
        }
        for (Jogador jogador : jogadores2) {
            jogadorDAO.cumpriuSuspensao(jogador, camp);
        }
        
        partida.setPlacarMandante(Integer.valueOf(txtGols1.getText()));
        partida.setPlacarVisitante(Integer.valueOf(txtGols2.getText()));
        partida.setLocal(txtEstadio.getText());
        partida.setObservacoes(txtObservacoes.getText());
        String data = String.valueOf(camp.getAno()) + "/" + String.valueOf(cmbMes.getSelectedItem()) + "/" + String.valueOf(cmbDia.getSelectedItem());
        partida.setData(data);
        PartidaDAO partidaDAO = new PartidaDAO();
        partidaDAO.cadastrarCompleto(partida); // cadastra a partida no banco de dados

        DefaultTableModel model = (DefaultTableModel) tbTime1.getModel();
        int linha1 = model.getRowCount();

        for (int i = 0; i < linha1; i++) {
            Jogador jogador = new Jogador();

            jogador.setApelido((String) model.getValueAt(i, 0)); //pega o apelido do jogador
            Jogador jogA = jogadorDAO.buscarPorNome(jogador); // busca o resto dos dados pelo apelido
            jogador.setGols(Integer.valueOf(String.valueOf(model.getValueAt(i, 1)))); //pega o número de gols na tabela
            for (int j = 0; j < jogador.getGols(); j++) {
                golDAO.inserir(jogA, partida);
            }
            jogador.setCa(Integer.valueOf(String.valueOf(model.getValueAt(i, 2)))); // número de cartões amarelos
            if (Integer.valueOf(String.valueOf(model.getValueAt(i, 2))) != 0) { // se ele tiver tomado cartão
                amareloDAO.inserir(jogA, partida);
                int a = jogA.getCa() + Integer.valueOf(String.valueOf(model.getValueAt(i, 2)));
                if (a == 2) { // e for o segundo
                    jogadorDAO.suspenso(jogador, camp); // o jogador estará suspenso
                    jogador.setCa(0); // esse comando é só pra organização
                }
            }
            jogador.setCv(Integer.valueOf(String.valueOf(model.getValueAt(i, 3)))); // número de cartões vermelhos
            if (Integer.valueOf(String.valueOf(model.getValueAt(i, 3))) == 1) {//se tiver tomado vermelho
                vermelhoDAO.inserir(jogA, partida);
                jogadorDAO.suspenso(jogador, camp);//ta suspenso
                jogador.setCa(0);//amarelo zera
            }
            jogadorDAO.atualizar(jogador, camp);//atualiza os dados no banco de dados
        }

        DefaultTableModel model1 = (DefaultTableModel) tbTime2.getModel();
        int linha2 = model1.getRowCount();

        for (int i = 0; i < linha2; i++) {
            Jogador jogador = new Jogador();
            jogador.setApelido((String) model1.getValueAt(i, 0));
            Jogador jogA = jogadorDAO.buscarPorNome(jogador);
            jogador.setGols(Integer.valueOf(String.valueOf(model1.getValueAt(i, 1))));
            for (int j = 0; j < jogador.getGols(); j++) {
                golDAO.inserir(jogA, partida);
            }
            jogador.setCa(Integer.valueOf(String.valueOf(model1.getValueAt(i, 2))));
            if (Integer.valueOf(String.valueOf(model1.getValueAt(i, 2))) != 0) {
                amareloDAO.inserir(jogA, partida);
                int a = jogA.getCa() + Integer.valueOf(String.valueOf(model1.getValueAt(i, 2)));
                if (a % 2 == 0) {
                    jogadorDAO.suspenso(jogador, camp);
                    jogador.setCa(0);
                }
            }
            jogador.setCv(Integer.valueOf(String.valueOf(model1.getValueAt(i, 3))));
            if (Integer.valueOf(String.valueOf(model1.getValueAt(i, 3))) == 1) {
                vermelhoDAO.inserir(jogA, partida);
                jogadorDAO.suspenso(jogador, camp);
                jogador.setCa(0);
            }
            jogadorDAO.atualizar(jogador, camp);
        }

        if (camp.isFaseDeGrupos() == true) {
            if (camp.getNumGrupos() == 2) {
                TelaDoisGrupos tdg = new TelaDoisGrupos(camp);
                tdg.setVisible(true);
            } else if (camp.getNumGrupos() == 4) {
                TelaQuatroGrupos tqg = new TelaQuatroGrupos(camp);
                tqg.setVisible(true);
            }
        }
        camp.setIniciado(true);
        campDAO.iniciar(camp);
        this.dispose();
    }

    public void cadastroMataMata() {

        List<Jogador> jogadores1 = jogadorDAO.listarSuspensosTime(mandante);
        List<Jogador> jogadores2 = jogadorDAO.listarSuspensosTime(visitante);

        for (Jogador jogador : jogadores1) {
            jogadorDAO.cumpriuSuspensao(jogador, camp);
        }
        for (Jogador jogador : jogadores2) {
            jogadorDAO.cumpriuSuspensao(jogador, camp);
        }

        partida.setPlacarMandante(Integer.valueOf(txtGols1.getText()));
        partida.setPlacarVisitante(Integer.valueOf(txtGols2.getText()));
        partida.setPenaltisMandante(Integer.valueOf(txtPenalti1.getText()));
        partida.setPenaltisVisitante(Integer.valueOf(txtPenalti2.getText()));
        partida.setLocal(txtEstadio.getText());
        partida.setObservacoes(txtObservacoes.getText());
        String data = String.valueOf(camp.getAno()) + "/" + String.valueOf(cmbMes.getSelectedItem()) + "/" + String.valueOf(cmbDia.getSelectedItem());
        partida.setData(data);
        PartidaDAO partidaDAO = new PartidaDAO();

        partidaDAO.cadastrarCompleto(partida);

        DefaultTableModel model = (DefaultTableModel) tbTime1.getModel();
        int linha1 = model.getRowCount();
        GolsDAO golDAO = new GolsDAO();
        CAmareloDAO amareloDAO = new CAmareloDAO();
        CVermelhoDAO vermelhoDAO = new CVermelhoDAO();
        for (int i = 0; i < linha1; i++) {
            Jogador jogador = new Jogador();

            jogador.setApelido((String) model.getValueAt(i, 0));
            Jogador jogA = jogadorDAO.buscarPorNome(jogador);
            jogador.setGols(Integer.valueOf(String.valueOf(model.getValueAt(i, 1))));
            for (int j = 0; j < jogador.getGols(); j++) {
                golDAO.inserir(jogA, partida);
            }
            jogador.setCa(Integer.valueOf(String.valueOf(model.getValueAt(i, 2))));
            if (Integer.valueOf(String.valueOf(model.getValueAt(i, 2))) != 0) {
                int a = jogA.getCa() + Integer.valueOf(String.valueOf(model.getValueAt(i, 2)));
                if (a == 2) {
                    amareloDAO.inserir(jogA, partida);
                    jogadorDAO.suspenso(jogador, camp);
                    jogador.setCa(0);
                }
            }
            jogador.setCv(Integer.valueOf(String.valueOf(model.getValueAt(i, 3))));
            if (Integer.valueOf(String.valueOf(model.getValueAt(i, 3))) == 1) {
                vermelhoDAO.inserir(jogA, partida);
                jogadorDAO.suspenso(jogador, camp);
                jogador.setCa(0);
            }
            jogadorDAO.atualizar(jogador, camp);
        }

        DefaultTableModel model1 = (DefaultTableModel) tbTime2.getModel();
        int linha2 = model1.getRowCount();

        for (int i = 0; i < linha2; i++) {
            Jogador jogador = new Jogador();

            jogador.setApelido((String) model1.getValueAt(i, 0));
            Jogador jogA = jogadorDAO.buscarPorNome(jogador);
            jogador.setGols(Integer.valueOf(String.valueOf(model1.getValueAt(i, 1))));
            for(int j = 0;j<jogador.getGols();j++){
                golDAO.inserir(jogA, partida);
            }
            jogador.setCa(Integer.valueOf(String.valueOf(model1.getValueAt(i, 2))));
            if (Integer.valueOf(String.valueOf(model1.getValueAt(i, 2))) != 0) {
                int a = jogA.getCa() + Integer.valueOf(String.valueOf(model1.getValueAt(i, 2)));
                if (a == 2) {
                    amareloDAO.inserir(jogA, partida);
                    jogadorDAO.suspenso(jogador, camp);
                    jogador.setCa(0);
                }
            }
            jogador.setCv(Integer.valueOf(String.valueOf(model1.getValueAt(i, 3))));
            if (Integer.valueOf(String.valueOf(model1.getValueAt(i, 3))) == 1) {
                vermelhoDAO.inserir(jogA, partida);
                jogadorDAO.suspenso(jogador, camp);
                jogador.setCa(0);
            }
            jogadorDAO.atualizar(jogador, camp);
        }

        camp = campDAO.buscar(camp.getId()); // atualiza o campeonato
        if(camp.isOitavas()){
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
        }
        dispose();
    }

    
    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
         // número de times ainda no campeonato
        if (lblPenalti.isVisible() == true) { // se tiver ido pros penaltis

            if (Integer.valueOf(txtPenalti1.getText()) > Integer.valueOf(txtPenalti2.getText())) {
                // se o valor nos penaltis do mandante for maior que o do visitante
                if (camp.isFinal()) { // se tiver só dois times
                    campDAO.campeao(camp, mandante); //mandante é campeão
                    campDAO.viceCampeao(camp, visitante); // visitante vice
                     // esse comando é questão de organização
                    camp.setArtilheiro(jogadorDAO.artilheiro(camp));
                    campDAO.artilheiro(camp, camp.getArtilheiro());
                    campDAO.finalizar(camp);
                    cadastroMataMata(); // puxa todo o método
                } else { // se tiver mais de 2 times
                    timeDAO.eliminar(visitante, camp); // elimina o visitante
                    cadastroMataMata();
                }
            } else if (Integer.valueOf(txtPenalti1.getText()) < Integer.valueOf(txtPenalti2.getText())) {
                // se o visitante tiver ganhado
                if (camp.isFinal()) {
                    campDAO.campeao(camp, visitante);
                    campDAO.viceCampeao(camp, mandante);
                    
                    camp.setArtilheiro(jogadorDAO.artilheiro(camp));
                    campDAO.artilheiro(camp, camp.getArtilheiro());
                    campDAO.finalizar(camp);
                    cadastroMataMata();
                } else {
                    timeDAO.eliminar(mandante, camp);
                    cadastroMataMata();
                }
            } else {
                //se tiver empatado nos pênalti
                JOptionPane.showMessageDialog(null, "os penaltis não podem empatar");

            }

        } else {
            // se não tiver ido pros penaltis
            if (txtGols1.getText().equals("") || txtGols2.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "O placar não pode estar vazio");
                txtGols1.setBorder(bordaVermelha);
                txtGols2.setBorder(bordaVermelha);
            } else if (txtEstadio.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "o jogo tem que ocorrer em um estádio");
                txtGols1.setBorder(bordaGols1);
                txtGols2.setBorder(bordaGols2);
                txtEstadio.setBorder(bordaVermelha);
            } else if (cmbDia.getSelectedIndex() == 0 || cmbMes.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(null, "Verifique a data do jogo");
                txtGols1.setBorder(bordaGols1);
                txtGols2.setBorder(bordaGols2);

                txtEstadio.setBorder(bordaEstadio);
                cmbDia.setBorder(bordaVermelha);
                cmbMes.setBorder(bordaVermelha);
                //verifica se tem algum campo vazio
            } else {
                if (JOptionPane.showConfirmDialog(null, "Tem certeza?", "Salvar Partida", JOptionPane.WARNING_MESSAGE) == 0) {
                    //aviso de confirmação

                    if (Integer.valueOf(txtGols1.getText()) > Integer.valueOf(txtGols2.getText())) {
                        //se o mandante ganhar
                        if (camp.isFaseDeGrupos() == true) { // se tiver na fase de grupos
                            mandante.setPontos(mandante.getPontos() + 3);
                            timeDAO.vitoria(mandante); //cadastra +3 no banco de dados
                            cadastro();
                        } else { //se não tiver na fase de grupos
                            if (camp.isFinal()) {//se for a final
                                campDAO.campeao(camp, mandante);
                                campDAO.viceCampeao(camp, visitante);
                                
                                camp.setArtilheiro(jogadorDAO.artilheiro(camp));
                                campDAO.artilheiro(camp, camp.getArtilheiro());
                                campDAO.finalizar(camp);
                                cadastroMataMata();
                            } else { // se não for
                                timeDAO.eliminar(visitante, camp);
                                cadastroMataMata();
                            }
                        }
                    } else if (Integer.valueOf(txtGols1.getText()) < Integer.valueOf(txtGols2.getText())) {
                        //se o visitante ganhar
                        if (camp.isFaseDeGrupos() == true) {
                            visitante.setPontos(visitante.getPontos() + 3);
                            timeDAO.vitoria(visitante);
                            cadastro();
                        } else {
                            if (camp.isFinal()) {
                                campDAO.campeao(camp, visitante);
                                campDAO.viceCampeao(camp, mandante);
                                
                                camp.setArtilheiro(jogadorDAO.artilheiro(camp));
                                campDAO.artilheiro(camp, camp.getArtilheiro());
                                campDAO.finalizar(camp);
                                cadastroMataMata();
                            } else {
                                timeDAO.eliminar(mandante, camp);
                                cadastroMataMata();
                            }
                        }
                    } else {
                        //se der empate
                        if (camp.isFaseDeGrupos() == true) {
                            mandante.setPontos(mandante.getPontos() + 1);
                            visitante.setPontos(visitante.getPontos() + 1);
                            timeDAO.empate(mandante);
                            timeDAO.empate(visitante);
                            cadastro();
                        } else { //se tiver no mata-mata ativa os pênaltis
                            lblPenalti.setVisible(true);
                            txtPenalti1.setVisible(true);
                            txtPenalti2.setVisible(true);
                            lblX.setVisible(true);
                            sepMandante.setVisible(true);
                            sepVisitante.setVisible(true);
                        }
                    }

                }
            }
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        if (camp.isFaseDeGrupos() == true) {
            if (camp.getNumGrupos() == 2) {
                TelaDoisGrupos tdg = new TelaDoisGrupos(camp);
                tdg.setVisible(true);
            } else if (camp.getNumGrupos() == 4) {
                TelaQuatroGrupos tqg = new TelaQuatroGrupos(camp);
                tqg.setVisible(true);
            }
        } else {
            if (camp.isOitavas()) {
                TelaOitavas t = new TelaOitavas(camp);
                t.setVisible(true);
            } else if (camp.isQuartas()) {
                TelaQuartas t = new TelaQuartas(camp);
                t.setVisible(true);
            } else if (camp.isSemi()) {
                TelaSemi t = new TelaSemi(camp);
                t.setVisible(true);
            } else if (camp.isFinal()) {
                TelaFinal t = new TelaFinal(camp);
                t.setVisible(true);
            }
        }
        this.dispose();

    }//GEN-LAST:event_btnCancelarActionPerformed

    private void cmbDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbDiaActionPerformed
        DefaultComboBoxModel cbm = (DefaultComboBoxModel) cmbMes.getModel();

        if ((cmbDia.getSelectedIndex() == 30 && camp.getAno() % 4 != 0) || cmbDia.getSelectedIndex() == 31 || cmbDia.getSelectedIndex() == 32 && cbm.getSize() == 13) {
            //se for selecionado algum dia que não tem em fevereiro, remove dos meses
            cbm.removeElementAt(2);
        }
        if (cmbDia.getSelectedIndex() < 30 && cbm.getSize() != 13) {
            //se trocar, adiciona de novo
            cbm.insertElementAt(02, 2);
        }
    }//GEN-LAST:event_cmbDiaActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastrarPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //               new TelaCadastrarPartida().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JComboBox cmbDia;
    private javax.swing.JComboBox cmbMes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lblMandante;
    private javax.swing.JLabel lblPenalti;
    private javax.swing.JLabel lblVisitante;
    private javax.swing.JLabel lblX;
    private javax.swing.JSeparator sepMandante;
    private javax.swing.JSeparator sepVisitante;
    private javax.swing.JTable tbTime1;
    private javax.swing.JTable tbTime2;
    private javax.swing.JTextField txtEstadio;
    private javax.swing.JTextField txtGols1;
    private javax.swing.JTextField txtGols2;
    private javax.swing.JTextField txtObservacoes;
    private javax.swing.JTextField txtPenalti1;
    private javax.swing.JTextField txtPenalti2;
    // End of variables declaration//GEN-END:variables
}
