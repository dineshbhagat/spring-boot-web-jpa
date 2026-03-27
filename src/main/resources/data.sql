-- Seed data for the application database (PostgreSQL)
-- Requires spring.jpa.defer-datasource-initialization=true so it runs AFTER Hibernate DDL.
-- Also requires spring.sql.init.mode=always for non-embedded databases.

INSERT INTO "user" (id, date_of_birth, full_name) VALUES (1, '2018-09-19', 'D') ON CONFLICT DO NOTHING;

INSERT INTO article (id, article_text) VALUES (1, 'This is my first article') ON CONFLICT DO NOTHING;
INSERT INTO article (id, article_text) VALUES (2, 'This is my second article') ON CONFLICT DO NOTHING;

INSERT INTO comment (id, comment_str, created_at, user_id, article_id) VALUES (1, 'This is my first comment to article 1', TIMESTAMP '2018-09-23 00:00:00', 1, 1) ON CONFLICT DO NOTHING;
INSERT INTO comment (id, comment_str, created_at, user_id, article_id) VALUES (2, 'This is my second comment to article 1', TIMESTAMP '2018-09-23 00:00:00', 1, 1) ON CONFLICT DO NOTHING;
