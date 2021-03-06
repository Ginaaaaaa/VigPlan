CREATE TABLE place (
		pk			NUMBER(10)		PRIMARY KEY,
    title      VARCHAR2(128) NOT NULL,
		link		VARCHAR2(400)	NOT NULL,
		description		VARCHAR2(4000)	NOT NULL,
		telephone		VARCHAR2(200) NOT NULL,
    address VARCHAR2(200)   NOT NULL,
    roadAddress VARCHAR2(128) NOT NULL,
    mapx NUMBER(10) NOT NULL,
    mapy NUMBER(10) NOT NULL

	);
  
CREATE SEQUENCE seq_place
START WITH 1
INCREMENT BY 1;

alter table place modify (link varchar2(400) null);
alter table place modify (description varchar2(4000) null);
alter table place modify (roadaddress varchar2(128) null);
alter table place modify (telephone varchar2(200) null);
alter table place modify (mapx number(25, 15));
alter table place modify (mapy number(25, 15));