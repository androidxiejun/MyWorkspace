package com.example.testgreendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "db_bag")
public class Bag {
    @Id
    private Long id;
    @Property(nameInDb = "bag_color")
    private String color;
    @Generated(hash = 573830589)
    public Bag(Long id, String color) {
        this.id = id;
        this.color = color;
    }
    @Generated(hash = 367414733)
    public Bag() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getColor() {
        return this.color;
    }
    public void setColor(String color) {
        this.color = color;
    }
}
