package br.com.softtek.aula;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.Date;

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
@WebServlet("/AulaServletIncluir")
public class AulaServletIncluir extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AulaServletIncluir() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("nome") == null) {
			response.getWriter().append("Nome e obrigatorio");
			return;
		}
		String nome = request.getParameter("nome");
		String ip = getIpExterno();
		LogAlunoDTO logAlunoDTO = new LogAlunoDTO(nome, new Date(), ip);
		try {
			Connection connection = Conexao.iniciarConexao();
			LogAluno.incluir(logAlunoDTO, connection);
			Conexao.commit();
			Conexao.fecharConexao();
			response.getWriter().append("LogAluno " + logAlunoDTO.getNome() + " incluido com sucesso");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private String getIpExterno() throws MalformedURLException, IOException {
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
		String ip = in.readLine();
		return ip;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
