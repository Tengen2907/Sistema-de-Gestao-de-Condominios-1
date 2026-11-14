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
import java.util.Vector;
import javax.swing.JOptionPane;
import model.Funcionario;

/**
 *
 * @author yurankali
 */
  

    public class PainelCadastroFuncionario extends javax.swing.JFrame {

        private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PainelCadastroFuncionario.class.getName());
    
        /**
         * Creates new form PainelcastroFuncionarios
         */
         private static final String FICHEIRO = "Funcionarios.TxT";
        Vector x = new Vector();

        public PainelCadastroFuncionario() {
            initComponents();
                x = ler_texto();
        }

     

        public void guardar_texto(Vector y) {
            try {
                File file = new File(FICHEIRO);
                FileWriter fw = new FileWriter(file);
                BufferedWriter bw = new BufferedWriter(fw);
                String nome, bi, ano, cargo, salario, senha, id, estado, telef;

                Funcionario funcionario;
                for (int i = 0; i < y.size(); i++) {
                    funcionario = (Funcionario) y.get(i);
                    nome = funcionario.getNomeCompleto();
                    bi = funcionario.getBi();
                    id = funcionario.getId() + "";
                    telef = funcionario.getTelefone();
                    senha = funcionario.getSenha();
                    estado = funcionario.getEstado();
                    ano = funcionario.getDataContratacoa();
                    cargo = funcionario.getCargo();
                    salario = funcionario.getSalario() + "";

                    bw.write(nome);
                    bw.newLine();
                    bw.write(bi);
                    bw.newLine();
                    bw.write(id);
                    bw.newLine();
                    bw.write(telef);
                    bw.newLine();
                    bw.write(senha);
                    bw.newLine();
                    bw.write(estado);
                    bw.newLine();
                    bw.write(ano);
                    bw.newLine();
                    bw.write(cargo);
                    bw.newLine();
                    bw.write(salario);
                    bw.newLine();
                    bw.write("--------------------");
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
                String nome;
                while ((nome = br.readLine()) != null) {
                    Funcionario funcionario = new Funcionario();
                    funcionario.setNomeCompleto(nome);
                    funcionario.setBi(br.readLine());
                    funcionario.setId(Integer.parseInt(br.readLine().trim()));
                    funcionario.setTelefone(br.readLine());
                    funcionario.setSenha(br.readLine());
                    funcionario.setEstado(br.readLine());
                    funcionario.setDataContratacoa(br.readLine());
                    funcionario.setCargo(br.readLine());
                    funcionario.setSalario((int) Double.parseDouble(br.readLine().trim()));
                    br.readLine();
                    y.add(funcionario);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return y;
        }

        private void telefoneValido(String telefone) {
            if (telefone.length() < 9) {
                JOptionPane.showMessageDialog(null, "Numero invalido");
            }

        }

        public void cadastro() {
            
           int salario = Integer.parseInt(txtsalario.getText().trim());
            String nomeComleto = txtNomeCompleto.getText();
            String anodeContratacao = cbxanoDeContratacao.getSelectedItem() + "";
            String bi = txtbi.getText();
            String cargo = cbxCargo.getSelectedItem() + "";
            String estado = txtestado.getText();

            int id;
            try {
                id = Integer.parseInt(txtID.getText().trim());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "O ID deve conter apenas numeros!");
                txtID.requestFocus();
                return;
            }

            String senhaDeAcesso = txtSenhaDeAcesso.getText();
            String confirmarSenhar = txtConfirmarSenha.getText();

            if (!senhaDeAcesso.equals(confirmarSenhar)) {
                JOptionPane.showMessageDialog(null, "As senhas nao coencidem!");
                return;
            }

            String telefone = txtTelefone.getText().trim();
            if (telefone.length()> 9) {
                JOptionPane.showMessageDialog(null, "Numero invalido");
                 return;
            }

            Funcionario funcionario = new Funcionario();
            funcionario.setBi(bi);
            funcionario.setCargo(cargo);
            funcionario.setTelefone(telefone);
            funcionario.setDataContratacoa(anodeContratacao);
            funcionario.setEstado(estado);
            funcionario.setSalario(salario);
            funcionario.setNomeCompleto(nomeComleto);
            funcionario.setSenha(senhaDeAcesso);
            funcionario.setId(id);

            x.add(funcionario);
            try {
                guardar_texto(x);
                JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
                limpar();
            } catch (Exception e) {
                x.remove(funcionario);
                JOptionPane.showMessageDialog(null, "Falha ao cadastrar!");
                e.printStackTrace();
            }

        }

        public void limpar() {
            Funcionario funcionario;
            txtNomeCompleto.setText("");
            txtbi.setText("");
            cbxanoDeContratacao.setSelectedIndex(0);
            txtsalario.setText("");
            cbxCargo.setSelectedIndex(0);
            txtID.setText("");
            txtSenhaDeAcesso.setText("");
            txtConfirmarSenha.setText("");
            txtTelefone.setText("");
            txtestado.setText("");
     

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
        txtTelefone = new javax.swing.JTextField();
        txtestado = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtSenhaDeAcesso = new javax.swing.JTextField();
        txtsalario = new javax.swing.JTextField();
        txtConfirmarSenha = new javax.swing.JTextField();
        txtNomeCompleto = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        cbxanoDeContratacao = new javax.swing.JComboBox<>();
        cbxCargo = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtbi = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        txtTelefone.setBackground(new java.awt.Color(204, 204, 204));

        txtestado.setBackground(new java.awt.Color(204, 204, 204));

        txtID.setBackground(new java.awt.Color(204, 204, 204));

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Salario");

        txtSenhaDeAcesso.setBackground(new java.awt.Color(204, 204, 204));
        txtSenhaDeAcesso.addActionListener(this::txtSenhaDeAcessoActionPerformed);

        txtsalario.setBackground(new java.awt.Color(204, 204, 204));
        txtsalario.addActionListener(this::txtsalarioActionPerformed);

        txtConfirmarSenha.setBackground(new java.awt.Color(204, 204, 204));

        txtNomeCompleto.setBackground(new java.awt.Color(204, 204, 204));
        txtNomeCompleto.addActionListener(this::txtNomeCompletoActionPerformed);

        jButton4.setBackground(new java.awt.Color(0, 102, 204));
        jButton4.setText("Limpar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/view/user-key (1).png"))); // NOI18N
        jLabel9.setText("Foto");

        jButton5.setBackground(new java.awt.Color(0, 102, 204));
        jButton5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Voltar");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        cbxanoDeContratacao.setBackground(new java.awt.Color(0, 102, 204));
        cbxanoDeContratacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028" }));
        cbxanoDeContratacao.addActionListener(this::cbxanoDeContratacaoActionPerformed);

        cbxCargo.setBackground(new java.awt.Color(0, 102, 204));
        cbxCargo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--Categoria--", "-Gestor de Condomínios / Gestor de Conta", "-Supervisor de Condomínio", "-Assistente / Auxiliar Administrativo", "-Contabilista / Técnico de Contabilidade ", "-Técnico de Manutenção / Engenheiro Civil" }));
        cbxCargo.addActionListener(this::cbxCargoActionPerformed);

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1333, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Precha essses campos para manter a sua conta Segura");

        jPanel5.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cadastro de Funcionarios");

        jPanel6.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1333, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton1.setText("Actualizar");

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("ID Usuario:");

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setText("Procurar");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Senha de Acesso:");

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setText("Salvar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Confirmar Senha:");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome Completo:");

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Telefone:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Ano de contratacao");

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Estado:");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("BI:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Cargo:");

        txtbi.setBackground(new java.awt.Color(204, 204, 204));
        txtbi.addActionListener(this::txtbiActionPerformed);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel8)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel4))
                                        .addGap(151, 151, 151)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtbi, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxanoDeContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(24, 24, 24)
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel10))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(21, 21, 21))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(54, 54, 54)))
                            .addComponent(jLabel13))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(txtSenhaDeAcesso)
                            .addComponent(txtConfirmarSenha))
                        .addGap(129, 129, 129)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17)
                            .addComponent(jLabel16))
                        .addGap(74, 74, 74)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTelefone)
                            .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel2)
                                            .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(17, 17, 17)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel3)
                                            .addComponent(cbxanoDeContratacao, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel6)
                                            .addComponent(cbxCargo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(38, 38, 38)
                                        .addComponent(jLabel5)
                                        .addGap(57, 57, 57)))
                                .addGap(51, 51, 51))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtsalario, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtbi, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(34, 34, 34))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(txtestado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenhaDeAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

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
    }// </editor-fold>//GEN-END:initComponents

    private void txtbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbiActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
cadastro();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbxCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCargoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCargoActionPerformed

    private void cbxanoDeContratacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxanoDeContratacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxanoDeContratacaoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
limpar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void txtNomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCompletoActionPerformed

    private void txtsalarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsalarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsalarioActionPerformed

    private void txtSenhaDeAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaDeAcessoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaDeAcessoActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new PainelCadastroFuncionario().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxCargo;
    private javax.swing.JComboBox<String> cbxanoDeContratacao;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JTextField txtConfirmarSenha;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JTextField txtSenhaDeAcesso;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtbi;
    private javax.swing.JTextField txtestado;
    private javax.swing.JTextField txtsalario;
    // End of variables declaration//GEN-END:variables
}
