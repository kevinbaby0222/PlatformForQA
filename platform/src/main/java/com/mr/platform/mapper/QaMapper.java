package com.mr.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mr.platform.entity.Qa;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;


@Mapper
@Repository
@Component
public interface QaMapper extends BaseMapper<Qa> {
    @Insert("INSERT INTO qa (questioncontent,askerid) VALUES(#{questioncontent}, #{askerid})")
    int save(String questioncontent, int askerid);

    @Update("UPDATE qa SET questioncontent = #{questioncontent} WHERE qaid = #{qaid} AND askerid = #{askerid}")
    int updateByQaid(Qa qa);

    @Select("SELECT q.* FROM qa q WHERE q.askerid = #{userid}")
    List<Qa> selectQuestionsByAskerId(int userid);


}
