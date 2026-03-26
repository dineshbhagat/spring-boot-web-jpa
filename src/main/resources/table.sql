-- Create database (run manually: CREATE DATABASE test;)

--
-- Table structure for table "user"
--
DROP TABLE IF EXISTS "user" CASCADE;
CREATE TABLE "user" (
  id SERIAL PRIMARY KEY,
  date_of_birth DATE DEFAULT NULL,
  full_name VARCHAR(64) DEFAULT NULL
);

--
-- Dumping data for table "user"
--
INSERT INTO "user" VALUES (1, '2018-09-19', 'D');


--
-- Table structure for table "article"
--
DROP TABLE IF EXISTS article CASCADE;
CREATE TABLE article (
  id SERIAL PRIMARY KEY,
  article_text VARCHAR(45) DEFAULT NULL
);

--
-- Dumping data for table "article"
--
INSERT INTO article VALUES (1, 'This is my first article');
INSERT INTO article VALUES (2, 'This is my second article');


--
-- Table structure for table "comment"
--
DROP TABLE IF EXISTS comment CASCADE;
CREATE TABLE comment (
  id SERIAL PRIMARY KEY,
  comment_str VARCHAR(400) DEFAULT NULL,
  created_at TIMESTAMP DEFAULT NULL,
  user_id INT NOT NULL REFERENCES "user"(id),
  article_id INT NOT NULL REFERENCES article(id)
);

CREATE INDEX article_id_idx ON comment(article_id);
CREATE INDEX user_id_idx ON comment(user_id);

--
-- Dumping data for table "comment"
--
INSERT INTO comment VALUES (1, 'This is my first comment to article 1', '2018-09-23 00:00:00', 1, 1);
INSERT INTO comment VALUES (2, 'This is my second comment to article 1', '2018-09-23 00:00:00', 1, 1);


--
-- Table structure for table "tag"
--
DROP TABLE IF EXISTS tag CASCADE;
CREATE TABLE tag (
  tag_id SERIAL PRIMARY KEY,
  name VARCHAR(45) DEFAULT NULL,
  description VARCHAR(45) DEFAULT NULL
);


--
-- Table structure for table "article_tag"
--
DROP TABLE IF EXISTS article_tag CASCADE;
CREATE TABLE article_tag (
  article_id INT NOT NULL REFERENCES article(id),
  tag_id INT NOT NULL REFERENCES tag(tag_id),
  UNIQUE (article_id, tag_id)
);

CREATE INDEX article_tag_article_id_idx ON article_tag(article_id);
CREATE INDEX article_tag_tag_id_idx ON article_tag(tag_id);
