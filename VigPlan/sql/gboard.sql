CREATE TABLE gboard (
gNo		NUMBER(30)	PRIMARY KEY,
gName     VARCHAR2(30) NOT NULL,
gRegdate   DATE    DEFAULT SYSDATE,
gPw     VARCHAR2(30) NOT NULL
);

CREATE SEQUENCE seq_gboard_pk
START WITH 1
INCREMENT BY 1;