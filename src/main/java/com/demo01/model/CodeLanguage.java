package com.demo01.model;

import lombok.Getter;
import lombok.Setter;

//@Setter
//@Getter
public class CodeLanguage {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private int id;

    private String name;

    private int age;

    @Override
    public String toString() {
        return "CodeLanguage{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
