<%@ page import="org.apache.catalina.filters.ExpiresFilter.XServletOutputStream"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UNITEA - Cadastro Familiar</title>
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

        header h1 {
            position: absolute;
            font-size: 20px;
            top: 35px;
            left: 10%;
        }

        header h2 {
            position: absolute;
            font-size: 40px;
            top: 80px;
            left: 5%;
        }

        nav ul {
            list-style: none;
            display: flex;
            left: 45%;
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
        
		select {
		    padding: 10px;
		    font-size: 16px;
		    border: 1px solid #ccc;
		    border-radius: 5px;
		    width: 100%;
		    background-color: #fff;
		    color: #333;
		    cursor: pointer;
		}
		
		select:focus {
		    border-color: #0066cc;
		    outline: none;
		    box-shadow: 0 0 5px rgba(0, 102, 204, 0.5);
		}

        nav a:hover {
            background-color: #003366;
        }
        
        
        #cadastrofamilia {
            border: 2px solid #003366;
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

        form {
            display: flex;
            flex-direction: column;
            gap: 15px;
        }

        label {
            font-weight: bold;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"],
        input[type="file"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
        }

        button[type="submit"] {
            background-color: #0066cc;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        button[type="submit"]:hover {
            background-color: #004a99;
        }

        footer {
            color: azure;
            background-color: #0066cc;
            text-align: center;
            padding: 20px;
            font-size: 14px;
        }
    </style>
</head>
<body>
    <header>
        <h1>UniTEA</h1>
        <h2>Inclusão Escolar</h2>
        <nav>
            <ul>
            	<li><a href="InicialCadastro.jsp">Página Inicial</a></li>
                <li><a href="cadastrofamiliar.jsp" id="cadastrofamilia">Cadastro Familiar</a></li>
                <li><a href="cadastroMonitor.jsp">Cadastro Monitor</a></li>
                <li><a href="login.jsp">Login</a></li>  
            </ul>
        </nav>
    </header>

    <main>
    	<section class="inicio">
            <h3>Cadastro de Familiar</h3>
        </section>
        <section class="meio">
            <h2>Cadastre-se gratuitamente!</h2>
            <section class="medio">
                <form action="cadastrarFamiliar" method="post">
                    <div>
                        <label for="nome">Nome:</label>
                        <input type="text" id="nome" name="nome" required>
                    </div>
                    <div>
                        <label for="email">Email:</label>
                        <input type="email" id="email" name="email" required>
                    </div>
                    <div>
                        <label for="endereco">Endereço:</label>
                        <input type="text" id="endereco" name="endereco" required>
                    </div>
                    <div>
                        <label for="senha">Senha:</label>
                        <input type="password" id="senha" name="senha" required>
                    </div>
                    <div>
					    <label for="perfil">Perfil:</label>
					    <select id="perfil" name="perfil" required>
					        <option value="" disabled selected>Selecione seu perfil</option>
					        <option value="familiar">Familiar</option>
					    </select>
					</div>
                    <h3>Dados do Aluno</h3>
                    <div>
                        <label for="nomeDoAluno">Nome do Aluno:</label>
                        <input type="text" id="nomeDoAluno" name="nomeDoAluno" required>
                    </div>
                    <div>
                        <label for="turma">Turma:</label>
                        <input type="text" id="turma" name="turma" required>
                    </div>
                    <div>
                        <label for="diagnostico">Digite os detalhes do diagnóstico:</label>
                        <input type="text" id="diagnostico" name="diagnostico" required>
                    </div>
                    <button type="submit">Enviar Cadastro</button>
                    <%
                        String mensagem = (String) request.getAttribute("mensagem");
                        if (mensagem != null) {
                            out.print(mensagem);
                        }
                    %>
                </form>
                <div style="text-align: center; margin-top: 20px;">
                    <p>Já tem uma conta? <a href="login.jsp">Clique aqui para fazer login</a></p>
                </div>
            </section>
        </section>
    </main>

    <footer>
        <h7>| Promovendo a inclusão escolar e construindo caminhos para que alunos com TEA desenvolvam seu potencial.|</h7>
        <br>
        <h8>© 2024 UniTEA. Todos os direitos reservados.</h8>
    </footer>
</body>
</html>
