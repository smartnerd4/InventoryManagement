/*NAME: EMPLOYEE_DETAILS TABLE TRIGGERS
STORY_ID:20190713(2)
DESCRIPTION:TRIGGERS are created for the table EMPLOYEE_DETAILS for automatic generation of SYS_CRE_DATE and SYS_LST_MOD_DATE fields.
DATE:13/07/2019
APPROVED BY:
*/

/* TRIGGER FOR SYS_CRE_DATE*/

CREATE OR REPLACE TRIGGER EMPLOYEE
         BEFORE  insert 
         ON EMPLOYEE_DETAILS
         FOR EACH ROW
         DECLARE
    begin
            :new.SYS_CRE_DATE:= sysdate;
            :new.SYS_LST_MOD_DATE:= sysdate;
    end;

/* TRIGGER FOR SYS_LST_MOD_DATE*/

CREATE OR REPLACE TRIGGER EMPLOYEE
         BEFORE update or delete
         ON EMPLOYEE_DETAILS
         FOR EACH ROW
         DECLARE
    begin
            :new.SYS_LST_MOD_DATE:= sysdate;
    end;
