package com.example.testgreendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity(nameInDb = "db_student_book")
public class StudentBook {
    @Id
    private Long id;
    private Long studentId;
    private Long bookId;
    @Generated(hash = 98494766)
    public StudentBook(Long id, Long studentId, Long bookId) {
        this.id = id;
        this.studentId = studentId;
        this.bookId = bookId;
    }
    @Generated(hash = 2001190842)
    public StudentBook() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getStudentId() {
        return this.studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
    public Long getBookId() {
        return this.bookId;
    }
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }
}
