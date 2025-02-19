DROP DATABASE IF EXISTS UNITEA;
CREATE DATABASE UNITEA;
USE UNITEA;

-- Tabela de Usuario
CREATE TABLE UNITEA.usuario (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    senha VARCHAR(100) NOT NULL,
    endereco VARCHAR(100) NOT NULL,
    perfil ENUM('mentor', 'familiar')
);

ALTER TABLE UNITEA.usuario AUTO_INCREMENT = 1;

-- Tabela Familiar
CREATE TABLE UNITEA.familiar (
    id_usuario INT,
    id_familiar INT AUTO_INCREMENT PRIMARY KEY,
    FOREIGN KEY (id_usuario) REFERENCES UNITEA.usuario(id_usuario) ON DELETE CASCADE
);

-- Tabela Monitor
CREATE TABLE UNITEA.monitor (
    id_usuario INT NOT NULL,
    id_monitor INT AUTO_INCREMENT PRIMARY KEY,
    especializacao VARCHAR(100) NOT NULL,
    anosExperiencia INT NOT NULL,
    formacaoAcademica VARCHAR(100) NOT NULL,
    disciplinas JSON NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES UNITEA.usuario(id_usuario) ON DELETE CASCADE
);

-- Tabela Aluno
CREATE TABLE UNITEA.aluno (
    id_aluno INT AUTO_INCREMENT PRIMARY KEY,
    id_familiar INT,
    FOREIGN KEY (id_familiar) REFERENCES UNITEA.familiar(id_familiar) ON DELETE CASCADE,
    nome VARCHAR(100) NOT NULL,
    diagnosticoTEA VARCHAR(100) NOT NULL,
    turma VARCHAR(100) NOT NULL
);

ALTER TABLE UNITEA.aluno AUTO_INCREMENT = 1;

-- Tabela PedidoMonitoria
CREATE TABLE UNITEA.pedidoMonitoria (
    id_pedido INT AUTO_INCREMENT PRIMARY KEY,
    informacoes VARCHAR(100) NOT NULL,
    status ENUM('pendente', 'aceito') NOT NULL,
    id_monitor INT,
    id_aluno INT,
    id_familiar INT,
    nome_chat VARCHAR(100), -- Coluna para armazenar o nome do chat
    disciplina VARCHAR(100), -- Coluna para disciplina
    FOREIGN KEY (id_monitor) REFERENCES UNITEA.monitor(id_monitor) ON DELETE CASCADE,
    FOREIGN KEY (id_aluno) REFERENCES UNITEA.aluno(id_aluno) ON DELETE CASCADE,
    FOREIGN KEY (id_familiar) REFERENCES UNITEA.familiar(id_familiar) ON DELETE CASCADE
);

-- Tabela Pedidos Criados por Familiar
CREATE TABLE UNITEA.pedidos_criados (
    id_pedido_criado INT AUTO_INCREMENT PRIMARY KEY,
    id_familiar INT,
    id_pedido INT,
	informacoes VARCHAR(100) NOT NULL,
    status ENUM('pendente') NOT NULL,
    id_aluno INT,
    nome_chat VARCHAR(100), -- Coluna para armazenar o nome do chat
    disciplina VARCHAR(100), -- Coluna para disciplina
    FOREIGN KEY (id_familiar) REFERENCES UNITEA.familiar(id_familiar) ON DELETE CASCADE,
    FOREIGN KEY (id_pedido) REFERENCES UNITEA.pedidoMonitoria(id_pedido) ON DELETE CASCADE
);

-- Tabela Pedidos em Andamento por Familiar
CREATE TABLE UNITEA.pedidos_andamento (
    id_pedido_andamento INT AUTO_INCREMENT PRIMARY KEY,
    id_familiar INT,
    id_pedido INT,
    id_monitor INT,
	informacoes VARCHAR(100) NOT NULL,
    status ENUM('aceito') NOT NULL,
    id_aluno INT,
    nome_chat VARCHAR(100), -- Coluna para armazenar o nome do chat
    disciplina VARCHAR(100), -- Coluna para disciplina
	FOREIGN KEY (id_monitor) REFERENCES UNITEA.monitor(id_monitor) ON DELETE CASCADE,
    FOREIGN KEY (id_familiar) REFERENCES UNITEA.familiar(id_familiar) ON DELETE CASCADE,
    FOREIGN KEY (id_pedido) REFERENCES UNITEA.pedidoMonitoria(id_pedido) ON DELETE CASCADE
);


-- Tabela Chat
CREATE TABLE UNITEA.chat (
    id_chat INT AUTO_INCREMENT PRIMARY KEY,
    id_pedido INT,
    id_familiar INT,
    id_monitor INT,
    nome_chat VARCHAR(100), -- Nome do chat referenciado do pedidoMonitoria
    FOREIGN KEY (id_monitor) REFERENCES UNITEA.monitor(id_monitor) ON DELETE CASCADE,
    FOREIGN KEY (id_familiar) REFERENCES UNITEA.familiar(id_familiar) ON DELETE CASCADE,
    FOREIGN KEY (id_pedido) REFERENCES UNITEA.pedidoMonitoria(id_pedido) ON DELETE CASCADE
);

-- Tabela Mensagem
CREATE TABLE UNITEA.mensagem (
    id_mensagem INT AUTO_INCREMENT PRIMARY KEY,
    conteudo TEXT NOT NULL,
    id_usuario INT,
    id_chat INT,
    FOREIGN KEY (id_usuario) REFERENCES UNITEA.usuario(id_usuario) ON DELETE CASCADE,
    FOREIGN KEY (id_chat) REFERENCES UNITEA.chat(id_chat) ON DELETE CASCADE
);

-- Inserir dados de exemplo
INSERT INTO UNITEA.usuario (nome, email, senha, endereco, perfil) 
VALUES ('joao', 'joao@gmail.com', 'joao1234', 'tanque novo', 'mentor');

-- Consultar as tabelas
SELECT * FROM UNITEA.usuario;
SELECT * FROM UNITEA.familiar;
SELECT * FROM UNITEA.aluno;
SELECT * FROM UNITEA.monitor;
SELECT * FROM UNITEA.pedidoMonitoria;
SELECT * FROM UNITEA.pedidoMonitoria WHERE id_pedido = '7';
SELECT * FROM UNITEA.pedidos_criados;
SELECT * FROM UNITEA.pedidos_andamento;
SELECT * FROM UNITEA.chat;
SELECT * FROM UNITEA.mensagem;

-- Excluir um usuário de exemplo
DELETE FROM usuario WHERE id_usuario = 3;