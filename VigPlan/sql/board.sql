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
