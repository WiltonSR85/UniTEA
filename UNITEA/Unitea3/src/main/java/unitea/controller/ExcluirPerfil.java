package unitea.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.ExcluirPerfilDao;
import unitea.model.UsuarioModel;

import java.io.IOException;

/**
 * Servlet implementation class ExcluirPerfil
 */
@WebServlet("/ExcluirPerfil")
public class ExcluirPerfil extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExcluirPerfil() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		HttpSession session1 = request.getSession();
        int idUsuario = (Integer) session1.getAttribute("id_usuario");
        //int idFamiliar = (Integer) session.getAttribute("id_familiar");
		
		UsuarioModel usuario= new UsuarioModel(idUsuario);
		
		usuario.excluirPerfil();
		
		HttpSession session = request.getSession(false); 

        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect("login.jsp");
	}

}
