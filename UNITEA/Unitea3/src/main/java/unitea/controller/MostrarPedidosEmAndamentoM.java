package unitea.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.MostrarPedidosEmAndamentoFDao;
import unitea.model.PedidoMonitoriaModel;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class MostrarPedidosEmAndamentoM
 */
//@WebServlet("/MostrarPedidosEmAndamentoM")
public class MostrarPedidosEmAndamentoM extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarPedidosEmAndamentoM() {
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
		int idMonitor= (Integer) session.getAttribute("id_mentor");
		
		MostrarPedidosEmAndamentoFDao tela= new MostrarPedidosEmAndamentoFDao();
		
		List<PedidoMonitoriaModel> listaDePedidos =tela.listarPedidosTelaInicialM(idMonitor); 
		session.setAttribute("pedidos3", listaDePedidos);
		
		
		/*request.setAttribute("pedidos", listaDePedidos);*/
	
		response.sendRedirect("telaMentor.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
