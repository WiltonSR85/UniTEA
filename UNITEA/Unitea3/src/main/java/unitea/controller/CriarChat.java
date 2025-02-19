package unitea.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.AceitarPedidoDao;
import unitea.dao.CriarChatDao;
import unitea.model.ChatModel;
import unitea.model.PedidoMonitoriaModel;

import java.io.IOException;

/**
 * Servlet implementation class CriarCHat
 */
//@WebServlet("/CriarChat")
public class CriarChat extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CriarChat() {
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
		
		HttpSession session = request.getSession();
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
		
		String idFamiliarString = request.getParameter("idFamiliar");
		int idFamiliar = 0;  

		if (idFamiliarString != null && !idFamiliarString.isEmpty()) {
		    try {
		        idFamiliar = Integer.parseInt(idFamiliarString);
		    } catch (NumberFormatException e) {
		        System.out.println("Erro ao converter idFamiliar para int: " + e.getMessage());
		    }
		} else {
		    System.out.println("O parâmetro idFamiliar não foi fornecido.");
		}
		
		String idMonitorString = request.getParameter("idMonitor");
		int idMonitor = 0;  

		if (idMonitorString != null && !idMonitorString.isEmpty()) {
		    try {
		        idMonitor = Integer.parseInt(idMonitorString);
		    } catch (NumberFormatException e) {
		        System.out.println("Erro ao converter idMonitor para int: " + e.getMessage());
		    }
		} else {
		    System.out.println("O parâmetro idMonitor não foi fornecido.");
		}
		
		String nomeChat = request.getParameter("nomeChat");
		
		ChatModel chat= new ChatModel(idMonitor,idFamiliar, idPedido, nomeChat);
		
		session.setAttribute("chat", chat);
		
		CriarChatDao criar= new CriarChatDao();
		
		PedidoMonitoriaModel pedido= criar.CriandoChat(chat);
		session.setAttribute("pedido", pedido);
		
		System.out.println(pedido.getChat().getIdPedidoMonitoriaAssociado());
		
		request.getRequestDispatcher("Chat.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
