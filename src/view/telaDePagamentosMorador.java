/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.Apartamento;
import model.Cadastro;
import model.Pagamento;

/**
 *
 * @author tengen
 */
public class telaDePagamentosMorador extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(telaDePagamentosMorador.class.getName());
    private static final String FICHEIRO = "Mensalidades.TxT";
    Vector x = new Vector();
    private Cadastro morador;
    private String idApartamento = "";

    /**
     * Creates new form telaDePagamentosMorador
     */
    public telaDePagamentosMorador() {
        initComponents();
        exibir_dados();
    }
    double valorMensalidade = 0;

    public void guardar_pagamentos(Vector y) throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FICHEIRO))) {

            for (int i = 0; i < y.size(); i++) {
                Pagamento p = (Pagamento) y.get(i);
                bw.write(p.getReferencia());
                bw.newLine();
                bw.write(p.getMetodoPagamento());
                bw.newLine();
                bw.write(p.getMoradorId());
                bw.newLine();
                bw.write(p.getValor() + "");
                bw.newLine();
                bw.write(p.getApartametoId());
                bw.newLine();
                bw.write("-----------------------------------");
                bw.newLine();

            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Vector ler_pagamentos() {
        Vector y = new Vector();
        File file = new File(FICHEIRO);
        if (!file.exists()) {
            return y;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String pagamentoID;
            while ((pagamentoID = br.readLine()) != null) {
                Pagamento pagamento = new Pagamento();
                pagamento.setReferencia(pagamentoID);
                pagamento.setMetodoPagamento(br.readLine());
                pagamento.setMoradorId(br.readLine());
                pagamento.setValor(Double.parseDouble(br.readLine()));
                pagamento.setApartametoId(br.readLine());
                br.readLine();
                y.add(pagamento);
            }
        } catch (Exception e) {
        }
        return y;
    }

    public telaDePagamentosMorador(Cadastro morador) {
        this.morador = morador;
        this.idApartamento = morador.getApartamento().trim();
        initComponents();
        exibir_dados();
    }

    public void exibir_dados() {

        try {
            Vector listarMensalidade = PainelCadastrarApartamentos.ler_texto();
            Apartamento a;

            for (int i = 0; i < listarMensalidade.size(); i++) {
                a = (Apartamento) listarMensalidade.get(i);

                if (idApartamento.equals(a.getId()+"")) {
                    valorMensalidade = a.getMesensalidade();
                    lblValor.setText(valorMensalidade + " MZN");
                    lblApartamento.setText(a.getId() + "-Bloco-" + a.getBloco() + "-Andar-" + a.getAndar());
                }

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void pagar() {
        try{
        String metodo = cbxMetodosDePagamento.getSelectedItem() + "";
        if (metodo.trim().isEmpty() || metodo.startsWith("---")) {
            JOptionPane.showMessageDialog(null, "Selecione o metodo de pagamento");
        }

        Pagamento p = new Pagamento();
        Vector pagamentos = ler_pagamentos();

        p.setReferencia("Pag" + System.currentTimeMillis());
        p.setMetodoPagamento(metodo);
        p.setMoradorId(morador.getId() + "");
        p.setValor(valorMensalidade);
        p.setApartametoId(idApartamento);
        pagamentos.add(p);
        
            guardar_pagamentos(pagamentos);
            JOptionPane.showMessageDialog(null, "Confirmar o pagamento de: "  +valorMensalidade +" MZN");
            cbxMetodosDePagamento.setSelectedIndex(0);
            historico_pagamentos();
        
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Falha ao registar o pagamento");
            e.printStackTrace();
        }
        
    }

    public void historico_pagamentos() {
        DefaultTableModel model = (DefaultTableModel) tblHistoricoDePagamentos.getModel();
        
        Vector l= ler_pagamentos();
        for(int i=0; i< l.size(); i++){
            Pagamento p =(Pagamento) l.get(i);
            if(idApartamento.equals(p.getApartametoId())){
                model.addRow(new Object[]{
                p.getReferencia(), p.getValor() +" MZN " ,p.getMetodoPagamento(), " Pago"});
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
        tblHistoricoDePagamentos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cbxMetodosDePagamento = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblValor = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        lblApartamento = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Meus Pagamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cantarell", 1, 18))); // NOI18N

        tblHistoricoDePagamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Valor", "Metodo de pagamento", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblHistoricoDePagamentos);

        jLabel1.setFont(new java.awt.Font("Cantarell", 1, 18)); // NOI18N
        jLabel1.setText("Historico de Pagamentos");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pagamentos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Cantarell", 1, 18))); // NOI18N

        jLabel2.setText("Metodos de Pagamento");

        cbxMetodosDePagamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M-pesa", "Emola", "BCI", "BIM", " " }));
        cbxMetodosDePagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxMetodosDePagamentoActionPerformed(evt);
            }
        });

        jLabel3.setText("Mensalidade");

        lblValor.setText(" ");

        jLabel5.setText("Apartamento");

        lblApartamento.setText(" ");

        jButton3.setBackground(java.awt.Color.blue);
        jButton3.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 255, 51));
        jButton3.setText("Pagar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbxMetodosDePagamento, 0, 123, Short.MAX_VALUE)
                            .addComponent(lblValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblApartamento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 104, Short.MAX_VALUE))
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cbxMetodosDePagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(lblValor))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(lblApartamento))
                .addGap(49, 49, 49)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(286, Short.MAX_VALUE))
        );

        jButton2.setBackground(java.awt.Color.blue);
        jButton2.setFont(new java.awt.Font("Cantarell", 1, 15)); // NOI18N
        jButton2.setForeground(java.awt.Color.green);
        jButton2.setText("Voltar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(java.awt.Color.blue);
        jButton1.setForeground(java.awt.Color.green);
        jButton1.setText("Ver Historico");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(136, 136, 136)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(666, 666, 666))
                            .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cbxMetodosDePagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxMetodosDePagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxMetodosDePagamentoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        PainelVisaoMorador visao = (morador != null)
                ? new PainelVisaoMorador(morador)
                : new PainelVisaoMorador();
        visao.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
pagar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
historico_pagamentos();        // TODO add your handling code here:
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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new telaDePagamentosMorador().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxMetodosDePagamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblApartamento;
    private javax.swing.JLabel lblValor;
    private javax.swing.JTable tblHistoricoDePagamentos;
    // End of variables declaration//GEN-END:variables
}
