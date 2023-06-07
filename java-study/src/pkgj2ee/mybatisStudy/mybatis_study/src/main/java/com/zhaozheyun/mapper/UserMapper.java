package com.zhaozheyun.mapper;

import com.zhaozheyun.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {

    Integer insert();

    Integer update();

    Integer delete();

    User findUserByUsername(String username);

    User checkLogin(String username, String password);

    /**
     * 验证登录（使用@Param）
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
    /**
     * 验证登录（参数为map）
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加用户信息
     */
    User checkLoginByUser(User user);

    List<User> findUserFullList();

    Map<String, Object> findUserByIdToMap();

    List<Map<String, Object>> findUserByUsernameToMapList();

    @MapKey("id")
    Map<String, Object> findUserByUsernameToMapSetMapKey();

}
