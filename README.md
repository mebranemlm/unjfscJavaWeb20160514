# unjfscJavaWeb20160514
Proyecto Java Web del 2016/05/14
#BD - Oracle

create table t_usuario(
usua varchar2(50) primary key not null,
pass varchar2(50),
freg date,
esta int
);
commit;

create table t_docente(
codi varchar2(50) primary key,
nomb varchar2(50),
apel varchar2(50),
freg date,
esta int,
usua varchar2(50),
foreign key (usua) references t_usuario(usua)
);
commit;


insert into t_usuario values(
'U001',
'123',
to_date('14/05/2016 09:37:00','DD/MM/YY HH24:MI:SS'),
'1');
commit;

insert into t_docente values(
'D001',
'Roberto',
'Sosa',
sysdate,
'1',
'U001');
commit;
