package com.community.demo.Mapper;

import com.community.demo.Model.Question;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface QuestionMapper2 {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,comment_count,view_count,like_count,tag) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{comment_count},#{view_count},#{like_count},#{tag})")
    public void  create(Question quesion);


    @Select("select * from question limit #{offset},#{size}")
    public List<Question> selectList(@Param("offset") int offset, @Param("size") int size);

    @Select("select count(1) from question")
    public int selectCount();

    @Select("select * from question where creator=#{userid} limit #{offset},#{size}")
    public List<Question> pfofileList(@Param("userid")int userid, @Param("offset") int offset, @Param("size") int size);

    @Select("select count(1) from question where creator=#{userid}")
    public int countByUserID(@Param("userid")int userid);

    @Select("select * from question where id=#{id}")
    public Question getByID(@Param("id") int id);

    @Update("update question set title=#{title},description=#{description},gmt_modified=#{gmt_modified},tag=#{tag} where id=#{id}")
    public void update(Question quesion);
}

