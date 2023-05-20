INSERT INTO tags (tag_name)
VALUES ('blog');
INSERT INTO tags (tag_name)
VALUES ('web');
INSERT INTO tags (tag_name)
VALUES ('development');
SELECT *
FROM tags;

INSERT INTO users (usr_username, usr_email, usr_name, usr_surname, usr_avatar)
VALUES ('Javagath', 'ievgenii.izrailtenko@google.com', 'Ievgenii', 'Izrailtenko', 'logo');
SELECT *
FROM users;

INSERT INTO blogs (blg_address, blg_title, blg_subtitle, blg_banner, blg_date, blg_usr_id)
VALUES ('how-to-write-my-first-blog', 'How to write my first blog?',
        'It will tell you how to write your first Blog', 'banner', '2023-01-01', 1);
SELECT *
FROM blogs;

INSERT INTO blog_tags (blt_blg_id, blt_tag_id)
VALUES (1, 1);
INSERT INTO blog_tags (blt_blg_id, blt_tag_id)
VALUES (1, 2);
INSERT INTO blog_tags (blt_blg_id, blt_tag_id)
VALUES (1, 3);
SELECT *
FROM blog_tags;

INSERT INTO components (cmp_blg_id, cmp_counter, cmp_type, cmp_header, cmp_content)
VALUES (1, 1, 'text', null, 'Some intro content');
INSERT INTO components (cmp_blg_id, cmp_counter, cmp_type, cmp_header, cmp_content)
VALUES (1, 2, 'text', 'First Header', 'First part of amazing content');
INSERT INTO components (cmp_blg_id, cmp_counter, cmp_type, cmp_header, cmp_content)
VALUES (1, 3, 'text', null, 'Second part of amazing content');
INSERT INTO components (cmp_blg_id, cmp_counter, cmp_type, cmp_header, cmp_content)
VALUES (1, 4, 'image', null, 'page-structure');
INSERT INTO components (cmp_blg_id, cmp_counter, cmp_type, cmp_header, cmp_content)
VALUES (1, 5, 'text', null, 'Third part of amazing content');
INSERT INTO components (cmp_blg_id, cmp_counter, cmp_type, cmp_header, cmp_content)
VALUES (1, 6, 'text', 'Second header', 'Amazing content of second header');
SELECT *
FROM components;