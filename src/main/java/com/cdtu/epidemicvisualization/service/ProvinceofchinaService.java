package com.cdtu.epidemicvisualization.service;

import com.cdtu.epidemicvisualization.entity.Provinceofchina;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Provinceofchina)表服务接口
 *
 * @author makejava
 * @since 2022-06-20 20:22:58
 */
public interface ProvinceofchinaService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Provinceofchina queryById(Integer id);

    /**
     * 分页查询
     *
     * @param provinceofchina 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    Page<Provinceofchina> queryByPage(Provinceofchina provinceofchina, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param provinceofchina 实例对象
     * @return 实例对象
     */
    Provinceofchina insert(Provinceofchina provinceofchina);

    /**
     * 修改数据
     *
     * @param provinceofchina 实例对象
     * @return 实例对象
     */
    Provinceofchina update(Provinceofchina provinceofchina);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}
