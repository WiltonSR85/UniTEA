package unitea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import unitea.model.ChatModel;
import unitea.model.Mensagem;
import unitea.model.PedidoMonitoriaModel;

public class CriarChatDao {

    public PedidoMonitoriaModel CriandoChat(ChatModel chat) {
        PedidoMonitoriaModel pedido = null;
        PreparedStatement stmt = null;
        PreparedStatement stmt1 = null;
        PreparedStatement stmt2 = null;
        ResultSet rs = null;
        ResultSet rs1 = null;
        Connection conn = null;

        String sqlInserirChat = "INSERT INTO UNITEA.chat (id_familiar, id_monitor, id_pedido, nome_chat) VALUES (?, ?, ?, ?)";
        String sqlBuscarChat = "SELECT * FROM UNITEA.chat WHERE id_pedido = ? AND id_familiar = ? AND id_monitor = ?";
        String sqlBuscarMensagens = "SELECT * FROM UNITEA.mensagem WHERE id_chat = ?";

        try {
            conn = new MysqlConnection().getConnection();

            if (conn == null) {
                System.out.println("Falha na conexão com o banco de dados.");
                return new PedidoMonitoriaModel();
            }

            stmt1 = conn.prepareStatement(sqlBuscarChat);
            stmt1.setInt(1, chat.getIdPedidoMonitoriaAssociado());
            stmt1.setInt(2, chat.getIdFamiliar());
            stmt1.setInt(3, chat.getIdMonitor());
            rs = stmt1.executeQuery();

            if (rs.next()) {
                int idChat = rs.getInt("id_chat");
                chat.setIdChat(idChat);

                stmt2 = conn.prepareStatement(sqlBuscarMensagens);
                stmt2.setInt(1, idChat);
                rs1 = stmt2.executeQuery();

                while (rs1.next()) {
                    Mensagem mensagem = new Mensagem(
                        rs1.getInt("id_mensagem"),
                        idChat,
                        rs1.getString("conteudo"),
                        rs1.getInt("id_usuario")
                    );
                    chat.getMensagens().add(mensagem);
                }

                pedido = new PedidoMonitoriaModel(chat);

            } else {
                stmt = conn.prepareStatement(sqlInserirChat, PreparedStatement.RETURN_GENERATED_KEYS);
                stmt.setInt(1, chat.getIdFamiliar());
                stmt.setInt(2, chat.getIdMonitor());
                stmt.setInt(3, chat.getIdPedidoMonitoriaAssociado());
                stmt.setString(4, chat.getNomeChat());

                int rowsAffected = stmt.executeUpdate();

                if (rowsAffected > 0) {
                    ResultSet generatedKeys = stmt.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int idChat = generatedKeys.getInt(1);
                        chat.setIdChat(idChat);
                    }

                    pedido = new PedidoMonitoriaModel(chat);
                }
            }

            if (pedido == null) {
                pedido = new PedidoMonitoriaModel(chat);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            if (pedido == null) {
                pedido = new PedidoMonitoriaModel();
            }
        } finally {
            try {
                if (rs != null) rs.close();
                if (rs1 != null) rs1.close();
                if (stmt1 != null) stmt1.close();
                if (stmt2 != null) stmt2.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e2) {
                e2.printStackTrace();
            }
        }

        return pedido;
    }
    

}

