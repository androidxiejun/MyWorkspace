package com.example.testgreendao.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.JoinProperty;
import org.greenrobot.greendao.annotation.ToMany;
import org.greenrobot.greendao.annotation.ToOne;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

import com.example.testgreendao.entity.DaoSession;
import com.example.testgreendao.entity.BagDao;
import com.example.testgreendao.entity.StudentDao;

import java.util.List;
import com.example.testgreendao.entity.BookDao;

@Entity(nameInDb = "db_student")
public class Student {
    @Id
    private Long id;
    @Unique
    private String name;
    @Unique
    private Integer age;
    private Long bagId;
    @ToOne(joinProperty = "bagId")
    Bag bag;
    @ToMany(referencedJoinProperty = "studentId")
    List<Book>bookList;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1943931642)
    private transient StudentDao myDao;
    @Generated(hash = 203448083)
    public Student(Long id, String name, Integer age, Long bagId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.bagId = bagId;
    }
    @Generated(hash = 1556870573)
    public Student() {
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
    public Long getBagId() {
        return this.bagId;
    }
    public void setBagId(Long bagId) {
        this.bagId = bagId;
    }
    @Generated(hash = 1142106681)
    private transient Long bag__resolvedKey;
    /** To-one relationship, resolved on first access. */
    @Generated(hash = 1839317348)
    public Bag getBag() {
        Long __key = this.bagId;
        if (bag__resolvedKey == null || !bag__resolvedKey.equals(__key)) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BagDao targetDao = daoSession.getBagDao();
            Bag bagNew = targetDao.load(__key);
            synchronized (this) {
                bag = bagNew;
                bag__resolvedKey = __key;
            }
        }
        return bag;
    }
    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 479675648)
    public void setBag(Bag bag) {
        synchronized (this) {
            this.bag = bag;
            bagId = bag == null ? null : bag.getId();
            bag__resolvedKey = bagId;
        }
    }

    public void setBookList(List<Book>bookList){
        this.bookList=bookList;
    }
    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 687556424)
    public List<Book> getBookList() {
        if (bookList == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            BookDao targetDao = daoSession.getBookDao();
            List<Book> bookListNew = targetDao._queryStudent_BookList(id);
            synchronized (this) {
                if (bookList == null) {
                    bookList = bookListNew;
                }
            }
        }
        return bookList;
    }
    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1428566046)
    public synchronized void resetBookList() {
        bookList = null;
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
    @Generated(hash = 1701634981)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getStudentDao() : null;
    }
}
