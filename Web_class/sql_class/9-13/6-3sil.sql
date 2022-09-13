use world;

select now();

-- 1.
select curdate() "오늘", 
datediff(curdate(),'2022-01-01')"올해 지난 날",
date_add(curdate(),interval 100 day) "100일 후";

-- 2.
select name, continent, LifeExpectancy,
case
	when LifeExpectancy > 80 then "장수국가"
    when LifeExpectancy > 60 then "일반국가"
	else "단명국가"
end "구분"
from country
where continent = 'asia'
order by LifeExpectancy;

-- 3.
select name, gnp, gnpold, ifnull(gnp-gnpold,'신규') "gnp 향상"
from country
order by 1;

-- 4.
select weekday('2022-05-05'), if(weekday('2022-05-05')>4,'불행','행복')"헹복여부";

-- 5.
select count(code) "전체" , count(IndepYear) "독립연도보유"
from country;

-- 6.
select sum(LifeExpectancy) "합계", 
round(avg(LifeExpectancy),2) "평균",
max(LifeExpectancy) "최대",
min(LifeExpectancy) "최소"
from country;

-- 7.
select continent, count(code)"국가 수", sum(Population)"인구 합"
from country
group by continent
order by 2 desc;

-- 8.
select continent, sum(SurfaceArea)"표면적의 합"
from country
group by continent
order by 2 asc limit 3;

-- 9.
select continent, sum(GNP)"gnp 합"
from country
where Population >= 50000000
group by continent
order by 2 desc limit 5;

-- 10.
select continent, sum(GNP)"gnp 합"
from country
where Population >= 50000000
group by continent
having sum(GNP)>= 5000000;

-- 11.
select indepyear, count(IndepYear) "독립 국가 수"
from country
group by IndepYear
having count(IndepYear) >= 10;

-- 12.
