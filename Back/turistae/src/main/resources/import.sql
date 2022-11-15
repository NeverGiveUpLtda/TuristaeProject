INSERT INTO tb_usuarios(permissao) VALUES ('visitante');
INSERT INTO tb_usuarios(permissao) VALUES ('turismo');


INSERT INTO tb_visitantes(nome,email,senha,ID_Usuario) VALUES ('vini','vini@gmail.com','123',1);
INSERT INTO tb_visitantes(nome,email,senha,ID_Usuario) VALUES ('lucas','lucas@gmail.com','12345',1);
INSERT INTO tb_visitantes(nome,email,senha,ID_Usuario) VALUES ('joao','joao@gmail.com','123458',1);
INSERT INTO tb_visitantes(nome,email,senha,ID_Usuario) VALUES ('leo','leo@gmail.com','123e458',1);

INSERT INTO tb_turismo(nomefantasia,razaosocial,bairro,celular,numero,logradouro,cep,uf,cnpj,cidade,ID_Usuario) VALUES ('teste','aipreto', 'aipreto',  'aipreto' , 'aipreto', 'aipreto', 'aipreto', 'aipreto', 'aipreto', 'aipreto' , 2);


INSERT INTO tb_conteudo(descricao,anexo,data) VALUES ('foto parque das águas','foto','2020-09-08');

INSERT INTO tb_blog(conteudo,ID_Visitante,ID_Post) VALUES ('parque das águas',1,1);


ALTER TABLE tb_blog ADD FOREIGN KEY (id_post) REFERENCES tb_conteudo(id_post);
ALTER TABLE tb_blog ADD FOREIGN KEY (id_visitante) REFERENCES tb_conteudo(id_visitante);
ALTER TABLE tb_visitantes ADD FOREIGN KEY (id_usuario) REFERENCES tb_conteudo(id_usuario);
ALTER TABLE tb_turismo ADD FOREIGN KEY (id_usuario) REFERENCES tb_conteudo(id_usuario);




