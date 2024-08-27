package com.mr.platform.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.mr.platform.entity.Qa;
import com.mr.platform.service.IQaService;
import com.mr.platform.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import com.mr.platform.mapper.QaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author MR-DMA
 * @since 2024-08-27
 */
@Tag(name = "QaController", description = "QA对接口管理")
@RestController
@RequestMapping("/qa")
public class QaController {
    @Autowired
    private QaMapper qaMapper;
    @Autowired
    private IQaService qaService;


    @Operation(summary = "根据UserID获取该用户问的Qa对", description = "输入Userid")
    @GetMapping("/{userid}")
    public ResponseEntity<List<Qa>> selectListByUserId(@PathVariable int userid) {
        List<Qa> qas = qaMapper.selectQuestionsByAskerId(userid);
        if (qas.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(qas);
        }
    }

    @Operation(summary = "获取所有QA对", description = "无需输入")
    @GetMapping()
    public ResponseEntity<List<Qa>> queryQaAll() {
        List<Qa> list = qaMapper.selectList(null);
        if (list.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(list);
        }
    }

    @Operation(summary = "添加QA对", description = "需要Body中以表单格式输入")
    @PostMapping()
    public ResponseEntity<String> insertQa(@RequestBody Qa qa) {
        int savedRows = qaMapper.save(qa.getQuestioncontent(), qa.getAskerid());
        if (savedRows > 0) {
            return ResponseEntity.status(HttpStatus.CREATED).body("添加成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("添加失败");
        }
    }

    @Operation(summary = "更新QA对", description = "需要输入完整的QA对信息")
    @PutMapping()
    public ResponseEntity<String> updateQa(Qa qa) {
        int updatedRows = qaMapper.updateByQaid(qa);
        if (updatedRows > 0) {
            return ResponseEntity.ok("更新成功");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("更新失败");
        }
    }

    @Operation(summary = "删除QA对", description = "需要输入QA对的ID")
    @DeleteMapping("/{qaid}")
    public ResponseEntity<String> deleteQa(@PathVariable int qaid) {
        int deletedRows = qaMapper.deleteById(qaid);
        if (deletedRows > 0) {
            return ResponseEntity.ok("删除成功");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("未找到QA对");
        }
    }

    @Operation(summary = "Playground", description = "自己玩")
    @GetMapping("/service")
    public ResponseEntity<List<Qa>> QaOps() {
        LambdaQueryWrapper<Qa> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(Qa::getQuestioncontent, "我");
        Collection<Qa> qas = qaService.list(queryWrapper);
        if (qas != null) {
            return ResponseEntity.ok(qas.stream().toList());
        } else {
            return ResponseEntity.noContent().build();
        }
    }


}
