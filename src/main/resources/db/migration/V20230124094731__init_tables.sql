CREATE TABLE user
(
    id          BIGINT AUTO_INCREMENT NOT NULL,
    username    VARCHAR(255)          NOT NULL,
    profile_pic VARCHAR(255)          NOT NULL,
    CONSTRAINT pk_user PRIMARY KEY (id)
);

CREATE TABLE follow
(
    follower_id BIGINT NOT NULL,
    followee_id BIGINT NOT NULL,
    CONSTRAINT pk_follow PRIMARY KEY (follower_id, followee_id)
);

CREATE TABLE tweet
(
    id        BIGINT AUTO_INCREMENT NOT NULL,
    sender_id BIGINT                NOT NULL,
    text      VARCHAR(255)          NOT NULL,
    timestamp datetime              NOT NULL,
    CONSTRAINT pk_tweet PRIMARY KEY (id)
);
