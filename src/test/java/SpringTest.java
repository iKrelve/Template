import krelve.ssm.TestObject;
import krelve.ssm.aop.Calculator;
import krelve.ssm.controller.UserController;
import krelve.ssm.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by krelve on 2015/11/30.
 */
public class SpringTest {

    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        TestObject testObject = (TestObject) applicationContext.getBean("testObject");
        System.out.println(testObject);
        UserController userController = (UserController) applicationContext.getBean("userController");
        System.out.println(userController);
        UserService userService = (UserService) applicationContext.getBean("userService");
        System.out.println(userService);
        userService.add();
/*        UserRepository userRepository = (UserRepository) applicationContext.getBean("userRepository");
        System.out.println(userRepository);*/
    }

    @Test
    public void testAOP() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
        Calculator calculator = (Calculator) applicationContext.getBean("calculator");
        calculator.add(1, 5);
        calculator.div(10, 5);
//        calculator.div(10, 0);
    }

}
