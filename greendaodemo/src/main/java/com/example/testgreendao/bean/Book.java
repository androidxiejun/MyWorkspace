package com.example.testgreendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "db_book")
public class Book {
    @Id
    private Long id;
    @Property(nameInDb = "book_name")
    private String bookName;
    private Long studentId;
    @Generated(hash = 1353976697)
    public Book(Long id, String bookName, Long studentId) {
        this.id = id;
        this.bookName = bookName;
        this.studentId = studentId;
    }
    @Generated(hash = 1839243756)
    public Book() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getBookName() {
        return this.bookName;
    }
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public Long getStudentId() {
        return this.studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

}
