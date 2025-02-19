package unitea.model;

import java.util.ArrayList;
import java.util.List;

public class ChatModel {

	private int idChat;
	private int idMonitor;
	private int idFamiliar;
	private int idPedidoMonitoriaAssociado;
	private String nomeChat;
	private List<Mensagem> mensagens;
	
	public ChatModel () {
		
	}

	public ChatModel(int idChat, int idMonitor, int idFamiliar,
			int pedidoMonitoriaAssociado, String nomeChat) {
		this.idChat = idChat;
		this.idMonitor = idMonitor;
		this.idFamiliar = idFamiliar;
		this.idPedidoMonitoriaAssociado = pedidoMonitoriaAssociado;
		this.nomeChat= nomeChat;
	}
	
	public ChatModel(int idMonitor, int idFamiliar,
			int pedidoMonitoriaAssociado, String nomeChat) {
		this.idMonitor = idMonitor;
		this.idFamiliar = idFamiliar;
		this.idPedidoMonitoriaAssociado = pedidoMonitoriaAssociado;
		this.nomeChat= nomeChat;
		this.mensagens= new ArrayList<>();
	}

	public int getIdChat() {
		return idChat;
	}

	public void setIdChat(int idChat) {
		this.idChat = idChat;
	}

	public int getIdMonitor() {
		return idMonitor;
	}

	public void setIdMonitor(int idMonitor) {
		this.idMonitor = idMonitor;
	}

	public int getIdFamiliar() {
		return idFamiliar;
	}

	public void setIdFamiliar(int idFamiliar) {
		this.idFamiliar = idFamiliar;
	}

	public int getIdPedidoMonitoriaAssociado() {
		return idPedidoMonitoriaAssociado;
	}

	public void setIdPedidoMonitoriaAssociado(int idPedidoMonitoriaAssociado) {
		this.idPedidoMonitoriaAssociado = idPedidoMonitoriaAssociado;
	}

	public String getNomeChat() {
		return nomeChat;
	}

	public void setNomeChat(String nomeChat) {
		this.nomeChat = nomeChat;
	}

	public List<Mensagem> getMensagens() {
		return mensagens;
	}

	public void setMensagens(List<Mensagem> mensagens) {
		this.mensagens = mensagens;
	}
	
}
