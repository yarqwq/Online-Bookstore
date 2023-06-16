package com.web.bookshop.service;
import com.web.bookshop.dao.BookDao;
import com.web.bookshop.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;
    public Book getBookByName(String name) {
        return bookDao.getByName(name);
    }
    // 获取所有书籍
    public List<Book> getAllBooks() {
        return bookDao.findAll();
    }
    // 添加书籍
    public boolean addBook(Book book) {
        return bookDao.save(book)>0;
    }
    // 更新书籍
    public boolean updateBook(Book book) {
        return bookDao.update(book)>0;
    }
    // 删除书籍
    public boolean deleteBook(String name) {
        return bookDao.deleteByName(name)>0;
    }
}