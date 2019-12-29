package com.community.demo.Mapper;

import com.community.demo.Model.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("insert into user(accountID,name,token,gmtCreate,gmtModified,picture) values(#{ACCOUNTID},#{NAME},#{TOKEN},#{GMTCREATE},#{GMTMODIFIED},#{picture})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User  findByToken(@Param("token") String token);

    @Select("select * from user where ID=#{ID}")
    User findByID(@Param("ID") int ID );

    @Select("select * from user where accountid=#{accountid}")
    User findByAccountID(@Param("accountid") String accountid);

    @Update("update user set name=#{NAME},token=#{TOKEN},gmtModified=#{GMTMODIFIED},gmtCreate=#{GMTCREATE} where id=#{ID}")
    void update(User dbUser);
}
