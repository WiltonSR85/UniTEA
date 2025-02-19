package unitea.model;

import org.eclipse.jdt.internal.compiler.ast.ThisReference;
import org.json.JSONObject;

public class PedidoMonitoriaModel {

	private int idPedido;
	private FamiliarModel solicitante;
	private MonitorModel monitor;
	private AlunoModel aluno;
	private String informacoes;
	private String status;
	private String nomeChat;
	private String disciplina;
	private ChatModel chat;
	
	public PedidoMonitoriaModel() {
		
	}

	public PedidoMonitoriaModel(int idPedido, FamiliarModel solicitante, MonitorModel monitor, AlunoModel aluno, String informacoes,
			String status, String nomeChat, String disciplina) {
		this.idPedido = idPedido;
		this.solicitante = solicitante;
		this.monitor = monitor;
		this.aluno = aluno;
		this.informacoes = informacoes;
		this.status = status;
		this.nomeChat= nomeChat;
		this.disciplina= disciplina;
	}
	
	public PedidoMonitoriaModel( FamiliarModel solicitante, AlunoModel aluno, String informacoes,
			String status, String nomeChat,  String disciplina) {
		this.solicitante = solicitante;
		this.aluno = aluno;
		this.informacoes = informacoes;
		this.status = status;
		this.nomeChat= nomeChat;
		this.disciplina= disciplina;
	}
	
	public PedidoMonitoriaModel(int idPedido, FamiliarModel solicitante, AlunoModel aluno, String informacoes,
			String status, String nomeChat, String disciplina) {
		this.idPedido = idPedido;
		this.solicitante = solicitante;
		this.aluno = aluno;
		this.informacoes = informacoes;
		this.status = status;
		this.nomeChat= nomeChat;
		this.disciplina= disciplina;
	}
	
	public PedidoMonitoriaModel(int idPedido, FamiliarModel solicitante, AlunoModel aluno, String informacoes, String disciplina) {
		this.idPedido = idPedido;
		this.solicitante = solicitante;
		this.aluno = aluno;
		this.informacoes = informacoes;
		this.disciplina= disciplina;
	}
	
	public PedidoMonitoriaModel(int idPedido, FamiliarModel solicitante, AlunoModel aluno, MonitorModel monitor,  String informacoes, String disciplina, String nomeChat) {
		this.idPedido = idPedido;
		this.solicitante = solicitante;
		this.aluno = aluno;
		this.monitor = monitor;
		this.informacoes = informacoes;
		this.disciplina= disciplina;
		this.nomeChat= nomeChat;
	}
	
	public PedidoMonitoriaModel(ChatModel chat) {
		this.chat= chat;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public FamiliarModel getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(FamiliarModel solicitante) {
		this.solicitante = solicitante;
	}

	public MonitorModel getMonitor() {
		return monitor;
	}

	public void setMonitor(MonitorModel monitor) {
		this.monitor = monitor;
	}

	public AlunoModel getAluno() {
		return aluno;
	}

	public void setAluno(AlunoModel aluno) {
		this.aluno = aluno;
	}

	public String getInformacoes() {
		return informacoes;
	}

	public void setInformacoes(String informacoes) {
		this.informacoes = informacoes;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	

	public String getNomeChat() {
		return nomeChat;
	}

	public void setNomeChat(String nomeChat) {
		this.nomeChat = nomeChat;
	}
	

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public ChatModel getChat() {
		return chat;
	}

	public void setChat(ChatModel chat) {
		this.chat = chat;
	}
	
	

	/*public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("id_pedido", this.idPedido);
        json.put("id_monitor", this.monitor);
        json.put("id_familiar", this.solicitante);
        json.put("id_aluno", this.aluno);
        json.put("informacoes", this.informacoes);
        json.put("status", this.status);
        json.put("nomechat", this.nomeChat);
        json.put("disciplina", this.disciplina);
        return json;
    }
	
	public JSONObject toJsonM() {
        JSONObject json = new JSONObject();
        json.put("id_pedido", this.idPedido);
        json.put("id_familiar", this.solicitante);
        json.put("id_aluno", this.aluno);
        json.put("informacoes", this.informacoes);
        json.put("status", this.status);
        json.put("nomechat", this.nomeChat);
        json.put("disciplina", this.disciplina);
        return json;
    }

    public PedidoMonitoriaModel fromJson(JSONObject json) {
        int idPedido = json.getInt("id_pedido");
        int idMonitor = json.getInt("id_monitor");
        int idFamiliar = json.getInt("id_familiar");
        int idAluno = json.getInt("id_aluno");
        String informacoes = json.getString("informacoes");
        String status = json.getString("status");
        String nomechat= json.getString("nomechat");
        String disciplina= json.getString("disciplina");
        return new PedidoMonitoriaModel(idPedido, idMonitor, idFamiliar, idAluno, informacoes, status, nomechat, disciplina);
    }*/
	
}
