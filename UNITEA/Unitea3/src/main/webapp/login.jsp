<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Página de Login</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    body {
      margin: 0;
      padding: 0;
      height: 100%;
      font-family: Arial, Helvetica, sans-serif;
    }

    .divisaodapagina {
      display: flex;
      height: 100vh;
    }

    .ladoesquerdo {
      flex: 1;
      background-color: #ffffff;
      background-image: url(/Unitea1/Imagens/projeto.jpeg);
      background-size: cover;
      background-position: center;
      padding: 20px;
      color: #ffffff;
      text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.6);
    }

    .ladoesquerdo h1 {
      font-size: 50px;
      text-align: center;
      margin-top: 30px;
    }

    .ladoesquerdo p {
      font-size: 45px;
      text-align: center;
      margin-top: 100px;
    }

    .ladodireito {
      flex: 1;
      background-color: #273DCE;
      color: white;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
    }

    .linha {
      border-top: 1px solid #ffffff;
      width: 300px;
      margin: 20px auto;
    }

    .quadrodelogin {
      background-color: #D5DFF0;
      padding: 30px;
      border-radius: 8px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      width: 400px;
    }

    .quadrodelogin div {
      margin-bottom: 20px;
    }

    input {
      width: 100%;
      padding: 10px;
      border: 1px solid #D5DFF0;
      border-radius: 4px;
      font-size: 16px;
    }

    .logar {
      width: 100%;
      padding: 12px;
      background-color: #273DCE;
      border: none;
      border-radius: 30px;
      color: white;
      font-size: 18px;
      cursor: pointer;
      margin-top: 10px;
    }

    .logar:hover {
      background-color: #1f2ea7;
    }

    .mensagem-erro {
      color: red;
      font-size: 14px;
      text-align: center;
      margin-top: 10px;
    }
  </style>
</head>
<body>
  <div class="divisaodapagina">
    <div class="ladoesquerdo">
      <h1>UniTEA</h1>
      <p>Bem vindo(a) ao UniTEA!</p>
    </div>
    <div class="ladodireito">
      <h2>Faça o seu login</h2>
      <div class="linha"></div>
      <div class="quadrodelogin">
        <form action="loginL" method="POST">
          <div>
            <p style="color: #293ecc;">Email</p>
            <input type="text" name="Email" placeholder="Email" required>
          </div>
          <div>
            <p style="color: #273DCE;">Senha</p>
            <input type="password" name="Senha" placeholder="Senha" required>
          </div>
          <button type="submit" class="logar">Entrar</button>
          <div style="text-align: center; margin-top: 20px; color: #273DCE">
            <p>Deseja voltar a tela inicial? <a href="InicialCadastro.jsp">Clique aqui</a></p>
          </div>
          <div class="mensagem-erro">
            <% 
              String mensagem = (String) request.getAttribute("mensagem");
              if (mensagem != null) {
            %>
              <p><%= mensagem %></p>
            <% } %>
          </div>
        </form>
      </div>
    </div>
  </div>
</body>
</html>
