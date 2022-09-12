use ssafy_user;

drop table if exists user;
drop table if exists board;

CREATE TABLE `user` (
	`id` varchar(40) NOT NULL PRIMARY KEY,
    `password` varchar(40) NOT NULL,
    `name` varchar(40) NOT NULL,
    `email` varchar(40) NOT NULL,
    `age` int NOT NULL
)ENGINE=InnoDB;

CREATE TABLE `board` (
	`num` int(10) NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `createtime` datetime,
    `title` varchar(40) NOT NULL,
    `content` varchar(100) NOT NULL,
    `writername` varchar(40) NOT NULL
)ENGINE=InnoDB;



INSERT INTO `user` (id, password, name, email, age) 
VALUES
('BlackWidow', '1278','나타샤 로마노프', 'blackwidow@ssafy.com', 38),
('CaptainAmerica', '5678','스티브 로저스', 'Captain@ssafy.com', 30),
('Hulk', '2486','브루스 배너', 'hulk@ssafy.com', 54),
('Ironman', '1234','토니 스타크', 'ironman@ssafy.com', 53),
('Thor', '1111','토르', 'GodOfThunder@ssafy.com', 1500),
('Ultron', '2355','울트론', 'ultron@ssafy.com', 0);


INSERT INTO `board` (num, createtime, title, content, writername)
VALUES 
(0, '2015-04-23 12:00:00','지구의 적은 인류다', '어벤져스만 아니었다면...' ,'울트론'),
(0, '2015-04-23 13:00:00','울트론님 왜 제말을 안들으세요', '아빠말을 잘 안듣는 어린이네요', '토니 스타크'),
(0, '2017-10-25 17:00:00','헐크님 정신이 드시나요?', '살살 하걸 그랬네요..','토르'),
(0, '2017-10-25 17:10:10','헐크님 말좀 해보세요','아직도 누워계신가요?', '토르'),
(0, '2017-10-25 17:15:20','헐크 그만괴롭히세요 토르님','왜 자꾸 우리 헐크 기를 죽이고 그래요', '나타샤 로마노프'),
(0, '2019-04-29 09:10:00','묠니르 가벼군요','깃털처럼 가벼워요', '스티브 로저스'),
(0, '2019-04-24 09:10:00','헐크버스터 최고','너무 재밌네요', '브루스 배너');

commit;

select * from board;
-- 1.
select * from user;

-- 2.
select name from user;

-- 3.
select * from board
order by createtime;

-- 4.
select * from user
where name = '울트론';

-- 5.
select * from user
where name like '토%';

-- 6. 
select * from board
where title like "%헐크%";

-- 7. 
select * from user
where id = 'ironman' || id = 'CaptainAmerica';

-- 8.
select * from user
where name like '토%' and age > 50;

-- 9.
select * from board
order by createtime desc limit 3;

-- 10.
select * from board
order by year(createtime) desc, num asc;

-- 11.
 select * from user
 where substr(id,3,1) = 'o';
 
 -- 12.
 select replace(content,' ','+') as 치환 from board;
 
 -- 13. 
 select distinct writername  from board;

