package com.cdtu.myComment.service.impl;

import com.cdtu.myComment.dao.UserDao;
import com.cdtu.myComment.entity.Comments;
import com.cdtu.myComment.dao.CommentsDao;
import com.cdtu.myComment.entity.User;
import com.cdtu.myComment.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * (Comments)表服务实现类
 *
 * @author makejava
 * @since 2022-06-29 14:03:17
 */
@Service("commentsService")
public class CommentsServiceImpl implements CommentsService {
    @Resource
    private CommentsDao commentsDao;
    @Resource
    private HttpServletRequest request;
//    @Resource
//    private Comments comments;
    @Resource
    private UserDao userDao;
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

    @Override
    public List<Comments> getByShopId(Integer shopId) {
        return commentsDao.getByShopId(shopId);
    }

//    @Override
//    public HashMap<String, Object> upload(MultipartFile[] files, Integer shopId){
//        HttpSession session = request.getSession();
//        String username = "";
//        HashMap<String, Object> map = new HashMap<>();
//        if (session.getAttribute("username") != null){
//            username = (String) session.getAttribute("username");
//        }else{
//            map.put("error","用户未登录");
//            return map;
//        }
//        String realPath = "src\\main\\resources\\static\\img\\user\\"+username+"\\"+shopId;
//        File folder = new File(realPath);
//        if (!folder.exists() && !folder.isDirectory()) {
//            folder.mkdirs();
//        }
//        if (files != null && files.length > 0){
//            for (int i =0;i <files.length;i++){
//                MultipartFile file = files[i];
//                if (!file.isEmpty()){
//                    int a = i;
//                    File newFile = new File(realPath+"/reply"+a+".jpg").getAbsoluteFile();
//                    while (newFile.exists()){
//                        a++;
//                        newFile = new File(realPath+"/reply"+a+".jpg").getAbsoluteFile();
//                    }
//                    try {
//                        file.transferTo(newFile);
//                    } catch (IOException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//            }
//        }
//
//        map.put("code","200");
//        return map;
//    }

    @Override
    public HashMap<String, Object> publish(MultipartFile[] files, String content, String score, String shopId,HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = "";
        HashMap<String, Object> map = new HashMap<>();
        if (session.getAttribute("username") != null){
            User user = (User) session.getAttribute("user");
            username = user.getId().toString();
        }else{
            map.put("code","201");
            return map;
        }
        String realPath = "src\\main\\resources\\static\\img\\user\\"+username+"\\"+shopId;
        File folder = new File(realPath);
        if (!folder.exists() && !folder.isDirectory()) {
            folder.mkdirs();
        }
        ArrayList<String> img = new ArrayList<>();

        if (files != null && files.length > 0){

            for (int i =0;i <files.length;i++){
                MultipartFile file = files[i];
                if (!file.isEmpty()){
                    int a = i;
                    File newFile = new File(realPath+"/reply"+a+".jpg").getAbsoluteFile();
                    while (newFile.exists()){
                        a++;
                        newFile = new File(realPath+"/reply"+a+".jpg").getAbsoluteFile();
                    }
                    try {
                        String s = fileUpload(file, request, "/reply" + a + ".jpg", username, shopId,newFile);
                        img.add(s);
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
        Comments comments = new Comments();
        comments.setUserid(userDao.getByUsername(username));
        comments.setShopid(Integer.valueOf(shopId));
        comments.setImg(String.valueOf(img));
        comments.setScore(score);
        comments.setUsercomment(content);
        System.out.println(comments);
        int insert = commentsDao.insert(comments);
        if (insert>=1){
            map.put("code",200);
        }

        return map;
    }

    @Override
    public List<Comments> show(String shopId) {
        return commentsDao.getByShopId(Integer.valueOf(shopId));
    }

    public String fileUpload(MultipartFile file, HttpServletRequest request,String filename,String username,String shopId,File newFile) throws IOException {
        String myurl = "img/user/"+username+"/"+shopId+"/";
        String realPath = request.getServletContext().getRealPath("/")+myurl;
        File folder = new File(realPath);
        if(!folder.exists()){
            folder.mkdirs();
        }
        File file1 = new File(folder, filename);
        file.transferTo(file1);
        BufferedImage read = ImageIO.read(file1);
        ImageIO.write(read,"jpg",newFile);
//        String url = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+myurl+filename;
        return myurl+filename;
    }
}
