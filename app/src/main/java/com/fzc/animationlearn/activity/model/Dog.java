package com.fzc.animationlearn.activity.model;

import io.realm.RealmObject;

/**
 * Created by fanzhengchen on 9/7/16.
 */
public class Dog extends RealmObject {

    private String name;
    private int age;

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
}
