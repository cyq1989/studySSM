package com.yq.dao;

import com.yq.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserDao {

    public User getUser(@Param("id") int id);

//    public User getUser(@Param("id") int id, @Param("name") String name);

    public void dropTable(@Param("tableName") String tableName);

    @Select("select t_id id, t_name name, t_age age from user where t_id = #{id}")
    public User selectUser(@Param("id") int id);

//    @Select("select t_id id, t_name name, t_age age from user where t_id = #{id} and t_name = #{name}")
//    public User selectUser(@Param("id") int id, @Param("name") String name);

    public int insertValue(User user);

}
