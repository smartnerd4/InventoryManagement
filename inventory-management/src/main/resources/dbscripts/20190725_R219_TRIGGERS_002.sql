/*NAME: SN_PROD table TRIGGERS
STORY_ID:20190725(2)
DESCRIPTION: TRIGERS FOR THE TABLE SN_PROD
1.TR_SN_PROD_BI: FOR AUTO GENERATION OF SYS_CRD_DATE FIELD AND SYS_CRD_USER FIELD
2.TR_SN_PROD_BU:FOR AUTO GENERATION OF SYS_LST_MOD_DATE FIELD AND SYS_LST_MOD_USER FIELD
3.TR_SN_PROD_BD:FOR AUTO GENERATION OF SYS_LST_MOD_DATE FIELD
4.PROD_ID_PARENT:FOR AUTO GENERATION OF PARENT PRODUCTS ID
5.PROD_ID_CHILD:FOR AUTO GENERATION OF CHILD PRODUCTS ID

DATE:25/07/2019
APPROVED BY:
*/

/* TRIGGER FOR SYS_CRE_DATE AND SYS_CRD_USER*/
CREATE OR REPLACE TRIGGER TR_SN_PROD_BI
         BEFORE  insert 
         ON SN_PROD
         FOR EACH ROW
         DECLARE
    begin
            :new.SYS_CRD_DATE:= sysdate;
            :new.SYS_CRD_USER:= user;
            
    end;
    
/* TRIGGERS FOR SYS_LST_MOD_DATE AND SYS_LST_MOD_USER BEFORE INSERT OR UPDATE*/
    CREATE OR REPLACE TRIGGER TR_SN_PROD_BU
         BEFORE  INSERT OR UPDATE 
         ON SN_PROD
         FOR EACH ROW
         DECLARE
    begin
            :new.SYS_LST_MOD_DATE:= sysdate;
             :new.SYS_LST_MOD_USER:= user;
    end;

/* TRIGGERS FOR SYS_LST_MOD_DATE BEFORE INSERT OR DELETE*/
    
     CREATE OR REPLACE TRIGGER TR_SN_PROD_BD
   after  DELETE ON SN_PROD  FOR EACH ROW
         DECLARE
    begin
        
            
    end;
    
/*TRIGGER FOR INSERTING PARENT PRODUCT ID'S INTO  TABLE*/

CREATE OR REPLACE TRIGGER PROD_ID_PARENT
BEFORE INSERT ON SN_PROD
FOR EACH ROW 
  WHEN (NEW.IS_PARNT_PROD = 1)
  BEGIN
  :NEW.PROD_ID :=PROD_ID_PARENT.NEXTVAL;
 :NEW.PARNT_PROD_ID :=PROD_ID_PARENT.CURRVAL;
END;

/*TRIGGER FOR INSERTING CHILD PRODUCT ID'S INTO TABLE*/

CREATE OR REPLACE TRIGGER PROD_ID_CHILD
BEFORE INSERT ON SN_PROD
FOR EACH ROW
  WHEN(NEW.IS_PARNT_PROD = 0)
  BEGIN
  :NEW.PROD_ID :=PROD_ID_CHILD.NEXTVAL;
  :NEW.PARNT_PROD_ID :=PROD_ID_PARENT.CURRVAL;
END;
