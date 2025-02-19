<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head> 
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela inicial comum</title>
    <link rel="stylesheet" href="paginainicialcadastro.css">
</head>
<script src="https://kit.fontawesome.com/e5d084f68c.js" crossorigin="anonymous"></script>
    
    <style>
    *{
    margin: 0;
    padding: 0;
    box-sizing: border-box;
}

body{
    font-family: Arial, Helvetica, sans-serif;
    line-height: 1.6;
}

header{
    background-image: url(/Unitea1/Imagens/projeto.jpeg);
    filter: brightness(100%);
    padding: 15px;
    background-size: contain;
    width: 100%;
    height: 300px;
    color: #ffffff;
    background-position: center;
    background-size: cover;
    align-items: center;
    display: flex;
    text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.6);
    justify-content: space-between;
}

#paginainicial{
    border: 2px solid hsl(219, 29%, 41%);
    border-radius: 5px;
}

nav ul{
    list-style: none;
    display: flex;
    left: 45%;
    top: 20px;
    position: absolute;
}

nav ul li{
    text-shadow: 2px 2px 5px rgba(0, 0, 0, 0.6);
    margin: 0 15px;
}

nav ul li a{
    color: hsl(0, 0%, 100%);
    text-decoration: none;
    font-size: 18px;
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
header h3{
    background-color: transparent;
    border: 2px solid white;
    padding: 5px; 
    text-align: center; 
    font-size: 16px;
    margin: 2px 2px; 
    cursor: pointer; 
    border-radius: 5px;
    position: absolute;
    top: 190px;
    left: 200px;
}

.parte1{
    padding: 100px 20px;
    background-color: hsl(0, 0%, 100%);
    text-align: center;
}

.quadro1{
    background-color: #D5DFF0;
    padding: 100px;
    width: 550px;
    border-radius: 10px;
    transform: translate(100px, 30px);
}

.linha {
    border-top: 1px solid #000000; 
    width: 500px;  
    margin: 10px 0; 
    transform:translate(-70px, -80px);

}

#textomonitoriasgrat{
    font-size: 35px;
    color: #273DCE;
    top: 460px;
    left: 800px;
    position: absolute;
}

.parte2{
    padding: 110px 20px;
    background-color: #D5DFF0;
    text-align: center;
}

#textosecadastre{
    font-size: 35px;
    color: #273DCE;
    top: 760px;
    left: 120px;
    position: absolute;
}

#cadastromonitor{
    background-color: transparent;
    border: 2px solid rgb(31, 31, 122);
    padding: 5px; 
    text-align: center; 
    text-decoration: none; 
    font-size: 16px;
    margin: 4px 2px; 
    cursor: pointer; 
    border-radius: 5px;
    position: relative;
    left: 310px;
}

.parte3{
    padding: 100px 20px;
    background-color: hsl(0, 0%, 100%);
    text-align: center;
}

#textoeducacao{
    font-size: 35px;
    color: #273DCE;
    top: 1100px;
    left: 200px;
    position: absolute;
}

.fundoquadro2{
    display: flex;
    justify-content: space-around;
    gap: 20px;
}

.quadro2{
    background-color: #D5DFF0;
    padding: 60px;
    width: 550px;
    border-radius: 10px;
    transform: translate(350px, -30px);
}

footer{
    color: azure;
    background-color: hsl(219, 84%, 48%);
    text-align: center;
    padding: 20px;
    font-size: 14px;
}

@media (max-width: 768px) {
    nav ul {
        flex-direction: column;
        align-items: center;
    }

    nav ul li {
        margin: 10px 0;
    }

    .quadropedido {
        flex-direction: column;
        align-items: center;
    }

    .pedidos {
        width: 80%;
        margin-bottom: 20px;
    }

    .chat{
        width: 0%;
        margin-bottom: 20px;
    }

    #messagem{
        width: 0%;
        margin-bottom: 20px;
    }  
}

@media (max-width: 480px) {
    .pedido h3 {
        font-size: 20px;
    }

    .pedido p {
        font-size: 14px;
    }
}

    </style>
<body>
    <header>
        <h1 style="position: absolute; font-size: 20px; top: 20px; left: 17%;">UniTEA</h1> 
        <h2 style="position: absolute; font-size: 50px; top: 55px; left: 5%; color: #3697D3;">Inclusão Escolar</h2>
        <nav>
            <ul>
                <li><a id="paginainicial">Página Inicial</a></li>
                <li><a href="cadastrofamiliar.jsp">Cadastro Familiar</a></li>
                <li><a href="cadastroMonitor.jsp">Cadastro Monitor</a></li>
                <li><a href="login.jsp">Login</a></li>
            </ul>
        </nav>
    </header>
    <section class="parte1">
        <div class="fundoquadro">
                <div class="quadro1">
                    <i class="fa-solid fa-book" style="color:  rgb(48, 48, 217); font-size: 80px; position: absolute; left: 90px; top: 60px;"></i>
                    <i class="fa-solid fa-pencil" style="color:  rgb(48, 48, 217); font-size: 80px; position: absolute; left: 220px; top: 60px;"></i>
                    <i class="fa-solid fa-graduation-cap" style="color:  rgb(48, 48, 217); font-size: 80px; position: absolute; left: 360px; top: 60px;"></i>
            </div>
        </div>
        <p id="textomonitoriasgrat"><b>Monitorias gratuitas<br>
            para alunos com TEA.</b></p>
    </section>
   <section class="parte2">
        <div>
         <p id="textosecadastre"><b>Se cadastre como monitor e ajude<br> a promover a Inclusão escolar.</b></p>
        </div>
        <div>    
            <h4><a href="cadastroMonitor.jsp" id="cadastromonitor" style="color: rgb(48, 48, 217); text-decoration: none;"><b>Cadastro Monitor</b></a></h4>    
        </div>
   </section>
   <section class="parte3"> 
        <div>
            <p id="textoeducacao"><b>Educação é para todos</b></p>    
        </div>
        <div class="fundoquadro2">
            <div class="quadro2">
                <p id="textoquadro2"><b>“Educação não transforma o mundo. Educação muda as pessoas. Pessoas transformam o mundo.”</b></p>
                <p id="nomeautor">Paulo Freire</p>
            </div>
        </div>
   </section>
    <footer>
        <h7>| Promovendo a inclusão escolar e construindo caminhos para que alunos com TEA desenvolvam seu potencial.|</h7>
        <br>
        <h8>© 2024 UniTEA. Todos os direitos reservados.</h8>
    </footer>
</body>
</html>