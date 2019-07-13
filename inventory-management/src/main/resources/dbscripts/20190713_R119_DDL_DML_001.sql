/*NAME:ROLES table
STORY_ID:20190713(1)
DESCRIPTION: A "master table ROLES"is created to maintain information regarding all the roles of organization and TRIGGER DATTE is created to generate SYS Date automatically.
DATE:13/07/2019
APPROVED BY:
*/

/*DISABLING  TRIGGERS ON TABLE EMPLOYEE_DETAILS*/

ALTER TABLE ROLES DISABLE ALL TRIGGERS ;

/*CREATING EMPLOYEE_DETAILS TABLE*/

CREATE TABLE ROLES
( ROLE_CD VARCHAR(20) NOT NULL,  
  ROLE_NAME varchar(50) NOT NULL,  
  SYS_CRD_DATE DATE,
  SYS_LST_MOD_DATE DATE,
  ACT_IN NUMBER,
  ROLE_GROUP_ID VARCHAR(20),
  BAND varchar(10),  
  CONSTRAINT ROLES_pk PRIMARY KEY (ROLE_CD)  
);  

/* TRIGGER FOR SYS DATE*/
 CREATE OR REPLACE TRIGGER ROLE
         before update or insert
         ON ROLES
         FOR EACH ROW
         DECLARE
    begin
            :new.SYS_CRD_DATE:= sysdate;
            :new.SYS_LST_MOD_DATE:= sysdate;
    end;

/* INSERTING DATA INTO ROLES TABLE*/

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('MNG_DIR','MANAGING DIRECTOR',1,'NULL','TIER1');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('DICTR','DIRECTOR',1,'NULL','TIER1');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('CEO','CHIEF EXECUTIVE OFFICER',1,'NULL','TIER2');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('CTO','CHIEF TECHNOLOGY OFFICER',1,'NULL','TIER2');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('CSARTC','CHIEF SOLUTIONS ARCHITECT',1,'NULL','TIER2');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('CFO','CHIEF FINANCIAL OFFICER',1,'NULL','TIER2');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('ZNL_MGR','ZONAL MANAGER',1,'NULL','TIER3');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('SOL_ARTC','SOLUTION ARCHITECH',1,'NULL','TIER3');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('SITE_INCHRG','SITE INCHARGE',1,'NULL','TIER3');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('ASSC',' ASSOCIATE',1,'NULL','TIER4');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('ADMIN_ASSC','ADMIN ASSOCIATE',1,'NULL','TIER4');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('ELCTRCN','ELECTRICIAN',1,'NULL','TIER5');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('CHNL_PTNR','CHANNEL PARTNER',1,'NULL','TIER5');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('KEY_ACCT_EXCTV','KET ACCOUNT EXECUTIVE',1,'NULL','TIER3');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('KEY_ACCT_MGR','KEY ACCOUNT MANAGER',1,'NULL','TIER3');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('SENR_SALES_ASSC','SENIOR SALES ASSOCIATIE',1,'NULL','TIER4');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('SALES_ASSC','SALES ASSOCIATIE',1,'NULL','TIER4');

INSERT INTO ROLES (ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND )VALUES('MRKT_EXCTV','MARKETING EXECUTIVE',1,'NULL','TIER5');

INSERT INTO ROLES (ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND )VALUES('VICE_PRESDNT','VICE PRESIDENT',1,'NULL','TIER2');

INSERT INTO ROLES(ROLE_CD,ROLE_NAME,ACT_IN,ROLE_GROUP_ID,BAND ) VALUES('HR_ASSC','HR ASSOCIATE',1,'NULL','TIER2');

/* DISPLAYS DATA IN TABLE*/

SELECT * FROM ROLES;


/*ENABLING  TRIGGERS ON TABLE EMPLOYEE_DETAILS*/
  
ALTER TABLE ROLES ENABLE ALL TRIGGERS;