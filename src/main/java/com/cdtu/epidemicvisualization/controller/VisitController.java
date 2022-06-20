package com.cdtu.epidemicvisualization.controller;

import com.cdtu.epidemicvisualization.entity.Visit;
import com.cdtu.epidemicvisualization.service.VisitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Visit)表控制层
 *
 * @author makejava
 * @since 2022-06-20 20:22:58
 */
@RestController
@RequestMapping("visit")
public class VisitController {
    /**
     * 服务对象
     */
    @Resource
    private VisitService visitService;

    /**
     * 分页查询
     *
     * @param visit       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Visit>> queryByPage(Visit visit, PageRequest pageRequest) {
        return ResponseEntity.ok(this.visitService.queryByPage(visit, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Visit> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.visitService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param visit 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Visit> add(Visit visit) {
        return ResponseEntity.ok(this.visitService.insert(visit));
    }

    /**
     * 编辑数据
     *
     * @param visit 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Visit> edit(Visit visit) {
        return ResponseEntity.ok(this.visitService.update(visit));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.visitService.deleteById(id));
    }

}

