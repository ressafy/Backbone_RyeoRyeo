-- 1.
use world;

-- 2.
desc city;
desc country;
desc countrylanguage;


-- 3.
select * 
from country
where code = 'KOR';

-- 4. 
select code,gnp,gnpold,gnp-gnpold as 'gnp변동량'
from country
where gnp - gnpold > 0 order by gnpold-gnp desc;

-- 5.
select distinct(continent) 
from country order by length(continent) asc;

-- 6.
select concat(name,'은 ', region, '에 속하며 인구는', population,'명이다.') '정보' 
from country where continent = 'asia';

-- 7.

