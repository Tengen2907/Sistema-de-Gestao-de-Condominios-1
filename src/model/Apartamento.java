package model;
import java.io.Serializable;

public class  Apartamento implements Serializable {
    private static final long seriaVersionuID = 1l;

  private int id;
  private String bloco;
  private int andar;
  private double mesensalidade;
  private boolean  estado;
  
  public Apartamento(){

}

    public Apartamento(int id, String bloco, int andar, double mesensalidade, boolean estado) {
        this.id = id;
        this.bloco = bloco;
        this.andar = andar;
        this.mesensalidade = mesensalidade;
        this.estado = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBloco() {
        return bloco;
    }

    public void setBloco(String bloco) {
        this.bloco = bloco;
    }

    public int getAndar() {
        return andar;
    }

    public void setAndar(int andar) {
        this.andar = andar;
    }

    public double getMesensalidade() {
        return mesensalidade;
    }

    public void setMesensalidade(double mesensalidade) {
        this.mesensalidade = mesensalidade;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
    
    
}
 