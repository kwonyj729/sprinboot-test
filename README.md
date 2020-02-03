# Springboot-MyBatis-MySQL

## 1. MySQL 세팅
```sql
-- DDL (create, drop, alter)
-- 유저이름@ip주소
create user 'spring'@'%' identified by 'bitc5600';
create database spring;

-- DCL (grant, revoke)
-- on DB이름.테이블명
grant all privileges on spring.* to 'spring'@'%';

CREATE TABLE mem(
	id int auto_increment primary key,
    username varchar(100) not null,
    password varchar(100) not null,
    email varchar(100),
    createDate timestamp
) engine=InnoDB default charset=utf8;
```

## 2. JSTL 태그 라이브러리
```jsp
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
```