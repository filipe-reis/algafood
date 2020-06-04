insert into cozinha (id, nome) values (1, 'Tailandesa');
insert into cozinha (id, nome) values (2, 'Indiana');

insert into restaurante (nome, taxa_frete, cozinha_id) values('Thai Gourmet', 10, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values('Thai Delivery', 9.50, 1);
insert into restaurante (nome, taxa_frete, cozinha_id) values('Tuk Tuk Comida Indiana', 15, 2);

insert into estado(id, nome) values (1, 'São Paulo');
insert into estado(id, nome) values (2, 'Rio de Janeiro');

insert into cidade(nome, estado_id) values ('São Paulo', 1);
insert into cidade(nome, estado_id) values ('Morumbi', 1);
insert into cidade(nome, estado_id) values ('Ipanema', 2);
insert into cidade(nome, estado_id) values ('Botafogo', 2);

insert into forma_pagamento(descricao) values('à vista');
insert into forma_pagamento(descricao) values('parcelado sem juros');
insert into forma_pagamento(descricao) values('parcelado com juros');

insert into permissao(nome, descricao) values ('escrita', 'essa permissão tem acesso para alteração');
insert into permissao(nome, descricao) values ('leitura', 'permissao apenas para leitura dos registros');

