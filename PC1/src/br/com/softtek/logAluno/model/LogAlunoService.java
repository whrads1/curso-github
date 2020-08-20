package br.com.softtek.logAluno.model;

import java.sql.Connection;
import java.util.List;

import br.com.softtek.logAluno.conexao.Conexao;
import br.com.softtek.logAluno.dao.LogAlunoDAO;

public class LogAlunoService {
	
	public static List<LogAluno> listar() throws Exception{
		try {
			Connection connection = Conexao.getConexao();
			List<LogAluno> logAluno = LogAlunoDAO.listar(connection);
			return logAluno;
		} catch (Exception e) {
			Conexao.roolback();
			System.out.println("Erro ao listar log de aluno " + e.getMessage());
			throw e;
		}
	}

	public static void excluir(Integer id) throws Exception{
		try {
			Connection connection = Conexao.getConexao();
			LogAlunoDAO.excluir(id, connection);
			Conexao.commit();
		} catch (Exception e) {
			Conexao.roolback();
			System.out.println("Erro ao excluir log de aluno " + e.getMessage());
			throw e;
		}
	}

	public static LogAluno get(Integer id) throws Exception {
		try {
			Connection connection = Conexao.getConexao();
			return LogAlunoDAO.get(id, connection);
		} catch (Exception e) {
			Conexao.roolback();
			System.out.println("Erro ao excluir log de aluno " + e.getMessage());
			throw e;
		}
	}
	
	public static void alterar(LogAluno logAluno) throws Exception{
		try {
			Connection connection = Conexao.getConexao();
			LogAlunoDAO.alterar(logAluno, connection);
			Conexao.commit();
		} catch (Exception e) {
			Conexao.roolback();
			System.out.println("Erro ao alterar log de aluno " + e.getMessage());
			throw e;
		}
	}
	
	public static void incluir(LogAluno logAluno) throws Exception{
		try {
			Connection connection = Conexao.getConexao();
			LogAlunoDAO.incluir(logAluno, connection);
			Conexao.commit();
		} catch (Exception e) {
			Conexao.roolback();
			System.out.println("Erro ao incluir log de aluno " + e.getMessage());
			throw e;
		}
	}
}
