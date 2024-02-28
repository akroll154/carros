package homework01_carros;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Admin_BD {

	public boolean criarBD() {

		try {

			//

			Conexao c = new Conexao();
			Connection conn = c.abrirConn();

			//

			String sql = "create database if not exists bdaula05_carro";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			conn.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean criarTabela() {

		try {

			//

			Conexao c = new Conexao();
			Connection conn = c.abrirConn("bdaula05_carro");

			//

			String sql = "create table if not exists carros (id int primary key auto_increment, nome varchar(50) not null, marca varchar(50) not null, placa varchar(7) unique, ano int CHECK (ano > 1900), valor double not null CHECK (valor > 0))";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			conn.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deletarBD() {

		try {

			//

			Conexao c = new Conexao();
			Connection conn = c.abrirConn();

			//

			String sql = "drop database if exists bdaula05_carro";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			conn.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean deletarTabela() {

		try {

			//

			Conexao c = new Conexao();
			Connection conn = c.abrirConn("bdaula05_carro");

			//

			String sql = "drop table if exists carros";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();
			conn.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean criarBDeTabela() {

		try {

			//

			Conexao c = new Conexao();
			Connection conn = c.abrirConn();

			//

			String sql = "create database if not exists bdaula05_carro";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.execute();

			sql = "USE bdaula05_carro";
			ps = conn.prepareStatement(sql);
			ps.execute();

			sql = "create table if not exists carros (id int primary key auto_increment, nome varchar(50) not null, marca varchar(50) not null, placa varchar(7) unique, ano int CHECK (ano > 1900), valor double not null CHECK (valor > 0))";
			ps = conn.prepareStatement(sql);
			ps.execute();
			conn.close();

			return true;

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

}
