USE mysql;
CREATE USER 'trang2kblog'@'localhost' IDENTIFIED WITH mysql_native_password BY 'trang2kblog@123';
GRANT ALL PRIVILEGES ON database_name.* TO'trang2kblog'@'localhost';
DROP DATABASE IF EXISTS trang2kblog;
CREATE DATABASE trang2kblog;
GRANT ALL ON trang2kblog.* TO trang2kblog@localhost;

USE trang2kblog;

CREATE TABLE IF NOT EXISTS `trang2kblog`.`blog` (
  `id`           INT(11)       AUTO_INCREMENT,
  `title`        NVARCHAR(250),
  `content`      TEXT,
  `status`       INT(1)        DEFAULT 1,
  `created_by` 	 INT(11)       DEFAULT NULL,
  `updated_by` 	 INT(11)       DEFAULT NULL,
  PRIMARY KEY (`id`)
)
  AUTO_INCREMENT = 1;

INSERT INTO `trang2kblog`.`blog` (title, content)
VALUES ('Title 1', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 2', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 3', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 4', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 5', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 6', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 7', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 8', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 9', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 10', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 11', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 12', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 13', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 14', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 15', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..'),
('Title 16', '(ND) Trên toàn nước Mỹ, số ca nhiễm mới có xu hướng tăng nhẹ sau 5 tuần sụt giảm. Một phần nguyên nhân dẫn tới sự gia tăng này là do có thêm nhiều xét nghiệm được tiến hành. Số ca xét nghiệm tăng cao kỷ lục vào ngày 5/6 khi có tới 545.690 trường hợp được xét nghiệm trong 1 ngày..');