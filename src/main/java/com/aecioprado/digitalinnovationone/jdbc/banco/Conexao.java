package com.aecioprado.digitalinnovationone.jdbc.banco;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {

	public static void main(String[] args) {


		Connection conexao;

		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/digital_innovation_one_jdbc";
		String usuario = "postgres";
		String senha = "admin123";

		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexao realizada com sucesso!");
		} catch(SQLException e) {
			e.printStackTrace();
		}


	}
}
