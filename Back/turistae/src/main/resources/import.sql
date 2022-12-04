-- isso era usado quando tinha a tabela user para cadastrar um tipo de usuário e depois o usuário em si
-- INSERT INTO tb_usuarios(permissao, email, senha) VALUES ('visitante', 'ettore@hotmail.com', '123456789');
-- INSERT INTO tb_usuarios(permissao, email, senha) VALUES ('turismo', 'turismo@teste.com.br' '123456789');

-- BASE DE USUÁRIOS
INSERT INTO tb_visitantes(nome, email, senha, permissao) VALUES ('Ettore Rollo','vini@gmail.com','123456789','visitante');
INSERT INTO tb_visitantes(nome, email, senha, permissao) VALUES ('Rafaela Estefogo','rafaela@gmail.com','123456789','visitante');
INSERT INTO tb_visitantes(nome, email, senha, permissao) VALUES ('Vitor Borges','vitor@gmail.com','123456789','visitante');
INSERT INTO tb_visitantes(nome, email, senha, permissao) VALUES ('Vinicius Borges','vinicius@gmail.com','123456789','visitante');
INSERT INTO tb_visitantes(nome, email, senha, permissao) VALUES ('Lucas Spizzica','lucas@gmail.com','123456789','visitante');

-- BASE CONTEUDO
INSERT INTO tb_conteudo(descricao,anexo) VALUES ('foto parque das águas','foto');
INSERT INTO tb_conteudo(descricao,anexo) VALUES ('foto iguatemi','foto iguatemi');

-- BASE TURISMO
INSERT INTO tb_turismo(nomefantasia,razaosocial,bairro,celular,numero,logradouro,cep,uf,cnpj,cidade, email, senha, permissao, id_conteudo) VALUES ('teste','aipreto', 'aipreto',  'aipreto' , 'aipreto', 'aipreto', 'aipreto', 'aipreto', 'aipreto', 'aipreto' , 'aipreto@gmail.com', '123456789', 'turismo', 1);
INSERT INTO tb_turismo(nomefantasia,razaosocial,bairro,celular,numero,logradouro,cep,uf,cnpj,cidade, email, senha, permissao, id_conteudo) VALUES ('empresaLucas','RazãoempresaLucas','bairro','15998889889','10','casa','18540000','sp','59515668000114','Porto feliz', 'empresaLucas@hotmail.com', '123456789', 'turismo',2);

-- INSERT INTO tb_visitantes(nome,email,senha,ID_Usuario) VALUES ('lucas','lucas@gmail.com','12345',1);
-- INSERT INTO tb_visitantes(nome,email,senha,ID_Usuario) VALUES ('joao','joao@gmail.com','123458',1);
-- INSERT INTO tb_visitantes(nome,email,senha,ID_Usuario) VALUES ('leo','leo@gmail.com','123e458',1);






-- INSERT INTO tb_blog(conteudo,ID_Visitante,ID_Post) VALUES ('parque das águas',1,1);


ALTER TABLE tb_blog ADD FOREIGN KEY (id_post) REFERENCES tb_conteudo(id_post);
ALTER TABLE tb_blog ADD FOREIGN KEY (id_visitante) REFERENCES tb_conteudo(id_visitante);
ALTER TABLE tb_visitantes ADD FOREIGN KEY (id_usuario) REFERENCES tb_conteudo(id_usuario);
ALTER TABLE tb_turismo ADD FOREIGN KEY (id_usuario) REFERENCES tb_conteudo(id_usuario);




