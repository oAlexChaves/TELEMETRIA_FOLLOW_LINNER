package main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import ENTITIES.Robo;

public class gravador {

    public void gravacao() {
        Connection conexao = ConnectarJDBC.obterConexao();
        PreparedStatement save = null;

        try {
            Scanner scan = new Scanner(System.in);
            Robo RoundAtual = new Robo();
            boolean round = true;

            System.out.println("Digite o numero do teste:");
            RoundAtual.numeroTeste = scan.next();
            System.out.println("Digite o P:");
            RoundAtual.P = scan.nextDouble();
            System.out.println("Digite o I:");
            RoundAtual.I = scan.nextDouble();
            System.out.println("Digite o D:");
            RoundAtual.D = scan.nextDouble();
            System.out.println("Digite a velocidade inicial:");
            RoundAtual.initial_speed = scan.nextDouble();
            
            // Setando data e hora formatada
            RoundAtual.dataHora = salvarDataHora();
            while (round == true) {
                // sua lógica aqui
            }

            // finalizar marcação de tempo
            System.out.println("Digite o conceito avaliando de 1 a 5:");
            RoundAtual.conceito = scan.nextInt();



            // Campos adicionais que precisam ser inicializados
            RoundAtual.sensores = "sensores"; // Substitua pelo valor apropriado
            RoundAtual.sensores_erro = "sensores_erro"; // Substitua pelo valor apropriado
            RoundAtual.tempo = "tempo"; // Substitua pelo valor apropriado
            
   
            save = conexao.prepareStatement(
                    "INSERT INTO corridas_treino"
                            + "(numero_teste, data_hora, P, I, D, initial_speed, conceito, sensores, sensores_erro, tempo)"
                            + "VALUES"
                            + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );
            save.setString(1, RoundAtual.numeroTeste);
            save.setString(2, RoundAtual.dataHora);
            save.setDouble(3, RoundAtual.P);
            save.setDouble(4, RoundAtual.I);
            save.setDouble(5, RoundAtual.D);
            save.setDouble(6, RoundAtual.initial_speed);
            save.setInt(7, RoundAtual.conceito);
            save.setString(8, RoundAtual.sensores);
            save.setString(9, RoundAtual.sensores_erro);
            save.setString(10, RoundAtual.tempo);
            save.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        
        finally {
            if (conexao != null) {
                try {
                    conexao.close();
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
