package com.mr.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@TableName("public.user")
public class User {
    @TableId(type = IdType.AUTO)
    private int userid;

    private String username;

    @TableField(exist = false)
    private List<Qa> qas;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<Qa> getQas() {
        return qas;
    }

    public void setQas(List<Qa> qas) {
        this.qas = qas;
    }

    @Override
    public String toString() {
        return "User{" +
                "userid=" + userid +
                ", username='" + username + '\'' +
                // ", qas=" + qas + //
                '}';
    }
}
