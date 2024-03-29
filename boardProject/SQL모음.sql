/*계정 생성 (광리자 계정으로 접속)*/
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

CREATE USER SPRING_JKH IDENTIFIED BY SPRING1234;

GRANT CONNECT, RESOURCE TO SPRING_JKH;

ALTER USER SPRING_JKH
DEFAULT TABLESPACE USERS 
QUOTA 20M ON USERS;




--> 계정 생성 후 접속방법 (새 데이터베이스) 추가


-------------------------------------------------------------------------


/*SPRING 계정 접속*/

-- "":내부에 작성된 글(모양) 그대로 인식 -> 대/소문자 구분

--> "" 작성 권장


--> CHAR(10)       : 고정 길이 문자열 10 바이트 (최대 2000 바이트)
--> VARCHAR(10)    : 가변 길이 문자열 10 바이트 (최대 4000 바이트)

--> NVARCHAR2(10)  : 가변 길이 문자열 10글자 (유니코드 , 최대 4000 바이트)
-- CLOB : 가변 길이 문자열 (최대 4GB)

/*MEMBER 테이블 생성*/
CREATE TABLE "MEMBER"(
	"MEMBER_NO" 			NUMBER CONSTRAINT "MEMNER_PK" PRIMARY KEY,
	"MEMBER_EMAIL" 		NVARCHAR2(50) NOT NULL,
	"MEMBER_PW" 			NVARCHAR2(100) NOT NULL,
	"MEMBER_NICKNAME" NVARCHAR2(10) NOT NULL,
	"MEMBER_TEL"			CHAR(11)			NOT NULL,
	"MEMBER_ADDRESS"  NVARCHAR2(150),
	"PROFILE_IMG"     VARCHAR2(300),  
	"ENROLL_DATE"			DATE           DEFAULT SYSDATE NOT NULL,
	"MEMBER_DEL_FL"   CHAR(1)  DEFAULT 'N' 
										CHECK("MEMBER_DEL_FL" IN ('Y','N')),
	"AUTHORITY"       NUMBER         DEFAULT 1
										CHECK("AUTHORITY" IN (1,2))
	
);

DROP TABLE "MEMBER";

SELECT * FROM "MEMBER";
--$2a$10$hg/OHFWfJpAe9bnTGGqCDuF1/gaIMNvVPkPBOoDKYpsr1nKiy0nIa
--회원 번호 시퀀스 만들기
CREATE SEQUENCE SEQ_MEMBER_NO NOCACHE;

--샘플 회원 데이터 삽입
INSERT INTO "MEMBER"
VALUES(SEQ_MEMBER_NO.NEXTVAL, 
			'member01@kh.or.kr', 
			'$2a$10$hg/OHFWfJpAe9bnTGGqCDuF1/gaIMNvVPkPBOoDKYpsr1nKiy0nIa',
			'샘플1',
			'01012341234',
			NULL,
			NULL,
			DEFAULT,
			DEFAULT,
			DEFAULT
			);
COMMIT;

SELECT * FROM "MEMBER";

--로그인 
-- ->BCrypt 암호화 사용 중
-- -> DB에서 비밀번호 비교 불가능!!!
-- -> 그래서 비밀번호(MEMBER_PW)를 조회 

-- --> 이메일이 일치하는 회원 + 탈퇴 안한 회원 조건만 추가


SELECT * FROM "MEMBER";

--이메일 중복 검사 (탈퇴 안한 회원 중 같은 이메일이 있는지 조회)
SELECT count(*) FROM "MEMBER"
WHERE MEMBER_DEL_FL = 'N'
AND MEMBER_EMAIL = 'member01@kh.or.kr';

SELECT * FROM "MEMBER";

