package com.cdtu.myComment.service;

import com.cdtu.myComment.entity.Shop;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Shop)表服务接口
 *
 * @author makejava
 * @since 2022-06-28 22:15:10
 */
public interface ShopService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Shop queryById(Integer id);

    /**
     * 分页查询
     *
     * @param shop        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    Page<Shop> queryByPage(Shop shop, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @return 实例对象
     */
    Shop insert(MultipartFile file, String name, String typeId, String address, String introduction) throws IOException;

    /**
     * 修改数据
     *
     * @param shop 实例对象
     * @return 实例对象
     */
    Shop update(Shop shop);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

    List<Shop> getAll();

    List<HashMap<String,Object>> getShopById(Integer id);

    List<Shop> search(String name);

    List<Shop>  classifySelect(String typeid);


}
