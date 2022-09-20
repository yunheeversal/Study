 
-- root 계정으로 접속하여 실행한다.
create user yuni identified by yuni;
grant connect, resource to yuni;

 CREATE TABLE GUEST  (	
 USERNAME VARCHAR2(30 BYTE) NOT NULL , 
 USERAGE NUMBER, 
 ADDRESS VARCHAR2(50 BYTE), 
 AGREE NUMBER
   )
   
INSERT INTO GUEST VALUES ('홍길동',10,'서울시 중랑구',1);
INSERT INTO GUEST VALUES ('국길동',13,'서울시 성북구',1);
INSERT INTO GUEST VALUES ('황길동',9,'서울시 은평구',0);
commit;