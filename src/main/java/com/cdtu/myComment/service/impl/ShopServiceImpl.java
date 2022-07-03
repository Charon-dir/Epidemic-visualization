package com.cdtu.myComment.service.impl;

import com.cdtu.myComment.dao.UserDao;
import com.cdtu.myComment.entity.Shop;
import com.cdtu.myComment.dao.ShopDao;
import com.cdtu.myComment.entity.User;
import com.cdtu.myComment.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Shop)表服务实现类
 *
 * @author makejava
 * @since 2022-06-28 22:15:10
 */
@Service("shopService")
public class ShopServiceImpl implements ShopService {
    @Resource
    private UserDao userDao;
    @Resource
    private ShopDao shopDao;
    @Resource
    private HttpSession session;
    @Resource
    private HttpServletRequest request;


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

    @Override
    public Shop insert(MultipartFile file, String name, String typeId, String address, String introduction) throws IOException {
        User user = (User) session.getAttribute("user");
        String myurl = "img/shop/user"+user.getId();
        String realPath = request.getServletContext().getRealPath("/") + myurl+"/";
        File folder = new File(realPath);
        if (!folder.exists()){
            folder.mkdirs();
        }
        File file1 = new File(folder,"/show.jpg");
        file.transferTo(file1);
        BufferedImage read = ImageIO.read(file1);
        String s = "src\\main\\resources\\static\\" + myurl;
        File output = new File(s);
        if (!output.exists()){
            output.mkdirs();
        }
        System.out.println(read);
        ImageIO.write(read,"jpg",new File(output.getAbsoluteFile()+"\\show.jpg"));
        Shop shop = new Shop();
        shop.setImg(myurl+"/show.jpg");
        shop.setAddress(address);
        shop.setName(name);
        shop.setIntroduction(introduction);
        shop.setTypedId(typeId);
        shopDao.insert(shop);
        user.setUsertype("2");
        userDao.update(user);
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
    public List<Shop> getAll() {
        return shopDao.getAll();
    }

    @Override
    public List<HashMap<String, Object>> getShopById(Integer id) {
        return shopDao.getShopById(id);
    }

    @Override
    public List<Shop> search(String name) {
        return shopDao.search("%"+name+"%");
    }

    @Override
    public List<Shop> classifySelect(String typeid) {
        return shopDao.classifySelect(typeid);
    }


}
