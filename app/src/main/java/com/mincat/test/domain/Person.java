package com.mincat.test.domain;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

import java.util.List;

/**
 * @author Ming
 * @描述 创建 person表
 */
// 表名
@Table(name = "xperson")
public class Person {

    // 列名 id为自增长
    @Column(name = "ID", isId = true, autoGen = true)
    public int id;
    @Column(name = "NAME")
    public String name;
    @Column(name = "AGE")
    public int age;
    @Column(name = "SEX")
    public String sex;
    @Column(name = "image")
    public String imageUrl;

    public Person(String name, int age, String sex, String imageUrl) {
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.imageUrl = imageUrl;
    }

    /**
     * 无参数的构造方法一定要有 否则向数据库中插入数据 读取数据会出错  org.xutils.ex.DbException: <init> []
     */
    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", name='" + name + '\'' + ", age=" + age + ", sex='" + sex + '\'' + ", imageUrl='" + imageUrl + '\'' + '}';
    }
}
