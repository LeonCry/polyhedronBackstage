//关于用户信息的mapper
package com.leon.mapper;
import com.leon.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    //    根据用户名查询单条用户信息数据
    User selectUserByUserQQ(@Param("userQQ") String userQQ);

    //    插入一条用户信息数据
    int insertUser(User user);

    //    修改一条用户信息数据
    int updateUser(User user);

    //    根据用户名或昵称返回用户信息list
    List<User> selectUsersByUserQQOrUserName(@Param("userQQ") String userQQ);


}
