CREATE TABLE user
(
    id        NUMERIC(10),
    user_name VARCHAR(64) UNIQUE NOT NULL,
    password  VARCHAR(64)        NOT NULL,
    created   TIMESTAMP(6)       NOT NULL,
    updated   TIMESTAMP(6),
    PRIMARY KEY (id)
);

CREATE TABLE message
(
    id      NUMERIC(19),
    message VARCHAR(3000) NOT NULL,
    created TIMESTAMP(6),
    PRIMARY KEY (id)
);

CREATE TABLE user_message
(
    id           NUMERIC(19),
    message_id   NUMERIC(19),
    from_user_id NUMERIC(10),
    to_user_id   NUMERIC(10),
    PRIMARY KEY (id),
    FOREIGN KEY (message_id) REFERENCES message (id),
    FOREIGN KEY (from_user_id) REFERENCES user (id),
    FOREIGN KEY (to_user_id) REFERENCES user (id)
);