package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import unitea.model.Mensagem;
import unitea.model.PedidoMonitoriaModel;

public class AdicionarComentarioDao {

	public void AdicionarComentario(Mensagem mensagem){
        PreparedStatement stmt = null;
        Connection conn = null;
        
        String sql = "INSERT INTO UNITEA.mensagem (id_usuario, id_chat, conteudo) VALUES (?, ?, ?)";

        try {
            conn = new MysqlConnection().getConnection();
            
            if (conn != null) {
                
                    stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
                    stmt.setInt(1, mensagem.getIdUsuario());
                    stmt.setInt(2, mensagem.getIdChat());
                    stmt.setString(3, mensagem.getConteudo());
                    
                    System.out.println("Pelo menos a conexão ta acontecendo");
                    System.out.println(mensagem.getIdUsuario());
                    System.out.println(mensagem.getIdChat());
                    System.out.println(mensagem.getConteudo());

                    
                    int rowsAffected = stmt.executeUpdate();
                    
                    if (rowsAffected > 0) {
                        System.out.println("ta rodando chefe");
                        }
            } else {
                System.out.println("Falha na conexão com o banco de dados.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        
    }
}
