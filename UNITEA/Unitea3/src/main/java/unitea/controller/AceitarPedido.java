package unitea.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.AceitarPedidoDao;
import unitea.model.MonitorModel;

import java.io.IOException;

/**
 * Servlet implementation class AceitarPedido
 */
//@WebServlet("/AceitarPedido")
public class AceitarPedido extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AceitarPedido() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		int idMonitor= (Integer) session.getAttribute("id_mentor");
		
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
		
		//AceitarPedidoDao aceitar= new AceitarPedidoDao();
		
		//aceitar.aceitarPedido(idPedido, idMonitor);
		
		MonitorModel monitor= new MonitorModel();
		
		monitor.aceitarPedido(idPedido, idMonitor);
		
		request.getRequestDispatcher("mostrarPendentes").forward(request, response);
	}

}
