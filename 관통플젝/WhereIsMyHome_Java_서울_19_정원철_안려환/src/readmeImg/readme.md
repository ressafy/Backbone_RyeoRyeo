Member
pair7 안려환 정원철
Requirements

관통 프로젝트
자바
해피하우스
Application Structure

View: UI 역할
Service: 비즈니스 로직 구현
Dao: 데이터베이스 접근, 도메인 객체를 DB에 저장하고 관리
Dto: 비즈니스 도메인 객체
결과화면
아무런 조건도 주지 않았을 경우
image

동으로 조회한 경우
image

아파트 이름으로 조회한 경우
image

[추가 기능] 대기 환경 정보 출력
image

<br/>
원하는 주택이나 아파트를 선택하게되면 해당 구를 기반으로 대기현황이 테이블 형태로 출력
[심화 기능] 관심 지역 상권 정보 출력
SelectOne CommercialInfo
<br/>
관심 있는 아파트 또는 주택을 클릭 후, 상권 정보 버튼 클릭 시, 해당 동의 주변 상권 정보 출력
-> 서울시 법정동별 상권 정보 출력
제출 소스
ClassName code line No.	code
HouseInfoView 246~247	
image
HouseServiceImpl 34	
image
HouseDaoImpl 80	
image
HouseInfo에 저장된 이미지 소스를 HouseDeal 인스턴스의 멤버 변수에 세팅
APTRentSAXHandler 28~	
image
HouseDealSAXHandler	
image
추가 기능 추가한 파일

EnvPollution.java
EnvPollutionService.java
EnvPollutionServiceImpl.java
EnvPollutionImpl.java
서울시 시간 평균 대기오염도 정보.csv
심화 기능 추가한 파일

ComAreaDAO.java
ComArea.java
ComService.java
ComServiceImpl.java
CommercialView.java
상가(상권)정보_서울_20212.csv