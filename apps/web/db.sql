create table `tb_media` (
    `id` INT primary key AUTO_INCREMENT,
    `title` varchar(100) not null,
    `src` varchar(100) not null,
    `picture` varchar(100) not null,
    `descript` varchar(100) not null,
    `uptime` varchar(100) not null
) comment '视频';