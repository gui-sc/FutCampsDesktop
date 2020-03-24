package model.view;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;
import model.bean.Campeonato;
import model.bean.Partida;
import model.bean.Time;
import model.dao.CampeonatoDAO;
import model.dao.PartidaDAO;
import model.dao.TimeDAO;

/**
 *
 * @author guilherme
 */
public class TelaCadastroTime extends javax.swing.JFrame {

    Campeonato camp;
    int timesC, numTimes;
    Border bordaVermelha = BorderFactory.createLineBorder(Color.RED);
    Border bordaNormal;
    Icon escudoPadrao;
    byte[] escudoTime;

    /**
     * Creates new form TelaCadastroTime
     */
    public TelaCadastroTime(Campeonato camp) {
        initComponents();
        this.escudoPadrao = lblEscudo.getIcon();
        try {
            BufferedImage escudo = new BufferedImage(escudoPadrao.getIconWidth(), escudoPadrao.getIconHeight(), BufferedImage.SCALE_DEFAULT);
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            ImageIO.write(escudo, "jpg", b);
            escudoTime = b.toByteArray();
        } catch (IOException ex) {

        }
        this.bordaNormal = txtNome.getBorder();

        this.camp = camp;
        TimeDAO timeDAO = new TimeDAO();
        List<Time> times = timeDAO.listarPorCamp(camp);
        timesC = times.size();
        numTimes = camp.getNumTimes();
        lblTimesCriados.setText(String.valueOf(timesC));
        lblNumTimes.setText(String.valueOf(numTimes));
        if (camp.isFaseDeGrupos()) {
            if (timesC == numTimes) { // verifica se o número de times cadastrados é igual ao numero que o usuário deu
                List<Time> timesNormal = timeDAO.listarNaoCabecasDeChave(camp);
                Collections.shuffle(timesNormal); // esse comando embaralha a lista dos times
                List<Time> cabecasDeChave = timeDAO.listarCabecasDeChave(camp);
                Collections.shuffle(cabecasDeChave);
                cabecasDeChave.get(0).setGrupo(1);
                cabecasDeChave.get(1).setGrupo(2);
                cabecasDeChave.get(2).setGrupo(3);
                cabecasDeChave.get(3).setGrupo(4);
                if (camp.getNumGrupos() == 1) {
                    for (Time time : timesNormal) {
                        time.setGrupo(1);
                    }
                }
                if (camp.getNumGrupos() == 2) {
                    for (int i = 0; i < times.size() - 2; i++) {
                        if (i < ((times.size() - 2) / 2)) { // divide a lista e dá o numero do grupo
                            timesNormal.get(i).setGrupo(1);
                        } else {
                            timesNormal.get(i).setGrupo(2);
                        }
                    }
                }
                if (camp.getNumGrupos() == 4) {
                    timesNormal.get(0).setGrupo(1);
                    timesNormal.get(1).setGrupo(1);
                    timesNormal.get(2).setGrupo(1);
                    timesNormal.get(3).setGrupo(2);
                    timesNormal.get(4).setGrupo(2);
                    timesNormal.get(5).setGrupo(2);
                    timesNormal.get(6).setGrupo(3);
                    timesNormal.get(7).setGrupo(3);
                    timesNormal.get(8).setGrupo(3);
                    timesNormal.get(9).setGrupo(4);
                    timesNormal.get(10).setGrupo(4);
                    timesNormal.get(11).setGrupo(4);
                }
                if (camp.getNumGrupos() == 8) {
                    for (int i = 0; i < times.size() - 8; i++) {
                        if (i < (times.size() - 8 / 8)) {
                            timesNormal.get(i).setGrupo(1);
                        } else if (i < ((times.size() - 8) * 2 / 8)) {
                            timesNormal.get(i).setGrupo(2);
                        } else if (i < ((times.size() - 8) * 3 / 8)) {
                            timesNormal.get(i).setGrupo(3);
                        } else if (i < ((times.size() - 8) * 4 / 8)) {
                            timesNormal.get(i).setGrupo(4);
                        } else if (i < ((times.size() - 8) * 5 / 8)) {
                            timesNormal.get(i).setGrupo(5);
                        } else if (i < ((times.size() - 8) * 6 / 8)) {
                            timesNormal.get(i).setGrupo(6);
                        } else if (i < ((times.size() - 8) * 7 / 8)) {
                            timesNormal.get(i).setGrupo(7);
                        } else {
                            timesNormal.get(i).setGrupo(8);
                        }
                    }
                }
                for (Time time : timesNormal) {
                    timeDAO.numGrupo(time); // cadastra o grupo de cada time no banco de dados
                }
                for (Time time : cabecasDeChave) {
                    timeDAO.numGrupo(time);
                }
                List<Time> times1 = timeDAO.listarGrupoComCC(1, camp);
                List<Time> times2 = timeDAO.listarGrupoComCC(2, camp);
                List<Time> times3 = timeDAO.listarGrupoComCC(3, camp);
                List<Time> times4 = timeDAO.listarGrupoComCC(4, camp);
                Partida partida = new Partida();
                PartidaDAO partidaDAO = new PartidaDAO();
                partida.setCampeonato(camp);
                partida.setFase("grupos");
                for (int i = 0; i < 3; i++) {
                    if (i == 0) {
                        partida.setMandante(times1.get(0));
                        partida.setVisitante(times1.get(1));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times1.get(2));
                        partida.setVisitante(times1.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times2.get(0));
                        partida.setVisitante(times2.get(1));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times2.get(2));
                        partida.setVisitante(times2.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times3.get(0));
                        partida.setVisitante(times3.get(1));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times3.get(2));
                        partida.setVisitante(times3.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times4.get(0));
                        partida.setVisitante(times4.get(1));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times4.get(2));
                        partida.setVisitante(times4.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                    } else if (i == 1) {
                        partida.setMandante(times1.get(0));
                        partida.setVisitante(times1.get(2));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times1.get(1));
                        partida.setVisitante(times1.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times2.get(0));
                        partida.setVisitante(times2.get(2));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times2.get(1));
                        partida.setVisitante(times2.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times3.get(0));
                        partida.setVisitante(times3.get(2));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times3.get(1));
                        partida.setVisitante(times3.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times4.get(0));
                        partida.setVisitante(times4.get(2));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times4.get(1));
                        partida.setVisitante(times4.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                    } else {
                        partida.setMandante(times1.get(0));
                        partida.setVisitante(times1.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times1.get(1));
                        partida.setVisitante(times1.get(2));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times2.get(0));
                        partida.setVisitante(times2.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times2.get(1));
                        partida.setVisitante(times2.get(2));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times3.get(0));
                        partida.setVisitante(times3.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times3.get(1));
                        partida.setVisitante(times3.get(2));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times4.get(0));
                        partida.setVisitante(times4.get(3));
                        partidaDAO.cadastrarPrevia(partida);
                        partida.setMandante(times4.get(1));
                        partida.setVisitante(times4.get(2));
                        partidaDAO.cadastrarPrevia(partida);
                    }
                }
                JOptionPane.showMessageDialog(null, "sorteio dos grupos realizado");

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

        btnSair = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtDirigente = new javax.swing.JTextField();
        txtCidade = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblTimesCriados = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblNumTimes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        chkCabecaDeChave = new javax.swing.JCheckBox();
        lblEscudo = new javax.swing.JLabel();
        btnEscolher = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Time");
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        btnSair.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSair.setText("Sair");
        btnSair.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        getContentPane().add(btnSair);
        btnSair.setBounds(390, 420, 55, 23);

        btnSalvar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalvar);
        btnSalvar.setBounds(60, 420, 69, 23);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Dirigente:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(40, 210, 70, 17);

        txtDirigente.setBackground(new java.awt.Color(126, 217, 87));
        txtDirigente.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtDirigente.setForeground(new java.awt.Color(255, 255, 255));
        txtDirigente.setBorder(null);
        getContentPane().add(txtDirigente);
        txtDirigente.setBounds(110, 210, 130, 15);

        txtCidade.setBackground(new java.awt.Color(126, 217, 87));
        txtCidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtCidade.setForeground(new java.awt.Color(255, 255, 255));
        txtCidade.setBorder(null);
        getContentPane().add(txtCidade);
        txtCidade.setBounds(110, 280, 130, 15);

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Cidade:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(40, 280, 60, 17);

        lblTimesCriados.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblTimesCriados.setForeground(new java.awt.Color(255, 255, 255));
        lblTimesCriados.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblTimesCriados);
        lblTimesCriados.setBounds(90, 30, 20, 20);

        txtNome.setBackground(new java.awt.Color(126, 217, 87));
        txtNome.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtNome.setForeground(new java.awt.Color(255, 255, 255));
        txtNome.setBorder(null);
        getContentPane().add(txtNome);
        txtNome.setBounds(110, 140, 130, 15);

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Nome:");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 140, 50, 20);

        jLabel7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("N° Times:");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(20, 30, 70, 20);

        lblNumTimes.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblNumTimes.setForeground(new java.awt.Color(255, 255, 255));
        lblNumTimes.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblNumTimes);
        lblNumTimes.setBounds(120, 30, 20, 20);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("/");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(110, 30, 20, 20);

        chkCabecaDeChave.setBackground(new java.awt.Color(126, 217, 87));
        chkCabecaDeChave.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        chkCabecaDeChave.setForeground(new java.awt.Color(255, 255, 255));
        chkCabecaDeChave.setText("Cabeça de Chave");
        chkCabecaDeChave.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                chkCabecaDeChaveItemStateChanged(evt);
            }
        });
        getContentPane().add(chkCabecaDeChave);
        chkCabecaDeChave.setBounds(50, 330, 190, 25);

        lblEscudo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/view/escudoGenerico.png"))); // NOI18N
        getContentPane().add(lblEscudo);
        lblEscudo.setBounds(310, 170, 120, 110);

        btnEscolher.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnEscolher.setText("Escolher Escudo");
        btnEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherActionPerformed(evt);
            }
        });
        getContentPane().add(btnEscolher);
        btnEscolher.setBounds(290, 320, 150, 30);

        jButton1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jButton1.setText("Escolher Tme Já cadastrado");
        jButton1.setMaximumSize(new java.awt.Dimension(77, 25));
        jButton1.setMinimumSize(new java.awt.Dimension(77, 25));
        jButton1.setPreferredSize(new java.awt.Dimension(77, 25));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(160, 420, 200, 25);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(110, 300, 140, 20);
        getContentPane().add(jSeparator2);
        jSeparator2.setBounds(110, 160, 140, 20);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(110, 230, 140, 20);

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/view/3.png"))); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 500, 500);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        txtNome.setBorder(bordaNormal);
        txtDirigente.setBorder(bordaNormal);
        txtCidade.setBorder(bordaNormal);

        if (txtNome.getText().equals("") || txtDirigente.getText().equals("") || txtCidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Verifique os campos em branco!");
            if (txtNome.getText().equals("")) {
                txtNome.setBorder(bordaVermelha);
            }
            if (txtDirigente.getText().equals("")) {
                txtDirigente.setBorder(bordaVermelha);
            }
            if (txtCidade.getText().equals("")) {
                txtCidade.setBorder(bordaVermelha);
            }
        } else {
            if (timesC == 12 && camp.getCabecasDeChave() == 0 || timesC == 13 && camp.getCabecasDeChave() == 1
                    || timesC == 14 && camp.getCabecasDeChave() == 2 || timesC == 15 && camp.getCabecasDeChave() == 3) {
                JOptionPane.showMessageDialog(null, "esse time tem de ser cabeça de chave!");
            } else {
                TimeDAO timeDAO = new TimeDAO();
                Time time = new Time();
                time.setNome(txtNome.getText());
                time.setDirigente(txtDirigente.getText());
                time.setCidade(txtCidade.getText());
                time.setCampeonato(camp);
                time.setCabecaDeChave(chkCabecaDeChave.isSelected());
                time.setEscudo(escudoTime);
                int id = timeDAO.inserir(time); // cadastra o time no banco de dados e pega o id que ele ganhou
                if (chkCabecaDeChave.isSelected()) {
                    camp.setCabecasDeChave(camp.getCabecasDeChave() + 1);
                    CampeonatoDAO campDAO = new CampeonatoDAO();
                    campDAO.cabecaDeChaveMais(camp);
                }
                time.setId(id);
                TelaJogadores tj = new TelaJogadores(camp, time); // passa o campeonato e o time como parâmetro pra proxima tela
                tj.setVisible(true); // o campeonato é só pra poder voltar depois
                this.dispose(); //  e o time é pra cadastrar os jogadores
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        TelaPrincipal tp = new TelaPrincipal();
        tp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnSairActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (timesC == numTimes) { // quando a janela abre, se o sorteio já tiver sido feito
            TelaCarregarCamp tcc = new TelaCarregarCamp(); // vai direto pra tela de carregar o campeonato
            tcc.setVisible(true);
            this.dispose(); // e fecha essa tela
        }
    }//GEN-LAST:event_formWindowOpened

    private void chkCabecaDeChaveItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_chkCabecaDeChaveItemStateChanged
        if (camp.getCabecasDeChave() == camp.getNumGrupos()) {
            JOptionPane.showMessageDialog(null, "Limite de Cabeças de Chave atingido!");
            chkCabecaDeChave.setSelected(false);
        }
    }//GEN-LAST:event_chkCabecaDeChaveItemStateChanged

    private void btnEscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherActionPerformed
        JFileChooser chooser = new JFileChooser();
        chooser.setDialogTitle("Escolher Escudo");
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Imagem", "jpg", "png");
        chooser.setFileFilter(filter);

        if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                File f = chooser.getSelectedFile();
                ImageIcon escudo = new javax.swing.ImageIcon(ImageIO.read(f));
                int lbAltura = lblEscudo.getHeight();
                int lbLargura = lblEscudo.getWidth();
                Double alturaImg = (double) escudo.getIconHeight();
                Double larguraImg = (double) escudo.getIconWidth();
                Double proporcaoImg = null;
                if (larguraImg >= lbLargura) {
                    proporcaoImg = alturaImg / larguraImg;
                    larguraImg = (double) lbLargura;
                    alturaImg = larguraImg * proporcaoImg;
                    while (alturaImg >= lbAltura) {
                        larguraImg = (double) --lbAltura;
                        alturaImg = larguraImg * proporcaoImg;
                    }
                } else if (alturaImg >= lbAltura) {
                    proporcaoImg = larguraImg / alturaImg;
                    alturaImg = (double) lbAltura;
                    while (larguraImg > lbLargura) {
                        alturaImg = (double) --lbAltura;
                        larguraImg = alturaImg * proporcaoImg;
                    }
                }
                Image imgRead = escudo.getImage().getScaledInstance(larguraImg.intValue(), alturaImg.intValue(),
                        Image.SCALE_DEFAULT);
                lblEscudo.setIcon(new ImageIcon(imgRead));
                try {
                    byte[] imagem = null;
                    if (lblEscudo.getIcon() != null) {
                        BufferedImage bimg = new BufferedImage(escudo.getIconWidth(), escudo.getIconHeight(),
                                BufferedImage.SCALE_DEFAULT);
                        bimg.createGraphics().drawImage(escudo.getImage(), 0, 0, null);
                        ByteArrayOutputStream buffer = new ByteArrayOutputStream();
                        ImageIO.write(bimg, "jpg", buffer);
                        imagem = buffer.toByteArray();
                        escudoTime = imagem;
                    } else {

                    }
                } catch (IOException | HeadlessException ex) {

                }
            } catch (IOException ex) {
                Logger.getLogger(TelaCadastroTime.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnEscolherActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        TelaTimesSemCamp t = new TelaTimesSemCamp(camp);
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTime.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                //               new TelaCadastroTime().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscolher;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JCheckBox chkCabecaDeChave;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel lblEscudo;
    private javax.swing.JLabel lblNumTimes;
    private javax.swing.JLabel lblTimesCriados;
    private javax.swing.JTextField txtCidade;
    private javax.swing.JTextField txtDirigente;
    private javax.swing.JTextField txtNome;
    // End of variables declaration//GEN-END:variables
}
