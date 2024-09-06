package com.mr.platform.controller;

import com.mr.platform.entity.User;
import com.mr.platform.mapper.UserMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

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

    @PostMapping()
    @Operation(summary = "添加新用户", description = "通过用户名添加新用户")
    public ResponseEntity<String> addUser(String username) {
        int result = userMapper.save(username);

        // 假设 insert 方法返回影响的行数，如果插入成功则返回 1
        if (result > 0) {
            // 插入成功，返回新建的用户信息，HTTP状态码为201 Created
            return new ResponseEntity<>(username, HttpStatus.CREATED);
        } else {
            // 插入失败，可以返回错误信息，HTTP状态码为400 Bad Request
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Failed to add user");
        }
    }



}
