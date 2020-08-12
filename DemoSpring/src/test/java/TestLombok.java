import com.wst.bean.*;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestLombok {
    @Test
    public void test(){
        Person person = new Person();
        person.setId("10086");
        person.setName("移动");
        System.out.println(person.toString());
    }
    @Test
    public void test2(){
        //创建Ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //根据id获取bean
//        Person p1 = (Person) applicationContext.getBean("person");
//        System.out.println(p1);
//        Person p2 = (Person) applicationContext.getBean("person2");
//        System.out.println(p2);
//        Person p3 = (Person) applicationContext.getBean("person3");
//        System.out.println(p3);
//        Person p4 = (Person) applicationContext.getBean("person4");
//        System.out.println(p4);
//        PersonCars p5 = (PersonCars) applicationContext.getBean("person5");
//        System.out.println(p5);
//        Car c1 = (Car) applicationContext.getBean("car");
//        System.out.println(c1);
//        PersonMap pm1 = (PersonMap) applicationContext.getBean("personMap1");
//        PersonMap pm11 = (PersonMap) applicationContext.getBean("personMap1");
//        System.out.println(pm1 == pm11);//单例模式

/*        ScopeC sc = (ScopeC) applicationContext.getBean("scope1");
        ScopeC sc2 = (ScopeC) applicationContext.getBean("scope1");
        System.out.println(sc);
        System.out.println(sc == sc2);

        ScopeC sc3 = (ScopeC) applicationContext.getBean("scope2");
        ScopeC sc4 = (ScopeC) applicationContext.getBean("scope2");
        System.out.println(sc3);
        System.out.println(sc4);
        System.out.println(sc3 == sc4);*/

        LifeC lifeC = (LifeC) applicationContext.getBean("life");
        System.out.println(lifeC);
        //容器关闭
        System.out.println("容器关闭1");
        ((ClassPathXmlApplicationContext)applicationContext).close();
        System.out.println("容器关闭2");
    }
    @Test
    public void test3(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext222222222222.xml");
        Person p = (Person) applicationContext.getBean("person");
        System.out.println(p);
        Person p2 = (Person) applicationContext.getBean("person2");
        System.out.println(p2);
        applicationContext.close();
    }
}
