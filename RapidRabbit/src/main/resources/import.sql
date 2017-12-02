insert into Usuario (id, nome, email, login, senha, ativo, cadastro, tipo) values (1, 'Zezin', 'ze@ze', 'ze', '123', true, dateadd('year', -1, current_date),0);
insert into Usuario (id, nome, email, login, senha, ativo, cadastro, tipo) values (2, 'Pedrin', 'pe@pe', 'pe', '123', true, dateadd('year', -1, current_date),1);
insert into Usuario (id, nome, email, login, senha, ativo, cadastro, tipo) values (3, 'Gustin', 'gu@gu', 'gu', '123', true, dateadd('year', -2, current_date),2);

insert into Produto (id, descricao, peso) values (1, 'Panela de Barro', 20);
insert into Produto (id, descricao, peso) values (2, 'Bicicleta', 15);
insert into Produto (id, descricao, peso) values (3, 'Pizza', 0.4);

insert into ponto_referencia (id, descricao, detalhe,horrario,km_Faltante,km_Percorrido) values (1, 'Lanchonete MCPizza','Lanchonete',current_date,3,0);
insert into ponto_referencia (id, descricao, detalhe,horrario,km_Faltante,km_Percorrido) values (2, 'Subida do serra','cliente',current_date,1,2);
insert into ponto_referencia (id, descricao, detalhe,horrario,km_Faltante,km_Percorrido) values (3, 'Casa Maria','cliente',current_date,0,3);
insert into ponto_referencia (id, descricao, detalhe,horrario,km_Faltante,km_Percorrido) values (4, 'Casa Zezin','',current_date,350,0);
insert into ponto_referencia (id, descricao, detalhe,horrario,km_Faltante,km_Percorrido) values (5, 'Rio de Janeiro','Treino',current_date,0,350);

insert into Entrega (id, codigo_origem,codigo_destino,codigo_produto,valor,km_Percorrido,codigo_cliente,codigo_motorista,cadastro,entrega_Aberta) values (1, 1,3,3,30,3,1,2,current_date,false);



insert into Entrega (id, codigo_origem,codigo_destino,codigo_produto,valor,km_Percorrido,codigo_cliente,codigo_motorista,cadastro,entrega_Aberta) values (2, 4,5,2,350,120,1,2,current_date,true);

# insert into entrega_ponto (codigo_entrega, codigo_ponto) values (1,1);
insert into entrega_ponto (codigo_entrega, codigo_ponto) values (1,2);
# insert into entrega_ponto (codigo_entrega, codigo_ponto) values (1,3);
# insert into entrega_ponto (codigo_entrega, codigo_ponto) values (2,4);
# insert into entrega_ponto (codigo_entrega, codigo_ponto) values (2,5);
