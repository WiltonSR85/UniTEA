package unitea.model;

import java.util.ArrayList;
import java.util.List;

import unitea.dao.FamiliarDao;
import unitea.dao.MostrarPedidosCriadosFamiliarDao;
import unitea.dao.CriarPedidoDao;
import unitea.dao.EditarPedidoDao;
import unitea.dao.ExcluirPedidoDao;

public class FamiliarModel extends UsuarioModel{
	
	private int idFamiliar;
	

	public FamiliarModel(int idUsuario, String nome, String email, String senha, String endereco, String perfil, int idFamiliar) {
		super(idUsuario, nome, email, senha, endereco, perfil);
		this.idFamiliar= idFamiliar;
	}
	
	public FamiliarModel(int idFamiliar) {
		this.idFamiliar= idFamiliar;
	}

	public FamiliarModel() {
		
	}
	
	public FamiliarModel( String nome, String email, String senha, String endereco, String perfil) {
		super(nome, email, senha, endereco, perfil);
	}
	
	public FamiliarModel( String nome, int idFamiliar) {
		super(nome);
		this.idFamiliar= idFamiliar;
	}
	
	
	public FamiliarModel( String nome) {
		super(nome);
	}
	public int getIdFamiliar() {
		return idFamiliar;
	}


	public void setIdFamiliar(int idFamiliar) {
		this.idFamiliar = idFamiliar;
	}

	public void cadastrarFamiliar(AlunoModel aluno) {
		FamiliarDao familiar= new FamiliarDao();
		
		familiar.cadastrarFamiliar(this, aluno);
	}
	
	public void criarPedido(PedidoMonitoriaModel pedido) {
		CriarPedidoDao criando= new CriarPedidoDao();
		
		criando.CriarPedido(pedido);
	}
	
	public void editarPedido(String disciplina, String nomeChat, String informacoes, int idPedido) {
		EditarPedidoDao editar= new EditarPedidoDao();
		
		editar.editarPedido(disciplina, nomeChat, informacoes, idPedido);
	}
	
	public void excluirPedido(int idPedido) {
		
		ExcluirPedidoDao excluir= new ExcluirPedidoDao();
		
		excluir.excluirPedido(idPedido);
	}
	
	public List<PedidoMonitoriaModel> visualizarPedidos() {
	    MostrarPedidosCriadosFamiliarDao dao = new MostrarPedidosCriadosFamiliarDao();
	    return dao.listarPedidos(this.idFamiliar);
	}

}
