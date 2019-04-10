package com.example.testgreendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.Unique;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;
import com.example.testgreendao.entity.DaoSession;
import com.example.testgreendao.entity.BookBDao;
import com.example.testgreendao.entity.StudentBDao;

@Entity(nameInDb = "db_student_b")
public class StudentB {
    @Id
    private Long id;
    @Unique
    private String name;
    @Unique
    private Integer age;
    @ToMany()
    @JoinEntity(entity = StudentBook.class,
            sourceProperty = "studentId",
            targetProperty = "bookId")
    private List<BookB> bookBList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 515539149)
    private transient StudentBDao myDao;
    @Generated(hash = 1533444127)
    public StudentB(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
    @Generated(hash = 183392835)
    public StudentB() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return this.age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1790117563)
    public List<BookB> getBookBList() {
        if (bookBList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookBDao targetDao = daoSession.getBookBDao();
            List<BookB> bookBListNew = targetDao._queryStudentB_BookBList(id);
            synchronized (this) {
                if (bookBList == null) {
                    bookBList = bookBListNew;
                }
            }
        }
        return bookBList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 2028588572)
    public synchronized void resetBookBList() {
        bookBList = null;
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
    @Generated(hash = 443068458)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentBDao() : null;
    }
}
