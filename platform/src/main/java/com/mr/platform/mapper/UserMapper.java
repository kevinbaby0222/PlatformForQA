package com.mr.platform.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mr.platform.entity.Qa;
import com.mr.platform.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author MR-DMA
 * @since 2024-08-27
 */
@Mapper
@Repository
@Component
public interface UserMapper extends BaseMapper<User> {

    @Select("SELECT u.*, q.* FROM public.user u LEFT JOIN qa q ON u.userid = q.askerid WHERE u.userid = #{userid}")
    @Results({
            @Result(property = "userid", column = "userid"),
            @Result(property = "username", column = "username"),
            @Result(property = "qas", column = "userid", many = @Many(select = "com.mr.platform.mapper.UserMapper.selectQuestionsByAskerId")),
    })
    List<User> selectUserAndQuestionsByUserId(int userid);

    @Select("SELECT q.* FROM qa q WHERE q.askerid = #{userid}")
    List<Qa> selectQuestionsByAskerId(int userid);

    @Insert("INSERT INTO t_user (username) VALUES(#{username})")
    int save(String username);

}
