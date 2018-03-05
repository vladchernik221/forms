CREATE TABLE IF NOT EXISTS `user` (
  `user_id`  BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `login`    VARCHAR(100)    NOT NULL,
  `password` VARCHAR(45)     NOT NULL,
  PRIMARY KEY (`user_id`),
  UNIQUE INDEX `user_id_UNIQUE` (`user_id` ASC),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC)
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `form` (
  `form_id`       BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name`          VARCHAR(256)    NOT NULL,
  `description`   VARCHAR(512)    NULL,
  `creation_date` DATETIME        NULL     DEFAULT CURRENT_TIMESTAMP,
  `author_id`     BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`form_id`),
  UNIQUE INDEX `form_id_UNIQUE` (`form_id` ASC),
  INDEX `fk_form_user_idx` (`author_id` ASC),
  CONSTRAINT `fk_form_user`
  FOREIGN KEY (`author_id`)
  REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `question` (
  `question_id` BIGINT UNSIGNED                 NOT NULL AUTO_INCREMENT,
  `text`        VARCHAR(512)                    NULL,
  `type`        ENUM ('OPEN', 'RADIO', 'CHECK') NOT NULL,
  `form_id`     BIGINT UNSIGNED                 NOT NULL,
  PRIMARY KEY (`question_id`),
  UNIQUE INDEX `question_id_UNIQUE` (`question_id` ASC),
  INDEX `fk_question_form1_idx` (`form_id` ASC),
  CONSTRAINT `fk_question_form1`
  FOREIGN KEY (`form_id`)
  REFERENCES `form` (`form_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `answer_option` (
  `answer_option_id` BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `answer`           VARCHAR(256)    NOT NULL,
  `question_id`      BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`answer_option_id`),
  UNIQUE INDEX `answer_option_id_UNIQUE` (`answer_option_id` ASC),
  INDEX `fk_answer_option_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_answer_option_question1`
  FOREIGN KEY (`question_id`)
  REFERENCES `question` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `answer` (
  `answer_id`     BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
  `simple_answer` VARCHAR(256)    NULL,
  `user_id`       BIGINT UNSIGNED NOT NULL,
  `question_id`   BIGINT UNSIGNED NOT NULL,
  `answer_option_id` BIGINT UNSIGNED NOT NULL,
  PRIMARY KEY (`answer_id`),
  UNIQUE INDEX `answer_id_UNIQUE` (`answer_id` ASC),
  INDEX `fk_answer_user1_idx` (`user_id` ASC),
  INDEX `fk_answer_question1_idx` (`question_id` ASC),
  CONSTRAINT `fk_answer_user1`
  FOREIGN KEY (`user_id`)
  REFERENCES `user` (`user_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answer_question1`
  FOREIGN KEY (`question_id`)
  REFERENCES `question` (`question_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_answer_answer_option1`
  FOREIGN KEY (`answer_option_id`)
  REFERENCES `answer_option` (`answer_option_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
)
  ENGINE = InnoDB;