package unitea.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.CriarChatDao;
import unitea.dao.EditarPedidoDao;
import unitea.model.ChatModel;
import unitea.model.FamiliarModel;
import unitea.model.PedidoMonitoriaModel;

import java.io.IOException;

/**
 * Servlet implementation class EditarPedido
 */
//@WebServlet("/EditarPedido")
public class EditarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
		
		String disciplina = request.getParameter("disciplina");
		
		String nomeChat = request.getParameter("nomeChat"); 
		
		String informacoes = request.getParameter("informacoesAdicionais");
		
		//EditarPedidoDao editar= new EditarPedidoDao();
		
		//editar.editarPedido(disciplina, nomeChat, informacoes, idPedido);
		
		FamiliarModel familiar= new FamiliarModel();
		
		familiar.editarPedido(disciplina, nomeChat, informacoes, idPedido);
		
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
