package br.com.softtek.controler;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.softtek.modelo.CervejaExpert;

/**
 * Servlet implementation class SelecaoCerveja
 */
@WebServlet("/SelecionarCerveja.do")
public class SelecaoCerveja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public SelecaoCerveja() {
    //    super();
    //    // TODO Auto-generated constructor stub
   // }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//  informar o navegador sobre o formato da resposta
		response.setContentType("text/html");
		//criando uma variável de saida 
		PrintWriter out = response.getWriter();
		String c = request.getParameter("cor");
		out.println("<h1>Cervejas sugeridas<h1/><br/>");
		
		//Criando uma variável com os métodos da classe CervejaExpert
		CervejaExpert ce = new CervejaExpert();
		//Pega a cor escolhida e traz as marcas
		List<String> resultado = ce.getMarcas(c);
		request.setAttribute("marcas",resultado);
		//E manda para o Visualizador
		RequestDispatcher rd = request.getRequestDispatcher("resultado.jsp");
		rd.forward(request, response);
	}

}
