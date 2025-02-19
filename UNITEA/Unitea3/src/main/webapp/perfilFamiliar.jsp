<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Perfil de Familiar | UNITEA</title>
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        
        body {
            font-family: Arial, sans-serif;
            line-height: 1.6;
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
            padding: 20px 20px;
        }

        .inicio h3 {
            font-size: 23px;
        }
        
        .meio {
            padding: 50px 20px;
            background-color: hsl(219, 50%, 90%);
        }

        .meio h2 {
            text-align: center;
        }

        .medio {
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        .profile-info {
            margin-bottom: 20px;
        }

        .profile-info label {
            font-weight: bold;
        }

        .profile-info span {
            margin-left: 10px;
            color: #555;
        }

        footer {
            color: azure;
            background-color: #0066cc;
            text-align: center;
            padding: 20px;
            font-size: 14px;
        }
        
        .button-container {
            text-align: center;
            margin-top: 30px;
        }

        .button {
            display: block;
            background-color: #ff4c4c;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            margin: 10px auto;
            transition: background-color 0.3s ease;
            font-size: 14px;
            border: none;
            cursor: pointer;
            width: 200px;
        }

        .button:hover {
            background-color: #e60000;
        }

        .logout-button {
            display: block;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            margin: 10px auto;
            transition: background-color 0.3s ease;
            font-size: 14px;
            border: none;
            cursor: pointer;
            width: 200px;
        }

        .logout-button:hover {
            background-color: #45a049;
        }

        .edit-btn {
            display: block;
            background-color: #004a99;
            color: white;
            padding: 10px 20px;
            border-radius: 5px;
            text-decoration: none;
            margin: 10px auto;
            transition: background-color 0.3s ease;
            font-size: 14px;
            width: 200px;
        }

        .edit-btn:hover {
            background-color: #003366;
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
            <h3>Perfil</h3>
        </section>
        
        <section class="meio">
            <h2>Informações do Familiar</h2>
            <div class="medio">
                <div class="profile-info">
                    <p><strong>Nome:</strong> <%= session.getAttribute("nomeFamiliar") %></p>
                </div>

                <div class="profile-info">
                    <p><strong>Email:</strong> <%= session.getAttribute("emailFamiliar") %></p>
                </div>

                <div class="profile-info">
                    <p><strong>Endereço:</strong> <%= session.getAttribute("enderecoFamiliar") %></p>
                </div>
            </div>
            <h2>Dados do Aluno</h2>
            <div class="medio">
                <div class="profile-info">
                    <p><strong>Nome do Aluno:</strong> <%= session.getAttribute("nomeAluno") %></p>
                </div>

                <div class="profile-info">
                    <p><strong>Turma:</strong> <%= session.getAttribute("turma") %></p>
                </div>

                <div class="profile-info">
                    <label for="diagnosticoTEA">Diagnóstico de TEA:</label>
                    <span><%= session.getAttribute("diagnostico") %></span>
                </div>
            </div>
            <br>
            <div class="button-container">
                <a href="editarFamiliar.jsp" class="edit-btn">Editar Perfil</a>

                <form action="excluirPerfil" method="POST">
                    <button type="submit" class="button" onclick="return confirm('Tem certeza de que deseja excluir seu perfil? Esta ação não pode ser desfeita.')">Excluir Perfil</button>
                </form>

                <form action="logout" method="POST">
                    <button type="submit" class="logout-button" onclick="return confirm('Tem certeza de que deseja sair?')">Sair</button>
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
