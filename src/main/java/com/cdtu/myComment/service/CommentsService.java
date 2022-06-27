package com.cdtu.myComment.service;

import com.cdtu.myComment.entity.Comments;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Comments)表服务接口
 *
 * @author makejava
 * @since 2022-06-27 20:52:53
 */
public interface CommentsService {

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    Comments queryById(Integer userid);

    /**
     * 分页查询
     *
     * @param comments    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Comments> queryByPage(Comments comments, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param comments 实例对象
     * @return 实例对象
     */
    Comments insert(Comments comments);

    /**
     * 修改数据
     *
     * @param comments 实例对象
     * @return 实例对象
     */
    Comments update(Comments comments);

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    boolean deleteById(Integer userid);

}
