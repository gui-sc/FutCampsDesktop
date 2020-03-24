package model.view;

import java.awt.Image;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import javax.swing.ImageIcon;
import model.bean.Campeonato;
import model.bean.Partida;
import model.dao.PartidaDAO;

/**
 *
 * @author Cliente
 */
public class TelaOitavas extends javax.swing.JFrame {

    Campeonato camp;

    public TelaOitavas(Campeonato camp) {
        initComponents();
        this.camp = camp;
        PartidaDAO partidaDAO = new PartidaDAO();
        List<Partida> partidas = partidaDAO.listarFase(camp, "oitavas");
        byte[] escudo = partidas.get(0).getMandante().getEscudo();
        InputStream is = new ByteArrayInputStream(escudo);
        Image image = new ImageIcon(escudo).getImage();
        ImageIcon icon = new ImageIcon(image);
        lblEscudoTime1.setIcon(icon);
        lblNomeTime1.setText(partidas.get(0).getMandante().getNome());
        escudo = partidas.get(0).getVisitante().getEscudo();
        is = new ByteArrayInputStream(escudo);
        image = new ImageIcon(escudo).getImage();
        icon = new ImageIcon(image);
        lblEscudoTime2.setIcon(icon);
        lblNomeTime2.setText(partidas.get(0).getVisitante().getNome());
        escudo = partidas.get(1).getMandante().getEscudo();
        is = new ByteArrayInputStream(escudo);
        image = new ImageIcon(escudo).getImage();
        icon = new ImageIcon(image);
        lblEscudoTime3.setIcon(icon);
        lblNomeTime3.setText(partidas.get(1).getMandante().getNome());
        escudo = partidas.get(1).getVisitante().getEscudo();
        is = new ByteArrayInputStream(escudo);
        image = new ImageIcon(escudo).getImage();
        icon = new ImageIcon(image);
        lblEscudoTime4.setIcon(icon);
        lblNomeTime4.setText(partidas.get(1).getVisitante().getNome());
        escudo = partidas.get(2).getMandante().getEscudo();
        is = new ByteArrayInputStream(escudo);
        image = new ImageIcon(escudo).getImage();
        icon = new ImageIcon(image);
        lblEscudoTime5.setIcon(icon);
        lblNomeTime5.setText(partidas.get(2).getMandante().getNome());
        escudo = partidas.get(2).getVisitante().getEscudo();
        is = new ByteArrayInputStream(escudo);
        image = new ImageIcon(escudo).getImage();
        icon = new ImageIcon(image);
        lblEscudoTime6.setIcon(icon);
        lblNomeTime6.setText(partidas.get(2).getVisitante().getNome());
        escudo = partidas.get(3).getMandante().getEscudo();
        is = new ByteArrayInputStream(escudo);
        image = new ImageIcon(escudo).getImage();
        icon = new ImageIcon(image);
        lblEscudoTime7.setIcon(icon);
        lblNomeTime7.setText(partidas.get(3).getMandante().getNome());
        escudo = partidas.get(3).getVisitante().getEscudo();
        is = new ByteArrayInputStream(escudo);
        image = new ImageIcon(escudo).getImage();
        icon = new ImageIcon(image);
        lblEscudoTime8.setIcon(icon);
        lblNomeTime8.setText(partidas.get(3).getVisitante().getNome());
        if (partidas.get(0).isCadastrada()) {
            lblGolsTime1.setText(String.valueOf(partidas.get(0).getPlacarMandante()));
            lblGolsTime2.setText(String.valueOf(partidas.get(0).getPlacarVisitante()));
            if(partidas.get(0).getPenaltisMandante() == 0 && partidas.get(0).getPenaltisVisitante() == 0){
                lblPenalti1.setVisible(false);
                lblPenalti2.setVisible(false);
                
            }else{
                lblPenalti1.setText(String.valueOf(partidas.get(0).getPenaltisMandante()));
                lblPenalti2.setText(String.valueOf(partidas.get(0).getPenaltisVisitante()));
            }
        }
        if (partidas.get(1).isCadastrada()) {
            lblGolsTime3.setText(String.valueOf(partidas.get(1).getPlacarMandante()));
            lblGolsTime4.setText(String.valueOf(partidas.get(1).getPlacarVisitante()));
            if(partidas.get(1).getPenaltisMandante() == 0 && partidas.get(1).getPenaltisVisitante() == 0){
                lblPenalti3.setVisible(false);
                lblPenalti4.setVisible(false);
                
            }else{
                lblPenalti3.setText(String.valueOf(partidas.get(1).getPenaltisMandante()));
                lblPenalti4.setText(String.valueOf(partidas.get(1).getPenaltisVisitante()));
            }
        }
        if (partidas.get(2).isCadastrada()) {
            lblGolsTime5.setText(String.valueOf(partidas.get(2).getPlacarMandante()));
            lblGolsTime6.setText(String.valueOf(partidas.get(2).getPlacarVisitante()));
            if(partidas.get(2).getPenaltisMandante() == 0 && partidas.get(2).getPenaltisVisitante() == 0){
                lblPenalti5.setVisible(false);
                lblPenalti6.setVisible(false);
                
            }else{
                lblPenalti5.setText(String.valueOf(partidas.get(2).getPenaltisMandante()));
                lblPenalti6.setText(String.valueOf(partidas.get(2).getPenaltisVisitante()));
            }
        }
        if (partidas.get(3).isCadastrada()) {
            lblGolsTime7.setText(String.valueOf(partidas.get(3).getPlacarMandante()));
            lblGolsTime8.setText(String.valueOf(partidas.get(3).getPlacarVisitante()));
            if(partidas.get(3).getPenaltisMandante() == 0 && partidas.get(3).getPenaltisVisitante() == 0){
                lblPenalti7.setVisible(false);
                lblPenalti8.setVisible(false);
                
            }else{
                lblPenalti7.setText(String.valueOf(partidas.get(3).getPenaltisMandante()));
                lblPenalti8.setText(String.valueOf(partidas.get(3).getPenaltisVisitante()));
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
        btnCancelar = new javax.swing.JButton();
        btnJogos = new javax.swing.JButton();
        btnArtilheiros = new javax.swing.JButton();
        btnSuspensos = new javax.swing.JButton();
        btnPendurados = new javax.swing.JButton();
        lblEscudoTime2 = new javax.swing.JLabel();
        lblEscudoTime5 = new javax.swing.JLabel();
        lblEscudoTime7 = new javax.swing.JLabel();
        lblEscudoTime4 = new javax.swing.JLabel();
        lblEscudoTime6 = new javax.swing.JLabel();
        lblEscudoTime8 = new javax.swing.JLabel();
        lblNomeTime8 = new javax.swing.JLabel();
        lblNomeTime2 = new javax.swing.JLabel();
        lblNomeTime6 = new javax.swing.JLabel();
        lblGolsTime2 = new javax.swing.JLabel();
        lblPenalti2 = new javax.swing.JLabel();
        lblNomeTime4 = new javax.swing.JLabel();
        lblEscudoTime1 = new javax.swing.JLabel();
        lblPenalti1 = new javax.swing.JLabel();
        lblEscudoTime3 = new javax.swing.JLabel();
        lblNomeTime1 = new javax.swing.JLabel();
        lblNomeTime3 = new javax.swing.JLabel();
        lblNomeTime5 = new javax.swing.JLabel();
        lblNomeTime7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblGolsTime1 = new javax.swing.JLabel();
        lblGolsTime3 = new javax.swing.JLabel();
        lblPenalti3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lblPenalti4 = new javax.swing.JLabel();
        lblGolsTime4 = new javax.swing.JLabel();
        lblGolsTime5 = new javax.swing.JLabel();
        lblPenalti5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblPenalti6 = new javax.swing.JLabel();
        lblGolsTime6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblGolsTime7 = new javax.swing.JLabel();
        lblPenalti7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lblPenalti8 = new javax.swing.JLabel();
        lblGolsTime8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Oitavas de Final");
        setMinimumSize(new java.awt.Dimension(500, 500));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(126, 217, 87));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCancelar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnCancelar.setText("Voltar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 600, 70, -1));

        btnJogos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnJogos.setText("Jogos");
        btnJogos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnJogos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJogosActionPerformed(evt);
            }
        });
        jPanel1.add(btnJogos, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 600, -1, -1));

        btnArtilheiros.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnArtilheiros.setText("Artilheiros");
        btnArtilheiros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnArtilheiros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArtilheirosActionPerformed(evt);
            }
        });
        jPanel1.add(btnArtilheiros, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 600, -1, -1));

        btnSuspensos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnSuspensos.setText("Suspensos");
        btnSuspensos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnSuspensos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuspensosActionPerformed(evt);
            }
        });
        jPanel1.add(btnSuspensos, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 600, -1, -1));

        btnPendurados.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        btnPendurados.setText("Pendurados");
        btnPendurados.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnPendurados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPenduradosActionPerformed(evt);
            }
        });
        jPanel1.add(btnPendurados, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 600, -1, -1));

        lblEscudoTime2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEscudoTime2.setForeground(new java.awt.Color(255, 255, 255));
        lblEscudoTime2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudoTime2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblEscudoTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 50, 100, 100));

        lblEscudoTime5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEscudoTime5.setForeground(new java.awt.Color(255, 255, 255));
        lblEscudoTime5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudoTime5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblEscudoTime5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 320, 100, 100));

        lblEscudoTime7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEscudoTime7.setForeground(new java.awt.Color(255, 255, 255));
        lblEscudoTime7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudoTime7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblEscudoTime7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 460, 100, 100));

        lblEscudoTime4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEscudoTime4.setForeground(new java.awt.Color(255, 255, 255));
        lblEscudoTime4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudoTime4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblEscudoTime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 190, 100, 100));

        lblEscudoTime6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEscudoTime6.setForeground(new java.awt.Color(255, 255, 255));
        lblEscudoTime6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudoTime6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblEscudoTime6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 320, 100, 100));

        lblEscudoTime8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEscudoTime8.setForeground(new java.awt.Color(255, 255, 255));
        lblEscudoTime8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudoTime8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblEscudoTime8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 460, 100, 100));

        lblNomeTime8.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeTime8.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeTime8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTime8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblNomeTime8, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 560, 100, 10));

        lblNomeTime2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeTime2.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeTime2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTime2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblNomeTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 100, 10));

        lblNomeTime6.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeTime6.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeTime6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTime6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblNomeTime6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 420, 100, 10));

        lblGolsTime2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGolsTime2.setForeground(new java.awt.Color(255, 255, 255));
        lblGolsTime2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGolsTime2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblGolsTime2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 80, 40, 40));

        lblPenalti2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti2.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblPenalti2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, 18, 20));

        lblNomeTime4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeTime4.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeTime4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTime4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblNomeTime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 290, 100, 10));

        lblEscudoTime1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEscudoTime1.setForeground(new java.awt.Color(255, 255, 255));
        lblEscudoTime1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudoTime1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblEscudoTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 100, 100));

        lblPenalti1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti1.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblPenalti1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 18, 20));

        lblEscudoTime3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblEscudoTime3.setForeground(new java.awt.Color(255, 255, 255));
        lblEscudoTime3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEscudoTime3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblEscudoTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 100, 100));

        lblNomeTime1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeTime1.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeTime1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTime1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblNomeTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 100, 10));

        lblNomeTime3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeTime3.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeTime3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTime3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblNomeTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 100, 10));

        lblNomeTime5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeTime5.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeTime5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTime5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblNomeTime5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 420, 100, 10));

        lblNomeTime7.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lblNomeTime7.setForeground(new java.awt.Color(255, 255, 255));
        lblNomeTime7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNomeTime7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblNomeTime7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 560, 100, 10));

        jLabel6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("X");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 80, 40, 50));

        lblGolsTime1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGolsTime1.setForeground(new java.awt.Color(255, 255, 255));
        lblGolsTime1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGolsTime1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblGolsTime1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 80, 40, 40));

        lblGolsTime3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGolsTime3.setForeground(new java.awt.Color(255, 255, 255));
        lblGolsTime3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGolsTime3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblGolsTime3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 40, 40));

        lblPenalti3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti3.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblPenalti3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 18, 20));

        jLabel7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("X");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, 40, 50));

        lblPenalti4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti4.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblPenalti4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, 18, 20));

        lblGolsTime4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGolsTime4.setForeground(new java.awt.Color(255, 255, 255));
        lblGolsTime4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGolsTime4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblGolsTime4, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 210, 40, 40));

        lblGolsTime5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGolsTime5.setForeground(new java.awt.Color(255, 255, 255));
        lblGolsTime5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGolsTime5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblGolsTime5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 40, 40));

        lblPenalti5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti5.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblPenalti5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 380, 18, 20));

        jLabel8.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("X");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, 40, 50));

        lblPenalti6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti6.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblPenalti6, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 380, 18, 20));

        lblGolsTime6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGolsTime6.setForeground(new java.awt.Color(255, 255, 255));
        lblGolsTime6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGolsTime6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblGolsTime6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 40, 40));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/model/view/7.png"))); // NOI18N
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 0, -1, 480));

        lblGolsTime7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGolsTime7.setForeground(new java.awt.Color(255, 255, 255));
        lblGolsTime7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGolsTime7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblGolsTime7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 480, 40, 40));

        lblPenalti7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti7.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblPenalti7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 510, 18, 20));

        jLabel9.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("X");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 480, 40, 50));

        lblPenalti8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblPenalti8.setForeground(new java.awt.Color(255, 255, 255));
        lblPenalti8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPenalti8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblPenalti8, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 510, 18, 20));

        lblGolsTime8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblGolsTime8.setForeground(new java.awt.Color(255, 255, 255));
        lblGolsTime8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblGolsTime8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 1, true));
        jPanel1.add(lblGolsTime8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 480, 40, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 650));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
        TelaCarregarCamp telaCarregarCamp = new TelaCarregarCamp();
        telaCarregarCamp.setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnJogosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJogosActionPerformed
        TelaJogos t = new TelaJogos(camp);
        t.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnJogosActionPerformed

    private void btnArtilheirosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArtilheirosActionPerformed
        this.dispose();
        TelaArtilheiros telaArtilheiros = new TelaArtilheiros(camp);
        telaArtilheiros.setVisible(true);
    }//GEN-LAST:event_btnArtilheirosActionPerformed

    private void btnSuspensosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuspensosActionPerformed
        this.dispose();
        TelaSuspensos ts = new TelaSuspensos(camp);
        ts.setVisible(true);

    }//GEN-LAST:event_btnSuspensosActionPerformed

    private void btnPenduradosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPenduradosActionPerformed
        TelaPendurados tp = new TelaPendurados(camp);
        tp.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btnPenduradosActionPerformed

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
            java.util.logging.Logger.getLogger(TelaOitavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaOitavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaOitavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaOitavas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //               new TelaOitavas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArtilheiros;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnJogos;
    private javax.swing.JButton btnPendurados;
    private javax.swing.JButton btnSuspensos;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblEscudoTime1;
    private javax.swing.JLabel lblEscudoTime2;
    private javax.swing.JLabel lblEscudoTime3;
    private javax.swing.JLabel lblEscudoTime4;
    private javax.swing.JLabel lblEscudoTime5;
    private javax.swing.JLabel lblEscudoTime6;
    private javax.swing.JLabel lblEscudoTime7;
    private javax.swing.JLabel lblEscudoTime8;
    private javax.swing.JLabel lblGolsTime1;
    private javax.swing.JLabel lblGolsTime2;
    private javax.swing.JLabel lblGolsTime3;
    private javax.swing.JLabel lblGolsTime4;
    private javax.swing.JLabel lblGolsTime5;
    private javax.swing.JLabel lblGolsTime6;
    private javax.swing.JLabel lblGolsTime7;
    private javax.swing.JLabel lblGolsTime8;
    private javax.swing.JLabel lblNomeTime1;
    private javax.swing.JLabel lblNomeTime2;
    private javax.swing.JLabel lblNomeTime3;
    private javax.swing.JLabel lblNomeTime4;
    private javax.swing.JLabel lblNomeTime5;
    private javax.swing.JLabel lblNomeTime6;
    private javax.swing.JLabel lblNomeTime7;
    private javax.swing.JLabel lblNomeTime8;
    private javax.swing.JLabel lblPenalti1;
    private javax.swing.JLabel lblPenalti2;
    private javax.swing.JLabel lblPenalti3;
    private javax.swing.JLabel lblPenalti4;
    private javax.swing.JLabel lblPenalti5;
    private javax.swing.JLabel lblPenalti6;
    private javax.swing.JLabel lblPenalti7;
    private javax.swing.JLabel lblPenalti8;
    // End of variables declaration//GEN-END:variables
}
