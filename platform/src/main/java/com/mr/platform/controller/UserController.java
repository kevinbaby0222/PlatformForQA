package com.mr.platform.controller;

import com.mr.platform.entity.User;
import com.mr.platform.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
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
    @Operation(summary = "查询用户", description = "通过用户ID查询用户")
    public ResponseEntity<User> queryUserAndQuestions(int userid) {

        User user = userMapper.selectById(userid);

        if (user == null) {

            return ResponseEntity.notFound().build();
        } else {

            return ResponseEntity.ok(user);
        }
    }

}
