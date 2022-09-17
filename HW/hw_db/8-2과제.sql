select * from user;
select * from board;

-- 1
SELECT count(*) 행수
FROM user, board
union distinct
SELECT count(*) 행수
FROM user,board; 

-- 2
select id,title
from user u, board b
where u.name = b.writername;

-- 3
select id, title
from user u, board b
where b.title like '%헐크%'
and u.name = b.writername
group by b.title;

-- 4
select email, createtime
from user u, board b
where year(b.createtime) < 2018
and u.name = b.writername;

-- 5 모르겠습니다
select  count(content) > 0 사용자수 , year(createtime) 년도
from user u, board b
group by year(createtime);

-- 6 모르겠습니다...
select id, 개수
from user u, board b
group by u.id;

-- 7
select id , age
from user 
where age > (select age from user where id = 'BlackWidow');

-- 8 
select id
from user
where (select count(*)>0 from board) 
and user.name = board.writername;

-- 9
select title
from board
where writername = any(select name from user where age between 30 and 60);

-- 10 ~ 한적이 있다면, 존재한다면을 못풀겠습니다...
select name
from user