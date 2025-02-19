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


public class MostrarPedidosPendentesMonitorDao {
	
	public List<PedidoMonitoriaModel> listarPedidosMonitor(MonitorModel monitor){
		List<PedidoMonitoriaModel> pedidos= new ArrayList<>();
		PreparedStatement stmt= null;
		ResultSet rs= null;
		PreparedStatement stmt1= null;
		ResultSet rs1= null;
		Connection conn = null;
		String json=null;
		String disciplina1= null;
		String disciplina2= null;
		String disciplina3= null;
		String disciplina4= null;
		String sql1= "SELECT disciplinas FROM monitor where id_monitor= ?";
		String sql= "SELECT "
		        + "    u.nome AS nome_familiar, "
		        + "    pc.id_pedido AS id_pedido, "
		        + "    pc.informacoes AS informacoes_adicionais, "
		        + "    a.nome AS nome_aluno, "
		        + "    a.turma AS turma, "
		        + "    a.diagnosticoTEA AS diagnostico_tea, "
		        + "    pc.disciplina AS disciplina "
		        + "FROM "
		        + "    familiar f "
		        + "JOIN "
		        + "    usuario u ON f.id_usuario = u.id_usuario "
		        + "JOIN "
		        + "    pedidoMonitoria pc ON f.id_familiar = pc.id_familiar "
		        + "JOIN "
		        + "    aluno a ON f.id_familiar = a.id_familiar "
		        + "WHERE "
		        + "    pc.status = ? AND (pc.disciplina= ? or pc.disciplina= ? or pc.disciplina= ? or pc.disciplina= ?)";

		
		try {
			conn = new MysqlConnection().getConnection();
			
			if(conn != null) {
				stmt1= conn.prepareStatement(sql1);
				stmt1.setInt(1, monitor.getIdMonitor());
				
				rs1=stmt1.executeQuery();
				if(rs1.next()) {
					json=rs1.getString("disciplinas");
					
					monitor.setDisciplinasFromJson(json);
					
					if (monitor.getDisciplinas().size() > 0) disciplina1 = monitor.getDisciplinas().get(0);
			        if (monitor.getDisciplinas().size() > 1) disciplina2 = monitor.getDisciplinas().get(1);
			        if (monitor.getDisciplinas().size() > 2) disciplina3 = monitor.getDisciplinas().get(2);
			        if (monitor.getDisciplinas().size() > 3) disciplina4 = monitor.getDisciplinas().get(3);
			        
			        System.out.println(disciplina1);
			        System.out.println(disciplina2);
			        System.out.println(disciplina3);
			        System.out.println(disciplina4);
				}
				
				stmt = conn.prepareStatement(sql);
				stmt.setString(1, "pendente");
				stmt.setString(2, disciplina1);
				stmt.setString(3, disciplina2);
				stmt.setString(4, disciplina3);
				stmt.setString(5, disciplina4);
				
				rs= stmt.executeQuery();
				
				while(rs.next()) {
					String nomeFamiliar= rs.getString("nome_familiar");
					String nomeAluno= rs.getString("nome_aluno");
					String informacoes= rs.getString("informacoes_adicionais");
					String diagnostico= rs.getString("diagnostico_tea");
					String turma= rs.getString("turma");
					String disciplina= rs.getString("disciplina");
					int idPedido= rs.getInt("id_pedido");
					
					System.out.println("AQUI ESTAMOS NOS");
					
					AlunoModel aluno= new AlunoModel(nomeAluno, diagnostico, turma);
					FamiliarModel familiar= new FamiliarModel(nomeFamiliar);
					PedidoMonitoriaModel pedido= new PedidoMonitoriaModel(idPedido, familiar,aluno, informacoes, disciplina);
					
					pedidos.add(pedido);
				}
				
				for (PedidoMonitoriaModel pedido : pedidos) {
					System.out.println(pedido.getAluno().getDiagnosticoTEA());
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
                if (stmt1 != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
		return pedidos;
	}

}
