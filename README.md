# Ad Search  
*_"식품 허위·과대광고 업체 및 제품검색 서비스"_*

### 🚩 **기획배경**

- YouTube, SNS등 광고 채널이 늘어나면서 식품 허위·과대광고 증가
- 무분별한 과대광고에 많은 피해자 발생 → 개선되지 않고 현재에도 지속중
- 소비자가 식품 허위·과대광고를 판별하는 능력이 필요하다고 생각함

### 🚩 **기획목표**

- 식품 허위·과대광고정보 서비스를  제공함으로서 소비자의 피해 줄이기
- 식품 허위·과대광고를 한 업체 혹은 제품을 검색할 수 있는 서비스 개발
- 더치트와 유사한 서비스 제공

### 🚩 **발전 가능성**

- 사용자 제보 등 데이터 수집도구로서의 기능 개발
- 데이터 분석을 통해 부가적인 기능 개발

### 사용 오픈소스 API

[공공데이터 포털 | 식품의약품안전처_식품 허위·과대광고정보](https://www.data.go.kr/data/15058599/openapi.do)

## 👯 BackEnd

`SpringBoot`, `mySQL` 를 사용하여 개발하였습니다.  
- Java Persistence API `JPA`  - SpringBoot 와 mySQL 간의 연결    
- RestTemplateBuilder UriBuilder - openAPI 와 SpringBoot 간의 연결    

`박경호` OpenAPI를 이용해 Json형태의 데이터 파싱  
`박승현` DB 스키마에 맞게 OpenAPI데이터 가공  
`신봉근` DB 스키마 작성 및 구축  
`이창하` Controller작성 및 구현  

저희팀의 프론트 엔드가 궁금하신가요? 👉🏻 [SWM-AdSearch-FrontEnd](https://github.com/swm-pgui/SWM-AdSearch-FrontEnd)

## How to build

1. AppKey 설정  
opEnAPI 사용간에 ServiceKey 유출을 방지하기 위한 `.gitignore` 파일을 main/resources/ 에 생성해두었습니다.   
`main/resources/appKey` 에 생성하고, 사용가능한 ServiceKey를 붙여넣어야 정상적인 실행이 가능합니다.  

2. Dependencies sync  
maven빌드 툴을 이용한 Springboot Dependency build
