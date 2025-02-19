package unitea.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;

import unitea.dao.AceitarPedidoDao;
import unitea.dao.MonitorDao;
import unitea.dao.MostrarPedidosCriadosFamiliarDao;
import unitea.dao.MostrarPedidosPendentesMonitorDao;

public class MonitorModel extends UsuarioModel{

	private int idMonitor;
	private int anosExperiencia;
	private String formacaoAcademica;
	private String especializacao;
	private List<String> disciplinas;
	
	public MonitorModel() {
		
	}

	public MonitorModel(int idMonitor, int anosExperiencia, String formacaoAcademica, String especializacao, List<String> disciplinas) {
		this.idMonitor= idMonitor;
		this.anosExperiencia = anosExperiencia;
		this.formacaoAcademica = formacaoAcademica;
		this.especializacao = especializacao;
		this.disciplinas = disciplinas;
	}
	
	public MonitorModel(String nome, String email, String senha, String endereco, String perfil, int anosExperiencia, String formacaoAcademica, String especializacao, List<String> disciplinas) {
		super( nome, email, senha, endereco, perfil);
		this.anosExperiencia = anosExperiencia;
		this.formacaoAcademica = formacaoAcademica;
		this.especializacao = especializacao;
		this.disciplinas = disciplinas;
	}
	
	public MonitorModel(String nome) {
		super( nome);
	}
	public MonitorModel(String nome, int idMonitor) {
		super( nome);
		this.idMonitor= idMonitor;
	}
	
	public MonitorModel(int idMonitor) {
		this.idMonitor= idMonitor;
	}

	public int getIdMonitor() {
		return idMonitor;
	}

	public void setIdMonitor(int idMonitor) {
		this.idMonitor = idMonitor;
	}

	public int getAnosExperiencia() {
		return anosExperiencia;
	}

	public void setAnosExperiencia(int anosExperiencia) {
		this.anosExperiencia = anosExperiencia;
	}

	public String getFormacaoAcademica() {
		return formacaoAcademica;
	}

	public void setFormacaoAcademica(String formacaoAcademica) {
		this.formacaoAcademica = formacaoAcademica;
	}

	public String getEspecializacao() {
		return especializacao;
	}

	public void setEspecializacao(String especializacao) {
		this.especializacao = especializacao;
	}

	

	public List<String> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<String> disciplinas) {
		this.disciplinas = disciplinas;
	}

	
	
	public String getDisciplinasAsJson() {
	    JSONArray jsonArray = new JSONArray(this.disciplinas);
	    return jsonArray.toString();
	}
	
	public void setDisciplinasFromJson(String json) {
	    JSONArray jsonArray = new JSONArray(json);
	    this.disciplinas = new ArrayList<>();
	    for (int i = 0; i < jsonArray.length(); i++) {
	        this.disciplinas.add(jsonArray.getString(i));
	    }
	}
	
	public void exibirDisciplinas() {
		System.out.println("As disciplinas são");
		for(String disciplina : disciplinas) {
			System.out.println(disciplina);
		}
	}
	
	public void dividirDisciplinas(String json) {

	    JSONArray jsonArray = new JSONArray(json);

	    String disciplina1 = (jsonArray.length() > 0) ? jsonArray.getString(0) : "N/A";
	    String disciplina2 = (jsonArray.length() > 1) ? jsonArray.getString(1) : "N/A";
	    String disciplina3 = (jsonArray.length() > 2) ? jsonArray.getString(2) : "N/A";
	    String disciplina4 = (jsonArray.length() > 3) ? jsonArray.getString(3) : "N/A";

	    System.out.println("Disciplina 1: " + disciplina1);
	    System.out.println("Disciplina 2: " + disciplina2);
	    System.out.println("Disciplina 3: " + disciplina3);
	    System.out.println("Disciplina 4: " + disciplina4);
	}
	
	public void cadastrarMonitor() {
		MonitorDao monitorDao= new MonitorDao();
		
		monitorDao.cadastrarMonitor( this);
	}
	
	public void aceitarPedido(int idPedido, int idMonitor) {
		
		AceitarPedidoDao aceitar= new AceitarPedidoDao();
		
		aceitar.aceitarPedido(idPedido, idMonitor);
	}
	
	public List<PedidoMonitoriaModel> mostrarPendentesMonitor() {
		MostrarPedidosPendentesMonitorDao mostrar= new MostrarPedidosPendentesMonitorDao();
		
		return mostrar.listarPedidosMonitor(this);
	}

}
