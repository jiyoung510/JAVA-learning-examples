create table member (
	id varchar2()
	
)

create table board (
	idx number primary key, 
	title varchar2(200) not null, 
	content varchar2(2000) not null, 
	postdate date default sysdate not null, 
	ofile varchar2(200), 
	sfile varchar2(30), 
	downcount number(5) default 0 not null, 
	visitcount number default 0 not null
);