package com.web.bookshop.dao;
import com.web.bookshop.model.Order;
import com.web.bookshop.model.OrderItem;
import com.web.bookshop.model.User;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface OrderDao {
    @Select("SELECT * FROM `orders` WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderTime", column = "ordertime"),
            @Result(property = "price", column = "price"),
            @Result(property = "state", column = "state"),
            @Result(property = "user", column = "user_id", javaType = User.class,
                    one = @One(select = "com.web.bookshop.dao.UserDao.findById")),
            @Result(property = "orderItems", column = "id", javaType = List.class,
                    many = @Many(select = "com.web.bookshop.dao.OrderItemDao.findByOrderId"))
    })
    Order findById(String id);

    @Insert("INSERT INTO `orders` (id, ordertime, price, state, user_id) " +
            "VALUES (#{id}, #{orderTime}, #{price}, #{state}, #{user.id})")
    int createOrder(Order order);

    @Update("UPDATE `orders` SET ordertime = #{orderTime}, price = #{price}, state = #{state}, user_id = #{user.id} " +
            "WHERE id = #{id}")
    int updateOrder(Order order);

    @Delete("DELETE FROM `orders` WHERE id = #{id}")
    int deleteOrder(String id);

    @Select("SELECT * FROM `orders`")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "orderTime", column = "ordertime"),
            @Result(property = "price", column = "price"),
            @Result(property = "state", column = "state"),
            @Result(property = "user", column = "user_id", javaType = User.class,
                    one = @One(select = "com.web.bookshop.dao.UserDao.findById")),
            @Result(property = "orderItems", column = "id", javaType = List.class,
                    many = @Many(select = "com.web.bookshop.dao.OrderItemDao.findByOrderId"))
    })
    List<Order> findAllOrders();
}