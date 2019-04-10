package com.example.testgreendao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.testgreendao.bean.Bag;
import com.example.testgreendao.bean.Book;
import com.example.testgreendao.bean.BookB;
import com.example.testgreendao.bean.Student;
import com.example.testgreendao.bean.StudentB;
import com.example.testgreendao.bean.StudentBook;
import com.example.testgreendao.daohelper.GreendaoUtil;
import com.example.testgreendao.entity.BagDao;
import com.example.testgreendao.entity.BookBDao;
import com.example.testgreendao.entity.BookDao;
import com.example.testgreendao.entity.DaoSession;
import com.example.testgreendao.entity.StudentBDao;
import com.example.testgreendao.entity.StudentBookDao;
import com.example.testgreendao.entity.StudentDao;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static StudentDao mStudentDao;
    private static StudentBDao mStudentBDao;
    private static BagDao mBagDao;
    private static BookDao mBookDao;
    private static BookBDao mBookBDao;
    private static StudentBookDao mStudentBookDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDao();
        testOneToOne();
        testOneToMany();
    }


    /**
     * 初始化所需的Dao类
     */
    private void initDao() {
        mStudentDao=GreendaoUtil.getmInstance().getDaoSession().getStudentDao();
        mStudentBDao=GreendaoUtil.getmInstance().getDaoSession().getStudentBDao();
        mBagDao=GreendaoUtil.getmInstance().getDaoSession().getBagDao();
        mBookDao=GreendaoUtil.getmInstance().getDaoSession().getBookDao();
        mBookBDao=GreendaoUtil.getmInstance().getDaoSession().getBookBDao();
        mStudentBookDao=GreendaoUtil.getmInstance().getDaoSession().getStudentBookDao();
    }

    /**
     * GreenDao一对一关联
     */
    private void testOneToOne() {
        Bag bag=new Bag();
        bag.setColor("黑色");
        mBagDao.save(bag);

        Student student=new Student();
        student.setName("栋梁");
        student.setAge(18);
        student.setBagId(bag.getId());
        mStudentDao.save(student);

    }


    /**
     * GreenDao一对多关联
     */
    private void testOneToMany() {
        List<Book>books=new ArrayList<>();
        Student student=new Student();

        Book bookA=new Book();
        bookA.setBookName("英语");
        bookA.setStudentId(student.getId());
        mBookDao.save(bookA);

        Book bookB=new Book();
        bookB.setBookName("数学");
        bookB.setStudentId(student.getId());
        mBookDao.save(bookB);

        Book bookC=new Book();
        bookC.setBookName("语文");
        bookC.setStudentId(student.getId());
        mBookDao.save(bookC);

        books.add(bookA);
        books.add(bookB);
        books.add(bookC);

        student.setAge(20);
        student.setName("花朵");
        student.setBookList(books);
        mStudentDao.save(student);
    }

    /**
     * GreenDao多对多关联
     */
    private void testManyToMany(){
        StudentB student1=new StudentB();
        student1.setName("张三");
        student1.setAge(22);
        mStudentBDao.save(student1);

        StudentB student2=new StudentB();
        student2.setName("李四");
        student2.setAge(25);
        mStudentBDao.save(student2);

        BookB book1=new BookB();
        book1.setBookName("呐喊");
        mBookBDao.save(book1);

        BookB book2=new BookB();
        book2.setBookName("活着");
        mBookBDao.save(book2);

        StudentBook studentBookA=new StudentBook();
        studentBookA.setStudentId(student1.getId());
        studentBookA.setBookId(book1.getId());
        mStudentBookDao.save(studentBookA);

        StudentBook studentBookB=new StudentBook();
        studentBookB.setStudentId(student1.getId());
        studentBookB.setBookId(book2.getId());
        mStudentBookDao.save(studentBookB);

        StudentBook studentBookC=new StudentBook();
        studentBookC.setStudentId(student2.getId());
        studentBookC.setBookId(book2.getId());
        mStudentBookDao.save(studentBookC);

    }
}
