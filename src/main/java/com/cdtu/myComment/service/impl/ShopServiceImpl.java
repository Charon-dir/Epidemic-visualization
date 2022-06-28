package com.cdtu.myComment.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.cdtu.myComment.entity.Shop;
import com.cdtu.myComment.dao.ShopDao;
import com.cdtu.myComment.service.ShopService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

/**
 * (Shop)表服务实现类
 *
 * @author makejava
 * @since 2022-06-27 21:38:46
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Resource
    private ShopDao shopDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Shop queryById(Integer id) {
        return this.shopDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param shop        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<Shop> queryByPage(Shop shop, PageRequest pageRequest) {
        long total = this.shopDao.count(shop);
        return new PageImpl<>(this.shopDao.queryAllByLimit(shop, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    @Override
    public Shop insert(Shop shop) {
        this.shopDao.insert(shop);
        return shop;
    }

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    @Override
    public Shop update(Shop shop) {
        this.shopDao.update(shop);
        return this.queryById(shop.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.shopDao.deleteById(id) > 0;
    }

    @Override
    public JSONObject getAll() {
        List<Shop> all = this.shopDao.getAll();
        HashSet<String> set = new HashSet<>();
        for (Shop s:
             all) {
            set.add(s.getTypedId());
        }

        JSONObject json = new JSONObject();
        for (String s:
             set) {
            JSONArray array = new JSONArray();
            for (Shop shop:
                    all) {
                if(shop.getTypedId().equals(s)){
                    JSONObject jsonObject = JSONUtil.parseObj(JSONUtil.toJsonStr(shop));
                    array.add(jsonObject);
                }
            }
            json.set(s,array);
        }
        return json;
    }

    @Override
    public List<Shop> getAllList() {
        List<Shop> all = this.shopDao.getAll();
        return all;
    }
}
