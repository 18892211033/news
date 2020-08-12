import com.wst.dao.CommentDao;
import com.wst.dao.UserDao;
import com.wst.db.DBSqlSession;
import com.wst.entity.Comment;
import com.wst.entity.Users;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

public class Test {
    @org.junit.Test
    public void test(){
        SqlSession sqlSession = DBSqlSession.getInstance(null).getSqlSession();
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        Users u = new Users();
        u = null;
//        System.out.println(userDao.getByTypeid(2));  //测试数据库是否正常连接


        /**
         * 登录   成功显示用户信息   ，失败显示null
         */
//        System.out.println(userDao.checkUser(1,"123"));//登录成功
//        System.out.println(userDao.checkUser(1,"1234"));//登录失败  结果为null

        /**
         * 根据id查询用户信息
         */
//        System.out.println(userDao.getUser(1)); //Users{id=1, name='张三', password='888', regDatetime=Wed Jul 01 23:03:27 CST 2020, status=0, photoUrl='null', list=null}返回的只有用户的基本信息

        /**
         * 用户修改个人信息 -- 可能修改status，也可能修改password，也可能修改photoUrl
         */
//        u.setId(1);
//        u.setPassword("888");
//        System.out.println(userDao.updateUser(u));       //测试成功  id=1的张三的密码改为888

        /**
         * 查询多个用户 -- 可能会提供用户名进行查询，也可能按照状态进行查询
         */
//        System.out.println(userDao.getUsers(null,1));
//        System.out.println(userDao.getUsers(null,null));     //全不填 就查全部（状态>=0的   状态只有0 or 1 >=0就能查全部）

        /**
         *新增用户
         */
//        u = new Users("测试添加","mima123",null,0,null);
//        System.out.println(userDao.addUser(u));    //测试成功

        /**
         * 查询该用户详细信息：包括个人信息以及该用户所发表的新闻评论相关信息
         */
//        System.out.println(userDao.getUserAll(1));
        sqlSession.commit();
    }
    @org.junit.Test
    public void test2(){
        SqlSession sqlSession = DBSqlSession.getInstance(null).getSqlSession();
        CommentDao commentDao = sqlSession.getMapper(CommentDao.class);

//        System.out.println(commentDao.addComment(new Comment(2,2,"我也评论了",null)));  //添加一条评论
//        System.out.println("123");

//        System.out.println(commentDao.getAllComment(3));    //根据新闻id查询所有相关评论

//        System.out.println(commentDao.getAllUComment(3));   //根据用户id查询所有评论
//        System.out.println(commentDao.delComment(7));    //删除一条评论     sql : delete from tb_comment where id=?

//        List<Integer> ids = new ArrayList<>();
//        ids.add(6);
//        ids.add(8);
//        System.out.println(commentDao.delComments(ids));  //根据评论id删除多条评论   sql:delete from tb_comment where id in ( ? , ? )
        sqlSession.commit();
    }
}
