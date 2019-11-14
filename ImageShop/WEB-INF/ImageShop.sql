commit;

create table code_class(
	class_code varchar2(3) not null,
	class_name varchar2(30) not null,
	use_yn varchar2(1) not null default 'Y',
	reg_date date not null default sysdate,
	upd_date date not null default sysdate,

);



alter table code_class add constraint class_primarykey primary key class_code;

select * from CODE_DETAIL;
select * from CODE_CLASS;
select * from member;
select * from board;
select * from pds;
select * from pds_attach;
select * from notice;
select * from item;

delete from pds;

insert into code_detail(class_code,code_value,code_name,sort_seq,use_yn)
	   values('A01','A01','Army',class_detail_seq.nextval,'Y');

drop table member;
create table member(
	user_no number ,
	user_id varchar2(50) not null,
	user_pw varchar2(100) not null,
	user_name varchar2(100) not null,
	job varchar2(10) default '00' not null ,
	coin number default 0,
	reg_date date default sysdate,
	upd_date date default sysdate,
	enabled varchar2(5) default '1'
	
);

delete  from member;

drop sequence user_no_seq;
create sequence user_no_seq
  start with 1
  increment by 1;

 create sequence class_detail_seq
 	start with 1
 	increment by 1;
  
 create sequence board_seq
 	start with 1
 	increment by 1;
 	
 create sequence pds_attach_seq
 	start with 1
 	increment by 1;
 	
 create sequence notice_no_seq
 	start with 1
 	increment by 1;
 	
 create sequence item_id_seq
 	start with 1
 	increment by 1;
 	
 create sequence log_no_seq
 	start with 1
 	increment by 1;	
 
 create sequence perlog_no_seq
 	start with 1
 	increment by 1;		
 	
 select * from user_sequences;
  
alter table member add constraint member_primarykey primary key (user_no);

drop table member_auth;
create table member_auth(
	user_no number not null,
	auth varchar2(50) not null
);

alter table member_auth add constraint fk_member_auth_user_no foreign key(user_no) references member(user_no);

create table persistent_logins(
	username varchar2(64) not null,
	series varchar2(64) not null,
	token varchar2(64) not null,
	last_used date not null
);

alter table persistent_logins add constraint member_auth_primarykey primary key (series);

create table board(
	board_no number not null,
	title varchar2(200) not null,
	content varchar2(500),
	writer varchar2(50) not null,
	reg_date date default sysdate not null
);

alter table board add constraint board_primarykey primary key (board_no);

create table notice(
	notice_no number not null,
	title varchar2(200) not null,
	content varchar2(500),
	reg_date date default sysdate not null
);

alter table notice add constraint notice_primarykey primary key (notice_no);

drop table item;
create table item(
	item_id number,
	item_name varchar2(20),
	price number,
	description varchar2(50),
	picture_url varchar2(200),
	preview_url varchar2(200)

);

alter table item add constraint item_primarykey primary key (item_id);


create table pds(
	item_id number,
	item_name varchar2(100),
	view_cnt number default 0,
	description varchar2(100)

);
alter table pds add constraint pds_primarykey primary key (item_id);

create table pds_attach(
	fullName varchar2(150) not null,
	item_id number not null,
	down_cnt number default 0,
	regdate date default sysdate

);
alter table pds_attach add constraint pds_attach_primarykey primary key (fullName);


create table charge_coin_history(
	history_no number,
	user_no number not null,
	amount number not null,
	reg_date date default sysdate
	
);

alter table charge_coin_history add constraint charge_coin_primarykey primary key (history_no);

create sequence history_no_seq
  start with 1
  increment by 1;

drop sequence history_no_seq;
  
create table pay_coin_history(
	history_no number,
	user_no number not null,
	item_id number not null,
	amount number not null,
	reg_date date default sysdate
);

alter table pay_coin_history add constraint pay_coin_primarykey primary key (history_no);

create table login_log(
	log_no number not null,
	user_no number not null,
	user_id varchar2(50) not null,
	remote_addr varchar2(50) not null,
	reg_date date default sysdate not null
);
alter table login_log add constraint login_log_primarykey primary key (log_no);

create table access_log(
	log_no number not null,
	request_uri varchar2(200) not null,
	class_name varchar2(100) not null,
	class_simple_name varchar2(50) not null,
	method_name varchar2(100) not null,
	remote_addr varchar2(50) not null,
	reg_date date default sysdate not null

);

alter table access_log add constraint access_log_primarykey primary key (log_no);

create table performance_log(
	log_no number not null,
	signature_name varchar2(50) not null,
	signature_type_name varchar2(100) not null,
	duration_time number default 0,
	reg_date date default sysdate not null

);
alter table performance_log add constraint performance_log_primarykey primary key (log_no);