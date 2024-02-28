package homework01_carros;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Carro {

	// atributos

	private int id;

	private String nome;
	private String marca;
	private String placa;
	private int ano;
	private double valor;

	// construtores

	public Carro() {

	}

	public Carro(String nome, String marca, String placa, int ano, double valor) {

		this.nome = nome;
		this.marca = marca;
		this.placa = placa;
		this.ano = ano;
		this.valor = valor;
	}

	public Carro(int id, String nome, String marca, String placa, int ano, double valor) {

		this.id = id;
		this.nome = nome;
		this.marca = marca;
		this.placa = placa;
		this.ano = ano;
		this.valor = valor;
	}

	// getters e setters

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	// metodos da classe

	public boolean cadastrarCarro() {

		try {

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			String sql = "insert into carros (nome, marca, placa, ano, valor) values (?,?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, nome);
			ps.setString(2, marca);
			ps.setString(3, placa);
			ps.setInt(4, ano);
			ps.setDouble(5, valor);

			ps.execute();
			conn.close();

			return true;

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return false;

	}

	// editar nome carro

	public boolean editarNomeCarro(String nome, String placa) {

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			//

			String sql = "update carros set nome = ? where placa = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, nome);
			ps.setString(2, placa);

			//

			ps.executeUpdate();
			conn.close();

			return true;

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return false;

	}

	// editar marca carro

	public boolean editarMarcaCarro(String marca, String placa) {

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			String sql = "update carros set marca = ? where placa = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, marca);
			ps.setString(2, placa);

			//

			ps.executeUpdate();
			conn.close();

			return true;

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return false;

	}

	public boolean editarPlacaCarro(String placa2, String placa) {

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			String sql = "update carros set placa = ? where placa = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, placa2);
			ps.setString(2, placa);

			//

			ps.executeUpdate();
			conn.close();

			return true;

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return false;

	}

	public boolean editarAnoCarro(int ano, String placa) {

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			String sql = "update carros set ano = ? where placa = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, ano);
			ps.setString(2, placa);

			//

			ps.executeUpdate();
			conn.close();

			return true;

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return false;

	}

	public boolean editarValorCarro(double valor, String placa) {

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			String sql = "update carros set valor = ? where placa = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setDouble(1, valor);
			ps.setString(2, placa);

			//

			ps.executeUpdate();
			conn.close();

			return true;

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return false;

	}

	public boolean excluirCarro(String placa) {

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			String sql = "delete from carros where placa = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setString(1, placa);

			//

			ps.executeUpdate();
			conn.close();

			return true;

		} catch (Exception e) {
			// e.printStackTrace();
		}

		return false;

	}

	public void localizarCarro(String placa) {

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			String sql = "SELECT id, nome, marca, placa, ano, valor FROM carros WHERE placa = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, placa);

			// ResultSet é uma interface utilizada para guardar dados vindos de um banco de
			// dados.
			// Ela guarda o resultado de uma pesquisa numa estrutura de dados que pode ser
			// percorrida como uma array, de forma que você possa ler os dados do banco.
			ResultSet resultado = ps.executeQuery();
			//

			while (resultado.next()) {

				int id = resultado.getInt(1);
				String nome = resultado.getString(2);
				String marca = resultado.getString(3);
				String placa2 = resultado.getString(4);
				int ano = resultado.getInt(5);
				double valor = resultado.getDouble(6);

				System.out.printf("ID:    %d%n", id);
				System.out.printf("Nome:  %s%n", nome);
				System.out.printf("Marca: %s%n", marca);
				System.out.printf("Placa: %s%n", placa2);
				System.out.printf("Ano:   %d%n", ano);
				System.out.printf("Valor: %.2f%n", valor);

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public int localizarCarro2(String placa) {

		int count = 0;

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			String sql = "SELECT COUNT(*) from carros WHERE placa = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, placa);

			// ResultSet é uma interface utilizada para guardar dados vindos de um banco de
			// dados.
			// Ela guarda o resultado de uma pesquisa numa estrutura de dados que pode ser
			// percorrida como uma array, de forma que você possa ler os dados do banco.
			ResultSet resultado = ps.executeQuery();
			//

			if (resultado.next()) {
				count = resultado.getInt(1);
			}

		} catch (java.lang.NullPointerException e) {
			System.err.println("Crie primeiro o banco de dados.");
		} catch (Exception e) {
			// e.printStackTrace();
		}

		return count;

	}

	public void listarCarros() {

		try {

			//

			Connection conn = new Conexao().abrirConn("bdaula05_carro");

			//

			String sql = "SELECT id, nome, marca, placa, ano, valor FROM carros ORDER BY id";
			PreparedStatement ps = conn.prepareStatement(sql);

			// ResultSet é uma interface utilizada para guardar dados vindos de um banco de
			// dados.
			// Ela guarda o resultado de uma pesquisa numa estrutura de dados que pode ser
			// percorrida como uma array, de forma que você possa ler os dados do banco.
			ResultSet resultado = ps.executeQuery();
			//

			while (resultado.next()) {

				int id = resultado.getInt(1);
				String nome = resultado.getString(2);
				String marca = resultado.getString(3);
				String placa2 = resultado.getString(4);
				int ano = resultado.getInt(5);
				double valor = resultado.getDouble(6);

				System.out.printf("ID:    %d%n", id);
				System.out.printf("Nome:  %s%n", nome);
				System.out.printf("Marca: %s%n", marca);
				System.out.printf("Placa: %s%n", placa2);
				System.out.printf("Ano:   %d%n", ano);
				System.out.printf("Valor: %.2f%n", valor);
				System.out.println();

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public boolean verificaExistenciaBancoDados() {

		//

		try (Connection conn = new Conexao().abrirConn("bdaula05_carro");
				Statement statement = conn.createStatement()) {

			// Verifica se o banco de dados existe
			ResultSet resultSet = statement
					.executeQuery("SELECT 1 FROM information_schema.schemata WHERE schema_name = 'bdaula05_carro';");
			// FROM information_schema.schemata: Especifica que estamos selecionando dados
			// da tabela schemata no esquema information_schema. Esta tabela contém
			// informações sobre os esquemas de banco de dados (ou seja, os próprios bancos
			// de dados) presentes no servidor MariaDB.
			return resultSet.next(); // Retorna true se existir, false caso contrário

		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

}
