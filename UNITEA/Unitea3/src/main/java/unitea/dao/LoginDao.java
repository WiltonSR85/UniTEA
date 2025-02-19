package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import unitea.model.AlunoModel;
import unitea.model.FamiliarModel;
import unitea.model.MonitorModel;
import unitea.model.UsuarioModel;

public class LoginDao {


    public UsuarioModel obterUsuario(String email, String senha) {
        UsuarioModel usuario = null;
        Connection conn = null;
        try {
        	conn = new MysqlConnection().getConnection();
            String query3 = "SELECT id_usuario, nome, email, senha, endereco, perfil FROM usuario WHERE email = ? AND senha = ?";
            PreparedStatement stmt3 = conn.prepareStatement(query3);
            stmt3.setString(1, email);
            stmt3.setString(2, senha);

            ResultSet rs3 = stmt3.executeQuery();

            if (rs3.next()) {
                usuario = new UsuarioModel();
                usuario.setIdUsuario(rs3.getInt("id_usuario"));
                usuario.setNome(rs3.getString("nome"));
                usuario.setEmail(rs3.getString("email"));
                usuario.setSenha(rs3.getString("senha"));
                usuario.setEndereco(rs3.getString("endereco"));
                usuario.setPerfil(rs3.getString("perfil"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return usuario;
    }

    public FamiliarModel buscarFamiliar(String email, String senha) {
        FamiliarModel familiar = null;
        Connection conn = null;
        try {
        	conn = new MysqlConnection().getConnection();

            String query3 = "SELECT id_usuario, nome, email, senha, endereco, perfil FROM usuario WHERE email = ? AND senha = ?";
            PreparedStatement stmt3 = conn.prepareStatement(query3);
            stmt3.setString(1, email);
            stmt3.setString(2, senha);
            ResultSet rs3 = stmt3.executeQuery();

            if (rs3.next()) {
                familiar = new FamiliarModel();
                familiar.setIdUsuario(rs3.getInt("id_usuario"));
                familiar.setNome(rs3.getString("nome"));
                familiar.setEmail(rs3.getString("email"));
                familiar.setSenha(rs3.getString("senha"));
                familiar.setEndereco(rs3.getString("endereco"));
                familiar.setPerfil(rs3.getString("perfil"));

                String query1 = "SELECT id_familiar FROM familiar WHERE id_usuario = ?";
                PreparedStatement stmt1 = conn.prepareStatement(query1);
                stmt1.setInt(1, familiar.getIdUsuario());
                ResultSet rs1 = stmt1.executeQuery();

                if (rs1.next()) {
                    familiar.setIdFamiliar(rs1.getInt("id_familiar"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return familiar;
    }

    public AlunoModel buscarAluno(int idFamiliar) {
        AlunoModel aluno = null;
        Connection conn = null;
        try {
        	conn = new MysqlConnection().getConnection();
            String query2 = "SELECT id_aluno, nome, turma, diagnosticoTEA FROM aluno WHERE id_familiar = ?";
            PreparedStatement stmt2 = conn.prepareStatement(query2);
            stmt2.setInt(1, idFamiliar);
            ResultSet rs2 = stmt2.executeQuery();

            if (rs2.next()) {
                aluno = new AlunoModel();
                aluno.setIdAluno(rs2.getInt("id_aluno"));
                aluno.setNome(rs2.getString("nome"));
                aluno.setTurma(rs2.getString("turma"));
                aluno.setDiagnosticoTEA(rs2.getString("diagnosticoTEA"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return aluno;
    }

    public MonitorModel buscarMentor(String email, String senha) {
    	MonitorModel mentor = null;
        Connection conn = null;
        try {
        	conn = new MysqlConnection().getConnection();

            String query3 = "SELECT id_usuario, nome, email, senha, endereco, perfil FROM usuario WHERE email = ? AND senha = ?";
            PreparedStatement stmt3 = conn.prepareStatement(query3);
            stmt3.setString(1, email);
            stmt3.setString(2, senha);
            ResultSet rs3 = stmt3.executeQuery();

            if (rs3.next()) {
                mentor = new MonitorModel();
                mentor.setIdUsuario(rs3.getInt("id_usuario"));
                mentor.setNome(rs3.getString("nome"));
                mentor.setEmail(rs3.getString("email"));
                mentor.setSenha(rs3.getString("senha"));
                mentor.setEndereco(rs3.getString("endereco"));
                mentor.setPerfil(rs3.getString("perfil"));

                String query2 = "SELECT id_monitor, especializacao, anosExperiencia, formacaoAcademica, disciplinas FROM monitor WHERE id_usuario = ?";
                PreparedStatement stmt2 = conn.prepareStatement(query2);
                stmt2.setInt(1, mentor.getIdUsuario());
                ResultSet rs2 = stmt2.executeQuery();

                if (rs2.next()) {
                    mentor.setIdMonitor(rs2.getInt("id_monitor"));
                    mentor.setEspecializacao(rs2.getString("especializacao"));
                    mentor.setAnosExperiencia(rs2.getInt("anosExperiencia"));
                    mentor.setFormacaoAcademica(rs2.getString("formacaoAcademica"));
                    
                    String disciplinasJson = rs2.getString("disciplinas");
                    if (disciplinasJson != null && !disciplinasJson.isEmpty()) {
                        try {
                            org.json.JSONArray jsonArray = new org.json.JSONArray(disciplinasJson);
                            List<String> disciplinas = new ArrayList<>();

                            for (int i = 0; i < jsonArray.length(); i++) {
                                disciplinas.add(jsonArray.getString(i)); 
                            }
                            mentor.setDisciplinas(disciplinas);;

                        } catch (Exception e) {
                            e.printStackTrace(); 
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return mentor;
    }
}
