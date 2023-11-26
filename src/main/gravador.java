package main;

import java.util.Scanner;

import ENTITIES.Robo;

public class gravador {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		Robo RoundAtual = new Robo();
		boolean round = true;
		//gravar o numero do teste 
		
    	System.out.println("Digite o P:");
    	RoundAtual.P = scan.nextDouble();
    	System.out.println("Digite o I:");
    	RoundAtual.I = scan.nextDouble();
    	System.out.println("Digite o D:");
    	RoundAtual.D = scan.nextDouble();
    	System.out.println("Digite a velocidade inicial:");
    	RoundAtual.initial_speed = scan.nextDouble();
    	//marcar o horario da corrida 
		// iniciar marcação de tempo 
        while (round == true) {
        	//marcando erros 
        	// gravar o array 
        	// se algum sensor diferente de 2500 gravar o array e o tempo 
        }
        //finalizar marcação de tempo
    	System.out.println("Digite o conceito avaliando de 1 a 5:");
    	RoundAtual.conceito = scan.next();
	}

}
