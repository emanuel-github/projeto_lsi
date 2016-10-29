create database SistemaDeRecargas;


create table TB_USUARIO(
idUsuario serial primary key,
nome varchar (100),
email varchar(100),
login varchar(100),
senha varchar (100)
);



create table TB_CLIENTE(
idCliente serial primary key,
cpf varchar (14),
email varchar(100),
telefone varchar (12),
idUsuario int,
constraint cliente_usuario foreign key (idUsuario) references TB_USUARIO(idUsuario)
);


create table TB_CARTUCHO(
idCartucho serial primary key,
modelo varchar(100),
preco decimal(4,2)
);


create table TB_TONER(
idToner serial primary key,
modelo varchar(100),
preco decimal(4,2)
);




create table TB_RECARGA(
idRecarga serial primary key,
data Date,
preco decimal (10,2),
pesoAtual decimal(3,3),
pesoFinal decimal(3,3),
idCartucho int,
idToner int,
constraint recarga_cartucho foreign key (idCartucho) references TB_CARTUCHO(idCartucho),
constraint recarga_toner foreign key (idToner) references TB_TONER(idToner)
);

