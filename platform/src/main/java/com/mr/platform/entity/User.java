package com.mr.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;


@Data
@Component
@TableName("public.t_user")
public class User implements Serializable {
    @TableId(type = IdType.AUTO)
    private int userid;

    private String username;

    @TableField(exist = false)
    private List<Qa> qas;

}
