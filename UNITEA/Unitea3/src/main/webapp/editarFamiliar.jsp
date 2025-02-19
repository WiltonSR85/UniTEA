<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Perfil de Familiar</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
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
        
        #perfilFamiliar {
            border: 2px solid hsl(219, 29%, 41%);
            border-radius: 5px;
        }

        .inicio {
        	background-color: #f4f4f4;
            text-align: center;
            padding: 20px;
        }
        
        .inicio h3 {
            font-size: 23px;
        }

        .meio {
            padding: 50px 20px;
            background-color: hsl(219, 50%, 90%);
        }

        .medio {
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .perfil-info {
            display: flex;
            flex-direction: column;
            gap: 20px;
        }

        .perfil-info form {
            display: flex;
            flex-direction: column;
            gap: 10px;
        }

        .perfil-info label {
            font-weight: bold;
            margin-bottom: 5px;
        }

        .perfil-info input {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
            font-size: 14px;
        }

        .button-container {
            text-align: center;
            margin-top: 20px;
        }

        .button {
            background-color: #0066cc;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            font-size: 14px;
            border: none;
            cursor: pointer;
            width: 200px;
        }

        .button:hover {
            background-color: #003366;
        }

        footer {
            background-color: #0066cc;
            color: white;
            text-align: center;
            padding: 20px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <header>
        <h1 style="position: absolute; font-size: 20px; top: 35px; left: 10%;">UniTEA</h1>
        <h2 style="position: absolute; font-size: 40px; top: 80px; left: 5%;">Inclusão Escolar</h2>
        <nav>
            <ul>
                <li><a href="perfilFamiliar.jsp" id="perfilFamiliar">Perfil</a></li>
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
        <section class="inicio">
            <h3>Editar Perfil de Familiar</h3>
        </section>

        <section class="meio">
            <h2 style="text-align: center;">Editar Informações</h2>
            <div class="medio">
                <form action="editarFamiliar" method="POST" class="perfil-info">
                    <div>
                        <label for="nome">Nome:</label>
                        <input type="text" id="nome" name="nomeFamiliar" value="<%= session.getAttribute("nomeFamiliar") %>">
                    </div>
                    <div>
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="emailFamiliar" value="<%= session.getAttribute("emailFamiliar") %>">
                    </div>
                    <div>
                        <label for="endereco">Endereço:</label>
                        <input type="text" id="endereco" name="enderecoFamiliar" value="<%= session.getAttribute("enderecoFamiliar") %>">
                    </div>
                    <div>
                        <label for="nomeAluno">Nome do Aluno:</label>
                        <input type="text" id="nomeAluno" name="nomeDoAluno" value="<%= session.getAttribute("nomeAluno") %>">
                    </div>
                    <div>
                        <label for="turma">Turma:</label>
                        <input type="text" id="turma" name="turma" value="<%= session.getAttribute("turma") %>">
                    </div>
                    <div>
                        <label for="diagnostico">Diagnóstico:</label>
                        <input type="text" id="diagnostico" name="diagnostico" value="<%= session.getAttribute("diagnostico") %>">
                    </div>

                    <div class="button-container">
                        <button type="submit" class="button">Salvar</button>
                    </div>
                </form>
            </div>
        </section>
    </main>

    <footer>
        <h7>| Promovendo a inclusão escolar e construindo caminhos para que alunos com TEA desenvolvam seu potencial.|</h7>
        <br>
        <h8>© 2024 UniTEA. Todos os direitos reservados.</h8>
    </footer>
</body>
</html>

