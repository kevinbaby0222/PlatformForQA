package com.mr.platform.controller;

import com.mr.platform.entity.User;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.mr.platform.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MR-DMA
 * @since 2024-08-27
 */
@Tag(name = "UserController", description = "用户接口管理")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired//注入userMapper，从而可以在类中正常使用userMapper的方法
    private UserMapper userMapper;

    @Operation(summary = "获取所有用户", description = "无需输入")
    @GetMapping()
    public ResponseEntity<List<User>> queryUserAll() {
        List<User> list = userMapper.selectList(null);
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(list);
        }
    }
    @GetMapping("/all")
    @Operation(summary = "查询用户及其问题信息", description = "通过用户ID查询用户及其所有问题")
    public ResponseEntity<List<User>> queryUserAndQuestions(int userid) {

        List<User> user = userMapper.selectUserAndQuestionsByUserId(userid);

        if (user == null) {

            return ResponseEntity.notFound().build();
        } else {

            return ResponseEntity.ok(user);
        }
    }

}
