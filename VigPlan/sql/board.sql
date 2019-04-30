CREATE TABLE vigteam_board (
		id			NUMBER(6)		PRIMARY KEY,
    pw      VARCHAR2(30) NOT NULL,
		title		VARCHAR2(200)	NOT NULL,
		writer		VARCHAR2(40)	NOT NULL,
		content		VARCHAR2(4000) NOT NULL,
		view_cnt	NUMBER(6)		DEFAULT 0,
		reg_date	DATE			DEFAULT SYSDATE
	);
  
CREATE SEQUENCE seq_brd_pk
START WITH 1
INCREMENT BY 1;

-- 테이블 수정
ALTER TABLE vigteam_board 
  ADD (member_no NUMBER);

-- 테이블 수정(4/30)
ALTER TABLE vigteam_board 
  ADD (filename1 VARCHAR2(30));