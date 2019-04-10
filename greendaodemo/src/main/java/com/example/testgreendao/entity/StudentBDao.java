package com.example.testgreendao.entity;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.example.testgreendao.bean.StudentBook;

import com.example.testgreendao.bean.StudentB;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "db_student_b".
*/
public class StudentBDao extends AbstractDao<StudentB, Long> {

    public static final String TABLENAME = "db_student_b";

    /**
     * Properties of entity StudentB.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Age = new Property(2, Integer.class, "age", false, "AGE");
    }

    private DaoSession daoSession;

    private Query<StudentB> bookB_StudentListQuery;

    public StudentBDao(DaoConfig config) {
        super(config);
    }
    
    public StudentBDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"db_student_b\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"NAME\" TEXT UNIQUE ," + // 1: name
                "\"AGE\" INTEGER UNIQUE );"); // 2: age
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"db_student_b\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, StudentB entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(3, age);
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, StudentB entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
 
        Integer age = entity.getAge();
        if (age != null) {
            stmt.bindLong(3, age);
        }
    }

    @Override
    protected final void attachEntity(StudentB entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public StudentB readEntity(Cursor cursor, int offset) {
        StudentB entity = new StudentB( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2) // age
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, StudentB entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setAge(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(StudentB entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(StudentB entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(StudentB entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "studentList" to-many relationship of BookB. */
    public List<StudentB> _queryBookB_StudentList(Long bookId) {
        synchronized (this) {
            if (bookB_StudentListQuery == null) {
                QueryBuilder<StudentB> queryBuilder = queryBuilder();
                queryBuilder.join(StudentBook.class, StudentBookDao.Properties.StudentId)
                    .where(StudentBookDao.Properties.BookId.eq(bookId));
                bookB_StudentListQuery = queryBuilder.build();
            }
        }
        Query<StudentB> query = bookB_StudentListQuery.forCurrentThread();
        query.setParameter(0, bookId);
        return query.list();
    }

}