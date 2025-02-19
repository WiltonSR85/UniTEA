package unitea.model;

import java.time.LocalDateTime;

public class Mensagem {

	private int idMensagem;
	private int idChat;
	private int idUsuario;
	private String conteudo;
	
	public Mensagem() {
		
	}
	
	public Mensagem(int idMensagem, int idChat, String conteudo, int idUsuario) {
		this.idMensagem= idMensagem;
		this.idChat= idChat;
		this.conteudo= conteudo;
		this.idUsuario= idUsuario;
	}
	
	public Mensagem( int idChat, String conteudo, int idUsuario) {
		this.idChat= idChat;
		this.conteudo= conteudo;
		this.idUsuario= idUsuario;
	}

	public int getIdMensagem() {
		return idMensagem;
	}

	public void setIdMensagem(int idMensagem) {
		this.idMensagem = idMensagem;
	}

	public int getIdChat() {
		return idChat;
	}

	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
