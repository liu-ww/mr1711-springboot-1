package com.mr.model;

import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.sql.Date;

public class User implements Serializable{
    private Integer id;

    private String name;

    private Integer age;

    private Date date;

    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", date=" + date +
                ", sex='" + sex + '\'' +
                '}';
    }

    public User() {
    }

    public User(Integer id, String name, Integer age, Date date, String sex) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.date = date;
        this.sex = sex;
    }
}