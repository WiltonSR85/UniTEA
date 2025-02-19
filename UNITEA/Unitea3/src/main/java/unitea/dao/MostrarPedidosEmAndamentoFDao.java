package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import unitea.model.AlunoModel;
import unitea.model.FamiliarModel;
import unitea.model.MonitorModel;
import unitea.model.PedidoMonitoriaModel;

public class MostrarPedidosEmAndamentoFDao {

	public List<PedidoMonitoriaModel> listarPedidosTelaInicial(int idFamiliar){
		List<PedidoMonitoriaModel> pedidos= new ArrayList<>();
		PreparedStatement stmt= null;
		ResultSet rs= null;
		Connection conn = null;
		
		String sql= "SELECT "
		        + "    u_familiar.nome AS nome_familiar, "
		        + "    pc.id_pedido AS id_pedido, "
		        + "    pc.informacoes AS informacoes_adicionais, "
		        + "    pc.status AS status,"
		        + "    a.nome AS nome_aluno, "
		        + "    a.turma AS turma, "
		        + "    a.diagnosticoTEA AS diagnostico_tea, "
		        + "    pc.disciplina AS disciplina, "
		        + "    u_monitor.nome AS nome_monitor, "
		        + "    pc.nome_chat AS nomeChat, "
		        + "    pc.id_monitor AS idMonitor "
		        + "FROM "
		        + "    UNITEA.familiar f "
		        + "JOIN "
		        + "    UNITEA.usuario u_familiar ON f.id_usuario = u_familiar.id_usuario "
		        + "JOIN "
		        + "    UNITEA.pedidos_andamento pc ON f.id_familiar = pc.id_familiar "
		        + "JOIN "
		        + "    UNITEA.aluno a ON f.id_familiar = a.id_familiar "
		        + "LEFT JOIN "
		        + "    UNITEA.monitor m ON pc.id_monitor = m.id_monitor "
		        + "LEFT JOIN "
		        + "    usuario u_monitor ON m.id_usuario = u_monitor.id_usuario "
		        + "WHERE "
		        + "    f.id_familiar = ?";

		
		try {
			conn = new MysqlConnection().getConnection();
			
			if(conn != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, idFamiliar);
				
				System.out.println("Pelo menos a conexão ta acontecendo");
				
				rs= stmt.executeQuery();
				
				while(rs.next()) {
					System.out.println("estamos aqui");
					String nomeFamiliar= rs.getString("nome_familiar");
					String nomeAluno= rs.getString("nome_aluno");
					String informacoes= rs.getString("informacoes_adicionais");
					String diagnostico= rs.getString("diagnostico_tea");
					String turma= rs.getString("turma");
					String disciplina= rs.getString("disciplina");
					int idPedido= rs.getInt("id_pedido");
					int idMonitor= rs.getInt("idMonitor");
					String nomeMonitor= rs.getString("nome_monitor");
					String nomeChat= rs.getString("nomeChat");
					
					System.out.println("AQUI ESTAMOS NOS");
					
					AlunoModel aluno= new AlunoModel(nomeAluno,diagnostico, turma);
					FamiliarModel familiar= new FamiliarModel(nomeFamiliar, idFamiliar);
					MonitorModel monitor= new MonitorModel(nomeMonitor, idMonitor);
					PedidoMonitoriaModel pedido= new PedidoMonitoriaModel(idPedido, familiar,aluno, monitor, informacoes, disciplina, nomeChat);
					
					pedidos.add(pedido);
				}
				
				for (PedidoMonitoriaModel pedido : pedidos) {
					System.out.println(pedido.getIdPedido());
				}
			}else {
				System.out.println("Falha na conexão com o banco de dados.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
		return pedidos;
	}
	
	public List<PedidoMonitoriaModel> listarPedidosTelaInicialM(int idMonitor){
		List<PedidoMonitoriaModel> pedidos= new ArrayList<>();
		PreparedStatement stmt= null;
		ResultSet rs= null;
		Connection conn = null;
		
		String sql = "SELECT "
	            + "    u_familiar.nome AS nome_familiar, "
	            + "    pc.id_pedido AS id_pedido, "
	            + "    pc.informacoes AS informacoes_adicionais, "
	            + "    pc.status AS status, "
	            + "    a.nome AS nome_aluno, "
	            + "    a.turma AS turma, "
	            + "    a.diagnosticoTEA AS diagnostico_tea, "
	            + "    pc.disciplina AS disciplina, "
	            + "    u_monitor.nome AS nome_monitor, "
	            + "    pc.nome_chat AS nomeChat, "
	            + "    f.id_familiar AS idFamiliar "
	            + "FROM "
	            + "    UNITEA.pedidos_andamento pc "
	            + "JOIN "
	            + "    UNITEA.familiar f ON f.id_familiar = pc.id_familiar "
	            + "JOIN "
	            + "    UNITEA.usuario u_familiar ON f.id_usuario = u_familiar.id_usuario "
	            + "JOIN "
	            + "    UNITEA.aluno a ON a.id_familiar = f.id_familiar "
	            + "LEFT JOIN "
	            + "    UNITEA.monitor m ON pc.id_monitor = m.id_monitor "
	            + "LEFT JOIN "
	            + "    UNITEA.usuario u_monitor ON m.id_usuario = u_monitor.id_usuario "
	            + "WHERE "
	            + "    pc.id_monitor = ?";

		try {
			conn = new MysqlConnection().getConnection();
			
			if(conn != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, idMonitor);
				
				System.out.println("Pelo menos a conexão ta acontecendo");
				
				rs= stmt.executeQuery();
				
				while(rs.next()) {
					System.out.println("estamos aqui");
					String nomeFamiliar= rs.getString("nome_familiar");
					String nomeAluno= rs.getString("nome_aluno");
					String informacoes= rs.getString("informacoes_adicionais");
					String diagnostico= rs.getString("diagnostico_tea");
					String turma= rs.getString("turma");
					String disciplina= rs.getString("disciplina");
					int idPedido= rs.getInt("id_pedido");
					int idFamiliar= rs.getInt("idFamiliar");
					String nomeMonitor= rs.getString("nome_monitor");
					String nomeChat= rs.getString("nomeChat");
					
					System.out.println("AQUI ESTAMOS NOS");
					
					AlunoModel aluno= new AlunoModel(nomeAluno, diagnostico, turma);
					FamiliarModel familiar= new FamiliarModel(nomeFamiliar, idFamiliar);
					MonitorModel monitor= new MonitorModel(nomeMonitor, idMonitor);
					PedidoMonitoriaModel pedido= new PedidoMonitoriaModel(idPedido, familiar,aluno, monitor, informacoes, disciplina, nomeChat);
					
					pedidos.add(pedido);
				}
				
				for (PedidoMonitoriaModel pedido : pedidos) {
					System.out.println(pedido.getIdPedido());
				}
			}else {
				System.out.println("Falha na conexão com o banco de dados.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
		return pedidos;
	}
}
