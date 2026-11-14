
package model;
import java.io.Serializable;

public class  Cadastro implements Serializable {
    private static final long seriaVersionuID = 1l;
    private int id;
    private String nomeCompleto;
    private String dataDeNascimento;
    private String bi;
    private String email;
    private String telefone;
    private String  apartamento;
    private String dataCadastro;
    private boolean ativo;
    private String estadoCivil;
    private String senha;
    private int telefoneAlternativo;
    private String nacionalidade;
    public String NUIT;
    public int contactoDeEmergencia;
    
    
    public Cadastro(){
        
    }
    public Cadastro(int id, String nomeCompleto, String dataDeNascimento, String bi, String telefone, String apartamento, String dataCadastro, boolean ativo, String usuarioId, String senha, String estadoCivil, int telefoneAlternativo, String nacionalidade, String email) {
        this.id = id;
        this.nomeCompleto = nomeCompleto;
        this.dataDeNascimento = dataDeNascimento;
        this.bi = bi;
        this.telefone = telefone;
        this.apartamento = apartamento;
        this.dataCadastro = dataCadastro;
        this.ativo = ativo;
        this.senha=senha;
        this.estadoCivil=estadoCivil;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getBi() {
        return bi;
    }

    public void setBi(String bi) {
        this.bi = bi;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public String getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(String dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    
    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public int getTelefoneAlternativo() {
        return telefoneAlternativo;
    }

    public void setTelefoneAlternativo(int telefoneAlternativo) {
        this.telefoneAlternativo = telefoneAlternativo;
    }
    
    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNUIT() {
        return NUIT;
    }

    public void setNUIT(String NUIT) {
        this.NUIT = NUIT;
    }

    public int getContactoDeEmergencia() {
        return contactoDeEmergencia;
    }

    public void setContactoDeEmergencia(int contactoDeEmergencia) {
        this.contactoDeEmergencia = contactoDeEmergencia;
    }
    
    
    
}
