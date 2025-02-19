<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="unitea.model.PedidoMonitoriaModel" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedidos de Monitoria - Aceitar</title>
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
            padding: 15px;
            height: 190px;
            color: white;
            text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.6);
            display: flex;
            justify-content: space-between;
            align-items: center;
            background-position: center;
            background-size: cover;
        }

        nav ul {
            list-style: none;
            display: flex;
            position: absolute;
            top: 20px;
            left: 45%;
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

        #pedidosMonitor {
            border: 2px solid hsl(219, 29%, 41%);
            border-radius: 5px;
        }

        main {
            padding: 180px 20px;
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

        table {
		    width: 100%;
		    border-collapse: separate;
		    border-spacing: 0;
		    margin: 20px 0;
		    background-color: white;
		    box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
		    border-radius: 10px;
		    overflow: hidden;
		}

		thead th {
		    background-color: #007BFF;
		    color: white;
		    padding: 15px;
		    font-size: 16px;
		    border: none;
		    text-align: center;
		}

		tbody td {
		    padding: 10px;
		    font-size: 14px;
		    text-align: center;
		    border: none;
		}

		tbody tr:nth-child(odd) {
    		background-color: #f9f9f9;
		}

		tbody tr:nth-child(even) {
   			 background-color: #e9ecef;
		}


        .button-accept {
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            border: none;
        }

        .button-accept:hover {
            background-color: #45a049;
            cursor: pointer;
        }
    </style>
</head>
<body>

    <header>
        <h1 style="position: absolute; font-size: 20px; top: 35px; left: 10%;">UniTEA</h1>
        <h2 style="position: absolute; font-size: 40px; top: 80px; left: 5%;">Inclusão Escolar</h2>
        <nav>
            <ul>
                <li><a href="perfilMentor.jsp">Perfil</a></li>
                <form action="mostrarPendentes" method="post" style="display: inline;">
            		<button type="submit" style="background: none; color: white; border: none; text-decoration: underline; cursor: pointer;">
               			 Pedidos de Monitoria
            		</button>
        		</form>
                <li><a href="telaMentor.jsp">Pedidos em Andamento</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="content">
            <h2>Pedidos Pendentes</h2>
            <br>
            <br>
            <table>
                <thead>
                    <tr>
                        <th>ID do Pedido</th>
                        <th>Nome do Familiar</th>
                        <th>Nome do Aluno</th>
                        <th>Disciplina</th>
                        <th>Diagnóstico TEA</th>
                        <th>Turma</th>
                        <th>Informações Adicionais</th>
                        <th>Ações</th>
                    </tr>
                </thead>
                <tbody>
                    <% 
                    List<PedidoMonitoriaModel> pedidos = (List<PedidoMonitoriaModel>) session.getAttribute("pedidos");
                    if (pedidos != null) {
                        for (PedidoMonitoriaModel pedido : pedidos) {
                    %>
                    <tr>
                        <td><%= pedido.getIdPedido() %></td>
                        <td><%= pedido.getSolicitante().getNome() %></td>
                        <td><%= pedido.getAluno().getNome() %></td>
                        <td><%= pedido.getDisciplina() %></td>
                        <td><%= pedido.getAluno().getDiagnosticoTEA() %></td>
                        <td><%= pedido.getAluno().getTurma() %></td>
                        <td><%= pedido.getInformacoes() %></td>
                        <td>
                            <form action="aceitarPedido" method="POST" style="display:inline;">
                                <input type="hidden" name="idPedido" value="<%= pedido.getIdPedido() %>">
                                <button type="submit" class="button-accept">Aceitar</button>
                            </form>
                        </td>
                    </tr>
                    <% 
                        }
                    } 
                    %>
                </tbody>
            </table>
        </div>    
    </main>
    
    <footer>
        <h7>| Promovendo a inclusão escolar e construindo caminhos para que alunos com TEA desenvolvam seu potencial.|</h7>
        <br>
        <h8>© 2024 UniTEA. Todos os direitos reservados.</h8>
    </footer>

</body>
</html>