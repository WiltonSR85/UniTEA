package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import unitea.model.AlunoModel;
import unitea.model.FamiliarModel;
import unitea.model.MonitorModel;
import unitea.model.UsuarioModel;

public class EditarPerfilDao {

	public void editarPerfilFamiliar( UsuarioModel usuario, FamiliarModel familiar, AlunoModel aluno) {
		
		
        String query = "UPDATE usuario SET nome = ?,email= ?, endereco = ? WHERE id_usuario = ?";
		String queryFamiliar = "UPDATE aluno SET nome = ?, turma = ?, diagnosticoTEA = ? WHERE id_familiar = ?";
		PreparedStatement Stat= null;
		PreparedStatement Stat1= null;
		Connection conn= null;
		
		try {
			conn= new MysqlConnection().getConnection();
			
			if(conn!= null) {
				Stat= conn.prepareStatement(query);
				
				Stat.setString(1, usuario.getNome());
				Stat.setString(2, usuario.getEmail());
				Stat.setString(3, usuario.getEndereco());
				Stat.setInt(4, usuario.getIdUsuario());
				
				Stat.executeUpdate();
				
				Stat1= conn.prepareStatement(queryFamiliar);
				
				Stat1.setString(1, aluno.getNome());
				Stat1.setString(2, aluno.getTurma());
				Stat1.setString(3, aluno.getDiagnosticoTEA());
				Stat1.setInt(4, familiar.getIdFamiliar());
				
				Stat1.executeUpdate();
				
				System.out.println("Atualizações realizadas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            try {
                if (Stat != null) {
                    Stat.close();
                }
                if (Stat1 != null) {
                    Stat1.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
	}
	
	public void editarPerfilMonitor( UsuarioModel usuario, MonitorModel monitor) {
        
        String query = "UPDATE usuario SET nome = ?,email= ?, endereco = ? WHERE id_usuario = ?";
        String queryMonitor = "UPDATE monitor SET especializacao = ?, anosExperiencia = ?, formacaoAcademica = ?, disciplinas= ? WHERE id_monitor = ?";
        PreparedStatement Stat= null;
		PreparedStatement Stat1= null;
		Connection conn= null;
		
		try {
			conn= new MysqlConnection().getConnection();
			
			if(conn!= null) {
				Stat= conn.prepareStatement(query);
				
				Stat.setString(1, usuario.getNome());
				Stat.setString(2, usuario.getEmail());
				Stat.setString(3, usuario.getEndereco());
				Stat.setInt(4, usuario.getIdUsuario());
				
				Stat.executeUpdate();
				
				Stat1= conn.prepareStatement(queryMonitor);
				
				Stat1.setString(1, monitor.getEspecializacao());
				Stat1.setInt(2, monitor.getAnosExperiencia());
				Stat1.setString(3, monitor.getFormacaoAcademica());
				Stat1.setString(4, monitor.getDisciplinasAsJson());
				Stat1.setInt(5, monitor.getIdMonitor());
				
				System.out.println(monitor.getAnosExperiencia());
				System.out.println(monitor.getEspecializacao());
				System.out.println(monitor.getFormacaoAcademica());
				monitor.exibirDisciplinas();
				
				
				Stat1.executeUpdate();
				
				System.out.println("Atualizações realizadas");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            try {
                if (Stat != null) {
                    Stat.close();
                }
                if (Stat1 != null) {
                    Stat1.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
	}

}


