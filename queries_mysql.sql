
-- elimino la base de datos si existe
drop database if exists queries_mysql;


create database if not exists queries_mysql; -- creo la base de datos si no existe

use queries_mysql;

/*
 Me creo la tablas
 - empiezo por DEPARTAMENTOS
 y continuo con EMPLEADOS
*/

create table DEPARTAMENTOS ( 
	DEPTNO	int 		not null 	primary key, 
	DNAME 	varchar(15) 	not null,
	LOC 	varchar(10)	not null
);

create table if not exists EMPLEADOS ( 
	EMPNO 	int 		not null 	primary key, 
	DEPTNO 	int 		null, 
	ENAME 	varchar(10) 	not null, 
	JOB 	varchar(20) 	not null, 
	MGR 	int 		null, 
	HIREDATE datetime 	not null, 
	SAL 	int 		not null, 
	COMM 	int 		null
);

alter table EMPLEADOS 
	add constraint fk_emp_tiene_dept foreign key (DEPTNO)
	references DEPARTAMENTOS(DEPTNO);

create index tiene_emp ON EMPLEADOS (
	DEPTNO ASC
);


insert into DEPARTAMENTOS values (10, 'ACCOUNTING', 'NEW YORK');





