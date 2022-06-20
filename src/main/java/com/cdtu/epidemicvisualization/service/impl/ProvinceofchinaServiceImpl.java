package com.cdtu.epidemicvisualization.service.impl;

import com.cdtu.epidemicvisualization.entity.Provinceofchina;
import com.cdtu.epidemicvisualization.dao.ProvinceofchinaDao;
import com.cdtu.epidemicvisualization.service.ProvinceofchinaService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Provinceofchina)表服务实现类
 *
 * @author makejava
 * @since 2022-06-20 20:22:58
 */
@Service("provinceofchinaService")
public class ProvinceofchinaServiceImpl implements ProvinceofchinaService {
    @Resource
    private ProvinceofchinaDao provinceofchinaDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Provinceofchina queryById(Integer id) {
        return this.provinceofchinaDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param provinceofchina 筛选条件
     * @param pageRequest     分页对象
     * @return 查询结果
     */
    @Override
    public Page<Provinceofchina> queryByPage(Provinceofchina provinceofchina, PageRequest pageRequest) {
        long total = this.provinceofchinaDao.count(provinceofchina);
        return new PageImpl<>(this.provinceofchinaDao.queryAllByLimit(provinceofchina, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param provinceofchina 实例对象
     * @return 实例对象
     */
    @Override
    public Provinceofchina insert(Provinceofchina provinceofchina) {
        this.provinceofchinaDao.insert(provinceofchina);
        return provinceofchina;
    }

    /**
     * 修改数据
     *
     * @param provinceofchina 实例对象
     * @return 实例对象
     */
    @Override
    public Provinceofchina update(Provinceofchina provinceofchina) {
        this.provinceofchinaDao.update(provinceofchina);
        return this.queryById(provinceofchina.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.provinceofchinaDao.deleteById(id) > 0;
    }
}
