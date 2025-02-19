<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UNITEA - Cadastro de Usuário</title>
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

        nav a:hover {
            background-color: #003366;
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

        #cadastroMonitor {
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

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="email"],
        input[type="password"] {
            padding: 10px;
            font-size: 16px;
            border: 1px solid #ccc;
            border-radius: 5px;
            width: 100%;
            margin-bottom: 15px;
        }

        .disciplinas-grid {
            display: grid;
            grid-template-columns: 1fr 1fr;
            gap: 15px;
        }

        .submit-btn {
            background-color: #004a99;
            color: white;
            padding: 12px 20px;
            border: none;
            border-radius: 5px;
            font-size: 16px;
            cursor: pointer;
            transition: background-color 0.3s ease;
            display: block;
            margin: 20px auto;
        }

        .submit-btn:hover {
            background-color: #003366;
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
        <h1 style="position: absolute; font-size: 20px; top: 35px; left: 10%;">UniTEA</h1>
        <h2 style="position: absolute; font-size: 40px; top: 80px; left: 5%;">Inclusão Escolar</h2>
        <nav>
            <ul>
                <li><a href="InicialCadastro.jsp">Página Inicial</a></li>
                <li><a href="cadastrofamiliar.jsp">Cadastro Familiar</a></li>
                <li><a href="cadastroMonitor.jsp" id="cadastroMonitor">Cadastro Monitor</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </nav>
    </header>

    <main>
        <section class="inicio">
            <h3>Cadastro de Monitor</h3>
        </section>

        <section class="meio">
            <h2>Cadastre-se gratuitamente!</h2>
            <div class="medio">
                <form action="cadastrarMonitor" method="POST">
                    <label for="Nome">Nome:</label>
                    <input type="text" id="Nome" name="nome" required>

                    <label for="Email">Email:</label>
                    <input type="email" id="Email" name="email" required>

                    <label for="Senha">Senha:</label>
                    <input type="password" id="Senha" name="senha" required>

                    <label for="Endereco">Endereço:</label>
                    <input type="text" id="Endereco" name="endereco" required>

                    <div>
					    <label for="perfil">Perfil:</label>
					    <select id="perfil" name="perfil" required>
					        <option value="" disabled selected>Selecione seu perfil</option>
					        <option value="mentor">Mentor</option>
					    </select>
					</div>
					
                    <label for="Especializacao">Especialização:</label>
                    <input type="text" id="Especializacao" name="especializacao" required>

                    <label for="AnosExperiencia">Anos de Experiência:</label>
                    <input type="text" id="AnosExperiencia" name="anosExperiencia" required>

                    <label for="FormacaoAcademica">Formação Acadêmica:</label>
                    <input type="text" id="FormacaoAcademica" name="formacaoAcademica" required>

                    <label>Disciplinas:</label>
                    <div class="disciplinas-grid">
                        <input type="text" id="Disciplina1" name="disciplina1" placeholder="Disciplina 1" required>
                        <input type="text" id="Disciplina2" name="disciplina2" placeholder="Disciplina 2" required>
                        <input type="text" id="Disciplina3" name="disciplina3" placeholder="Disciplina 3" required>
                        <input type="text" id="Disciplina4" name="disciplina4" placeholder="Disciplina 4" required>
                    </div>

                    <button type="submit" class="submit-btn">Enviar Cadastro</button>

                    <div>
                        <% 
                        String mensagem = (String) request.getAttribute("mensagem");
                        if (mensagem != null)
                            out.print(mensagem);
                        %>
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

