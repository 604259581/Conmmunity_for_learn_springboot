package com.community.demo.Mapper;

import com.community.demo.Model.Question;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface QuestionMapper {

    @Insert("insert into question(title,description,gmt_create,gmt_modified,creator,comment_count,view_count,like_count,tag) values (#{title},#{description},#{gmt_create},#{gmt_modified},#{creator},#{comment_count},#{view_count},#{like_count},#{tag})")
    public void  create(Question quesion);


    @Select("select * from question limit #{offset},#{size}")
    public List<Question> selectList(@Param("offset") int offset, @Param("size") int size);

    @Select("select count(1) from question")
    public int selectCount();
}
