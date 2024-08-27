package com.mr.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Tag(name = "User对象", description = "User表")
@TableName("public.qa")
@Component
public class Qa implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "qaid", type = IdType.AUTO)
    private int qaid;

    private String questioncontent;

    private int askerid;

    public int getQaid() {
        return qaid;
    }

    public void setQaid(int qaid) {
        this.qaid = qaid;
    }

    public String getQuestioncontent() {
        return questioncontent;
    }

    public void setQuestioncontent(String questioncontent) {
        this.questioncontent = questioncontent;
    }

    public int getAskerid() {
        return askerid;
    }

    public void setAskerid(int askerid) {
        this.askerid = askerid;
    }

    @Override
    public String toString() {
        return "Qa{" +
                "qaid = " + qaid +
                ", questioncontent = " + questioncontent +
                ", askerid = " + askerid +
                "}";
    }
}
