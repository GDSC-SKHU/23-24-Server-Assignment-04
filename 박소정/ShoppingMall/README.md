# [상품 주문 API]

## Domain 설계
1. 고객(customer)
   -고객id
   -이름
   -전화번호
   -주소

2. 상품(item)
   -상품id
   -상품명
   -가격

3. 주문(order)
   -주문id
   -고객id
   -상품id
   -상품 수량

4. Controller(요청 받기), Service(직접적인 로직, 결과값 도출), Repository(데이터베이스와 연결, 직접 접근, 불러오기)

## API 설계(CRUD)
1. Create
- customer 추가 API
- item 추가 API
- order 추가 API
2. Read
- customer 조회 API
- item 조회 API
- order 조회 API
3. Update
- customer 수정 API
- item 수정 API
- order 수정 API
4. Delete
- customer 삭제 API
- item 삭제 API
- order 삭제 API


## 구현할 기능 목록
1. 
- [x] dto 
2. domain
- [x] Customer
- [x] Item
- [x] Order
3.
- [x] repository
4. service
   1. Create
   - [x] customer 추가
   - [x] item 추가
   - [x] order 추가
   2. Read
   - [x] customer 조회
   - [x] item 조회
   - [x] order 조회
   3. Update
   - [x] customer 수정
   - [x] item 수정
   - [x] order 수정
   4. Delete
   - [x] customer 삭제
   - [x] item 삭제
   - [x] order 삭제
5. controller
- [ ] CustomerController
- [ ] ItemController
- [ ] OrderController