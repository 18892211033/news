import com.wst.bean.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    @org.junit.Test
    public void Test1(){
        ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) app.getBean("user1");
        System.out.println(user);
        app.close();
    }
}
