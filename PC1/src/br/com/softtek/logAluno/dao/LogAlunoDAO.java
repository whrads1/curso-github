package br.com.softtek.logAluno.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import br.com.softtek.logAluno.model.LogAluno;

public class LogAlunoDAO {

	public static List<LogAluno> listar(Connection conexao) throws Exception {
		try {
			PreparedStatement preparedStatement = conexao.prepareStatement("select id, nome, data_inclusao, ip from log_aluno order by id");
            ResultSet results = preparedStatement.executeQuery();
            List<LogAluno> resultado = new ArrayList<LogAluno>();
            while (results.next())
            {
                resultado.add(new LogAluno(results.getInt("id"), results.getString("nome"), results.getTimestamp("data_inclusao"), results.getString("ip")));
            }
            return resultado;
		}catch (Exception e) {
			System.out.println("Erro ao Ler, log com mensagem " + e.getMessage());
			throw e;
		}
	}
	
	public static void incluir(LogAluno LogAluno, Connection connection) throws Exception {
		try {
	        PreparedStatement preparedStatement = connection.prepareStatement("insert into log_aluno (nome, data_inclusao, ip) VALUES (?, ?, ?)");
	        preparedStatement.setString(1, LogAluno.getNome());
	        preparedStatement.setTimestamp(2, new Timestamp(LogAluno.getDataInclusao().getTime()));
	        preparedStatement.setString(3, LogAluno.getIp());
	        preparedStatement.executeUpdate();
		}catch (Exception e) {
			System.out.println("Erro ao Inserir, log com mensagem " + e.getMessage());
			throw e;
		}
	}
	
	public static void excluir(Integer id, Connection connection) throws Exception {
		try {
	        PreparedStatement preparedStatement = connection.prepareStatement("delete from log_aluno where id = ?");
	        preparedStatement.setInt(1, id);
	        preparedStatement.executeUpdate();
		}catch (Exception e) {
			System.out.println("Erro ao excluir, log com mensagem " + e.getMessage());
			throw e;
		}
	}

	public static void alterar(LogAluno LogAluno, Connection connection) throws Exception {
		try {
	        PreparedStatement preparedStatement = connection.prepareStatement("update log_aluno set nome = ? where id = ?");
	        preparedStatement.setString(1, LogAluno.getNome());
	        preparedStatement.setInt(2, LogAluno.getId());
	        preparedStatement.executeUpdate();
		}catch (Exception e) {
			System.out.println("Erro ao Alterar, log com mensagem " + e.getMessage());
			throw e;
		}
	}

	public static LogAluno get(Integer id, Connection conexao) throws Exception {
		try {
			PreparedStatement preparedStatement = conexao.prepareStatement("select id, nome, data_inclusao, ip from log_aluno where id = ?");
			preparedStatement.setInt(1, id);
            ResultSet results = preparedStatement.executeQuery();
            if(results.next()){
                return new LogAluno(results.getInt("id"), results.getString("nome"), results.getTimestamp("data_inclusao"), results.getString("ip"));
            }
           	return null;
		}catch (Exception e) {
			System.out.println("Erro ao Ler, log com mensagem " + e.getMessage());
			throw e;
		}
	}
}
	
