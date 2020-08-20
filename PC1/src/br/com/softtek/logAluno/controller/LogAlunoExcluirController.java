package br.com.softtek.logAluno.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.softtek.logAluno.model.LogAlunoService;

/**
 * Servlet implementation class IncluirLogAluno
 */
@WebServlet("/ExcluirLogAluno")
public class LogAlunoExcluirController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogAlunoExcluirController() {
        super();
    }

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			LogAlunoService.excluir(Integer.valueOf(request.getParameter("id")));
			response.sendRedirect("/PC1");
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("erro", true);
		}
	}

}
