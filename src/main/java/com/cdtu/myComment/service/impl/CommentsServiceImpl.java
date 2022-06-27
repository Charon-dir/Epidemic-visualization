package com.cdtu.myComment.service.impl;

import com.cdtu.myComment.entity.Comments;
import com.cdtu.myComment.dao.CommentsDao;
import com.cdtu.myComment.service.CommentsService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Comments)表服务实现类
 *
 * @author makejava
 * @since 2022-06-27 20:52:53
 */
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
    @Resource
    private CommentsDao commentsDao;

    /**
     * 通过ID查询单条数据
     *
     * @param userid 主键
     * @return 实例对象
     */
    @Override
    public Comments queryById(Integer userid) {
        return this.commentsDao.queryById(userid);
    }

    /**
     * 分页查询
     *
     * @param comments    筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Comments> queryByPage(Comments comments, PageRequest pageRequest) {
        long total = this.commentsDao.count(comments);
        return new PageImpl<>(this.commentsDao.queryAllByLimit(comments, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param comments 实例对象
     * @return 实例对象
     */
    @Override
    public Comments insert(Comments comments) {
        this.commentsDao.insert(comments);
        return comments;
    }

    /**
     * 修改数据
     *
     * @param comments 实例对象
     * @return 实例对象
     */
    @Override
    public Comments update(Comments comments) {
        this.commentsDao.update(comments);
        return this.queryById(comments.getUserid());
    }

    /**
     * 通过主键删除数据
     *
     * @param userid 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer userid) {
        return this.commentsDao.deleteById(userid) > 0;
    }
}
