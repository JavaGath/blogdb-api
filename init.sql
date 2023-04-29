CREATE TABLE IF NOT EXISTS users
(
    usr_id       SERIAL PRIMARY KEY,
    usr_username VARCHAR(50) UNIQUE NOT NULL,
    usr_email    VARCHAR(50) UNIQUE NOT NULL,
    usr_name     VARCHAR(50),
    usr_surname  VARCHAR(50),
    usr_avatar   VARCHAR(50)
);


CREATE TABLE IF NOT EXISTS blogs
(
    blg_id       SERIAL PRIMARY KEY,
    blg_address  VARCHAR(60) UNIQUE NOT NULL,
    blg_title    VARCHAR(50) UNIQUE NOT NULL,
    blg_subtitle VARCHAR(60)        NOT NULL,
    blg_banner   VARCHAR(20)        NOT NULL,
    blg_date     DATE               NOT NULL,
    blg_usr_id   SERIAL,
    CONSTRAINT fk_users
        FOREIGN KEY (blg_usr_id) REFERENCES users (usr_id)
);

CREATE TABLE IF NOT EXISTS tags
(
    tag_name VARCHAR(30) PRIMARY KEY
);

CREATE TABLE IF NOT EXISTS blog_tags
(
    blt_blg_id   SERIAL,
    blt_tag_name VARCHAR(30),
    CONSTRAINT fk_blogs
        FOREIGN KEY (blt_blg_id) REFERENCES blogs (blg_id),
    CONSTRAINT fk_tags
        FOREIGN KEY (blt_tag_name) REFERENCES tags (tag_name)
);

CREATE TABLE IF NOT EXISTS components
(
    cmp_counter INT    NOT NULL,
    cmp_blg_id  SERIAL NOT NULL,
    cmp_type    VARCHAR(10),
    cmp_header  VARCHAR(50),
    cmp_content TEXT,

    PRIMARY KEY (cmp_counter, cmp_blg_id),
    CONSTRAINT fk_blogs
        FOREIGN KEY (cmp_blg_id) REFERENCES blogs (blg_id)
);

DO
$do$
    BEGIN
        IF NOT EXISTS(SELECT
                      FROM pg_roles
                      WHERE rolname = 'blogservice') THEN
            CREATE USER blogservice WITH ENCRYPTED PASSWORD 'password123';
            GRANT ALL PRIVILEGES ON DATABASE postgres TO blogservice;
            GRANT SELECT ON ALL TABLES IN SCHEMA public TO blogservice;
            GRANT UPDATE ON ALL TABLES IN SCHEMA public TO blogservice;
            GRANT INSERT ON ALL TABLES IN SCHEMA public TO blogservice;
            GRANT DELETE ON ALL TABLES IN SCHEMA public TO blogservice;
            GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO blogservice;
            GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public to blogservice;
        END IF;
    END
$do$;