package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import ENTITIES.Robo;
import testes.teste_robo_bluetooth;

public class gravador {

    public void gravacao() {
        Connection conexao = ConnectarJDBC.obterConexao();
        PreparedStatement save = null;

        try {
            Scanner scan = new Scanner(System.in);
            Robo RoundAtual = new Robo();
            boolean round = true;
            teste_robo_bluetooth teste = new teste_robo_bluetooth();
            
            System.out.println("Digite o numero do teste:");
            RoundAtual.numeroTeste = scan.next();
            RoundAtual.P = teste.P;
            System.out.println("P salvo com sucesso!");
            RoundAtual.I = teste.I;
            System.out.println("I salvo com sucesso!");
            RoundAtual.D = teste.D;
            System.out.println("D salvo com sucesso!");
            System.out.println("Digite a velocidade inicial:");
            RoundAtual.initial_speed = teste.Initial_speed;
            
            // Setando data e hora formatada
            RoundAtual.dataHora = salvarDataHora();
            long inicio = System.currentTimeMillis();
            for(int x = 0; x < 5; x++) {
            	System.out.println(teste_robo_bluetooth.randomizarString());        	
            }
            long tempoDecorrido = System.currentTimeMillis() - inicio;
            System.out.println("Round finalizado! ");
            RoundAtual.tempo = "" + tempoDecorrido /100;
            System.out.println("O tempo decorrido foi de " + RoundAtual.tempo);
            
            // finalizar marcação de tempo
            System.out.println("\n Digite o conceito avaliando de 1 a 5:");
            RoundAtual.conceito = scan.nextInt();
             
            save = conexao.prepareStatement(
                    "INSERT INTO corridas_treino"
                            + "(numero_teste, data_hora, P, I, D, initial_speed, conceito, tempo)"
                            + "VALUES"
                            + "(?, ?, ?, ?, ?, ?, ?, ?)"
            );
            
            save.setString(1, RoundAtual.numeroTeste);
            save.setString(2, RoundAtual.dataHora);
            save.setDouble(3, RoundAtual.P);
            save.setDouble(4, RoundAtual.I);
            save.setDouble(5, RoundAtual.D);
            save.setDouble(6, RoundAtual.initial_speed);
            save.setInt(7, RoundAtual.conceito);
            save.setString(8, RoundAtual.tempo);
            save.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        finally {
            if (conexao != null) {
                try {
                    conexao.close();
                    System.out.println("A corrida foi registrada com sucesso!!");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public String salvarDataHora() {
        LocalDateTime dataHoraAtual = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yy HH:mm");
        return dataHoraAtual.format(formato);
    }

    public static void main(String[] args) {
        gravador gravador = new gravador();
        gravador.gravacao();
    }
}
