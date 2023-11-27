package main;

import java.util.Scanner;



public class main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        int escolha;
        gravador Gravador = new gravador();
        exibir_corridas exibir_corridas = new exibir_corridas();

        do {
            exibirMenu();
            System.out.print("Escolha uma opção: ");
            escolha = scanner.nextInt();

            switch (escolha) {
                case 1:
                	Gravador.gravacao();
                    break;
                case 2:
                	exibir_corridas.exibir();
                    System.out.println("2. Ver corridas gravadas:");
                    break;
                case 3:
                    System.out.println("3. Excluir corridas gravadas:");
                    break;
                case 4:
                    System.out.println("4. editar o numero do test:");
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
        System.out.println("1. Opção 1");
        System.out.println("2. Opção 2");
        System.out.println("3. Opção 3");
        System.out.println("4. Opção 4");
        System.out.println("0. Sair");
        System.out.println("-----------------");
    }

}
