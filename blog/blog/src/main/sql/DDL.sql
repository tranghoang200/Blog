USE mysql;
CREATE USER 'trang2kblog'@'localhost' IDENTIFIED WITH mysql_native_password BY 'trang2kblog@123';
GRANT ALL PRIVILEGES ON database_name.* TO'trang2kblog'@'localhost';

DROP DATABASE IF EXISTS trang2kblog;
CREATE DATABASE trang2kblog;

USE trang2kblog;

CREATE TABLE IF NOT EXISTS `trang2kblog`.`blog` (
  `id`           INT(11)       	AUTO_INCREMENT,
  `title`        NVARCHAR(250) 	NULL,
  `description`  NVARCHAR(2000) NULL,
  `content`      TEXT 			NULL,
  `status`       INT(1)        	NULL	DEFAULT 1,
  `created_by` 	 NVARCHAR(250)	NULL	DEFAULT 'ADMIN',
  `created_date` DATETIME     	NULL	DEFAULT CURRENT_TIMESTAMP,
  `updated_by` 	 NVARCHAR(250)	NULL 	DEFAULT 'ADMIN',
  `updated_date` DATETIME     	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

CREATE TABLE IF NOT EXISTS `trang2kblog`.`log` (
  `id`           INT(11)       	AUTO_INCREMENT,
  `content`      TEXT 			NULL,
  `status`       INT(1)        	NULL	DEFAULT 1,
  `created_by` 	 NVARCHAR(250)	NULL	DEFAULT 'ADMIN',
  `created_date` DATETIME     	NULL	DEFAULT CURRENT_TIMESTAMP,
  `updated_by` 	 NVARCHAR(250)	NULL 	DEFAULT 'ADMIN',
  `updated_date` DATETIME     	NULL	DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

SELECT * FROM log;

INSERT INTO `trang2kblog`.`blog` (title, description, content, created_by)
VALUES ('Title 1', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..', 'trang2k'),
('Title 2', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..', 'trang2k'),
('Title 3', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..', 'trang2k'),
('Title 4', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..', 'trang2k'),
('Title 5', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..', 'trang2k'),
('Title 6', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 7', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..', 'trang2k'),
('Title 8', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 9', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 10', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 11', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 12', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 13', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 14', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 15', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k'),
('Title 16', 'Desciption', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..',  'trang2k');