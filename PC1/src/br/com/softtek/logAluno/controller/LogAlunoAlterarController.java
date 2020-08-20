package br.com.softtek.logAluno.controller;

import java.io.IOException;

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
@WebServlet("/AlterarLogAluno")
public class LogAlunoAlterarController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogAlunoAlterarController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LogAluno logAluno = LogAlunoService.get(Integer.valueOf(request.getParameter("id")));
			request.setAttribute("logAluno", logAluno);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", true);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/log-aluno-alterar.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LogAluno logAluno = LogAlunoService.get(Integer.valueOf(request.getParameter("id")));
			logAluno.setNome(request.getParameter("nomeAluno"));
			LogAlunoService.alterar(logAluno);
			response.sendRedirect("/PC1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", true);
		}
		
	}

}
