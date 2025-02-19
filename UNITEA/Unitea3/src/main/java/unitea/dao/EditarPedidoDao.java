package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import unitea.model.AlunoModel;
import unitea.model.FamiliarModel;
import unitea.model.UsuarioModel;

public class EditarPedidoDao {

public void editarPedido( String disciplina, String nomeChat, String informacoes, int idPedido) {
		
		
        String query = "UPDATE UNITEA.pedidoMonitoria SET disciplina = ?, nome_chat= ?, informacoes = ? WHERE id_pedido = ?";
		String query1 = "UPDATE UNITEA.pedidos_criados SET disciplina = ?, nome_chat= ?, informacoes = ? WHERE id_pedido = ?";
		PreparedStatement Stat= null;
		PreparedStatement Stat1= null;
		Connection conn= null;
		
		try {
			conn= new MysqlConnection().getConnection();
			
			if(conn!= null) {
				Stat= conn.prepareStatement(query);
				
				Stat.setString(1, disciplina);
				Stat.setString(2, nomeChat);
				Stat.setString(3, informacoes);
				Stat.setInt(4, idPedido);
				
				Stat.executeUpdate();
				
				Stat1= conn.prepareStatement(query1);
				
				Stat1.setString(1, disciplina);
				Stat1.setString(2, nomeChat);
				Stat1.setString(3, informacoes);
				Stat1.setInt(4, idPedido);
				
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
