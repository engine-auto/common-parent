package com.auto.mapper;

import com.auto.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Roy on 2017/6/16.
 */
public interface UserMapper {

    @Select("SELECT * FROM t_user")
    @Results({
            @Result(property = "username",  column = "username"),
            @Result(property = "password", column = "password")
    })
    List<User> getAll();

    @Select("SELECT * FROM t_user WHERE id = #{id}")
    @Results({
            @Result(property = "username",  column = "username"),
            @Result(property = "password", column = "password")
    })
    User getOne(Long id);

    @Select("SELECT * FROM t_user WHERE username = #{username}")
    @Results({
            @Result(property = "username",  column = "username")
    })
    User findByusername(String username);

    @Insert("INSERT INTO t_user(username,password) VALUES(#{username}, #{password}")
    void insert(User user);

    @Update("UPDATE t_user SET username=#{username},password=#{password} WHERE id =#{id}")
    void update(User user);

    @Delete("DELETE FROM t_user WHERE id =#{id}")
    void delete(Long id);

}