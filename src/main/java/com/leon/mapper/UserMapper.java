//关于用户信息的mapper
package com.leon.mapper;
import com.leon.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface UserMapper {
//    向数据库UserInfo中插入一条数据==注册
    int insertUser(User user);
//    根据用户名查询单条数据
    User selectUserByUserQQ(@Param("userQQ") String userQQ);

}
