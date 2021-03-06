/*NAME: SN_PROD table SEQUENCES
STORY_ID:20190725(3)
DESCRIPTION: sequences are created for generting product id's
DATE:25/07/2019
APPROVED BY:
*/
/*SEQUENCE FOR GENERATING PRODUCT ID'S*/
CREATE SEQUENCE PROD_ID_PARENT
 START WITH     3001
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
 
/*SEQUENCE FOR GENERATING PRODUCT ID'S OF CHILD PRODUCTS*/
CREATE SEQUENCE PROD_ID_CHILD
 START WITH     4001
 INCREMENT BY   1
 NOCACHE
 NOCYCLE;
