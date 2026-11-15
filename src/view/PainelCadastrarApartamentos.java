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
import model.Apartamento;

/**
 *
 * @author yurankali
 */
public class PainelCadastrarApartamentos extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PainelCadastrarApartamentos.class.getName());
    private static final String FICHEIRO = "Apartamentos.TxT";
    Vector x = new Vector();

    /**
     * Creates new form PainelCadastrarApartamentos
     */
    public PainelCadastrarApartamentos() {
        initComponents();
        x = ler_texto();

    }

    public void guadar_texto(Vector y) throws IOException {
        try {
            File file = new File(FICHEIRO);
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            String id, bloco, andar, mensalidade, linha;
            boolean estado;

            Apartamento apartamento1;
            for (int i = 0; i < y.size(); i++) {
                apartamento1 = (Apartamento) y.get(i);
                id = apartamento1.getId() + "";
                bloco = apartamento1.getBloco();
                andar = apartamento1.getAndar() + "";
                mensalidade = apartamento1.getMesensalidade() + "";
                estado = apartamento1.isEstado();
                linha = "--------------------";
                bw.write(id);
                bw.newLine();
                bw.write(bloco);
                bw.newLine();
                bw.write(andar);
                bw.newLine();
                bw.write(mensalidade);
                bw.newLine();
                bw.write(Boolean.toString(estado));
                bw.newLine();
                bw.write(linha);
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static Vector ler_texto() {
        Vector y = new Vector();
        File file = new File(FICHEIRO);
        if (!file.exists()) {
            return y;
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String bloco;
            while ((bloco = br.readLine()) != null) {
                Apartamento apartamento1 = new Apartamento();
                apartamento1.setId(Integer.parseInt(bloco));
                apartamento1.setBloco(br.readLine());
                apartamento1.setAndar(Integer.parseInt(br.readLine()));
                apartamento1.setMesensalidade(Double.parseDouble(br.readLine()));
                apartamento1.setEstado(Boolean.parseBoolean(br.readLine()));
                br.readLine();
                y.add(apartamento1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return y;
    }

    public void cadastrar() {

        int id;
        String bloco = txtBloco.getText();
        int andar = Integer.parseInt(txtAndar.getText());
        double mensalidade = Double.parseDouble(txtMensalidade.getText());
        boolean estado = true;
        try {
            id = Integer.parseInt(txtID.getText());
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "O ID deve conter apenas numeros!");

            return;
        }
        
        Apartamento apartamento1 = new Apartamento();
        apartamento1.setId(id);
        apartamento1.setBloco(bloco);
        apartamento1.setAndar(andar);
        apartamento1.setMesensalidade(mensalidade);
        apartamento1.setEstado(estado);

        x.add(apartamento1);

        try {
            guadar_texto(x);
            JOptionPane.showMessageDialog(null, "Apartamento cadastrado com sucesso!");
            limpar();
        } catch (Exception e) {
            x.remove(apartamento1);
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar!");

            e.printStackTrace();
        }
    }

    public void limpar() {
        txtID.setText("");
        txtBloco.setText("");
        txtAndar.setText("");
        txtMensalidade.setText("");

    }

    public void Procurar() {
        String id = txtID.getText();
        Apartamento apartamento1;
        for (int i = 0; i < x.size(); i++) {
            apartamento1 = (Apartamento) x.get(i);
            if (Integer.parseInt(id) == apartamento1.getId()) {
                txtBloco.setText(apartamento1.getBloco());
                txtAndar.setText(apartamento1.getAndar() + "");
                txtMensalidade.setText(apartamento1.getMesensalidade() + "");

            }

        }

    }

    public void Eliminar() {
        try {
            String id = txtID.getText();
            Apartamento apartamento1;
            for (int i = 0; i < x.size(); i++) {
                apartamento1 = (Apartamento) x.get(i);
                if (Integer.parseInt(id) == apartamento1.getId()) {
                    x.removeElementAt(i);
                    guadar_texto(x);

                    JOptionPane.showMessageDialog(null, "Apartamento eliminado com sucesso!");
                    return;

                }
            }
            JOptionPane.showMessageDialog(null, "Apartamento nao encontrado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro" + e.getMessage());
        }
    }

    public void actualizar() {
        try {
            int id = Integer.parseInt(txtID.getText().trim());
            for (int i = 0; i < x.size(); i++) {
                Apartamento apartamento1 = (Apartamento) x.get(i);
                if (id == apartamento1.getId()) {
                    apartamento1.setBloco(txtBloco.getText());
                    apartamento1.setAndar(Integer.parseInt(txtAndar.getText()));
                    apartamento1.setMesensalidade(Double.parseDouble(txtMensalidade.getText()));
                    guadar_texto(x);
                    JOptionPane.showMessageDialog(null, "Apartamento actualizado com sucesso");
                    return;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao actualizar!");
            e.printStackTrace();
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

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtBloco = new javax.swing.JTextField();
        txtAndar = new javax.swing.JTextField();
        txtMensalidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(java.awt.Color.white);
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Apartamentos", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("sansserif", 1, 14), java.awt.Color.black)); // NOI18N
        jPanel2.setForeground(java.awt.Color.white);

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel1.setForeground(java.awt.Color.black);
        jLabel1.setText("ID");

        jLabel2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel2.setForeground(java.awt.Color.black);
        jLabel2.setText("Bloco");

        jLabel3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel3.setForeground(java.awt.Color.black);
        jLabel3.setText("Andar");

        jLabel5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jLabel5.setForeground(java.awt.Color.black);
        jLabel5.setText("Mensalidade");

        txtID.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        txtBloco.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        txtAndar.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        txtMensalidade.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N

        jButton1.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton1.setText("Cadastrar");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton2.setText("Limpar");
        jButton2.addActionListener(this::jButton2ActionPerformed);

        jButton3.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton3.setText("Procurar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jButton7.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton7.setText("Eliminar");
        jButton7.addActionListener(this::jButton7ActionPerformed);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/condominio.jpg"))); // NOI18N
        jLabel11.setText("jLabel11");

        jButton4.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton4.setText("Voltar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 742, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(231, 231, 231)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtAndar, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel2Layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtBloco, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(221, 221, 221)
                        .addComponent(jButton4)))
                .addContainerGap(291, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(109, 109, 109)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBloco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtAndar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensalidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(91, 91, 91)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addGap(0, 260, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        cadastrar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        limpar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Procurar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        Eliminar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new PainelApartamentos().setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look i feel */
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
        java.awt.EventQueue.invokeLater(() -> new PainelCadastrarApartamentos().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtAndar;
    private javax.swing.JTextField txtBloco;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtMensalidade;
    // End of variables declaration//GEN-END:variables
}
