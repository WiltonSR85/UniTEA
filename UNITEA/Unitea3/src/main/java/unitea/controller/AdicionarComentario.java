package unitea.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.AdicionarComentarioDao;
import unitea.dao.CriarChatDao;
import unitea.model.ChatModel;
import unitea.model.Mensagem;
import unitea.model.PedidoMonitoriaModel;
import unitea.model.UsuarioModel;

import java.io.IOException;

/**
 * Servlet implementation class adicionarComentario
 */
//@WebServlet("/adicionarComentario")
public class AdicionarComentario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdicionarComentario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		String idChatString = request.getParameter("idChat");
		int idChat = 0;  

		if (idChatString != null && !idChatString.isEmpty()) {
		    try {
		        idChat = Integer.parseInt(idChatString);
		    } catch (NumberFormatException e) {
		        System.out.println("Erro ao converter idChat para int: " + e.getMessage());
		    }
		} else {
		    System.out.println("O parâmetro idChat não foi fornecido.");
		}
		
		String idUsuarioString = request.getParameter("usuario");
		int idUsuario = 0;  

		if (idUsuarioString != null && !idUsuarioString.isEmpty()) {
		    try {
		        idUsuario = Integer.parseInt(idUsuarioString);
		    } catch (NumberFormatException e) {
		        System.out.println("Erro ao converter idUsuario para int: " + e.getMessage());
		    }
		} else {
		    System.out.println("O parâmetro idUsuario não foi fornecido.");
		}
		
		String conteudo = request.getParameter("mensagem");
		
		Mensagem mensagem= new Mensagem(idChat, conteudo, idUsuario);
		
		//AdicionarComentarioDao adicionar= new AdicionarComentarioDao();
		
		//adicionar.AdicionarComentario(mensagem);
		UsuarioModel usuario= new UsuarioModel();
		
		usuario.adicionarComentario(mensagem);
		
		CriarChatDao criar= new CriarChatDao();
		
		ChatModel chat= (ChatModel) session.getAttribute("chat");
		
		chat.getMensagens().clear();
		
		session.removeAttribute("pedido");
		
		PedidoMonitoriaModel pedido= criar.CriandoChat(chat);
		session.setAttribute("pedido", pedido);
		
		//request.getRequestDispatcher("Chat.jsp").forward(request, response);
		response.sendRedirect("Chat.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
