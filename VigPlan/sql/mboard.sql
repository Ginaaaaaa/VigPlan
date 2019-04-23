CREATE Table mboard (
mNo   NUMBER PRIMARY KEY,
mTitle VARCHAR2(30) NOT NULL,
mDate VARCHAR2(30) NOT NULL,
mPlace VARCHAR2(30),
mContent VARCHAR2(100)
);

CREATE SEQUENCE seq_mboard_pk
  START WITH 1
  INCREMENT BY 1;

-- 추가 DDL: 2019-04-19
CREATE TABLE group_moim_bridge (
  group_gno number(30),
  moim_mno number,
  primary key (group_gno, moim_mno) -- Optional
);
  
ALTER TABLE mboard DROP COLUMN mplace;

CREATE TABLE mboard_place_bridge (
  mno number,
  pk number(30),
  primary key (mno, pk) -- Optional
);
