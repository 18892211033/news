import com.wst.bean.Person;
import com.wst.bean0729.User;
import com.wst.controller.SysController;
import com.wst.controller.UserController;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

public class Test0729 {
/*    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext0729.xml");
        UserController u = (UserController) applicationContext.getBean("userController");
        User u2 = (User) applicationContext.getBean("user");
        u.get(1);
        u.add(u2);
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }*/
//    protected //保证本包使用
/*@Test
    public void testpm(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext0729pm.xml");
        SysController s = (SysController) applicationContext.getBean("sysCon");
//        s.get("wst","123");
//        System.out.println("-------------------------------------");
//        s.get(null,null);
//        System.out.println("-------------------------------------");
        s.get("wst");
          System.out.println("----------------------");
        s.getU(12);
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }*/
    @Test
    public void test0730(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext0730.xml");
        SysController s = (SysController) applicationContext.getBean("sysController");
        s.get("王思桐0730" , "123");
//        s.get("张三");
        ((ClassPathXmlApplicationContext)applicationContext).close();
    }
}
