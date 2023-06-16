package com.web.bookshop.dao;
import java.util.List;
import com.web.bookshop.model.Book;
import org.apache.ibatis.annotations.*;
@Mapper
public interface BookDao {
    @Select("select * from book where name = #{name}")
    public Book getByName(String name);
    @Select("SELECT * FROM book")
    List<Book> findAll();
    @Insert("INSERT INTO book (title, author, publication_date) VALUES (#{title}, #{author}, #{publicationDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int save(Book book);
    @Update("UPDATE book SET title = #{title}, author = #{author}, publication_date = #{publicationDate} WHERE id = #{id}")
    int update(Book book);
    @Delete("DELETE FROM book WHERE id = #{id}")
    int deleteByName(String name);
}
