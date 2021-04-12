package com.aecioprado.digitalinnovationone.jdbc.banco;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

public class Conexao {

	public static void main(String[] args) throws SQLException {
		
		/*
		 * Importante:
		 * aprender a fazer a configuração da conexão
		 * com um arquivo properties
		 */
		
		// inicializa um objeto tipo "Connection"
		Connection conexao = null;

		String driver = "org.postgresql.Driver";
		String url = "jdbc:postgresql://localhost:5432/digital_innovation_one_jdbc";
		String usuario = "postgres";
		String senha = "admin123";

		try {
			conexao = DriverManager.getConnection(url, usuario, senha);
			System.out.println("Conexao realizada com sucesso!");
		} catch(SQLException e) {
			System.out.println("Conexão falhou!");
			e.printStackTrace();
		} finally {
			conexao.close();
		}


	}
}
