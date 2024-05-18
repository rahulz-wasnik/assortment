CREATE TABLE `jdbc`.Organisation
(
id 	INT,
orgname VARCHAR(70)
);

INSERT INTO `jdbc`.Organisation
VALUES
( 1, 
 'Infosys'
);

INSERT INTO `jdbc`.Organisation
VALUES
( 2, 
 'IBM'
);

INSERT INTO `jdbc`.Organisation
VALUES
( 3, 
 'HSBC'
);

INSERT INTO `jdbc`.Organisation
VALUES
( 4, 
 'Noggin'
);

INSERT INTO `jdbc`.Organisation
VALUES
( 5, 
 'Yieldbroker'
);

select * from `jdbc`.Organisation;