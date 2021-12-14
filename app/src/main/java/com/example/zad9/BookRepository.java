package com.example.zad9;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

public class BookRepository {

    private BookDao bookDao;
    private LiveData<List<Book>> books;

    BookRepository(Application application){
        BookDatabase database = BookDatabase.getDatabase(application);
        bookDao = database.bookDao();
        books = bookDao.findall();
    }

    LiveData<List<Book>> findallBooks(){
        return books;
    }

    void insert(Book book){
        BookDatabase.databaseWriteExecutor.execute(() ->{
            bookDao.insert(book);
        });
    }

    void update(Book book){
        BookDatabase.databaseWriteExecutor.execute(() ->{
            bookDao.update(book);
        });
    }

    void delete(Book book){
        BookDatabase.databaseWriteExecutor.execute(() ->{
            bookDao.delete(book);
        });
    }

}
