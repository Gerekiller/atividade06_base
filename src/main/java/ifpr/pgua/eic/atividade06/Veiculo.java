package ifpr.pgua.eic.atividade06;

import java.time.LocalDateTime;

public class Veiculo {
    private String placa;
    private String modelo;
    private String fabricante;
    private int anoFabricacao;
    private String cor;
    private LocalDateTime horaEntrada;
    private boolean estaEstacionado;

    public Veiculo(String placa, String modelo, String fabricante, int anoFabricacao, String cor){
        this.placa = placa;
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.anoFabricacao = anoFabricacao;
        this.cor = cor;
    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getFabricante(){
        return fabricante;
    }

    public void setFabricante(String fabricante){
        this.fabricante = fabricante;
    }

    public int getAnoFabricacao(){
        return anoFabricacao;
    }

    public void setAnoFabricacao(int anoFabricacao){
        this.anoFabricacao = anoFabricacao;
    }

    public String getCor(){
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public boolean isEstaEstacionado(){
        return estaEstacionado;
    }

    LocalDateTime getHoraEntrada(){
        return horaEntrada;
    }

    public boolean registraEntrada(LocalDateTime horaEntrada){
        this.horaEntrada = horaEntrada;
        if(isEstaEstacionado() == true){
            return false;
        }
        else{
            this.estaEstacionado = true;
            return true;
        }
    }

    boolean registraSaida(){
        if(isEstaEstacionado() == true){
            this.horaEntrada = null;
            this.estaEstacionado = false;
            return true;
        }
        else{
            return false;
        }
    }

    public String toString(){
        String str = "Placa: "+placa+", Modelo: "+modelo+", Fabricante: "+fabricante+", Ano: "+anoFabricacao+", Cor: "+cor+", Situação atual: "+estaEstacionado;
        return str;
    }
}
