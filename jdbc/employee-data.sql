CREATE TABLE `jdbc`.Employee
(
id 	INT,
fullName VARCHAR(70), 
salary  INT, 
dept_id INT,
mgr_id INT
);


INSERT INTO `jdbc`.Employee
VALUES
(
1,
'HR 1', 
25,
1,
null
);

INSERT INTO `jdbc`.Employee
VALUES
(
2,
'HR 2', 
75,
1,
1
);

INSERT INTO `jdbc`.Employee
VALUES
(
3,
'HR 3', 
50,
1,
1
);

-------------------------------------------------------------------------------
 
INSERT INTO `jdbc`.Employee
VALUES
(
4,
'Finance 1', 
25,
2,
1
);

INSERT INTO `jdbc`.Employee
VALUES
(
5,
'Finance 2', 
75,
2,
2
);

INSERT INTO `jdbc`.Employee
VALUES
(
6,
'Finance 3', 
50,
2,
2
);

INSERT INTO `jdbc`.Employee
VALUES
(
7,
'Finance 4', 
10,
2,
5
);

INSERT INTO `jdbc`.Employee
VALUES
(
8,
'Finance 5', 
15,
2,
4
);

INSERT INTO `jdbc`.Employee
VALUES
(
9,
'Finance 6', 
55,
2,
4
);

-------------------------------------------------------------------------------

INSERT INTO `jdbc`.Employee
VALUES
(
10,
'IT 1', 
55,
3,
3
);

INSERT INTO `jdbc`.Employee
VALUES
(
11,
'IT 2', 
57,
3,
2
);

select * from `jdbc`.Employee where id = 12;

