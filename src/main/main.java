package main;

import java.util.Scanner;

import ENTITIES.Robo;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scan = new Scanner(System.in);
		Robo RoundAtual = new Robo();
		boolean round = true;
		
    	System.out.println("Digite o P:");
    	RoundAtual.P = scan.nextDouble();
    	System.out.println("Digite o I:");
    	RoundAtual.I = scan.nextDouble();
    	System.out.println("Digite o D:");
    	RoundAtual.D = scan.nextDouble();
    	System.out.println("Digite a velocidade inicial:");
    	RoundAtual.initial_speed = scan.nextDouble();
		
        while (round == true) {

        }
    	System.out.println("Digite o conceito avaliando de 1 a 5:");
    	RoundAtual.initial_speed = scan.nextDouble();
	}

}
