package com.example.testgreendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.testgreendao.entity.DaoSession;
import com.example.testgreendao.entity.StudentDao;
import com.example.testgreendao.entity.BookBDao;
import com.example.testgreendao.entity.StudentBDao;

@Entity(nameInDb = "db_book_b")
public class BookB {
    @Id
    private Long id;
    @Property(nameInDb = "book_name")
    private String bookName;
    @ToMany
    @JoinEntity(entity = StudentBook.class,
    sourceProperty = "bookId",
    targetProperty = "studentId")
    private List<StudentB>studentList;
    /** Used to resolve relations */
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1118690060)
    private transient BookBDao myDao;
    @Generated(hash = 1958363109)
    public BookB(Long id, String bookName) {
        this.id = id;
        this.bookName = bookName;
    }
    @Generated(hash = 1283110361)
    public BookB() {
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
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    public void setStudentList(List<StudentB>studentList){
        this.studentList=studentList;
    }
    @Generated(hash = 921777853)
    public List<StudentB> getStudentList() {
        if (studentList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            StudentBDao targetDao = daoSession.getStudentBDao();
            List<StudentB> studentListNew = targetDao._queryBookB_StudentList(id);
            synchronized (this) {
                if (studentList == null) {
                    studentList = studentListNew;
                }
            }
        }
        return studentList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1628625923)
    public synchronized void resetStudentList() {
        studentList = null;
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }
    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 598709328)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getBookBDao() : null;
    }
}
