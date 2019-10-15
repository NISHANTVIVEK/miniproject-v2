CREATE TABLE LOGIN(login_id varchar2(5),
password varchar2(10),
role varchar2(5)) ;

INSERT INTO LOGIN VALUES ('1', '1','MAC');
INSERT INTO LOGIN VALUES ('2', '2','MAC');
INSERT INTO LOGIN VALUES ('3', '3','ADMIN');
INSERT INTO LOGIN VALUES ('4', '4','ADMIN');


CREATE TABLE PROGRAMS_OFFERED( ProgramName varchar2(5), description varchar2(20), applicant_eligibility varchar2(40) , duration number, degree_certificate_offered varchar2(10));
INSERT INTO PROGRAMS_OFFERED VALUES('CS' ,'COMPUTER SCIENCE','XII',4,'BE');
INSERT INTO PROGRAMS_OFFERED VALUES('IT' ,'INFROMATION TECHNO','XII',4,'BE');
INSERT INTO PROGRAMS_OFFERED VALUES('ENTC' ,'ELECTRONICS','XII',4,'BE');
INSERT INTO PROGRAMS_OFFERED VALUES('EC' ,'ELECTRONICS AND COM','XII',4,'BE');
INSERT INTO PROGRAMS_OFFERED VALUES('MECH' ,'MECHANICAL','XII',4,'BE');

commit;