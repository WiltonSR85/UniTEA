package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class AceitarPedidoDao {
	
	public void aceitarPedido(int idPedido, int idMonitor){
		PreparedStatement stmt= null;
		PreparedStatement stmt1= null;
		PreparedStatement stmt2= null;
		PreparedStatement stmt3= null;
		ResultSet rs= null;
		Connection conn = null;
		

		int idAluno= 0;
		int idFamiliar=0;
		String status= null;
		String nomeChat= null;
		String disciplina= null;
		String informacoes=null;
		
		
		String sql= "DELETE FROM pedidos_criados WHERE id_pedido= ?";
		String sql1= "UPDATE pedidoMonitoria SET status= ?, id_monitor= ? WHERE id_pedido= ?";
		String sql2 = "SELECT * FROM UNITEA.pedidoMonitoria WHERE id_pedido = ?";
		String sql3= "INSERT INTO UNITEA.pedidos_andamento  (id_pedido, id_aluno, id_familiar,id_monitor, status, nome_chat, disciplina, informacoes) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = new MysqlConnection().getConnection();
			
			if(conn != null) {
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, idPedido);
				stmt.executeUpdate();
				
				stmt1= conn.prepareStatement(sql1);
				stmt1.setString(1, "aceito");
				stmt1.setInt(2, idMonitor);
				stmt1.setInt(3, idPedido);
				stmt1.executeUpdate();
				
				stmt2= conn.prepareStatement(sql2);
				stmt2.setInt(1, idPedido);
				
				rs= stmt2.executeQuery();
				
				if(rs.next()) {
					
					System.out.println("AOOO POTENCIA");
					idPedido= rs.getInt("id_pedido");
					idAluno= rs.getInt("id_aluno");
					idMonitor= rs.getInt("id_monitor");
					idFamiliar= rs.getInt("id_familiar");
					status= rs.getString("status");
					nomeChat= rs.getString("nome_chat");
					disciplina= rs.getString("disciplina");
					informacoes= rs.getString("informacoes");
					
					
					
					stmt3= conn.prepareStatement(sql3);
					stmt3.setInt(1, idPedido);
					stmt3.setInt(2, idAluno);
					stmt3.setInt(3, idFamiliar);
					stmt3.setInt(4, idMonitor);
					stmt3.setString(5, status);
					stmt3.setString(6, nomeChat);
					stmt3.setString(7, disciplina);
					stmt3.setString(8, informacoes);
					stmt3.executeUpdate();
					
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
                if (stmt2 != null) stmt2.close();
                if (stmt3 != null) stmt3.close();
                if (conn != null) conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
		
	}
}
