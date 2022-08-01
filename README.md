# CafeWhereIGo
> ## 프로젝트 설명
* 프로젝트명: <a href="http://ec2-18-233-14-146.compute-1.amazonaws.com:8080/CafeWhereIGo/main/main.do">카페어디가?!</a>

* 진행인원: 1명

* 진행기간: 2022/3/24~2022/6/24(3개월)


* 프로젝트 진행배경
  - 기존의 카페정보검색 방법의 경우, 주로 포털 사이트를 이용하여 검색하는 경우가 많음
  - 일반적인 카페가 아닌 전통찻집, 키즈카페 등이 검색되는 경우가 있었음(Daum)
  - 예를 들어, 분위기 좋은 카페를 검색했지만 전혀 다른 결과의 카페가 검색되는 경우 존재(Naver)
  - 위 불편함을 개선하기 위해 카페에 특화된 서비스 개발

* 주요기능
  - 지역과 시설정보(콘센트 여부, Wi-Fi 유무, 주차장 유무) 및 카페테마를 선택하여 카페검색 가능
  - 국토교통부로부터 시/군/구 목록을 불러와서 원하는 지역의 카페를 검색할 수 있도록 구현
  - 페이지 상단에 있는 빠른검색란을 통해 카페를 즉시 검색가능
  - 카페에 대한 정보를 한 눈에 알기 쉽게 표시
  - 카페에 대한 리뷰 게시가능
  - 좋아하는 카페에 대해 찜 가능
  - 카페 주차장 위치정보를 카카오맵으로 표시
  - 음료, 디저트 주문 및 단체석 예약가능
  - 카페관련 커뮤니티 게시판 존재(오늘의 카페, 이벤트, Q&A, 카페탐방후기)
  - 각 게시판에 대한 좋아요 가능

* 설계
  + Use Case 설계
    - 회원관리시스템
    <img width="510" alt="image" src="https://user-images.githubusercontent.com/21366358/182107525-cd3184ad-75e3-4d97-a800-eb377db42100.png">
    - 카페관리시스템
    <img width="627" alt="image" src="https://user-images.githubusercontent.com/21366358/182109052-accb7f74-69e9-463b-a3bf-0db56c9b9277.png">
    - 주문/예약관리시스템
    <img width="286" alt="image" src="https://user-images.githubusercontent.com/21366358/182107821-ab7e70f7-195e-4fc7-84dc-bee8eb1b1ce8.png">
    - 게시판관리시스템
    <img width="263" alt="image" src="https://user-images.githubusercontent.com/21366358/182108481-bf64d8bc-aef8-4b54-881f-19a1fac78f77.png">

  * DB 설계
    <img width="961" alt="image" src="https://user-images.githubusercontent.com/21366358/182026121-64c8ba97-eb03-40e4-88a9-68dc9441848b.png">

> ## 문제해결
* 간헐적으로 DB 커넥션이 끊기는 문제
  * 증상
    - 간헐적으로 DB에 접근하지 못하는 증상 발생 
    - 문제가 발생할 때 마다 로그에서 "Unknown Connection"이라는 에러메세지가 발견됨 
  * 문제
    - MySQL에는 MySQL 서버에 대해 설정할 수 있는 System 변수를 제공
    - 그 중에 사용하지 않는 커넥션을 유지하는 시간을 설정하는 wait_timeout이라는 System 변수가 존재
    - wait_timeout의 경우, 기본값이 8시간으로 되어있음
    - 8시간 후 커넥션이 끊겨 DB 접근불가
      <img width="700" alt="image" src="https://user-images.githubusercontent.com/21366358/182085137-1fa04882-e123-41ce-8e11-72668f9b5c21.png">

  * 문제해결
    - 커넥션 유지시간을 무한정 늘리는 것은 불가
    - 시간을 늘려도 언젠가 끊길 가능성 존재
    - 주기적으로 커넥션을 확인하여 커넥션이 끊길 경우 다시 연결을 시도하는 방향으로 문제해결
    - 커넥션 상태를 확인하는 Validation Query 도입
    - 일정 시간마다 Validation Query를 날려서 커넥션 상태를 확인하도록 설정
      <img width="902" alt="image" src="https://user-images.githubusercontent.com/21366358/182088577-716c6d0c-0b1e-447e-991f-2dc5eb367d3d.png">

> ## 기술스택 및 개발도구
* 기술스택
  - <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white"/>
  - <img src="https://img.shields.io/badge/MySQL-4479A1?style=flat-square&logo=MySQL&logoColor=white"/>
  - <img width="100px" src="https://user-images.githubusercontent.com/21366358/176229524-7fd3671d-a903-4e43-82f5-93394394b58b.png"/>
  - <img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=JavaScript&logoColor=white"/>
  - <img src="https://img.shields.io/badge/jQuery-0769AD?style=flat-square&logo=jQuery&logoColor=white"/>
  - <img width="80px" src="https://user-images.githubusercontent.com/21366358/176232066-2054dded-192f-4e50-8bbc-29cc038b30bf.png"/>
  - <img width="80px" src="https://user-images.githubusercontent.com/21366358/176232720-ea52a7b1-59b9-49e0-9ab6-f795cac5be1e.png"/>
  - <img src="https://img.shields.io/badge/Apache Maven-C71A36?style=flat-square&logo=Apache Maven&logoColor=white"/>
  - <img src="https://img.shields.io/badge/Amazon EC2-FF9900?style=flat-square&logo=Amazon EC2&logoColor=white"/>
 
* 외부 API
  - 카카오맵
  - 행정구역 목록 API(공공데이터)
  - Google Font

* 개발도구
  - <img src="https://img.shields.io/badge/Eclipse-2C2255?style=flat-square&logo=Eclipse&logoColor=white"/>
  - <img src="https://img.shields.io/badge/Visual Studio Code-007ACC?style=flat-square&logo=Visual Studio Code&logoColor=white"/>
  - <img width="80px" src="https://user-images.githubusercontent.com/21366358/176233284-31078442-5a34-42db-b728-742975404ce8.png"/>
  - <img src="https://img.shields.io/badge/Git-F05032?style=flat-square&logo=Git&logoColor=white"/>
