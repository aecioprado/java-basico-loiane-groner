package com.aecioprado.digitalinnovationone.jdbc.aluno;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aecioprado.digitalinnovationone.jdbc.banco.ConexaoFactory;

public class AlunoDao {

	Scanner scan = new Scanner(System.in);

	// incio do método inserir

	public void inserir() {


		try {
			Connection conexao = ConexaoFactory.getConnection();

			String opcao = null;

			Aluno aluno = new Aluno();

			// inicio do loop de inserção
			do {

				System.out.println("Informe os dados do novo registro: ");

				// nome
				System.out.println("Nome: ");
				String nome = scan.nextLine();
				aluno.setNome(nome);

				// idade
				System.out.println("Idade: ");
				int idade = scan.nextInt();
				aluno.setIdade(idade);

				// correção do cursor para evitar erro de leitura
				// no futuro substituir por um bufferedreader
				scan.nextLine();

				// estado
				System.out.println("estado: ");
				String estado = scan.nextLine();
				aluno.setEstado(estado);

				// formata a string SQL
				String sql = "INSERT INTO aluno(nome, idade, estado) VALUES (?,?,?)";

				// formata o preparedStetament com a string SQL definida
				PreparedStatement pstm = conexao.prepareStatement(sql);

				// seta os dados lidos para dentro do comanda SQl 
				pstm.setString(1 , aluno.getNome());
				pstm.setInt(2 , aluno.getIdade());
				pstm.setString(3 , aluno.getEstado());

				// executa o comando SQl
				pstm.executeUpdate();

				System.out.println("Deseja inserir um novo registro ? (S/N) ");
				opcao = scan.nextLine();

				if(opcao.equalsIgnoreCase("N")) {
					System.out.println("Programa encerrado.");
				}

				System.out.println("******");

			} while (!opcao.equalsIgnoreCase("n"));	
			// fim do loop de inserção


			// exceção
			// no futuro incluir uma SQLException
		} catch(Exception e) {
			System.out.println("Conexão falhou." +  e.getMessage());
			e.printStackTrace();
		} 

	}

	// fim do método inserir


	// inicio do método listar

	public List<Aluno> listar(){ //List<Aluno> é um tipo do dado.

		// instância uma lista chamada "alunos".
		List<Aluno> alunos = new ArrayList<Aluno>();

		try {
			Connection conexao = ConexaoFactory.getConnection();

			// formata a string sql
			String sql = "select * from aluno order by id";

			//formata o preparedStetament
			PreparedStatement pstm = conexao.prepareStatement(sql);

			//executa a query SQL e registra o resultado no objeto "rs" do tipo ResultSet
			ResultSet rs = pstm.executeQuery();

			//itera a leitura dos campos de cada registro gravado no objeto "rs"
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String estado = rs.getString("estado");

				// inseri os campos lidos na lista "alunos"
				alunos.add(new Aluno(id, nome, idade, estado));
				
				conexao.close();
			}

			// exceção
			// no futuro incluir uma SQLException
		} catch(Exception e) {
			System.out.println("Conexão falhou!" +  e.getMessage());
			e.printStackTrace();

		}

		// retorna a lista alunos
		return alunos;

	}
	// fim do método listar


	// início do método atualizarPorId

	public void atualizarPorId() {

		// na próxima versão tentar usar try-with-resources
		try {

			Connection conexao = ConexaoFactory.getConnection();

			// informa o id
			System.out.println("Informe o Id: ");
			int id = scan.nextInt();

			// correção do erro de cursos do Scanner
			// corrigir na próxima versão
			scan.nextLine();

			// lê um novo nome
			System.out.println("Informe Nome: ");
			String nome = scan.nextLine();

			// lê uma nova idade
			System.out.println("Informe Idade: ");
			int idade = scan.nextInt();

			// correção do erro de cursos do Scanner
			// corrigir na próxima versão
			scan.nextLine();

			// lê um estado
			System.out.println("Informe Estado: ");
			String estado = scan.nextLine();

			// formata a string SQL
			String sql_select = "UPDATE aluno set nome = ?, idade = ?,  estado = ? WHERE id= ? ";

			// formata o prepareStatement
			PreparedStatement pstmt = conexao.prepareStatement(sql_select);

			// prepara os campos do comando SQL
			pstmt.setString(1, nome);
			pstmt.setInt(2, idade);
			pstmt.setString(3, estado);
			pstmt.setInt(4, id);

			// executa query SQL
			pstmt.executeUpdate();

			System.out.println("Registro id=" + id + " atualizado com sucesso");


		} catch(Exception e) { 
			System.out.println("Conexão falhou!" + e.getMessage());
			e.printStackTrace();

		}


	}
	// fim do método atualizarPorId

	// início do método deletarPorId

	public void deletarPorId() {

		try {
			
			Connection conexao = ConexaoFactory.getConnection();
			
			System.out.println("Informe o Id: ");
			int id = scan.nextInt();
			
			String sql_delete = "DELETE from aluno WHERE id = ?";
			
			PreparedStatement pstmt = conexao.prepareStatement(sql_delete);
			
			pstmt.setInt(1, id);
			
			pstmt.executeUpdate();
			
			System.out.println("Registro =" + id +"deletado com sucesso.");

		} catch(Exception e) {
			
			System.out.println("Conexão falou." + e.getMessage());
			e.printStackTrace();

		}
	}
	// fim do método deletarPorId


}

