package ifpr.pgua.eic.atividade06;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App{
    private static Scanner scan = new Scanner(System.in);
    private static Estacionamento estacionamento = new Estacionamento("Estacionamento", "(41)999998888");

    private static String menu(){
        String str = "";

        str += "1 - Cadastrar veículo\n";
        str += "2 - Listar todos veículos\n";
        str += "3 - Listar veículos estacionados\n";
        str += "4 - Registrar entrada de veículo\n";
        str += "5 - Registrar saída de veículo\n";
        str += "0 - Sair\n";

        return str;
    }

    private static void cadastrarVeiculo(){
        int anoFabricacao;
        String placa, modelo, fabricante, cor;
        System.out.print("Insira a placa: ");
        placa = scan.nextLine();
        System.out.print("Insira o modelo: ");
        modelo = scan.nextLine();
        System.out.print("Insira o fabricante: ");
        fabricante = scan.nextLine();
        System.out.print("Insira o ano de fabricação: ");
        anoFabricacao = scan.nextInt();
        scan.nextLine();
        System.out.print("Insira a cor: ");
        cor = scan.nextLine();
        estacionamento.cadastraVeiculo(placa, modelo, fabricante, anoFabricacao, cor);
        System.out.print("\n");
    }

    private static void listarTodosVeiculos(){
        System.out.println("Veiculos cadastrados");
        System.out.println(estacionamento.listaTodosVeiculos());
    }

    private static void listarVeiculosEstacionados(){
        System.out.println("Veiculos estacionados");
        System.out.println(estacionamento.listaVeiculosEstacionados());
    }

    private static void buscarVeiculo(){
        String placa;
        System.out.print("Digite a placa para buscar: ");
        placa = scan.nextLine();
        estacionamento.buscarVeiculo(placa);
    }

    private static void registrarEntrada(){
        String placa;
        System.out.print("Digite a placa para entrada: ");
        placa = scan.nextLine();
        estacionamento.registraEntrada(placa);
    }

    private static void registrarSaida(){
        String placa;
        System.out.print("Digite a placa para saída: ");
        placa = scan.nextLine();
        estacionamento.registraSaida(placa);
    }

    private static void gerarVeiculos(){
    }

    public static void main( String[] args ){
        int opcao = 1;
        do{
            System.out.println(menu());
            opcao = scan.nextInt();
            scan.nextLine();
            if(opcao == 1){
                cadastrarVeiculo();
            }
            if(opcao == 2){
                listarTodosVeiculos();
            }
            if(opcao == 3){
                listarVeiculosEstacionados();
            }
            if(opcao == 4){
                registrarEntrada();
            }
            if(opcao == 5){
                registrarSaida();
            }
        }while(opcao != 0);
    }
}
