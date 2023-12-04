package negocios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import persistencia.ConnectarJDBC;

public class excluir_teste {
    Scanner scan = new Scanner(System.in);

    public void excluir() {
        Connection conexao = ConnectarJDBC.obterConexao();
        try {
            if (conexao != null) {
                System.out.println("Digite o numero do teste:");
                String numero_teste = scan.next(); // ID da linha que você deseja excluir

                String sql = "DELETE FROM corridas_treino WHERE numero_teste = ?";

                try (PreparedStatement statement = conexao.prepareStatement(sql)) {
                    statement.setString(1, numero_teste);

                    int linhasAfetadas = statement.executeUpdate();

                    if (linhasAfetadas > 0) {
                        System.out.println("Registro excluído com sucesso!");
                    } else {
                        System.out.println("Nenhum registro encontrado para exclusão.");
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

