
package unitea.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.LoginDao;
import unitea.model.AlunoModel;
import unitea.model.FamiliarModel;
import unitea.model.MonitorModel;
import unitea.model.UsuarioModel;

import java.io.IOException;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
	    
	    String email = request.getParameter("Email");
	    String senha = request.getParameter("Senha");
	    
	    LoginDao login = new LoginDao();
	    
	    UsuarioModel usuario = login.obterUsuario(email, senha);
	    
	    if (usuario == null) {  
	        request.setAttribute("mensagem", "Email ou senha incorretos.");
	        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	        dispatcher.forward(request, response);
	    } else {

	        if ("familiar".equalsIgnoreCase(usuario.getPerfil())) {
	            FamiliarModel familiar = login.buscarFamiliar(email, senha);
	            AlunoModel aluno = login.buscarAluno(familiar.getIdFamiliar());
	            
	            HttpSession session = request.getSession();
	            
	            session.setAttribute("id_usuario", familiar.getIdUsuario());
	            session.setAttribute("id_usuarioFamiliar", familiar.getIdUsuario());
	            session.setAttribute("nomeFamiliar", familiar.getNome());
	            session.setAttribute("emailFamiliar", familiar.getEmail());
	            session.setAttribute("senhaFamiliar", familiar.getSenha());
	            session.setAttribute("enderecoFamiliar", familiar.getEndereco());
	            session.setAttribute("perfilFamiliar", familiar.getPerfil());
	            
	            session.setAttribute("id_familiar", familiar.getIdFamiliar());
	            session.setAttribute("id_aluno", aluno.getIdAluno());
	            session.setAttribute("nomeAluno", aluno.getNome());
	            session.setAttribute("turma", aluno.getTurma());
	            session.setAttribute("diagnostico", aluno.getDiagnosticoTEA());
	            
	            response.sendRedirect("telaInicial");
	        } else if ("mentor".equalsIgnoreCase(usuario.getPerfil())) {
	            MonitorModel monitor = login.buscarMentor(email, senha);
	            
	            HttpSession session = request.getSession();
	            session.setAttribute("id_usuario", monitor.getIdUsuario());
	            session.setAttribute("id_usuarioMonitor", monitor.getIdUsuario());
	            session.setAttribute("nomeMonitor", monitor.getNome());
	            session.setAttribute("emailMonitor", monitor.getEmail());
	            session.setAttribute("senhaMonitor", monitor.getSenha());
	            session.setAttribute("enderecoMonitor", monitor.getEndereco());
	            session.setAttribute("perfilMonitor", monitor.getPerfil());
	            
	            session.setAttribute("id_mentor", monitor.getIdMonitor());
	            session.setAttribute("especializacao", monitor.getEspecializacao());
	            session.setAttribute("anosExperiencia", monitor.getAnosExperiencia());
	            session.setAttribute("formacaoAcademica", monitor.getFormacaoAcademica());
	            session.setAttribute("disciplinas", monitor.getDisciplinas());
	            
	            int f = 1; 
                for (String disciplina : monitor.getDisciplinas()) {
                    session.setAttribute("disciplina" + f, disciplina);
                    f++;
                }

	            
	            response.sendRedirect("telaInicialM");
	        } else {
	            request.setAttribute("mensagem", "Email ou senha incorretos.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
	            dispatcher.forward(request, response);
	        }
	    }
	}
}
