package br.com.softtek.aula.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Conexao {

	private static Connection connection = null;
	private static final String HOST = "aulasofttek.postgres.database.azure.com";
	private static final String DATABASE = "softtek";
	private static final String USUARIO = "aluno@aulasofttek";
	private static final String SENHA = "";
	private static final String DRIVER = "org.postgresql.Driver";
	private static final String SCHEMA = "aula";

	private Conexao() {}

	public static Connection iniciarConexao() throws Exception {
		if(connection != null && !connection.isClosed()) {
			return connection;
		}
		return criarConexao();
	}
	
	public static void fecharConexao() throws Exception {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.close();
				System.out.println("Conexao fechada");
			}	
		}catch (Exception e) {
			System.out.println("Erro ao fechar conexao com a mensagem " + e.getMessage());
			throw e;
		}
		
	}
	
	public static void commit() throws Exception {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.commit();
				System.out.println("Commit Conexao");
			}	
		}catch (Exception e) {
			System.out.println("Erro ao realizar o commit com a mensagem " + e.getMessage());
		}
	}
	
	
	public static void roolback() throws Exception {
		try {
			if(connection != null && !connection.isClosed()) {
				connection.rollback();
				System.out.println("Rollback Conexao");
			}	
		}catch (Exception e) {
			System.out.println("Erro ao realizar o roolback com a mensagem " + e.getMessage());
		}
	}

	private static Connection criarConexao() throws ClassNotFoundException, SQLException {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			throw new ClassNotFoundException("Erro ao carregar o driver", e);
		}
		try {
			String url = String.format("jdbc:postgresql://%s/%s?currentSchema=%s", HOST, DATABASE, SCHEMA);
			Properties properties = new Properties();
			properties.setProperty("user", USUARIO);
			properties.setProperty("password", SENHA);
			connection = DriverManager.getConnection(url, properties);
			connection.setAutoCommit(false);
			System.out.println("Conexao iniciada");
			return connection;
		} catch (SQLException e) {
			throw new SQLException("Failed to create connection to database.", e);
		}
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("testando conexao");
		iniciarConexao();
		fecharConexao();
	}
}
