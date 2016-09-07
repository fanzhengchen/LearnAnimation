package com.fzc.animationlearn.activity.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by fanzhengchen on 9/7/16.
 */
public class User extends RealmObject {
    @PrimaryKey
    private long id;
    private String name;
    private int age;
    private RealmList<Dog> dogs;

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

    public RealmList<Dog> getDogs() {
        return dogs;
    }

    public void setDogs(RealmList<Dog> dogs) {
        this.dogs = dogs;
    }
}
