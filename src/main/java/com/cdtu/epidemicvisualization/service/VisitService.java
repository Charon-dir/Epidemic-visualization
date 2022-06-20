package com.cdtu.epidemicvisualization.service;

import com.cdtu.epidemicvisualization.entity.Visit;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Visit)表服务接口
 *
 * @author makejava
 * @since 2022-06-20 20:22:58
 */
public interface VisitService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Visit queryById(Integer id);

    /**
     * 分页查询
     *
     * @param visit       筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Visit> queryByPage(Visit visit, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    Visit insert(Visit visit);

    /**
     * 修改数据
     *
     * @param visit 实例对象
     * @return 实例对象
     */
    Visit update(Visit visit);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
