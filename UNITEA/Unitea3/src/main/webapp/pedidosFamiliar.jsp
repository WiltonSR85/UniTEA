<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="unitea.model.PedidoMonitoriaModel" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pedidos de Monitoria - Familiar</title>
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

        #pedidosFamiliar {
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
		    margin-top: auto; /* Garante que o footer fique no final da tela */
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


        .button {
		    background-color: #007BFF;
		    color: white;
		    padding: 10px 20px;
		    border-radius: 5px;
		    text-decoration: none;
		    margin-top: 10px;
		}

		.button:hover {
    		background-color: #0056b3; 
		}

		.button-excluir {
    		background-color: #ff4c4c;
		}

		.button-excluir:hover {
    		background-color: #e60000;
		}


        .form-pedido {
            margin-top: 20px;
            display: none;
        }

        .form-pedido div {
            margin-bottom: 10px;
        }

        .form-pedido label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        .form-pedido input {
            width: 100%;
            padding: 8px;
            box-sizing: border-box;
        }

        .form-pedido button {
            margin-top: 10px;
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
                <form action="mostrarPedidos" method="post" style="display: inline;">
            		<button type="submit" style="background: none; color: white; border: none; text-decoration: underline; cursor: pointer;">
                		Pedidos de Monitoria
            		</button>
        		</form>
                <li><a href="telaFamiliar.jsp">Pedidos em Andamento</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <div class="content">
            <h2>Meus Pedidos de Monitoria</h2>
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
                            <button class="button" onclick="editarPedido(this)" data-id="<%= pedido.getIdPedido() %>">Editar</button>
                            <form action="excluirPedido" method="get">
                                  <button class="button button-excluir" type="submit" name="idPedido" value="<%= pedido.getIdPedido() %>">
                                                    Excluir
                                  </button>
                            </form>
    
                        </td>
                    </tr>
                    <% 
                            }
                        } 
                    %>
                </tbody>
            </table>
    
            <button class="button" onclick="adicionarNovoPedido()">Criar Novo Pedido</button>
    
            <div class="form-pedido" id="novo-pedido-form">
                <h3>Criar Novo Pedido</h3>
                <form id="form-pedido" action="criarPedido" method="POST">
                    <div>
                        <label for="nome-aluno">Nome do Aluno:</label>
                        <input type="text" id="nome-aluno" name="nomeAluno" readonly value="${sessionScope.nomeAluno}">
                    </div>
                    <div>
                        <label for="diagnostico-tea">Diagnóstico TEA:</label>
                        <input type="text" id="diagnostico-tea" name="diagnosticoTEA" readonly value="${sessionScope.diagnostico}">
                    </div>
                    <div>
                        <label for="turma">Turma:</label>
                        <input type="text" id="turma" name="turma" readonly value="${sessionScope.turma}">
                    </div>
    
                    <div>
                        <label for="disciplina">Disciplina:</label>
                        <input type="text" id="disciplina" name="disciplina" placeholder="Disciplina" required>
                    </div>
                    <div>
                        <label for="nome-chat">Nome do Chat:</label>
                        <input type="text" id="nome-chat" name="nomeChat" placeholder="Nome do Chat" required>
                    </div>
                    <div>
                        <label for="informacoes-adicionais">Informações Adicionais:</label>
                        <input type="text" id="informacoes-adicionais" name="informacoesAdicionais" placeholder="Informações Adicionais">
                    </div>
    
                    <button type="submit" class="button">Salvar Pedido</button>
                    <button type="button" class="button" onclick="cancelarPedido()">Cancelar</button>
                </form>
            </div>
            
            <div class="form-pedido" id="novo-pedido-form-editar">
                <h3>Editar Pedido</h3>
                <form id="form-pedido-editar" action="editarPedido" method="POST">
                    <input type="hidden" id="id-pedido-editar" name="idPedido">
                    <div>
                        <label for="disciplina">Disciplina:</label>
                        <input type="text" id="disciplina-editar" name="disciplina" placeholder="Disciplina" required>
                    </div>
                    <div>
                        <label for="nome-chat">Nome do Chat:</label>
                        <input type="text" id="nome-chat-editar" name="nomeChat" placeholder="Nome do Chat" required>
                    </div>
                    <div>
                        <label for="informacoes-adicionais">Informações Adicionais:</label>
                        <input type="text" id="informacoes-adicionais-editar" name="informacoesAdicionais" placeholder="Informações Adicionais">
                    </div>
    
                    <button type="submit" class="button">Salvar Alterações</button>
                    <button type="button" class="button" onclick="cancelarEditarPedido()">Cancelar</button>
                </form>
            </div>
        </div>
    </main>
    

    <footer>
        <h7>| Promovendo a inclusão escolar e construindo caminhos para que alunos com TEA desenvolvam seu potencial.|</h7>
        <br>
        <h8>© 2024 UniTEA. Todos os direitos reservados.</h8>
    </footer>


    <script>
        function adicionarNovoPedido() {
            document.getElementById('novo-pedido-form').style.display = 'block';
        }

        function cancelarPedido() {
            document.getElementById('novo-pedido-form').style.display = 'none';
        }

        function editarPedido(button) {
            var linha = button.closest('tr');
            var idPedido = button.getAttribute('data-id');

            document.getElementById('id-pedido-editar').value = idPedido;
            document.getElementById('disciplina-editar').value = linha.cells[3].innerText;
            document.getElementById('nome-chat-editar').value = linha.cells[5].innerText;
            document.getElementById('informacoes-adicionais-editar').value = linha.cells[6].innerText;

            document.getElementById('novo-pedido-form-editar').style.display = 'block';
        }

        function cancelarEditarPedido() {
            document.getElementById('novo-pedido-form-editar').style.display = 'none';
        }
    </script>

</body>
</html>