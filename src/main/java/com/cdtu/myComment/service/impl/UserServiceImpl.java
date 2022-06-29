package com.cdtu.myComment.service.impl;

import com.cdtu.myComment.entity.User;
import com.cdtu.myComment.dao.UserDao;
import com.cdtu.myComment.service.UserService;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2022-06-27 20:52:54
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private UserDao userDao;
    @Resource
    private HttpSession session;
//    @Resource
//    private User user;
    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public User queryById(Integer id) {
        return this.userDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @Override
    public Page<User> queryByPage(User user, PageRequest pageRequest) {
        long total = this.userDao.count(user);
        return new PageImpl<>(this.userDao.queryAllByLimit(user, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User insert(User user) {
        this.userDao.insert(user);
        return user;
    }

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    @Override
    public User update(User user) {
        this.userDao.update(user);
        return this.queryById(user.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.userDao.deleteById(id) > 0;
    }

    @Override
    public boolean login() {

//        session.setAttribute("user",user);
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        Boolean loginSussess = this.userDao.login(username,password);
        if (loginSussess){
            
        }
        return loginSussess;
    }

    @Override
    public Boolean sign(User user) {
        return userDao.sign(user);
    }

    @Override
    public Boolean queryByUsername(String username) {
        return userDao.isSign(username);
    }
}
