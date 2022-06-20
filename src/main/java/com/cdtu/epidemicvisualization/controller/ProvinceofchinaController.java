package com.cdtu.epidemicvisualization.controller;

import com.cdtu.epidemicvisualization.entity.Provinceofchina;
import com.cdtu.epidemicvisualization.service.ProvinceofchinaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Provinceofchina)表控制层
 *
 * @author makejava
 * @since 2022-06-20 20:22:58
 */
@RestController
@RequestMapping("provinceofchina")
public class ProvinceofchinaController {
    /**
     * 服务对象
     */
    @Resource
    private ProvinceofchinaService provinceofchinaService;

    /**
     * 分页查询
     *
     * @param provinceofchina 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Provinceofchina>> queryByPage(Provinceofchina provinceofchina, PageRequest pageRequest) {
        return ResponseEntity.ok(this.provinceofchinaService.queryByPage(provinceofchina, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Provinceofchina> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.provinceofchinaService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param provinceofchina 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Provinceofchina> add(Provinceofchina provinceofchina) {
        return ResponseEntity.ok(this.provinceofchinaService.insert(provinceofchina));
    }

    /**
     * 编辑数据
     *
     * @param provinceofchina 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Provinceofchina> edit(Provinceofchina provinceofchina) {
        return ResponseEntity.ok(this.provinceofchinaService.update(provinceofchina));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.provinceofchinaService.deleteById(id));
    }

}

