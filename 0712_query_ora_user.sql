select count(*) from board;

select * from board order by bgroup desc, bstep asc;

select rownum rnum, a.*from board a order by bgroup desc, bstep asc;

select rownum rnum, a.*from (select * from board order by bgroup desc, bstep asc) a
where rownum>=1 and rownum<=10
;

-- 10개 단위로 끊어서 보기 1st
select * from
(select rownum rnum, a.*from (select * from board order by bgroup desc, bstep asc) a)
where rnum>=11 and rnum<=20
;
--  10개 단위로 끊어서 보기 2nd
select * from
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a)
where rnum>=11 and rnum<=20;


-- 현재글 rnum = 12 /  bno=24 => bno만 바꾸면 됨
select * from
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a)
where rnum = (select rnum from
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a)
where bno=5);

-- rnum로 찾기
select rnum from
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a)
where bno=24;

-- 현재글 rnum = 12 /  bno=24
select * from
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a)
where rnum = 12;

-- 이전글
select * from
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a)
where rnum = 12+1;

-- 디음글
select * from
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a)
where rnum = 12-1;

-- 리스트 호출시
select rownum rnum, a.*from (select * from board order by bgroup desc, bstep asc) a
where rownum>=1 and rownum<=10
;

-- 검색 호출시
select rownum rnum, a.*from (select * from board order by bgroup desc, bstep asc) a
where rownum>=1 and rownum<=10
and btitle like '%나경원%'
;

select rownum rnum, a.*from (select * from board order by bgroup desc, bstep asc) a
where rownum>=1 and rownum<=10
and btitle like '%나경원%' or bcontent like '%원희룡%'
;


select * from board 
where btitle like '%나경원%'
order by bgroup desc, bstep asc
;

-- 게시글 총개수
select count(*) from board;

select count(*) from board
where btitle like '%나경원%' or bcontent like '%원희룡%';



select count(*) from board
where btitle like '%나경원%';

select count(*) from board
where bcontent like '%나경원%';

select count(*) from board
where btitle like '%나경원%' or bcontent like '%나경원%';


select * from 
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a) 
where rownum>=1 and rownum<=10
and btitle like '%나경원%' or bcontent like '%나경원%';

select * from 
(select row_number() over(order by bgroup desc, bstep asc) rnum, a.*from board a
where btitle like '%나경원%' or bcontent like '%나경원%') 
where rownum>=1 and rownum<=10
and ;
