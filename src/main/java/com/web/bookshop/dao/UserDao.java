package com.web.bookshop.dao;
import com.web.bookshop.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface UserDao {
    @Select("select * from user where id = #{id}")
    User findById(String id);
    @Select("select * from user where username = #{username}")
    User findByUsername(String username);
    @Select("select * from user")
    List<User> findAll();
    @Insert("insert into user (id, username, password, cellphone, email, address, admin) values (#{id}, #{username}, #{password}, #{cellphone}, #{email}, #{address}, #{admin})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int createUser(User user);
    @Update("update user set username = #{username}, password = #{password}, cellphone = #{cellphone}, email = #{email}, address = #{address}, admin = #{admin} where id = #{id}")
    int updateUser(User user);
    @Delete("delete from user where id = #{id}")
    int deleteUser(String id);
}