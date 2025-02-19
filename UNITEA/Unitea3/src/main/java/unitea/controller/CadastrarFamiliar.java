package unitea.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import unitea.dao.FamiliarDao;
import unitea.model.AlunoModel;
import unitea.model.FamiliarModel;
import unitea.model.UsuarioModel;

import java.io.IOException;

/**
 * Servlet implementation class CadastrarFamiliar
 */
//@WebServlet("/cadastrarFamiliar")
public class CadastrarFamiliar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CadastrarFamiliar() {
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
		
		String nome= request.getParameter("nome");
		String email= request.getParameter("email");
		String senha= request.getParameter("senha");
		String endereco= request.getParameter("endereco");
		String perfil= request.getParameter("perfil");
		String nomeAluno= request.getParameter("nomeDoAluno");
		String turma= request.getParameter("turma");
		String diagnostico= request.getParameter("diagnostico");
		String mensagem;
		
		System.out.println("1- " + nome + ". " + email + ". " + senha + ". " + endereco + ". " + perfil + ". " + nomeAluno + ". " + turma + ". " + diagnostico);
		
		RequestDispatcher dispatcher= request.getRequestDispatcher("cadastrofamiliar.jsp");
		
		if(nome !=null && !nome.isEmpty() && email !=null
				&& !email.isEmpty() && senha !=null && !senha.isEmpty()
				&& endereco != null && !endereco.isEmpty() &&
				perfil !=null && !perfil.isEmpty() &&
				nomeAluno!=null && !nomeAluno.isEmpty() &&
				turma!=null && !turma.isEmpty() &&
				diagnostico!=null && !diagnostico.isEmpty()) {
			

			FamiliarModel familiar= new FamiliarModel(nome, email, senha, endereco, perfil);
			AlunoModel aluno= new AlunoModel(nomeAluno, diagnostico, turma);
			//usuario.cadastrar();
			familiar.cadastrarFamiliar(aluno);
			System.out.println(familiar.getNome());
			System.out.println(familiar.getEmail());
			System.out.println(familiar.getSenha());
			System.out.println(familiar.getEndereco());
			System.out.println(familiar.getPerfil());
			System.out.println(aluno.getNome());
			System.out.println(aluno.getDiagnosticoTEA());
			System.out.println(aluno.getTurma());
			mensagem= "Usuário cadastrado com sucesso!";
			request.setAttribute("mensagem", mensagem);			
			dispatcher.forward(request, response);
		}
		
		else {
			mensagem= "Os campos precisam ser preenchidos";
			request.setAttribute("mensagem", mensagem);			
			dispatcher.forward(request, response);
		}
	}

}
