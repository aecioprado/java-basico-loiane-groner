package com.aecioprado.digitalinnovationone.jdbc.banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoFactory {

	// Factory é um método público e estático pra ser injetado nas consultas sql
	
	public static Connection getConnection() throws SQLException {
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
		
		return conexao;

	} 
}
