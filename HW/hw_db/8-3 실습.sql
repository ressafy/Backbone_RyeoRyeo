-- 1. 도시명 kabul이 속한 국가의 이름은?
-- country테이블에 code가 국가 코드이고 city의 countrycode가 국가코드임
-- 국가 이름은 country에, 도시명은 city에 있음
-- 여러 개의 테이블을 연결할 때 join 문장을 사용한다.
select co.code, co.name 
from country co join city ci on co.code = ci.countrycode
where ci.name='kabul';

-- 2. 국가의 공식 언어 사용율이 100%인 국가의 정보를 출력하시오. 국가 이름으로 오름차순 정렬한다.(8건)
-- join 조건과 일반 where 조건을 주의해서 사용하자.
select co.name, cl.language, cl.percentage 
from country co join countrylanguage cl on co.code=cl.countrycode 
where cl.isOfficial='T' and cl.percentage =100
order by 1;

-- 3. 도시명 amsterdam에서 사용되는 주요 언어와 amsterdam이 속한 국가는?
-- 여러 개의 테이블을 join 해야하는 경우에도 테이블간의 관계를 파악해서 연결시키면 된다.
-- city의 도시명으로 국가 코드를 찾고 국가 코드로 countrylanguage에서 언어를, country에서 국가명을 찾는다.
select ci.name, cl.language, co.name
from city ci join countrylanguage cl using (countrycode)
             join country co on ci.countrycode = co.code
where cl.isofficial = 'T' and ci.name='amsterdam';        

-- 4. 국가명이 united로 시작하는 국가의 정보와 수도의 이름, 인구를 함께 출력하시오. 단 수도 정보가 없다면 출력하지 않는다. (3건)
-- inner join의 경우 join되는 두 개의 테이블에 모두 정보가 있을 경우만 출력된다.
select co.name, co.capital, ci.name "수도", ci.population "수도인구"
from country co join city ci on co.capital = ci.id
where co.name like 'united%'; 

-- 5. 국가명이 united로 시작하는 국가의 정보와 수도의 이름, 인구를 함께 출력하시오. 단 수도 정보가 없다면 수도 없음이라고 출력한다. (4건)
-- 정보가 없는 경우에도 출력하기 위해서는 outer join을 사용한다.
select co.name, co.capital, ifnull(ci.name, '수도없음') "수도", 
                            ifnull(ci.population, '수도없음') "수도인구"
from country co left join city ci on co.capital = ci.id
where co.name like 'united%'; 

-- 6. 국가 코드 che의 공식 언어 중 가장 사용률이 높은 언어보다 사용율이 높은 공식언어를 사용하는 국가는 몇곳인가?
-- 먼저 che의 공식 언어 중 사용률의 최대값이 필요하다.
select max(percentage) from countrylanguage where isOfficial='T' and countrycode='che';

-- 이를 이용해 main query를 작성해보자.
select count(distinct(countrycode)) "국가수"
from countrylanguage 
where isOfficial='T' and percentage > (select max(percentage) 
                                       from countrylanguage 
                                       where isOfficial='T' and countrycode='che'
                                       );

-- 7. 국가명 south korea의 공식 언어는?
-- 조회 시점에 아직 모르는 값이 있다면 sub query를 이용해서 사용할 수 있다.
-- countrylanguage에는 나라 이름이 아닌 code만 있으므로 먼저 south korea의 code를 subquery로 조회하자.
select code from country where name='south korea';

-- 이제 얻어진 code를 이용해 main 쿼리를 작성한다.
select language 
from countrylanguage 
where countrycode = (select code from country where name='south korea') and isOfficial='T';

-- 8. 국가 이름이 bo로 시작하는 국가에 속한 도시의 개수를 출력하시오. (3건)
-- 국가별 도시의 개수를 모르기 때문에 이 부분을 먼저 쿼리해보자.
select countrycode "code", count(name) cnt from city group by code;

-- inline view를 이용하여 기존 테이블과 join 할 수 있다.
select c.name, c.code, t.cnt "도시개수"
from country c join (select countrycode "code", count(name) cnt from city group by code) t
               using (code)
where c.name like 'bo%';

-- 9. 국가 이름이 bo로 시작하는 국가에 속한 도시의 개수를 출력하시오. 도시가 없을 경우는 단독 이라고 표시한다.(4건)
-- 일반 inner join은 연결하려는 대상 모두에 데이터가 있을 경우만 출력된다.
-- 국가가 있는데 도시가 없는 상태까지 처리하기 위해서는 outer join을 사용한다.
select c.name, c.code, ifnull(t.cnt , '단독') "도시개수"
from country c left join (select countrycode "code", count(name) cnt from city group by code) t using (code)
where c.name like 'bo%';

-- 10. 인구가 가장 많은 도시는 어디인가?
-- where 절에는 집계 함수를 바로 사용할 수 없다.
-- 먼저 가장 많은 인구를 subquery로 구한 후 이 값을 where 절에서 사용해보자.
select countrycode, name, population 
from city 
where population= (select max(population) from city);

-- 11. 가장 인구가 적은 도시의 이름, 인구수, 국가를 출력하시오.
-- 검색 결과로 사용되는 scalar sub query는 하나의 컬럼만 반환 가능하다.
-- 여러개의 컬럼이 sub query에서 와야하는 경우는 inline view 형태를 사용할 수 있다.
select co.name, co.code, t.name, t.population
from country co join (select countrycode, name, population 
                      from city 
                      where population= (select min(population) from city)
                      ) t
                on co.code=t.countrycode;

-- 12. KOR의 seoul보다 인구가 많은 도시들을 출력하시오.
-- 먼저 KOR의 seoul의 인구를 찾아야 한다.
select population from city where countrycode='KOR' and name='seoul';

-- 위 sub query를 이용해 main query 를 작성한다.
select countrycode, name, population 
from city where population > (select population from city where countrycode='KOR' and name='seoul');

-- 13. San Miguel 이라는 도시에 사는 사람들이 사용하는 공식 언어는?
-- 다중행 sub query를 이용한다.
-- 먼저 san miguel이 어떤 나라에 있는지 확인이 필요하다.
select countrycode from city where name='san miguel';  # 총 3건의 row가 반환된다.

-- 이제 이 나라들의 공식 언어를 살펴보자.
select countrycode, language
from countrylanguage
where countrycode in (select countrycode from city where name='san miguel') and isOfficial='T';

-- 14. 국가 코드와 해당 국가의 최대 인구수를 출력하시오. 국가 코드로 정렬한다.(232건)
select countrycode, max(population) "max_pop" 
from city
group by countrycode
order by countrycode;

-- 15. 국가별로 가장 인구가 많은 도시의 정보를 출력하시오. 국가코드로 정렬한다.(232건)
select countrycode, name, population 
from city 
where (countrycode, population) in (select countrycode, max(population) from city  group by countrycode)
order by countrycode;

-- 16. 국가 이름과 함께 국가별로 가장 인구가 많은 도시의 정보를 출력하시오. (239건)
select co.code, co.name, t.name, t.population
from country co left join (select countrycode, name, population 
                              from city 
                              where (countrycode, population) in 
                                (select countrycode, max(population) 
                                from city  group by countrycode)
                          ) t on co.code=t.countrycode;

-- 17. 위 쿼리의 내용이 자주 사용된다. 재사용을 위해 위 쿼리의 내용을 summary라는 이름의 view로 생성하시오.
-- view를 생성하기 위해 create or replace view <view name> as <select 쿼리> 를 사용한다.
create or replace view summary
as 
select co.code, co.name "co_name", t.name "ci_name", t.population
from country co left join (select countrycode, name, population 
                              from city 
                              where (countrycode, population) in (select countrycode, max(population) from city  group by countrycode)
                          ) t on co.code=t.countrycode;

-- 18. summary에서 KOR의 대표도시를 조회하시오.
-- view에서 조회할 때는 일반적인 테이블을 사용하는 것과 동일하다.
select * from summary where code='kor';
