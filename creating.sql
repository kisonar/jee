--- as system only once
CREATE BIGFILE TABLESPACE mossad
  DATAFILE 'mossad.dat'
  SIZE 20M AUTOEXTEND ON;

-- as system user
CREATE USER mossad
  IDENTIFIED BY mossad
  DEFAULT TABLESPACE mossad;
commit;

--grant permissions
GRANT CREATE SESSION TO mossad WITH ADMIN OPTION;
grant create procedure to mossad;
grant create sequence to mossad;
grant create session to mossad;
grant create table to mossad;
grant create trigger to mossad;
grant create type to mossad;
GRANT RESOURCE to mossad;
commit;


--jako mossad
CREATE TABLE task_status (
  id INT NOT NULL,
  val VARCHAR2(20) NOT NULL,  
  CONSTRAINT TASK_STATUS_PK PRIMARY KEY ("ID")
) ;
commit;
--CREATE UNIQUE INDEX TASK_STATUS_UNIQUE_INDEX_ID ON TASK_STATUS (ID); 
--CREATE UNIQUE INDEX TASK_STATUS_UNIQUE_INDEX_VAL ON TASK_STATUS (VAL); 
--commit;
insert into task_status values (1,'Not started');
insert into task_status values (2,'Ongoing');
insert into task_status values (3,'Finished');
insert into task_status values (4,'Paused');
commit;

CREATE TABLE task_type (
  id INT NOT NULL,
  val VARCHAR2(20) NOT NULL, 
  CONSTRAINT task_type_PK PRIMARY KEY ("ID")
) ;
commit;
insert into task_type values (1,'Private');
insert into task_type values (2,'Home');
insert into task_type values (3,'Work');
insert into task_type values (4,'Friends');
insert into task_type values (5,'Hobby');
insert into task_type values (6,'None');
commit;

CREATE TABLE task_priority (
  id INT NOT NULL,
  val VARCHAR2(20) NOT NULL, 
  CONSTRAINT task_priority_PK PRIMARY KEY ("ID")
) ;
commit;
insert into task_priority values (1,'High');
insert into task_priority values (2,'Medium');
insert into task_priority values (3,'Low');
insert into task_priority values (4,'Not specified');
commit;

CREATE TABLE mossad_user (
  id INT NOT NULL,
  name VARCHAR2(20) NOT NULL, 
  surname  VARCHAR2(20) NOT NULL, 
  email  VARCHAR2(20) NOT NULL,
  password VARCHAR2(20) NOT NULL,
  CONSTRAINT mossad_user_PK PRIMARY KEY ("ID")
) ;
commit;
CREATE UNIQUE INDEX mossad_user_UNIQUE_INDEX_email ON mossad_user (email); 
commit;
--//TODO add autoincrement
insert into mossad_user values (1,'user1name','user1surname','user1email@wp.pl','user1password');
insert into mossad_user values (2,'user2name','user2surname','user2email@wp.pl','user2password');
commit;

CREATE TABLE mossad_task (
  id INT NOT NULL,
  title VARCHAR2(20) NOT NULL, 
  description VARCHAR2(20) ,
  priority INT NOT NULL ,
  userId int NOT NULL ,
  status int NOT NULL,
  type int NOT NULL,
  CONSTRAINT mossad_task_PK PRIMARY KEY ("ID")
  --CONSTRAINT `priority_fk` FOREIGN KEY (`priority`) REFERENCES `task_priority` (`id`),
  --CONSTRAINT `status_fk` FOREIGN KEY (`status`) REFERENCES `task_status` (`id`), 
  --CONSTRAINT `type_fk` FOREIGN KEY (`type`) REFERENCES `task_type` (`id`),
  --CONSTRAINT `user_fk` FOREIGN KEY (`userId`) REFERENCES `mossad_user` (`id`)
  
) ;


INSERT INTO `mossad_task` (`id`, `title`, `description`, `priority`, `userId`, `status`, `type`) VALUES ('1', 'Task title', 'Task descrption', '2', '1', '3', '6');















--TODO to add to task table dodac pozniuej
--due time
--repetition
--estimation how long
--location 
--URL
--postpone counter


-- --
--TODO

--Task repetition
--Note
--Tag
--Sharing Task




