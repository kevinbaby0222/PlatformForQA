package com.mr.platform.controller;

import com.mr.platform.entity.Qa;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class PlatformController {

    //  http://localhost:2222/hello?nickname=Clem&team=liquid
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello(String nickname, String team) {
        System.out.println(team);
        return "欢迎来到数据平台," + nickname;
    }

    @RequestMapping(value = "/getTest3", method = RequestMethod.GET)
    public String getTest3(@RequestParam(value = "nickname", required = false) String name) {
        System.out.println("nickname:" + name);
        return "This is a GET";
    }

    @RequestMapping(value = "/postTest2", method = RequestMethod.POST)
    public String postTest2(String username, String password) {
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        return "This is a POST";
    }

    @RequestMapping(value = "/postTest3", method = RequestMethod.POST)
    public String postTest3(@RequestBody Qa qa) {
        System.out.println("问题ID:" + qa.getQaid());
        System.out.println("问题内容:" + qa.getQuestioncontent());
        return qa.toString();
    }
    @PostMapping("/postTestMarkdown")
    public String postTestMarkdown(@RequestBody Map<String, String> data) {
        // 从Map中获取Markdown内容
        String markdown = data.get("markdown");
        // 打印Markdown内容
        System.out.println("Markdown内容: " + markdown);
        // 返回一个简单的成功消息
        return "Markdown content received" + markdown;
    }

}
