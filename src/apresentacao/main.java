package apresentacao;

import java.util.Scanner;

import negocios.excluir_teste;
import negocios.exibir_corridas;
import negocios.gravador;



public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int escolha;
        gravador Gravador = new gravador();
        exibir_corridas exibir_corridas = new exibir_corridas();
        excluir_teste excluir = new excluir_teste();

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: \n ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                	Gravador.gravacao();
                    break;
                case 2:
                	exibir_corridas.exibir();
                    break;
                case 3:
                	excluir.excluir();
                    break;
                case 0:
                    System.out.println("Saindo do programa. Adeus!");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (escolha != 0);
        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1. Gravar uma corrida do vespa");
        System.out.println("2. Exibir corridas do vespa");
        System.out.println("3. excluir uma corrida");
        System.out.println("0. Sair");
        System.out.println("-----------------");
    }

}
