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
		
		// lembrar de definir os dados como constantes
		final String URL = "jdbc:postgresql://localhost:5432/digital_innovation_one_jdbc";
		final String USUARIO = "postgres";
		final String SENHA = "admin123";

		try {
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conexao realizada com sucesso!");
		} catch(SQLException e) {
			System.out.println("Conexão falhou!");
			e.printStackTrace();
		} finally {
			conexao.close();
		}


	}
}
