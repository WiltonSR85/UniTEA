package unitea.model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

public class AlunoModel {

	private int idAluno;
	private String nome;
	private int responsavel;
	private String diagnosticoTEA;
	private String turma;
	
	public AlunoModel() {
		
	}

	public AlunoModel(int idAluno, String nome, int responsavel, String diagnosticoTEA, String turma) {
		this.idAluno = idAluno;
		this.nome = nome;
		this.responsavel = responsavel;
		this.diagnosticoTEA = diagnosticoTEA;
		this.turma = turma;
	}
	public AlunoModel(String nome, String diagnosticoTEA, String turma) {
		this.nome = nome;
		this.diagnosticoTEA = diagnosticoTEA;
		this.turma = turma;
	}
	
	public AlunoModel(int idAluno,String nome, String diagnosticoTEA, String turma) {
		this.idAluno= idAluno;
		this.nome = nome;
		this.diagnosticoTEA = diagnosticoTEA;
		this.turma = turma;
	}
	
	public AlunoModel(int idAluno) {
		this.idAluno = idAluno;
	}		

	public int getIdAluno() {
		return idAluno;
	}

	public void setIdAluno(int idAluno) {
		this.idAluno = idAluno;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(int responsavel) {
		this.responsavel = responsavel;
	}

	public String getDiagnosticoTEA() {
		return diagnosticoTEA;
	}

	public void setDiagnosticoTEA(String diagnosticoTEA) {
		this.diagnosticoTEA = diagnosticoTEA;
	}

	public String getTurma() {
		return turma;
	}

	public void setTurma(String turma) {
		this.turma = turma;
	}

	public JSONObject toJson() {
        JSONObject json = new JSONObject();  
        json.put("id_aluno", idAluno);
        json.put("nome", nome);            
        json.put("turma", turma);
        json.put("diagnostico", diagnosticoTEA);
        return json;  
    }
	
}
