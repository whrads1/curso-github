package br.com.softtek.logAluno.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.softtek.logAluno.model.LogAluno;
import br.com.softtek.logAluno.model.LogAlunoService;

/**
 * Servlet implementation class IncluirLogAluno
 */
@WebServlet("/IncluirLogAluno")
public class LogAlunoIncluirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogAlunoIncluirController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/log-aluno-incluir.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LogAluno logAluno = new LogAluno();
			logAluno.setNome(request.getParameter("nomeAluno"));
			logAluno.setDataInclusao(new Date());
			logAluno.setIp(getIpExterno());
			LogAlunoService.incluir(logAluno);
			response.sendRedirect("/PC1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", true);
		}
	}
	
	private String getIpExterno() throws MalformedURLException, IOException {
		URL whatismyip = new URL("http://checkip.amazonaws.com");
		BufferedReader in = new BufferedReader(new InputStreamReader(whatismyip.openStream()));
		String ip = in.readLine();
		return ip;
	}

}
