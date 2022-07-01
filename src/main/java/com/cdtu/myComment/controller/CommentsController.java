package com.cdtu.myComment.controller;

import com.cdtu.myComment.entity.Comments;
import com.cdtu.myComment.service.CommentsService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * (Comments)表控制层
 *
 * @author makejava
 * @since 2022-06-29 14:03:16
 */
@RestController
@RequestMapping("comments")
public class CommentsController {
    /**
     * 服务对象
     */

    @Resource
    private CommentsService commentsService;
    /**
     * 分页查询
     *
     * @param comments    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Comments>> queryByPage(Comments comments, PageRequest pageRequest) {
        return ResponseEntity.ok(this.commentsService.queryByPage(comments, pageRequest));
    }
    @PostMapping("/getByShopId")
    public List<Comments> getByShopId(@RequestParam(name = "shopId") Integer shopId){
        return commentsService.getByShopId(shopId);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Comments> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.commentsService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param comments 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Comments> add(Comments comments) {
        return ResponseEntity.ok(this.commentsService.insert(comments));
    }

    /**
     * 编辑数据
     *
     * @param comments 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Comments> edit(Comments comments) {
        return ResponseEntity.ok(this.commentsService.update(comments));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.commentsService.deleteById(id));
    }

    @PostMapping("/publish")
    public HashMap<String,Object> publish(
            @RequestParam(name = "file") MultipartFile[] files,
            @RequestParam(name = "content") String content,
            @RequestParam(name = "score") String score,
            @RequestParam(name = "shopId") String shopId
    ){
        HashMap<String, Object> publish = commentsService.publish(files, content, score, shopId);

        return publish;
    }

    @PostMapping("/show")
    public List<Comments> show(
            @RequestParam("shopId") String shopId
    ){
        return commentsService.show(shopId);
    }

}

