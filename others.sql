CREATE SEQUENCE task_status_seq;
commit;

CREATE OR REPLACE TRIGGER task_status_trigger 

	BEFORE INSERT ON mossad.task_status 
		FOR EACH ROW

		BEGIN
		  SELECT task_status_seq.NEXTVAL
		  INTO   :new.id
		  FROM   dual;
		END;