CREATE TABLE `jdbc`.Department
(
id 	INT,
departmentName VARCHAR(70)
);

INSERT INTO `jdbc`.Department
VALUES
( 1, 
 'HR'
);

INSERT INTO `jdbc`.Department
VALUES
( 2, 
 'Finance'
);

INSERT INTO `jdbc`.Department
VALUES
( 3, 
 'IT'
);

select * from `jdbc`.Department;