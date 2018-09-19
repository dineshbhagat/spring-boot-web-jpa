
SET FOREIGN_KEY_CHECKS = 0; 
truncate test.user ;
truncate test.hibernate_sequence;
truncate test.comment;
truncate test.article;
SET FOREIGN_KEY_CHECKS = 1;



INSERT INTO `test`.`hibernate_sequence`
(`next_val`)
VALUES
(0);
