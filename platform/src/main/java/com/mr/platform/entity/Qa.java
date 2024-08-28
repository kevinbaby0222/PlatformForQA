package com.mr.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Tag(name = "User对象", description = "User表")
@TableName("public.qa")
@Component
public class Qa implements Serializable {


    @TableId(value = "qaid", type = IdType.AUTO)
    private int qaid;

    private String questioncontent;

    private int askerid;

}
