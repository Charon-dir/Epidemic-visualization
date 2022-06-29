package com.cdtu.myComment.controller;

import com.cdtu.myComment.entity.Shop;
import com.cdtu.myComment.service.ShopService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Shop)表控制层
 *
 * @author makejava
 * @since 2022-06-28 22:15:09
 */
@RestController
@RequestMapping("shop")
public class ShopController {
    /**
     * 服务对象
     */
    @Resource
    private ShopService shopService;

    /**
     * 分页查询
     *
     * @param shop        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Shop>> queryByPage(Shop shop, PageRequest pageRequest) {
        return ResponseEntity.ok(this.shopService.queryByPage(shop, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Shop> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.shopService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param shop 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Shop> add(Shop shop) {
        return ResponseEntity.ok(this.shopService.insert(shop));
    }

    /**
     * 编辑数据
     *
     * @param shop 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Shop> edit(Shop shop) {
        return ResponseEntity.ok(this.shopService.update(shop));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.shopService.deleteById(id));
    }

}

