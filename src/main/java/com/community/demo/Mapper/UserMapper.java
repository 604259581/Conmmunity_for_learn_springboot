package com.community.demo.Mapper;

import com.community.demo.Model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Insert("insert into user(accountID,name,token,gmtCreate,gmtModified,picture) values(#{ACCOUNTID},#{NAME},#{TOKEN},#{GMTCREATE},#{GMTMODIFIED},#{picture})")
    void insert(User user);

    @Select("select * from user where token=#{token}")
    User  findByToken(@Param("token") String token);

    @Select("select * from user where ID=#{ID}")
    User findByID(@Param("ID") int ID );

//    @Select("select ID from user where token=#{token}")
//    int  findByID(@Param("token") String token);
//
//    @Select("select ACCOUNTID from user where token=#{token}")
//    String  findByACCID(@Param("token") String token);
//
//    @Select("select name from user where token=#{token}")
//    String  findByName(@Param("token") String token);
//
//    @Select("select token from user where token=#{token}")
//    String  findByToken(@Param("token") String token);
//
//    @Select("select GMTCREATE from user where token=#{token}")
//    long  findByGmtCreate(@Param("token") String token);
//
//    @Select("select GMTMODIFIED from user where token=#{token}")
//    long  findByModified(@Param("token") String token);


}
