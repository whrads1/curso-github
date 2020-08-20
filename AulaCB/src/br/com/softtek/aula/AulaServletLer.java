package br.com.softtek.aula;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.softtek.aula.conexao.Conexao;
import br.com.softtek.aula.log.LogAluno;
import br.com.softtek.aula.log.LogAlunoDTO;

/**
 * Servlet implementation class AulaServlet
 */
@WebServlet("/AulaServletLer")
public class AulaServletLer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AulaServletLer() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Connection connection = Conexao.iniciarConexao();
			List<LogAlunoDTO> logAluno = LogAluno.ler(connection);
			Conexao.fecharConexao();
			StringBuilder responseSB = new StringBuilder();
			logAluno.stream().forEach(aluno -> responseSB.append(aluno.getId() + " | " + aluno.getNome() + " | " + aluno.getDataInclusao() + " | " + aluno.getIp() + "\n"));
			response.getWriter().append(responseSB);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
