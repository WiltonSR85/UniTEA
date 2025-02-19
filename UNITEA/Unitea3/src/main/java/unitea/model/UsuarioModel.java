package unitea.model;

import unitea.dao.AdicionarComentarioDao;
import unitea.dao.EditarPerfilDao;
import unitea.dao.ExcluirPerfilDao;
import unitea.dao.UsuarioDao;

public class UsuarioModel {
	
	private int idUsuario;
	private String nome;
	private String email;
	private String senha;
	private String endereco;
	private String perfil;
	
	public UsuarioModel() {
		
	}
	
	public UsuarioModel(int idUsuario) {
		this.idUsuario= idUsuario;
	}

	public UsuarioModel(int idUsuario, String nome, String email, String senha, String endereco, String perfil) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.perfil = perfil;
	}
	
	public UsuarioModel(String nome, String email, String senha, String endereco, String perfil) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.endereco = endereco;
		this.perfil = perfil;
	}
	
	public UsuarioModel(int idUsuario, String nome, String email, String endereco) {
		this.idUsuario = idUsuario;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
	}
	
	public UsuarioModel(String nome) {
		this.nome = nome;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getPerfil() {
		return perfil;
	}

	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	
	public void cadastrar() {
		new UsuarioDao().cadastrarUsuario(this);
		System.out.println("Usuario cadastrado!");
	}
	
	public void editarPerfilMonitor(MonitorModel monitor) {
		EditarPerfilDao editar= new EditarPerfilDao();
		
		editar.editarPerfilMonitor(this, monitor);
	}
	
	public void editarPerfilFamiliar(FamiliarModel familiar, AlunoModel aluno) {
		EditarPerfilDao editar= new EditarPerfilDao();
		
		editar.editarPerfilFamiliar(this, familiar, aluno);
	}
	
	public void excluirPerfil() {
		
		ExcluirPerfilDao excluir= new ExcluirPerfilDao();
		excluir.excluirPerfil(this.idUsuario);
	}
	
	public void adicionarComentario(Mensagem mensagem) {
		AdicionarComentarioDao adicionar= new AdicionarComentarioDao();
		
		adicionar.AdicionarComentario(mensagem);

	}

}
