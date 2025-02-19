package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import unitea.model.AlunoModel;
import unitea.model.FamiliarModel;
import unitea.model.PedidoMonitoriaModel;

public class MostrarPedidosCriadosFamiliarDao {

	public List<PedidoMonitoriaModel> listarPedidos(int idFamiliar){
		List<PedidoMonitoriaModel> pedidos= new ArrayList<>();
		PreparedStatement stmt= null;
		ResultSet rs= null;
		Connection conn = null;
		
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
		        + "    pedidos_criados pc ON f.id_familiar = pc.id_familiar "
		        + "JOIN "
		        + "    aluno a ON f.id_familiar = a.id_familiar "
		        + "WHERE "
		        + "    f.id_familiar = ?";

		
		try {
			conn = new MysqlConnection().getConnection();
			
			if(conn != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, idFamiliar);
				
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
					System.out.println(pedido.getDisciplina());
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
