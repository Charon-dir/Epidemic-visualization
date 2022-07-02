package com.cdtu.myComment.controller;

import com.cdtu.myComment.entity.User;
import com.cdtu.myComment.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2022-06-27 20:52:53
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    @PostMapping("/login")
    public Map login(HttpServletRequest request,HttpSession session){

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean login = userService.login(username,password);
        HashMap<String, Object> userMap = new HashMap<>();
//        System.out.println(username);
        if (login){
            userMap.put("message","登录成功");
            userMap.put("code","200");
            userMap.put("url","index");
            Cookie cookie = new Cookie(username.trim(), password.trim());
            cookie.setMaxAge(60*60*24);
            cookie.setPath("/");
            userMap.put("cookie",cookie);
            session.setAttribute("username",username);
            System.out.println("user:"+session.getAttribute("user"));
            return userMap;
        }else{
            userMap.put("message","登录失败");
            userMap.put("code","400");
            return userMap;
        }
    }

    @PostMapping("/sign")
    public Map  sign(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setUsertype("1");
        Boolean isSign =  userService.queryByUsername(username);
        HashMap<String, Object> signMap = new HashMap<>();

//        判断用户名是否被注册
        if (isSign){
            signMap.put("code","400");
            signMap.put("message","用户名已被注册");
            return signMap;
        }

//        进行注册
        Boolean signResult = userService.sign(user);
        if (signResult){
            signMap.put("code","200");
            signMap.put("message","注册成功！");
           return  signMap;
        }else{
            signMap.put("code","400");
            signMap.put("message","注册失败");
            return  signMap;
        }

    }
    /**
     * 分页查询
     *
     * @param user        筛选条件
     * @param pageRequest 分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<User>> queryByPage(User user, PageRequest pageRequest) {
        return ResponseEntity.ok(this.userService.queryByPage(user, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<User> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<User> add(User user) {
        return ResponseEntity.ok(this.userService.insert(user));
    }

    /**
     * 编辑数据
     *
     * @param user 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<User> edit(User user) {
        return ResponseEntity.ok(this.userService.update(user));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.userService.deleteById(id));
    }

    @GetMapping("/logout")
    public HashMap<String,Object> logout(HttpServletRequest request){
        HashMap<String,Object> map = new HashMap<>();
        map.put("code",200);
        request.getSession().invalidate();
        return map;
    }
}

