package ifpr.pgua.eic.atividade06;

import java.beans.VetoableChangeListener;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Vector;

public class Estacionamento {
    
    private String nome;
    private String telefone;
    private ArrayList<Veiculo> veiculos;

    public Estacionamento(String nome, String telefone){
        this.nome = nome;
        this.telefone = telefone;
        veiculos = new ArrayList<>();
    }

    public boolean cadastraVeiculo(String placa, String modelo, String fabricante, int anoFabricacao, String cor){
        Veiculo carro = new Veiculo(placa, modelo, fabricante, anoFabricacao, cor);
        if(veiculos != null){
            Veiculo busca = new Veiculo(placa, "", "", 0, "");
            ArrayList<Veiculo> lista = listaTodosVeiculos();
            for (int a = 0; a < lista.size(); a++) {
                Veiculo b = lista.get(a);
                if (b.getPlaca().equals(busca.getPlaca())) {
                    return false;
                }
            }
        }
        veiculos.add(carro);
        return true;
    }

    public ArrayList<Veiculo> listaTodosVeiculos(){
        return veiculos;
    }

    public ArrayList<Veiculo> listaVeiculosEstacionados(){
        ArrayList<Veiculo> estacionados = new ArrayList<>();
        ArrayList<Veiculo> lista = listaTodosVeiculos();
        for (Veiculo veiculo : lista) {
            if(veiculo.isEstaEstacionado() == true){
                estacionados.add(veiculo);
            }
        }

        return estacionados;
    }

    public Veiculo buscarVeiculo(String placa){
        Veiculo busca = new Veiculo(placa, "", "", 0, "");
        ArrayList<Veiculo> lista = listaTodosVeiculos();
        for (int a = 0; a < lista.size(); a++) {
            Veiculo b = lista.get(a);
            if (b.getPlaca().equals(busca.getPlaca())) {
                return b;
            }
        }
        return null;
    }

    public boolean registraEntrada(String placa){
        Veiculo busca = new Veiculo(placa, "", "", 0, "");
        int index = 0, registro = 0;
        ArrayList<Veiculo> lista = listaTodosVeiculos();
        for (int a = 0; a < lista.size(); a++) {
            Veiculo b = lista.get(a);
            if (b.getPlaca().equals(busca.getPlaca()) && b.isEstaEstacionado() == false) {
                index = a;
                registro = 1;
            }
        }

        if(registro == 0){
            return false;
        }
        else{
            LocalDateTime hora = LocalDateTime.now();
            veiculos.get(index).registraEntrada(hora);
            return true;
        }
    }

    public int registraSaida(String placa){
        Veiculo busca = new Veiculo(placa, "", "", 0, "");
        int index = 0, estacionado = 0;
        ArrayList<Veiculo> lista = listaTodosVeiculos();
        for (int a = 0; a < lista.size(); a++) {
            Veiculo b = lista.get(a);
            if (b.getPlaca().equals(busca.getPlaca()) && b.isEstaEstacionado() == true) {
                index = a;
                estacionado = 1;
            }
        }

        if(estacionado == 1){
            LocalDateTime dataEntrada = veiculos.get(index).getHoraEntrada(); 
            LocalDateTime dataSaida = LocalDateTime.now();
            int totalMinutos;
            return totalMinutos = DataUtils.calculaMinutos(dataEntrada,dataSaida);
        }else{
            return -1;
        }
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        this.telefone = telefone;
    }

    public String toString(){
        String str = "Nome: "+nome+", Telefone: "+telefone+", Veiculo: "+veiculos.toString();
        return str;
    }

}
