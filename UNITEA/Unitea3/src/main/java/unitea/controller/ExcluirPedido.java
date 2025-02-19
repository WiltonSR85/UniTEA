package unitea.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import unitea.dao.EditarPedidoDao;
import unitea.dao.ExcluirPedidoDao;
import unitea.model.FamiliarModel;

import java.io.IOException;

/**
 * Servlet implementation class ExcluirPedido
 */
//@WebServlet("/ExcluirPedido")
public class ExcluirPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String idPedidoString = request.getParameter("idPedido");
		int idPedido = 0;  

		if (idPedidoString != null && !idPedidoString.isEmpty()) {
		    try {
		        idPedido = Integer.parseInt(idPedidoString);
		    } catch (NumberFormatException e) {
		        System.out.println("Erro ao converter idPedido para int: " + e.getMessage());
		    }
		} else {
		    System.out.println("O parâmetro idPedido não foi fornecido.");
		}
		
		//ExcluirPedidoDao excluir= new ExcluirPedidoDao();
		
		//excluir.excluirPedido(idPedido);
		
		FamiliarModel familiar= new FamiliarModel();
		familiar.excluirPedido(idPedido);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("mostrarPedidos");
		dispatcher.forward(request, response);
		
		//request.getRequestDispatcher("Chat.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
