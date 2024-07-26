select * from employees;

select * from departments;

select employee_id, emp_name, department_id, job_id, salary from employees;

-- join
select employee_id, emp_name, hire_date, salary,  a.department_id, b.department_name, parent_id from employees a, departments b
where a.department_id = b.department_id;

select employee_id, emp_name, department_id, job_id, manager_id, phone_number, salary from employees;

desc employees;

desc departments;

select *from board 
order by bgroup desc, bstep asc;


select * from employees a, departments b
where a.department_id = b.department_id;

select * from board
where btitle like '%나경원%';


select * from board;


create table commentB(
cno number primary key,
bno number(4),
id varchar2(30),
cpw varchar2(30),
ccontent varchar2(2000),
cdate date default sysdate
);

create table member(
memno number(4),
id varchar2(30) primary key,
pw varchar2(30),
name varchar2(30),
gender varchar2(6),
mdate date default sysdate
);


-- foreign key 등록하려면 primary key로 등록이 되어 있어야 추가
alter table commentB
add constraint fk_board_id
Foreign key(id) references member(id);

alter table commentB
add constraint fk_board_bno
Foreign key(bno) references board(bno);

desc board;
desc member;

drop table commentB;

insert into commentB values(
 commentB_seq.nextval,30,'ggg','','댓글 내용입니다.', sysdate
);

select * from member;

select * from commentB;
select * from commentB where bno=29;

select * from commentB where bno=29;

insert into member values(
 seq_mno.nextval,'ggg','1111','홍길자','F', sysdate
);

select * from board
where bno=29;

select count(*) from commentB;

select * from board;

desc board;
desc commentB;

select * from commentB
where  bno=29;

select * from board
where  bno=29;

select * from commentB;

commit;

select * from commentB where cno = 1;


-- * primary key 수정 - 추가 *
alter table board
add primary key (bno);
------------------------------------------------------------

--* foreign key 수정 - 추가 *
alter table board
add constraint fk_board_member_id foreign key(id)
references member(id);

--* Foreign key 수정-추가 : 연관되어 있는 모든 데이터 삭제  *
alter table board
add constraint fk_board_member_id foreign key(id)
references member(id)
on delete cascade

--* Foreign key 수정-추가 : 데이터 존재, 해당값 null표시  *
alter table board
add constraint fk_board_member_id foreign key(id)
references member(id)
on delete set null

------------------------------------------------------------
--* foreign key 삭제 *
alter table board drop constraint fk_board_member_id;
--* 테이블 생성 *
create table board(
 bno number(4) primary key,
  id varchar2(20),
  btitle varchar2(100) not null,
  constraint fk_board_member_id foreign key(id)
  references member(id)
);

