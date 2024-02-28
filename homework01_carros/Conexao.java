package homework01_carros;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public Connection abrirConn() {

		try {
			String url = "jdbc:mariadb://localhost:3306/";
			String user = "root";
			String password = "";

			//

			Connection conn = DriverManager.getConnection(url, user, password);

			return conn;

		} catch (SQLException e) {
			System.err.println("Erro ao acessar o banco de dados.");
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return null;
	}

	public Connection abrirConn(String bd) {

		try {
			String url = "jdbc:mariadb://localhost:3306/" + bd;
			String user = "root";
			String password = "";

			//

			Connection conn = DriverManager.getConnection(url, user, password);

			return conn;

		} catch (SQLException e) {
			System.err.println("Erro ao acessar o banco de dados.");
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return null;
	}

}
