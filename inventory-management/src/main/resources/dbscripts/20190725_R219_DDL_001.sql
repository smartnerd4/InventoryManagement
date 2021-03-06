/*NAME: SN_PROD table
STORY_ID:20190725(1)
DESCRIPTION: TABLES are created to maintain information regarding all the PRODUCT DETAILS of an organization
DATE:25/07/2019
APPROVED BY:
*/


/*CREATING PRODUCTS TABLE*/
CREATE TABLE SN_PROD
(
PROD_ID NUMBER NOT NULL,
PROD_CD VARCHAR(20),
PROD_NAME VARCHAR(20),
PROD_DESC VARCHAR(200),
ACT_IN NUMBER,
IS_PARNT_PROD NUMBER,
PARNT_PROD_ID NUMBER,
SYS_CRD_DATE DATE,
SYS_LST_MOD_DATE DATE,
WORK_FLOW_IN NUMBER,
SYS_CRD_USER VARCHAR(20),
SYS_LST_MOD_USER VARCHAR(20),
COMMENTS VARCHAR(20),
CONSTRAINT SN_PROD_pk PRIMARY KEY (PROD_ID)  
);


/*CREATING  PRODUCTS TABLE TO MAINTAIN DELETED PRODUCTS DATA */
CREATE TABLE SN_PROD_TEMP
(
PROD_ID NUMBER NOT NULL,
PROD_CD VARCHAR(20),
PROD_NAME VARCHAR(20),
PROD_DESC VARCHAR(200),
ACT_IN NUMBER,
IS_PARNT_PROD NUMBER,
PARNT_PROD_ID NUMBER,
SYS_CRD_DATE DATE,
SYS_LST_MOD_DATE DATE,
WORK_FLOW_IN NUMBER,
SYS_CRD_USER VARCHAR(20),
SYS_LST_MOD_USER VARCHAR(20),
COMMENTS VARCHAR(20),
CONSTRAINT SN_PROD_pk PRIMARY KEY (PROD_ID)  
);