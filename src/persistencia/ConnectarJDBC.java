package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectarJDBC {
	   public static Connection obterConexao() {

	        String url = "jdbc:mysql://localhost:3306/corridas_vespa";
	        String usuario = "root";
	        String senha = "chaves84";


	        try {
	            Connection conexao = DriverManager.getConnection(url, usuario, senha);
	            System.out.println("Conexão bem-sucedida!");
	            return conexao;
	        } catch (SQLException e) {
	            System.out.println("Erro ao conectar ao banco de dados: " + e.getMessage());
	            return null; 
	        }
	    }
}
