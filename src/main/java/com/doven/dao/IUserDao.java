package com.doven.dao;

import com.doven.domain.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/*** @author dyt
 * @version 1.0
 * @date 2021/5/19 21:54
 */
public interface IUserDao {
    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE id = 1")
    User findOne();
}
