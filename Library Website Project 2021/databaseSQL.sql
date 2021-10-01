
drop table Reservations;
drop table Books;
drop table Category;
drop table Users;


CREATE TABLE Users( 
   Username VARCHAR(20), 
   Password VARCHAR(6) NOT NULL, 
   FirstName VARCHAR(20) NOT NULL,
   Surname VARCHAR(30) NOT NULL,
   AddressLine1 VARCHAR(30) NOT NULL,
   AddressLine2 VARCHAR(30) NOT NULL,
   City VARCHAR(30) NOT NULL,
   Telephone INTEGER(10) NOT NULL,
   Mobile INTEGER(10) NOT NULL,
CONSTRAINT Users_PK PRIMARY KEY (Username) 
);


CREATE TABLE Category( 
   CategoryID INTEGER(3), 
   CategoryDescription VARCHAR(30) NOT NULL, 
CONSTRAINT Category_PK PRIMARY KEY (CategoryID) 
);


CREATE TABLE Books( 
   ISBN VARCHAR(12), 
   BookTitle VARCHAR(50) NOT NULL, 
   Author VARCHAR(40) NOT NULL,
   Edition INTEGER(2) NOT NULL,
   YearPublished YEAR(4) NOT NULL,
   Category INTEGER(30) NOT NULL,		/*Foreign key*/
   Reserved VARCHAR(1) NOT NULL,
CONSTRAINT Category_FK FOREIGN KEY (Category) REFERENCES Category(CategoryID),
CONSTRAINT Books_PK PRIMARY KEY (ISBN) 
);


CREATE TABLE Reservations( 
   ISBN VARCHAR(12) NOT NULL, 			/*Foreign key*/
   Username VARCHAR(20) NOT NULL,			/*Foreign key*/
   ReservedDate VARCHAR(12) NOT NULL,
CONSTRAINT Reservations_PK PRIMARY KEY (ISBN,Username),
CONSTRAINT Res_Books_FK FOREIGN KEY (ISBN) REFERENCES Books(ISBN),
CONSTRAINT Res_Users_FK FOREIGN KEY (Username) REFERENCES Users(Username) 
);









INSERT INTO Users VALUES (  
	'alanjmckenna',  
	't1234s',
	'Alan',
	'McKenna',
	'38 Cranley Road',
	'Fairview',
	'Dublin',
	9998377,
	856625567
);

INSERT INTO Users VALUES (  
	'joecrotty',  
	'kj7899',
	'Joseph',
	'Crotty',
	'Apt 5 Clyde Road',
	'Donnybrook',
	'Dublin',
	8887889,
	876654456
);

INSERT INTO Users VALUES (  
	'tommy100',  
	'123456',
	'Tom',
	'Behan',
	'14 Hyde Road',
	'Dalkey',
	'Dublin',
	9983747,
	876738782
);





INSERT INTO Category VALUES (  
	001,  
	'Health'
);

INSERT INTO Category VALUES (  
	002,  
	'Business'
);

INSERT INTO Category VALUES (  
	003,  
	'Biography'
);

INSERT INTO Category VALUES (  
	004,  
	'Technology'
);

INSERT INTO Category VALUES (  
	005,  
	'Travel'
);

INSERT INTO Category VALUES (  
	006,  
	'Self-Help'
);

INSERT INTO Category VALUES (  
	007,  
	'Cookery'
);

INSERT INTO Category VALUES (  
	008,  
	'Fiction'
);






INSERT INTO Books VALUES (  
	'093-403992',  
	'Computers in Business',
	'Alicia Oneill',
	3,
	1997,
	002,
	'N'
);

INSERT INTO Books VALUES (  
	'23472-8729',  
	'Exploring Peru',
	'Stephanie Birchi',
	4,
	2005,
	005,
	'N'
);

INSERT INTO Books VALUES (  
	'237-34823',  
	'Business Strategy',
	'Joe Peppard',
	2,
	2002,
	002,
	'N'
);

INSERT INTO Books VALUES (  
	'23u8-923849',  
	'A Guide To Nutrition',
	'John Thorpe',
	2,
	1997,
	001,
	'N'
);

INSERT INTO Books VALUES (  
	'2983-3494',  
	'Cooking For Children',
	'Anabelle Sharpe',
	1,
	2003,
	007,
	'N'
);

INSERT INTO Books VALUES (  
	'82n8-308',  
	'Computers For Idiots',
	'Susan O\'Neill',
	5,
	1998,
	004,
	'N'
);

INSERT INTO Books VALUES (  
	'9823-23984',  
	'My Life In Picture',
	'Kevin Graham',
	8,
	2004,
	003,
	'N'
);

INSERT INTO Books VALUES (  
	'9823-2403-0',  
	'DaVinci Code',
	'Dan Brown',
	1,
	2003,
	008,
	'N'
);

INSERT INTO Books VALUES (  
	'98234-029384',  
	'My Ranch In Texas',
	'George Bush',
	1,
	2005,
	003,
	'Y'
);


INSERT INTO Books VALUES (  
	'9823-98345',  
	'How To Cook Italian Food',
	'Jamie Oliver',
	2,
	2005,
	007,
	'Y'
);

INSERT INTO Books VALUES (  
	'9823-98487',  
	'Optimising Your Business',
	'Cleo Blair',
	1,
	2001,
	002,
	'N'
);

INSERT INTO Books VALUES (  
	'988745-234',  
	'Tara Road',
	'Maeve Binchy',
	4,
	2002,
	008,
	'N'
);

INSERT INTO Books VALUES (  
	'993-004-00',  
	'My Life In Bits',
	'John Smith',
	1,
	2001,
	003,
	'N'
);

INSERT INTO Books VALUES (  
	'9987-0039882',  
	'Shooting History',
	'Jon Snow',
	1,
	2003,
	003,
	'N'
);

INSERT INTO Books VALUES (  
	'9988-0539892',  
	'How to Win Friends and Influence People',
	'Dale Carnegie',
	2,
	1936,
	006,
	'N'
);




INSERT INTO Reservations VALUES (  
	'98234-029384',  
	'joecrotty',
	'11-Oct-2008'
);

INSERT INTO Reservations VALUES (  
	'9823-98345',  
	'tommy100',
	'11-Oct-2008'
);





/*______________________*/



INSERT INTO Category VALUES (  
	009,  
	'Romance'
);

INSERT INTO Books VALUES (  
	'998556',  
	'Emma',
	'Jane Austen',
	6,
	1815,
	009,
	'N'
);