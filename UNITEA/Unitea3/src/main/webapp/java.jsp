<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>UNITEA</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f8ff;
            color: #333;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #0066cc;
            color: white;
            padding: 15px;
            text-align: center;
        }

        nav {
            background-color: #004a99;
            color: white;
            padding: 10px 0;
            text-align: center;
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

        main {
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
            background-color: white;
            border-radius: 10px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }

        h2 {
            text-align: center;
            color: #0066cc;
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
            background-color: #0066cc;
            color: white;
            text-align: center;
            padding: 10px 0;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Cadastro de Usuário</h1>
    </header>
    
    <nav>
        <a href="#">Página inicial</a>
        <a href="#">Cadastro Familiar</a>
        <a href="#">Cadastro Monitor</a>
        <a href="login.jsp">Login</a>
    </nav>

    <main>
        <h2>Cadastre-se gratuitamente!</h2>
        
        <form action="cadastrarUsuario" method="POST">
            <div>
                <label for="Nome">Nome:</label>
                <input type="text" id="Nome" name="Nome" required>
            </div>
            
            <div>
                <label for="Email">Email:</label>
                <input type="text" id="Email" name="Email" required>
            </div>
            
            <div>
                <label for="Senha">Senha:</label>
                <input type="password" id="Senha" name="Senha" required>
            </div>
            
            <div>
                <label for="Endereco">Endereco:</label>
                <input type="text" id="Endereco" name="Endereco" required>
            </div>
            
            <div>
                <label for="Perfil">Perfil:</label>
                <input type="text" id="Perfil" name="Perfil" required>
            </div>
 
            <button type="submit">Enviar Cadastro</button>
            
            <div>
            <% 
            String mensagem= (String) request.getAttribute("mensagem");
            if(mensagem!= null)
            	out.print(mensagem);
            %>
            </div>
        </form>
    </main>

    <footer>
        <p>&copy; 2024 Cadastro de Alunos | Todos os direitos reservados</p>
    </footer>
</body>
</html>