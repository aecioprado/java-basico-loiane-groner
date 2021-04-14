package com.aecioprado.digitalinnovationone.jdbc.banco;

import java.util.List;

import com.aecioprado.digitalinnovationone.jdbc.aluno.Aluno;
import com.aecioprado.digitalinnovationone.jdbc.aluno.AlunoDao;

public class Consultas {

	public static void main(String[] args) {

		AlunoDao alunoDao = new AlunoDao();

		// listar registros
		System.out.println("-------- Listar ---------");

		// criar uma lista chamada alunos que recebe objetos do tipo alunoDao
		List<Aluno> alunos = alunoDao.listar();

		// iterar os objetos da lista alunos
		alunos.forEach(System.out::println);

		System.out.println();

		// inserir registros
		System.out.println("-------- Inserir ---------");


		alunoDao.inserir();


		// atualizar por id

		System.out.println("-------- Atualizar por Id ---------");


		alunoDao.atualizarPorId();

		// deletar por ID

		System.out.println("-------- Deletar por Id ---------");
		
		alunoDao.deletarPorId();
		

	}

}
