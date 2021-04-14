package com.aecioprado.digitalinnovationone.jdbc.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	// Factory é um método público e estático pra ser injetado no crud
	
	// início do método getConnection
	
	public static Connection getConnection() throws SQLException {
		
		Connection conexao = null;

		final String URL = "jdbc:postgresql://localhost:5432/digital_innovation_one_jdbc";
		final String USUARIO = "postgres";
		final String SENHA = "admin123";

		try {
			conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
			System.out.println("Conexao realizada com sucesso!");
		} catch(SQLException e) {
			System.out.println("Conexão falhou!");
			e.printStackTrace();

		}
		return conexao;
	}
	// fim do método getConnection
}