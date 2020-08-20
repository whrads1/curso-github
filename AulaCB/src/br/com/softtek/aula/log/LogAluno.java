package br.com.softtek.aula.log;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class LogAluno {

	public static List<LogAlunoDTO> ler(Connection conexao) throws Exception {
		try {
			PreparedStatement stmt = conexao.prepareStatement("select id, nome, data_inclusao, ip from log_aluno");
            ResultSet results = stmt.executeQuery();
            List<LogAlunoDTO> resultado = new ArrayList<LogAlunoDTO>();
            while (results.next())
            {
                resultado.add(new LogAlunoDTO(results.getInt("id"), results.getString("nome"), results.getTimestamp("data_inclusao"), results.getString("ip")));
            }
            return resultado;
		}catch (Exception e) {
			System.out.println("Erro ao ler log com mensagem " + e.getMessage());
			throw e;
		}
	}
	
	public static void incluir(LogAlunoDTO logAlunoDTO, Connection connection) throws Exception {
		try {
	        PreparedStatement preparedStatement = connection.prepareStatement("insert into log_aluno (nome, data_inclusao, ip) VALUES (?, ?, ?)");
	        preparedStatement.setString(1, logAlunoDTO.getNome());
	        preparedStatement.setTimestamp(2, new Timestamp(logAlunoDTO.getDataInclusao().getTime()));
	        preparedStatement.setString(3, logAlunoDTO.getIp());
	        preparedStatement.executeUpdate();
		}catch (Exception e) {
			System.out.println("Erro ao ler log com mensagem " + e.getMessage());
			throw e;
		}
	}
}
