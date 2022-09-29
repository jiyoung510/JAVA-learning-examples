select * from member;
delete from member where id='hong';
select * from MVCBOARD;
create table MVCMEMBER (
id varchar2(10) not null,
pass varchar2(10) not null,
name varchar2(30) not null,
regidate date default sysdate not null,
birth varchar2(10),
addr varchar2(50),
email varchar2(50),
primary key(id)
);
insert into MVCMEMBER (id, pass, name)
    values ('kys', '1234', '������');
insert into MVCMEMBER (id, pass, name)
    values ('jbg', '1234', '�庸��');
insert into MVCMEMBER (id, pass, name)
    values ('lss', '1234','�̼���');
insert into MVCMEMBER (id, pass, name)
    values ('kkc', '1234','������');
insert into MVCMEMBER (id, pass, name)
    values ('djy', '1234','������');
drop table MVCMEMBER;
drop table MVCBOARD;
create table mvcboard2 (
	idx number primary key, 
	id varchar2(10) not null,
	name varchar2(50) not null, 
	title varchar2(200) not null, 
	content varchar2(2000) not null, 
	postdate date default sysdate not null, 
	ofile varchar2(200), 
	sfile varchar2(30), 
	downcount number(5) default 0 not null, 
	pass varchar2(50) not null, 
	visitcount number default 0 not null
);
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '������', '�ڷ�� ����1 �Դϴ�.','����','1234');
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '�庸��', '�ڷ�� ����2 �Դϴ�.','����','1234');
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '�̼���', '�ڷ�� ����3 �Դϴ�.','����','1234');
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '������', '�ڷ�� ����4 �Դϴ�.','����','1234');
insert into mvcboard (idx, name, title, content, pass)
    values (seq_board_num.nextval, '������', '�ڷ�� ����5 �Դϴ�.','����','1234');
    
alter table mvcboard add constraint mvcboard_mem_fk foreign key (id) references mvcmember (id);
create table mvcboard (
	idx number primary key, 
	name varchar2(50) not null, 
	title varchar2(200) not null, 
	content varchar2(2000) not null, 
	postdate date default sysdate not null, 
	ofile varchar2(200), 
	sfile varchar2(30), 
	downcount number(5) default 0 not null, 
	pass varchar2(50) not null, 
	visitcount number default 0 not null
);