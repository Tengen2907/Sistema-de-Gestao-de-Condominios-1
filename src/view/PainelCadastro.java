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
import model.Cadastro;

/**
 *
 * @author yurankali
 */
public class PainelCadastro extends javax.swing.JFrame {

    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(PainelCadastro.class.getName());

    /**
     * Creates new form PainelCadastro
     */
    private static final String FICHEIRO = "Moradores.TxT";
    Vector x = new Vector();

    public PainelCadastro() {
        initComponents();
        x = ler_texto();
        adicionar();
    }

    public void guardar_texto(Vector y) throws IOException {

        File file = new File(FICHEIRO);
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        String nome, bi, email, aparta, data, estado, id, senha, telef, naciol, datanaic, nuit, contactoDeEmergen;

        Cadastro cadastro;
        for (int i = 0; i < y.size(); i++) {
            cadastro = (Cadastro) y.get(i);
            nome = cadastro.getNomeCompleto();
            bi = cadastro.getBi();
            email = cadastro.getEmail();
            aparta = cadastro.getApartamento();
            data = cadastro.getDataCadastro();
            datanaic = cadastro.getDataDeNascimento();
            id = cadastro.getId() + "";
            telef = cadastro.getTelefone();
            senha = cadastro.getSenha();
            estado = cadastro.getEstadoCivil();
            naciol = cadastro.getNacionalidade();
            nuit = cadastro.getNUIT();
            contactoDeEmergen = cadastro.getContactoDeEmergencia() + "";

            bw.write(nome);
            bw.newLine();
            bw.write(bi);
            bw.newLine();
            bw.write(email);
            bw.newLine();
            bw.write(aparta);
            bw.newLine();
            bw.write(data);
            bw.newLine();
            bw.write(datanaic);
            bw.newLine();
            bw.write(id);
            bw.newLine();
            bw.write(telef);
            bw.newLine();
            bw.write(senha);
            bw.newLine();
            bw.write(estado);
            bw.newLine();
            bw.write(naciol);
            bw.newLine();
            bw.write(nuit);
            bw.newLine();
            bw.write(contactoDeEmergen);
            bw.newLine();
            bw.write("--------------------");
            bw.newLine();

        }
        bw.close();

    }

    public static Vector ler_texto() {
        Vector y = new Vector();
        File file = new File(FICHEIRO);
        if (!file.exists()) {
            return y;   // 
        }
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String nome;
            while ((nome = br.readLine()) != null) {
                Cadastro cadastro = new Cadastro();
                cadastro.setNomeCompleto(nome);
                cadastro.setBi(br.readLine());
                cadastro.setEmail(br.readLine());
                cadastro.setApartamento(br.readLine());
                cadastro.setDataCadastro(br.readLine());
                cadastro.setDataDeNascimento(br.readLine());
                cadastro.setId(Integer.parseInt(br.readLine().trim()));
                cadastro.setTelefone(br.readLine());
                cadastro.setSenha(br.readLine());
                cadastro.setEstadoCivil(br.readLine());
                cadastro.setNacionalidade(br.readLine());
                cadastro.setNUIT(br.readLine());
                cadastro.setContactoDeEmergencia(Integer.parseInt(br.readLine()));

                br.readLine();
                y.add(cadastro);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return y;
    }

    private void telefoneValido(String telefone) {
        if (telefone.length() != 9) {  //>
            JOptionPane.showMessageDialog(null, "Numero invalido");
            return;
        }

    }

    public void cadastro() {

        String nomeComleto = txtNomeCompleto.getText();
        String dataDeNascimento = cbxDataDeNascimento.getSelectedItem() + "";
        String bi = txtBI.getText();
        String email = txtEmail.getText();
        Vector listaApartamentos = PainelCadastrarApartamentos.ler_texto();
        int lista= cbxApartamento.getSelectedIndex();
        if (lista < 0 || lista >= listaApartamentos.size()) {
            JOptionPane.showMessageDialog(null, "Escolha um apartamento!");
            return;
        }
        String apartamento = ((Apartamento) listaApartamentos.get(lista)).getId() + "";
        String dataDeCadastro = cbxDataDeCadastro.getSelectedItem() + "";
        String estadoCivil = cbxEstadoCivil.getSelectedItem() + "";
        String nuit = txtNUIT.getText();
        int contactoDeEmergencia = Integer.parseInt(txtContactoDeEmergencia.getText());
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

        String nacionalidade = cbxNacinal.getSelectedItem() + "";

        Cadastro cadastro = new Cadastro();
        cadastro.setNomeCompleto(nomeComleto);
        cadastro.setDataDeNascimento(dataDeNascimento);
        cadastro.setBi(bi);
        cadastro.setEmail(email);
        cadastro.setApartamento(apartamento);
        cadastro.setDataCadastro(dataDeCadastro);
        cadastro.setEstadoCivil(estadoCivil);
        cadastro.setId(id);
        cadastro.setSenha(senhaDeAcesso);
        cadastro.setTelefone(telefone);
        cadastro.setNacionalidade(nacionalidade);
        cadastro.setNUIT(nuit);
        cadastro.setContactoDeEmergencia(contactoDeEmergencia);
        x.add(cadastro);
        try {
            guardar_texto(x);
            JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
            limpar();
        } catch (Exception e) {
            x.remove(cadastro);
            JOptionPane.showMessageDialog(null, "Falha ao cadastrar!");

            e.printStackTrace();
        }

    }

    public void limpar() {
        txtNomeCompleto.setText("");
        cbxDataDeNascimento.setSelectedIndex(0);
        txtBI.setText("");
        txtEmail.setText("");
        cbxApartamento.setSelectedIndex(0);
        cbxDataDeCadastro.setSelectedIndex(0);
        cbxEstadoCivil.setSelectedIndex(0);
        txtID.setText("");
        txtSenhaDeAcesso.setText("");
        txtConfirmarSenha.setText("");
        txtTelefone.setText("");
        txtTelefoneAlternativo.setText("");
        cbxNacinal.setSelectedIndex(0);
        txtNUIT.setText("");
        txtContactoDeEmergencia.setText("");

    }

    public void adicionar() {
        cbxApartamento.removeAllItems();
        Vector listarApartamentos = PainelCadastrarApartamentos.ler_texto();
        Apartamento apartamento1;

        for (int i = 0; i < listarApartamentos.size(); i++) {
            apartamento1 = (Apartamento) listarApartamentos.get(i);
            cbxApartamento.addItem(apartamento1.getId() + "-Bloco-" + apartamento1.getBloco() + "-Andar-" + apartamento1.getAndar());
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

        cbxNacionalidade = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtBI = new javax.swing.JTextField();
        txtNomeCompleto = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        cbxDataDeNascimento = new javax.swing.JComboBox<>();
        cbxEstadoCivil = new javax.swing.JComboBox<>();
        cbxApartamento = new javax.swing.JComboBox<>();
        cbxDataDeCadastro = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        txtTelefone = new javax.swing.JTextField();
        txtTelefoneAlternativo = new javax.swing.JTextField();
        txtID = new javax.swing.JTextField();
        txtSenhaDeAcesso = new javax.swing.JTextField();
        txtConfirmarSenha = new javax.swing.JTextField();
        cbxNacinal = new javax.swing.JComboBox<>();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        txtNUIT = new javax.swing.JLabel();
        txtNomeCompleto1 = new javax.swing.JTextField();
        txtNUIT1 = new javax.swing.JLabel();
        txtContactoDeEmergencia = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbxNacionalidade.setBackground(new java.awt.Color(255, 255, 255));
        cbxNacionalidade.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel1.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Cadastro de Morador");

        jButton1.setBackground(new java.awt.Color(0, 102, 204));
        jButton1.setFont(new java.awt.Font("sansserif", 0, 14)); // NOI18N
        jButton1.setText("Funcionario");
        jButton1.addActionListener(this::jButton1ActionPerformed);

        jButton2.setBackground(new java.awt.Color(0, 102, 204));
        jButton2.setText("Cancelar");

        jButton3.setBackground(new java.awt.Color(0, 102, 204));
        jButton3.setText("Salvar");
        jButton3.addActionListener(this::jButton3ActionPerformed);

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Nome Completo:");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Data de Nascimento:");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("BI:");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Email:");

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Apartamento:");

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Data de Cadastro:");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Estado: ");

        txtBI.setBackground(new java.awt.Color(204, 204, 204));
        txtBI.addActionListener(this::txtBIActionPerformed);

        txtNomeCompleto.setBackground(new java.awt.Color(204, 204, 204));
        txtNomeCompleto.addActionListener(this::txtNomeCompletoActionPerformed);

        txtEmail.setBackground(new java.awt.Color(204, 204, 204));
        txtEmail.addActionListener(this::txtEmailActionPerformed);

        cbxDataDeNascimento.setBackground(new java.awt.Color(0, 102, 204));
        cbxDataDeNascimento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028" }));
        cbxDataDeNascimento.addActionListener(this::cbxDataDeNascimentoActionPerformed);

        cbxEstadoCivil.setBackground(new java.awt.Color(0, 102, 204));
        cbxEstadoCivil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Estado Civil", "Solteiro/a", "Casado/a", "Viuvo/a" }));

        cbxApartamento.setBackground(new java.awt.Color(0, 102, 204));
        cbxApartamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------" }));
        cbxApartamento.addActionListener(this::cbxApartamentoActionPerformed);

        cbxDataDeCadastro.setBackground(new java.awt.Color(0, 102, 204));
        cbxDataDeCadastro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028" }));

        jPanel2.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1333, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 22, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Precha essses campos para manter a sua conta Segura");

        jPanel3.setBackground(new java.awt.Color(0, 102, 204));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 35, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 389, Short.MAX_VALUE)
        );

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

        jLabel11.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("ID Usuario:");

        jLabel13.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Senha de Acesso:");

        jLabel14.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Confirmar Senha:");

        jLabel16.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Telefone:");

        jLabel17.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Telefone Alternativo:");

        jLabel18.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Nacionalidade:");

        txtTelefone.setBackground(new java.awt.Color(204, 204, 204));

        txtTelefoneAlternativo.setBackground(new java.awt.Color(204, 204, 204));

        txtID.setBackground(new java.awt.Color(204, 204, 204));

        txtSenhaDeAcesso.setBackground(new java.awt.Color(204, 204, 204));
        txtSenhaDeAcesso.addActionListener(this::txtSenhaDeAcessoActionPerformed);

        txtConfirmarSenha.setBackground(new java.awt.Color(204, 204, 204));

        cbxNacinal.setBackground(new java.awt.Color(0, 102, 204));
        cbxNacinal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nacionalidade", " " }));

        jButton4.setBackground(new java.awt.Color(0, 102, 204));
        jButton4.setText("Limpar");
        jButton4.addActionListener(this::jButton4ActionPerformed);

        jButton5.setBackground(new java.awt.Color(0, 102, 204));
        jButton5.setFont(new java.awt.Font("sansserif", 0, 18)); // NOI18N
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Voltar");
        jButton5.addActionListener(this::jButton5ActionPerformed);

        txtNUIT.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtNUIT.setForeground(new java.awt.Color(0, 0, 0));
        txtNUIT.setText("Nuit");

        txtNomeCompleto1.setBackground(new java.awt.Color(204, 204, 204));
        txtNomeCompleto1.addActionListener(this::txtNomeCompleto1ActionPerformed);

        txtNUIT1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        txtNUIT1.setForeground(new java.awt.Color(0, 0, 0));
        txtNUIT1.setText("Contacto de emergencia");

        txtContactoDeEmergencia.setBackground(new java.awt.Color(204, 204, 204));
        txtContactoDeEmergencia.addActionListener(this::txtContactoDeEmergenciaActionPerformed);

        javax.swing.GroupLayout cbxNacionalidadeLayout = new javax.swing.GroupLayout(cbxNacionalidade);
        cbxNacionalidade.setLayout(cbxNacionalidadeLayout);
        cbxNacionalidadeLayout.setHorizontalGroup(
            cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(60, 60, 60)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5)
                                .addGap(21, 21, 21))
                            .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel10))
                                    .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel8)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jLabel4))
                                                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cbxNacionalidadeLayout.createSequentialGroup()
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                                        .addGap(52, 52, 52)
                                                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtBI, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cbxDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cbxApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(cbxDataDeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                                        .addGap(18, 18, 18)
                                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtNUIT)
                                            .addComponent(txtNUIT1))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtContactoDeEmergencia)
                                            .addComponent(txtNomeCompleto1, javax.swing.GroupLayout.DEFAULT_SIZE, 309, Short.MAX_VALUE))))
                                .addGap(141, 141, 141))))
                    .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addGap(54, 54, 54)))
                            .addComponent(jLabel13))
                        .addGap(33, 33, 33)
                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtID, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addComponent(txtSenhaDeAcesso)
                            .addComponent(txtConfirmarSenha))
                        .addGap(129, 129, 129)
                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(130, 130, 130)
                                .addComponent(txtTelefone))
                            .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel17)
                                    .addComponent(jLabel18))
                                .addGap(24, 24, 24)
                                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTelefoneAlternativo, javax.swing.GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                    .addComponent(cbxNacinal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        cbxNacionalidadeLayout.setVerticalGroup(
            cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(7, 7, Short.MAX_VALUE)
                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                            .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel2)
                                .addComponent(txtNomeCompleto, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGap(17, 17, 17)
                            .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel3)
                                .addComponent(cbxDataDeNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                    .addGap(17, 17, 17)
                                    .addComponent(jLabel4)
                                    .addGap(18, 18, 18)
                                    .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(29, 29, 29))
                                .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtBI, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(78, 78, 78)))
                            .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel6)
                                .addComponent(cbxApartamento, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                                    .addGap(25, 25, 25)
                                    .addComponent(jLabel7)
                                    .addGap(18, 18, 18))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, cbxNacionalidadeLayout.createSequentialGroup()
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbxDataDeCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                            .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cbxEstadoCivil, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNomeCompleto1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(cbxNacionalidadeLayout.createSequentialGroup()
                        .addComponent(txtNUIT)
                        .addGap(29, 29, 29)
                        .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNUIT1)
                            .addComponent(txtContactoDeEmergencia, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel16)
                    .addComponent(txtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel17)
                    .addComponent(txtTelefoneAlternativo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSenhaDeAcesso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel18)
                    .addComponent(txtConfirmarSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxNacinal, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                .addGroup(cbxNacionalidadeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
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
            .addComponent(cbxNacionalidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cbxNacionalidade, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtBIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBIActionPerformed

    private void txtNomeCompletoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCompletoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCompletoActionPerformed

    private void txtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEmailActionPerformed

    private void txtSenhaDeAcessoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSenhaDeAcessoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSenhaDeAcessoActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpar();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        cadastro();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void cbxApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxApartamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxApartamentoActionPerformed

    private void cbxDataDeNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxDataDeNascimentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxDataDeNascimentoActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new TelaPrincipal().setVisible(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new PainelCadastroFuncionario().setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtNomeCompleto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNomeCompleto1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNomeCompleto1ActionPerformed

    private void txtContactoDeEmergenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtContactoDeEmergenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtContactoDeEmergenciaActionPerformed

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
        java.awt.EventQueue.invokeLater(() -> new PainelCadastro().setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbxApartamento;
    private javax.swing.JComboBox<String> cbxDataDeCadastro;
    private javax.swing.JComboBox<String> cbxDataDeNascimento;
    private javax.swing.JComboBox<String> cbxEstadoCivil;
    private javax.swing.JComboBox<String> cbxNacinal;
    private javax.swing.JPanel cbxNacionalidade;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField txtBI;
    private javax.swing.JTextField txtConfirmarSenha;
    private javax.swing.JTextField txtContactoDeEmergencia;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtID;
    private javax.swing.JLabel txtNUIT;
    private javax.swing.JLabel txtNUIT1;
    private javax.swing.JTextField txtNomeCompleto;
    private javax.swing.JTextField txtNomeCompleto1;
    private javax.swing.JTextField txtSenhaDeAcesso;
    private javax.swing.JTextField txtTelefone;
    private javax.swing.JTextField txtTelefoneAlternativo;
    // End of variables declaration//GEN-END:variables
}
