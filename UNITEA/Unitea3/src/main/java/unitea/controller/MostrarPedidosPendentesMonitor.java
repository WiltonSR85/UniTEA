package unitea.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.MostrarPedidosPendentesMonitorDao;
import unitea.model.MonitorModel;
import unitea.model.PedidoMonitoriaModel;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class MostrarPedidosPendentesMonitor
 */
//@WebServlet("/MostrarPedidosPendentesMonitor")
public class MostrarPedidosPendentesMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarPedidosPendentesMonitor() {
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
		
		MonitorModel monitor= new MonitorModel(idMonitor);
		
		//MostrarPedidosPendentesMonitorDao mostrar= new MostrarPedidosPendentesMonitorDao();
		
		List<PedidoMonitoriaModel> listaDePedidos =monitor.mostrarPendentesMonitor(); 
		session.setAttribute("pedidos", listaDePedidos);
		
		
		request.getRequestDispatcher("pedidosMonitor.jsp").forward(request, response);
	}

}
