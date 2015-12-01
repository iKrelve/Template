import krelve.ssm.db.dao.UserDao;
import krelve.ssm.mapper.UserMapper;
import krelve.ssm.po.User;
import krelve.ssm.po.UserExample;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * Created by krelve on 2015/11/28.
 */
public class UserMapperTest {
    private ApplicationContext applicationContext;

    @Before
    public void setUp() throws Exception {
        applicationContext = new ClassPathXmlApplicationContext("spring/spring-mybatis.xml");
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDao dao = (UserDao) applicationContext.getBean("UserDao");
        User user = dao.findUserById(1);
        System.out.println(user);
    }

    @Test
    public void testFindUserByIdMapper() throws Exception {
        UserMapper userDao = (UserMapper) applicationContext.getBean("userMapper");
//        User user = userDao.findUserById(1);
//        System.out.println(user);
    }

    @Test
    public void insert() throws Exception {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        User user = new User();
        user.setUsername("mybatis");
        user.setBirthday(new Date());
        user.setAddress("somewhere");
        userMapper.insert(user);
    }

    @Test
    public void testSelectByExample() {
        UserMapper userMapper = (UserMapper) applicationContext.getBean("userMapper");
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUsernameLike("daily%");
        List<User> users = userMapper.selectByExample(userExample);
        for (User user : users) {
            System.out.println(user);
        }
    }

}
