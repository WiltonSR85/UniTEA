package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ExcluirPedidoDao {

public void excluirPedido(int idPedido) {
		
        String query = "DELETE FROM UNITEA.PedidoMonitoria WHERE id_pedido = ?";
        String query1 = "DELETE FROM UNITEA.pedidos_criados WHERE id_pedido = ?";
		PreparedStatement Stat= null;
		PreparedStatement Stat1= null;
		Connection conn= null;
		
		try {
			conn= new MysqlConnection().getConnection();
			
			if(conn!= null) {
				Stat= conn.prepareStatement(query);
				
				Stat.setInt(1, idPedido);
				
				Stat.executeUpdate();
				
				System.out.println("Exclusões realizadas");
				
				Stat1= conn.prepareStatement(query1);
				
				Stat1.setInt(1, idPedido);
				
				Stat1.executeUpdate();

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
