package unitea.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.MostrarPedidosCriadosFamiliarDao;
import unitea.model.FamiliarModel;
import unitea.model.PedidoMonitoriaModel;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class mostarPedidosCriadosFamiliar
 */
//@WebServlet("/mostarPedidosCriadosFamiliar")
public class MostrarPedidosCriadosFamiliar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MostrarPedidosCriadosFamiliar() {
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
		int idFamiliar= (Integer) session.getAttribute("id_familiar");
		
		MostrarPedidosCriadosFamiliarDao mostrarDao= new MostrarPedidosCriadosFamiliarDao();
		
		List<PedidoMonitoriaModel> listaDePedidos =mostrarDao.listarPedidos(idFamiliar); 
		session.setAttribute("pedidos", listaDePedidos);
		
		
		/*request.setAttribute("pedidos", listaDePedidos);*/
	

		
		request.getRequestDispatcher("pedidosFamiliar.jsp").forward(request, response);
		
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session = request.getSession();
		int idFamiliar= (Integer) session.getAttribute("id_familiar");
		
		System.out.println("o id familiar é:"+ idFamiliar);
		
		FamiliarModel familiar= new FamiliarModel(idFamiliar);
		
		List<PedidoMonitoriaModel> listaDePedidos =familiar.visualizarPedidos(); 
		session.setAttribute("pedidos", listaDePedidos);
		
		
		/*request.setAttribute("pedidos", listaDePedidos);*/
	
		request.getRequestDispatcher("pedidosFamiliar.jsp").forward(request, response);
	}

}
