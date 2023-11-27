package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class exibir_corridas {


    public void exibir() {
        Connection conexao = ConnectarJDBC.obterConexao();
        try {
            if (conexao != null) {
                String sql = "SELECT * FROM corridas_treino";

                try (PreparedStatement statement = conexao.prepareStatement(sql);
                     ResultSet resultSet = statement.executeQuery()) {

                    // Imprimir os nomes das colunas
                    for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                        System.out.print(resultSet.getMetaData().getColumnName(i) + "\t");
                    }
                    System.out.println();

                    // Imprimir os dados da tabela
                    while (resultSet.next()) {
                        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
                            System.out.printf("%-9s", resultSet.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                }
            } else {
                System.out.println("Falha ao obter conexão com o banco de dados.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}