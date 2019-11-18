/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.cefetrj.mg.bsi.sisbiblio.view;

import static br.cefetrj.mg.bsi.sisbiblio.config.Settings.*;
import br.cefetrj.mg.bsi.sisbiblio.controller.ObraController;
import br.cefetrj.mg.bsi.sisbiblio.model.Obra;
import br.cefetrj.mg.bsi.sisbiblio.rn.ObraRN;
import br.cefetrj.mg.bsi.sisbiblio.tablemodel.AutorTableModel;
import br.cefetrj.mg.bsi.utils.Utils;
import static br.cefetrj.mg.bsi.utils.Utils.*;
import java.awt.Event;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author cristian
 */
public class Dashboard extends javax.swing.JFrame {

    /**
     * Creates new form Dashboard
     */
    private final ObraController obraCtl, AutorCtl = null;
    private ObraRN obraRN=null;
    public Dashboard() {
        initComponents();
        lblId.setVisible(false);
        restoreView();
        obraCtl = new ObraController(this);
        obraRN=new ObraRN();
        //autorCtl=new AutorController(this);
        rdbObra.setSelected(true);
        rdbObraActionPerformed(null);
        autocomplete();
        
        

    }

    public void limpar(){
        if(pnlObra.isVisible()){
            txtISBN.setText("");
            txtTitulo.setText("");
            if(tableAutor.getModel() instanceof DefaultTableModel){
                ((DefaultTableModel)tableAutor.getModel()).setNumRows(0);
            }else if(tableAutor.getModel() instanceof AutorTableModel)
                ((AutorTableModel)tableAutor.getModel()).clear();
            btnCadastrarAtualizar.setText("Cadastrar");
            btnExcluir.setVisible(false);
            rdbObraActionPerformed(null);
            showFormObra();
            
        }
    }
    /*
    *  
     */
    public void showIndex(){
        
        pnlForm.setVisible(false);
        pnlRelatorio.setVisible(false);
        pnlTable.setVisible(true);
    }
            
    public void showFormObra() {
        pnlTable.setVisible(false);
        pnlRelatorio.setVisible(false);
        pnlForm.setVisible(true);
        pnlObra.setVisible(true);
        pnlButton.setVisible(true);
        
//        pnlObra.setVisible(!pnlObra.isVisible());
//        if(pnlObra.isVisible()){
//            pnlRelatorio.setVisible(false);
//            pnlTable.setVisible(false);
//            pnlForm.setVisible(true);
//            pnlButton.setVisible(true);
//            if(btnCadastrarAtualizar.getText().equalsIgnoreCase("cadastrar")){
//                btnExcluir.setVisible(false);
//            }
//            else{
//                btnExcluir.setVisible(true);
//            }
//        }else{
//            pnlRelatorio.setVisible(!false);
//            pnlTable.setVisible(!false);
//            pnlForm.setVisible(!true);
//            pnlButton.setVisible(!true);
//        }
//        
    }

    public void showFormAutor() {

    }

    public void showRelatorio() {
        pnlRelatorio.setVisible(!pnlRelatorio.isVisible());
        if (pnlRelatorio.isVisible()) {
            pnlTable.setVisible(false);
            pnlForm.setVisible(false);
            pnlButton.setVisible(false);
        } else {
            pnlTable.setVisible(true);
            pnlForm.setVisible(true);
            pnlButton.setVisible(false);
        }

    }

    public void autocomplete() {
        
        List<String> msg=new ArrayList<>();
        msg.add("facebook");
        msg.add("Google");
        msg.add("youtube");
        JList<String> list=new JList<>(msg.toArray(new String[0]));
        msg.forEach((s) -> {
            cboAutor.addItem(s);
        });
        AutoCompleteDecorator.decorate(cboAutor);
    }

    public void restoreView() {
        pnlTable.setVisible(true);
        pnlForm.setVisible(false);
        pnlObra.setVisible(false);
        pnlButton.setVisible(false);
        pnlRelatorio.setVisible(false);
    }

    public JButton getBtnCadastrarAtualizar() {
        return btnCadastrarAtualizar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JTextField getTxtISBN() {
        return txtISBN;
    }

    public JTextField getTxtPesquisa() {
        return txtPesquisa;
    }

    public JTextField getTxtTitulo() {
        return txtTitulo;
    }

    public JTable getTable() {
        return table;
    }

    public JLabel getLblId() {
        return lblId;
    }

    public JXTable getTableAutor() {
        return tableAutor;
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDBCLoginService1 = new org.jdesktop.swingx.auth.JDBCLoginService();
        buttonGroup1 = new javax.swing.ButtonGroup();
        pnlMenu = new javax.swing.JPanel();
        pnlMenuAutor = new javax.swing.JPanel();
        lblMenuAutor = new javax.swing.JLabel();
        pnlMenuObra = new javax.swing.JPanel();
        lblMenuObra = new javax.swing.JLabel();
        pnlMenuRelatorio = new javax.swing.JPanel();
        lblMenuRelatorio = new javax.swing.JLabel();
        pnlMenuInicio = new javax.swing.JPanel();
        lblMenuInicio = new javax.swing.JLabel();
        pnlHead = new javax.swing.JPanel();
        lblHead = new javax.swing.JLabel();
        pnlBody = new javax.swing.JPanel();
        pnlTable = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtPesquisa = new org.jdesktop.swingx.JXSearchField();
        rdbAutor = new javax.swing.JRadioButton();
        rdbObra = new javax.swing.JRadioButton();
        pnlForm = new javax.swing.JPanel();
        pnlObra = new javax.swing.JPanel();
        lblId = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtISBN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAutor = new org.jdesktop.swingx.JXTable();
        cboAutor = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        btnAdicionarAutor = new javax.swing.JButton();
        pnlButton = new javax.swing.JPanel();
        btnCadastrarAtualizar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        pnlRelatorio = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        btnGerarRelAutoresPorObras = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SisBiblio-Dashboard");
        setBackground(new java.awt.Color(255, 255, 255));
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenu.setBackground(new java.awt.Color(0, 102, 255));
        pnlMenu.setForeground(new java.awt.Color(255, 255, 255));
        pnlMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlMenuAutor.setBackground(new java.awt.Color(51, 153, 255));
        pnlMenuAutor.setToolTipText("");
        pnlMenuAutor.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenuAutor.setBackground(new java.awt.Color(102, 204, 255));
        lblMenuAutor.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblMenuAutor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/cefetrj/mg/bsi/sisbiblio/icon/twotone_person_add_black_24dp.png"))); // NOI18N
        lblMenuAutor.setText("Autor");
        lblMenuAutor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuAutorMouseClicked(evt);
            }
        });
        pnlMenuAutor.add(lblMenuAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 60));

        pnlMenu.add(pnlMenuAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 180, 60));

        pnlMenuObra.setBackground(new java.awt.Color(51, 153, 255));
        pnlMenuObra.setToolTipText("");
        pnlMenuObra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenuObra.setBackground(new java.awt.Color(0, 102, 255));
        lblMenuObra.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblMenuObra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/cefetrj/mg/bsi/sisbiblio/icon/twotone_book_black_24dp.png"))); // NOI18N
        lblMenuObra.setText("Obras");
        lblMenuObra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuObraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMenuObraMouseEntered(evt);
            }
        });
        pnlMenuObra.add(lblMenuObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 60));

        pnlMenu.add(pnlMenuObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 180, 60));

        pnlMenuRelatorio.setBackground(new java.awt.Color(51, 153, 255));
        pnlMenuRelatorio.setToolTipText("");
        pnlMenuRelatorio.setMaximumSize(new java.awt.Dimension(100, 50));
        pnlMenuRelatorio.setMinimumSize(new java.awt.Dimension(100, 50));
        pnlMenuRelatorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenuRelatorio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblMenuRelatorio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/cefetrj/mg/bsi/sisbiblio/icon/relatorio.png"))); // NOI18N
        lblMenuRelatorio.setText("Relatórios");
        lblMenuRelatorio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuRelatorioMouseClicked(evt);
            }
        });
        pnlMenuRelatorio.add(lblMenuRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 60));

        pnlMenu.add(pnlMenuRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, 180, 60));

        pnlMenuInicio.setBackground(new java.awt.Color(51, 153, 255));
        pnlMenuInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblMenuInicio.setBackground(new java.awt.Color(0, 102, 255));
        lblMenuInicio.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        lblMenuInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/cefetrj/mg/bsi/sisbiblio/icon/baseline_home_black_18dp.png"))); // NOI18N
        lblMenuInicio.setText("Inicio");
        lblMenuInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMenuInicioMouseClicked(evt);
            }
        });
        pnlMenuInicio.add(lblMenuInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 180, 60));

        pnlMenu.add(pnlMenuInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 180, -1));

        getContentPane().add(pnlMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 200, 600));

        pnlHead.setBackground(new java.awt.Color(204, 204, 204));
        pnlHead.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblHead.setBackground(new java.awt.Color(51, 51, 51));
        lblHead.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/cefetrj/mg/bsi/sisbiblio/icon/twotone_close_black_18dp.png"))); // NOI18N
        lblHead.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblHeadMouseClicked(evt);
            }
        });
        pnlHead.add(lblHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 0, 40, 50));

        getContentPane().add(pnlHead, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 600, 50));

        pnlBody.setBackground(new java.awt.Color(255, 255, 255));
        pnlBody.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlTable.setBackground(new java.awt.Color(255, 255, 255));
        pnlTable.setForeground(new java.awt.Color(204, 204, 204));
        pnlTable.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        table.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        pnlTable.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 580, 320));

        txtPesquisa.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        txtPesquisa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtPesquisaActionPerformed(evt);
            }
        });
        txtPesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesquisaKeyReleased(evt);
            }
        });
        pnlTable.add(txtPesquisa, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 570, 40));

        rdbAutor.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbAutor);
        rdbAutor.setText("Autor");
        rdbAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbAutorActionPerformed(evt);
            }
        });
        pnlTable.add(rdbAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(484, 100, 90, -1));

        rdbObra.setBackground(new java.awt.Color(255, 255, 255));
        buttonGroup1.add(rdbObra);
        rdbObra.setText("Obra");
        rdbObra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdbObraActionPerformed(evt);
            }
        });
        pnlTable.add(rdbObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 100, 80, -1));

        pnlBody.add(pnlTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, -1));

        pnlForm.setBackground(new java.awt.Color(255, 255, 255));
        pnlForm.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pnlObra.setBackground(new java.awt.Color(255, 255, 255));
        pnlObra.setForeground(new java.awt.Color(204, 204, 204));
        pnlObra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblId.setText("jLabel8");
        pnlObra.add(lblId, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 10, -1, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel5.setText("Título");
        pnlObra.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 0, 140, 30));

        txtTitulo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlObra.add(txtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 560, 40));

        txtISBN.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        pnlObra.add(txtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 560, 40));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel6.setText("ISBN");
        pnlObra.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, 140, 30));

        tableAutor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane2.setViewportView(tableAutor);

        pnlObra.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 560, 110));

        cboAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        pnlObra.add(cboAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 560, 40));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Autores");
        pnlObra.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 182, 80, 30));

        btnAdicionarAutor.setBackground(new java.awt.Color(255, 255, 255));
        btnAdicionarAutor.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        btnAdicionarAutor.setText("Adicionar");
        btnAdicionarAutor.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnAdicionarAutor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdicionarAutorActionPerformed(evt);
            }
        });
        pnlObra.add(btnAdicionarAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(474, 260, 110, 40));

        pnlForm.add(pnlObra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 450));

        pnlButton.setBackground(new java.awt.Color(255, 255, 255));
        pnlButton.setForeground(new java.awt.Color(204, 204, 204));
        pnlButton.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnCadastrarAtualizar.setBackground(new java.awt.Color(255, 255, 255));
        btnCadastrarAtualizar.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnCadastrarAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/cefetrj/mg/bsi/sisbiblio/icon/baseline_add_black_18dp.png"))); // NOI18N
        btnCadastrarAtualizar.setText("Cadastrar");
        btnCadastrarAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarAtualizarActionPerformed(evt);
            }
        });
        pnlButton.add(btnCadastrarAtualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 260, 50));

        btnExcluir.setBackground(new java.awt.Color(255, 255, 255));
        btnExcluir.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/cefetrj/mg/bsi/sisbiblio/icon/baseline_delete_black_18dp.png"))); // NOI18N
        btnExcluir.setText("Excluir");
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });
        pnlButton.add(btnExcluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 20, 250, 50));

        pnlForm.add(pnlButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, 580, 100));

        pnlBody.add(pnlForm, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 550));

        pnlRelatorio.setBackground(new java.awt.Color(255, 255, 255));
        pnlRelatorio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("(Em Breve)");
        pnlRelatorio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 90, 20));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setText("Obras por autores");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton1.setEnabled(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        pnlRelatorio.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 580, 60));

        btnGerarRelAutoresPorObras.setBackground(new java.awt.Color(255, 255, 255));
        btnGerarRelAutoresPorObras.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        btnGerarRelAutoresPorObras.setText("Autores por obra");
        btnGerarRelAutoresPorObras.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnGerarRelAutoresPorObras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGerarRelAutoresPorObrasActionPerformed(evt);
            }
        });
        pnlRelatorio.add(btnGerarRelAutoresPorObras, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, 580, 50));

        pnlBody.add(pnlRelatorio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 450));

        getContentPane().add(pnlBody, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 600, 550));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lblHeadMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblHeadMouseClicked
        // TODO add your handling code here:
        if (confirm("Deseja sair?", TITLE) == 0) {
            System.exit(0);
        }

    }//GEN-LAST:event_lblHeadMouseClicked

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        boolean response=false;
        if (confirm(MSG_DELETE, TITLE) == 0) {
            response=obraCtl.excluir(Integer.parseInt(lblId.getText()));
            Utils.print(MSG, TITLE, response);
            if(response)
                limpar();
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnCadastrarAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarAtualizarActionPerformed
        // TODO add your handling code here:
        boolean response = false;
        if (pnlObra.isVisible()) {
            ArrayList<String> erros=obraRN.validarForm(this);
            if(erros.isEmpty())
                if(btnCadastrarAtualizar.getText().equalsIgnoreCase("cadastrar"))
                    response = obraCtl.inserir();
                else 
                    response=obraCtl.atualizar();
            else{
                MSG="";
                for(String s:erros){
                    MSG+=s+"\n";
                }
                //Utils.print(MSG, TITLE, false);
                 
            }
        }
        /*else if(pnlAutor.isVisible())
            response = obraCtl.inserir();*/
        
        Utils.print(MSG, TITLE, response);
        if(response)
            limpar();
        

    }//GEN-LAST:event_btnCadastrarAtualizarActionPerformed

    private void txtPesquisaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtPesquisaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtPesquisaActionPerformed

    private void rdbObraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbObraActionPerformed
        // TODO add your handling code here:
        txtPesquisa.setPrompt("Informe o titulo ou isbn da obra...");
        txtPesquisa.setPromptFontStyle(Font.ITALIC);
        obraCtl.renderizar(table,new Obra());
    }//GEN-LAST:event_rdbObraActionPerformed

    private void rdbAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdbAutorActionPerformed
        // TODO add your handling code here:
        txtPesquisa.setPrompt("Informe o nome ou email do autor...");
        txtPesquisa.setPromptFontStyle(Font.ITALIC);
    }//GEN-LAST:event_rdbAutorActionPerformed

    private void lblMenuAutorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuAutorMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_lblMenuAutorMouseClicked

    private void lblMenuObraMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuObraMouseClicked
        // TODO add your handling code here:
        showFormObra();
    }//GEN-LAST:event_lblMenuObraMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void lblMenuRelatorioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuRelatorioMouseClicked
        // TODO add your handling code here:
        showRelatorio();
    }//GEN-LAST:event_lblMenuRelatorioMouseClicked

    private void lblMenuObraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuObraMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_lblMenuObraMouseEntered

    private void btnGerarRelAutoresPorObrasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGerarRelAutoresPorObrasActionPerformed
        // TODO add your handling code here:
        obraCtl.gerarRelatorioAutoresPorObras();
    }//GEN-LAST:event_btnGerarRelAutoresPorObrasActionPerformed

    private void txtPesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesquisaKeyReleased
        // TODO add your handling code here:
        if(rdbObra.isSelected())
            obraCtl.findByISBNOrTitulo(txtPesquisa.getText(),txtPesquisa.getText());
    }//GEN-LAST:event_txtPesquisaKeyReleased

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount() ==2){
            int id=(int)table.getValueAt(table.getSelectedRow(), 0);
            if(!obraCtl.buscar(id)){
                Utils.print("Por favor, selecione uma linha válida!",TITLE,false);
            }
        }
    }//GEN-LAST:event_tableMouseClicked

    private void tableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tableKeyPressed
        // TODO add your handling code here:
        boolean response=false;
        if(evt.getKeyCode() ==  Event.DELETE){
            if(confirm(MSG_DELETE,TITLE) == 0){
                if(rdbObra.isSelected()){
                    int id=(int)table.getValueAt(table.getSelectedRow(),0);
                    response=obraCtl.excluir(id);
                        
                    
                }
                Utils.print(MSG, TITLE, response);
                obraCtl.renderizar(table,new Obra());
            }
        }
            
    }//GEN-LAST:event_tableKeyPressed

    private void btnAdicionarAutorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdicionarAutorActionPerformed
        // TODO add your handling code here:
        Utils.print(cboAutor.getSelectedItem().toString());
    }//GEN-LAST:event_btnAdicionarAutorActionPerformed

    private void lblMenuInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMenuInicioMouseClicked
        // TODO add your handling code here:
        showIndex();
    }//GEN-LAST:event_lblMenuInicioMouseClicked

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
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionarAutor;
    private javax.swing.JButton btnCadastrarAtualizar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnGerarRelAutoresPorObras;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cboAutor;
    private javax.swing.JButton jButton1;
    private org.jdesktop.swingx.auth.JDBCLoginService jDBCLoginService1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHead;
    private javax.swing.JLabel lblId;
    private javax.swing.JLabel lblMenuAutor;
    private javax.swing.JLabel lblMenuInicio;
    private javax.swing.JLabel lblMenuObra;
    private javax.swing.JLabel lblMenuRelatorio;
    private javax.swing.JPanel pnlBody;
    private javax.swing.JPanel pnlButton;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnlHead;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlMenuAutor;
    private javax.swing.JPanel pnlMenuInicio;
    private javax.swing.JPanel pnlMenuObra;
    private javax.swing.JPanel pnlMenuRelatorio;
    private javax.swing.JPanel pnlObra;
    private javax.swing.JPanel pnlRelatorio;
    private javax.swing.JPanel pnlTable;
    private javax.swing.JRadioButton rdbAutor;
    private javax.swing.JRadioButton rdbObra;
    private javax.swing.JTable table;
    private org.jdesktop.swingx.JXTable tableAutor;
    private javax.swing.JTextField txtISBN;
    private org.jdesktop.swingx.JXSearchField txtPesquisa;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
