<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Perfil do Mentor</title>
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
        
        #perfilMentor {
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
            text-decoration: none;
            transition: background-color 0.3s ease;
            font-size: 14px;
            border: none;
            cursor: pointer;
            width: 200px;
            margin: auto;
        }

        .button:hover {
            background-color: #003366;
        }

        footer {
            background-color: #0066cc;                                                  
            color: azure;
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
                <li><a href="perfilMentor.jsp" id="perfilMentor">Perfil</a></li>
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
        <section class="inicio">
            <h3>Editar Perfil do Mentor</h3>
        </section>

        <section class="meio">
            <h2 style="text-align: center;">Editar Informações</h2>
            <div class="medio">
                <form action="editarMonitor" method="POST" class="perfil-info">
                    <div>
                        <label for="nome">Nome:</label>
                        <input type="text" id="nome" name="nome" value="<%= session.getAttribute("nomeMonitor") %>">
                    </div>
                    <div>
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" value="<%= session.getAttribute("emailMonitor") %>">
                    </div>
                    <div>
                        <label for="endereco">Endereço:</label>
                        <input type="text" id="endereco" name="endereco" value="<%= session.getAttribute("enderecoMonitor") %>">
                    </div>
                    <div>
                        <label for="especializacao">Especialização:</label>
                        <input type="text" id="especializacao" name="especializacao" value="<%= session.getAttribute("especializacao") %>">
                    </div>
                    <div>
                        <label for="anosExperiencia">Anos de Experiência:</label>
                        <input type="text" id="anosExperiencia" name="anosExperiencia" value="<%= session.getAttribute("anosExperiencia") %>">
                    </div>
                    <div>
                        <label for="formacaoAcademica">Formação Acadêmica:</label>
                        <input type="text" id="formacaoAcademica" name="formacaoAcademica" value="<%= session.getAttribute("formacaoAcademica") %>">
                    </div>
                    <div>
                        <label for="disciplina1">Disciplina 1:</label>
                        <input type="text" id="disciplina1" name="disciplina1" value="<%= session.getAttribute("disciplina1") %>">
                    </div>
                    <div>
                        <label for="disciplina2">Disciplina 2:</label>
                        <input type="text" id="disciplina2" name="disciplina2" value="<%= session.getAttribute("disciplina2") %>">
                    </div>
                    <div>
                        <label for="disciplina3">Disciplina 3:</label>
                        <input type="text" id="disciplina3" name="disciplina3" value="<%= session.getAttribute("disciplina3") %>">
                    </div>
                    <div>
                        <label for="disciplina4">Disciplina 4:</label>
                        <input type="text" id="disciplina4" name="disciplina4" value="<%= session.getAttribute("disciplina4") %>">
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
