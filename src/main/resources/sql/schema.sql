create table IF NOT EXISTS oauth_client_details (
    client_id VARCHAR(256) PRIMARY KEY,
    resource_ids VARCHAR(256),
    client_secret VARCHAR(256),
    scope VARCHAR(256),
    authorized_grant_types VARCHAR(256),
    web_server_redirect_uri VARCHAR(256),
    authorities VARCHAR(256),
    access_token_validity INTEGER,
    refresh_token_validity INTEGER,
    additional_information VARCHAR(4096),
    autoapprove VARCHAR(256)
);

CREATE TABLE `tbl_user` (
    `msrl` BIGINT(20) NOT NULL,
    `name` VARCHAR(100) NOT NULL,
    `password` VARCHAR(100) NULL DEFAULT NULL,
    `provider` VARCHAR(100) NULL DEFAULT NULL,
    `uid` VARCHAR(100) NOT NULL,
    `email` VARCHAR(100) NOT NULL,
    PRIMARY KEY (`msrl`),
    UNIQUE INDEX `UK_tbl_user_uid` (`uid`)
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB;

CREATE TABLE `user_roles` (
    `user_msrl` BIGINT(20) NOT NULL,
    `roles` VARCHAR(255) NULL DEFAULT NULL,
    INDEX `FK7ie1lfmnysdogxy1g91ernbkv` (`user_msrl`),
    CONSTRAINT `FK_tbl_user_msrl` FOREIGN KEY (`user_msrl`) REFERENCES `tbl_user` (`msrl`)
)
COLLATE='utf8_general_ci'
ENGINE=INNODB;



