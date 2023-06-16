package com.web.bookshop.controller;
import com.web.bookshop.model.Book;
import com.web.bookshop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    // 获取所有书籍
    @GetMapping("/books")
    public String getBooks(Model model) {
        List<Book> books = bookService.getAllBooks();
        model.addAttribute("books", books);
        return "books"; // 返回books.html视图
    }
    // 获取书籍详情页
    @GetMapping("/book/{name}")
    public String showBookDetails(@PathVariable("name") String name, Model model) {
        // 从数据库中获取指定书籍ID的书本信息
        Book book = bookService.getBookByName(name);
        // 将书本信息传递给模型
        model.addAttribute("book", book);
        return "book"; // 返回 book.html 视图
    }
}