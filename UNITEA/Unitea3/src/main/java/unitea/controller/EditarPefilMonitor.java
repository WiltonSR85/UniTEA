package unitea.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import unitea.dao.EditarPerfilDao;
import unitea.model.AlunoModel;
import unitea.model.FamiliarModel;
import unitea.model.MonitorModel;
import unitea.model.UsuarioModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Servlet implementation class EditarPefilMonitor
 */
//@WebServlet("/EditarPefilMonitor")
public class EditarPefilMonitor extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarPefilMonitor() {
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
		
		HttpSession session = request.getSession();
		int idUsuario = (Integer) session.getAttribute("id_usuarioMonitor");
        int idMentor = (Integer) session.getAttribute("id_mentor");
		
		String nome= request.getParameter("nome");
		String email= request.getParameter("email");
		String endereco= request.getParameter("endereco");
		String especializacao= request.getParameter("especializacao");
		String anosExperiencia= request.getParameter("anosExperiencia");
		String formacaoAcademica= request.getParameter("formacaoAcademica");
		String mensagem;
		EditarPerfilDao editarDao= new EditarPerfilDao();
		
		int anosExperiencia1= Integer.parseInt(anosExperiencia);
		System.out.println(nome);
		System.out.println(email);
		System.out.println(endereco);
		System.out.println(especializacao);
		System.out.println(anosExperiencia1);
		System.out.println(formacaoAcademica);
		
		List<String> disciplinas = new ArrayList<>();
	    for (int i = 1; i <= 4; i++) {
	        String disciplina = request.getParameter("disciplina" + i);
	        if (disciplina != null && !disciplina.isEmpty()) {
	            disciplinas.add(disciplina);
	        }
	    }
	    
	    MonitorModel monitor1= new MonitorModel(idMentor,anosExperiencia1, formacaoAcademica, especializacao, disciplinas);
		monitor1.exibirDisciplinas();
	    
		RequestDispatcher dispatcher= request.getRequestDispatcher("perfilMentor.jsp");
		
		if(nome !=null && !nome.isEmpty() && email !=null
				&& !email.isEmpty() && endereco != null && !endereco.isEmpty() &&
				especializacao!=null && !especializacao.isEmpty() &&
				anosExperiencia!=null && !anosExperiencia.isEmpty() &&
				formacaoAcademica!=null && !formacaoAcademica.isEmpty()) {
			
			UsuarioModel usuario= new UsuarioModel(idUsuario,nome, email, endereco);
			MonitorModel monitor= new MonitorModel(idMentor,anosExperiencia1, formacaoAcademica, especializacao, disciplinas);
			//usuario.cadastrar();
			usuario.editarPerfilMonitor(monitor);
			//editarDao.atualizarMentor(request);
			
			session.setAttribute("id_usuario", usuario.getIdUsuario());
            session.setAttribute("nomeMonitor", nome);
            session.setAttribute("emailMonitor", email);
            session.setAttribute("enderecoMonitor", endereco);
            
            session.setAttribute("especializacao", especializacao);
            session.setAttribute("anosExperiencia", anosExperiencia);
            session.setAttribute("formacaoAcademica", formacaoAcademica);
            
            session.setAttribute("disciplinas", monitor.getDisciplinas());
            
            int f = 1; 
            for (String disciplina : monitor.getDisciplinas()) {
                session.setAttribute("disciplina" + f, disciplina);
                f++;
            }
            
			System.out.println(usuario.getNome());
			System.out.println(usuario.getEmail());
			System.out.println(usuario.getSenha());
			System.out.println(usuario.getEndereco());
			System.out.println(usuario.getPerfil());
			System.out.println(monitor.getAnosExperiencia());
			System.out.println(monitor.getEspecializacao());
			System.out.println(monitor.getFormacaoAcademica());
			monitor.exibirDisciplinas();
			mensagem= "Usuário editado com sucesso!";
			request.setAttribute("mensagem", mensagem);			
			dispatcher.forward(request, response);
		}else {
			mensagem= "Os campos precisam ser preenchidos";
			request.setAttribute("mensagem", mensagem);			
			dispatcher.forward(request, response);
		}
	
	}

}
