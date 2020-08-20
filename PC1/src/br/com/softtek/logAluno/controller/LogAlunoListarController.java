package br.com.softtek.logAluno.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.softtek.logAluno.model.LogAlunoService;

/**
 * Servlet implementation class IncluirLogAluno
 */
@WebServlet("/index.html")
public class LogAlunoListarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogAlunoListarController() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setAttribute("listaLogAluno", LogAlunoService.listar());
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", true);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/log-aluno-listar.jsp");
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
