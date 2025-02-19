<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="unitea.model.PedidoMonitoriaModel" %>
<%@ page import="unitea.model.Mensagem" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela Inicial Familiar - Chat</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
		    font-family: Arial, sans-serif;
		    background-color: #f4f4f4;
		    display: flex;
		    flex-direction: column;
		    min-height: 100vh;
		}

        header {
            background-image: url(/Unitea1/Imagens/projeto.jpeg);
            filter: brightness(100%);
            padding: 15px;
            background-size: contain;
            width: 100%;
            height: 190px;
            color: #ffffff;
            box-sizing: border-box;
            background-position: center;
            background-size: cover;
            align-items: center;
            display: flex;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.6);
            justify-content: space-between;
        }

        nav ul {
            list-style: none;
            display: flex;
            left: 70%;
            top: 20px;
            position: absolute;
        }

        nav a {
            color: white;
            text-decoration: none;
            padding: 10px 20px;
            margin: 0 10px;
            border-radius: 5px;
            transition: background-color 0.3s ease;
        }

        nav a:hover {
            background-color: #003366;
        }

        nav button {
            background: none;
            color: white;
            border: none;
            text-decoration: none;
            padding: 10px 20px;
            margin: 0 10px;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        nav button:hover {
            background-color: #003366;
        }

        main {
            padding: 50px 20px;
            background-color: hsl(219, 50%, 90%);
            text-align: center;
        }

        footer {
		    color: azure;
		    background-color: #0066cc;
		    text-align: center;
		    padding: 20px;
		    font-size: 14px;
		    margin-top: auto; 
		}

        .content {
            padding: 20px;
            text-align: center;
        }

        .chat-box {
            max-width: 600px;
            margin: 0 auto;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #ffffff;
            display: flex;
            flex-direction: column;
            overflow: hidden;
        }

        .chat-header {
            background-color: #0066cc;
            color: white;
            padding: 10px;
            font-size: 20px;
            text-align: center;
        }

        .chat-messages {
            flex: 1;
            padding: 15px;
            overflow-y: auto;
            background-color: #f9f9f9;
            text-align: left;
        }

        .chat-messages .mensagem {
            padding: 10px;
            margin-bottom: 10px;
            background-color: #e6f7ff;
            border-radius: 5px;
            border: 1px solid #ccc;
        }

        .chat-messages hr {
            border: 0;
            border-top: 1px solid #ddd;
            margin: 10px 0;
        }

        .chat-input {
            padding: 10px;
            background-color: #f1f1f1;
            display: flex;
            align-items: center;
            border-top: 1px solid #ddd;
        }

        .chat-input input[type="text"] {
            flex: 1;
            padding: 10px;
            border: 1px solid #ddd;
            border-radius: 5px;
            margin-right: 10px;
        }

        .chat-input button {
            padding: 10px 15px;
            background-color: #007BFF;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .chat-input button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>

    <header>
        <h1 style="position: absolute; font-size: 20px; top: 35px; left: 10%;">UniTEA</h1>
        <h2 style="position: absolute; font-size: 40px; top: 80px; left: 5%;">Inclusão Escolar</h2>
        <nav>
            <ul>
                <li><a href="perfilFamiliar.jsp">Perfil</a></li>
                <li>
                    <form action="mostrarPedidos" method="post" style="display: inline;">
                        <button type="submit">
                            Pedidos de Monitoria
                        </button>
                    </form>
                </li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="content">
            <div class="chat-box">
                <div class="chat-header">
                    <% 
                    PedidoMonitoriaModel pedido = (PedidoMonitoriaModel) session.getAttribute("pedido");
                    if (pedido != null && pedido.getChat() != null) { 
                    %>
                        <%= pedido.getChat().getNomeChat() %>
                    <% 
                    } else { 
                    %>
                        Chat indisponível
                    <% 
                    } 
                    %>
                </div>
                <div class="chat-messages">
                    <% 
                    if (pedido != null && pedido.getChat() != null && pedido.getChat().getMensagens() != null) {
                        for (Mensagem mensagem : pedido.getChat().getMensagens()) {
                    %>
                        <div class="mensagem">
                            <strong style="color: red;">Usuário <%= mensagem.getIdUsuario() %>:</strong>
                            <p><%= mensagem.getConteudo() %></p>
                        </div>
                        <hr>
                    <% 
                        }
                    } else {
                    %>
                        <p>Sem mensagens ainda.</p>
                    <% 
                    } 
                    %>
                </div>
                <div class="chat-input">
                    <form action="comentar" method="get">
                        <input type="hidden" name="idChat" value="<%= pedido != null && pedido.getChat() != null ? pedido.getChat().getIdChat() : "" %>">
                        <input type="hidden" name="usuario" value="<%= session.getAttribute("id_usuarioFamiliar") != null ? session.getAttribute("id_usuarioFamiliar") : "" %>">
                        <input type="text" name="mensagem" placeholder="Digite sua mensagem aqui..." required>
                        <button type="submit">Enviar</button>
                    </form>
                </div>
            </div>
        </div>
    </main>

    <footer>
        <h7>| Promovendo a inclusão escolar e construindo caminhos para que alunos com TEA desenvolvam seu potencial.|</h7>
        <br>
        <h8>© 2024 UniTEA. Todos os direitos reservados.</h8>
    </footer>

</body>
</html>
