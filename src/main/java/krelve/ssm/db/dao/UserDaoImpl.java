package krelve.ssm.db.dao;

import krelve.ssm.po.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

/**
 * Created by krelve on 2015/11/28.
 */
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

    public User findUserById(int id) throws Exception {
        SqlSession sqlSession = getSqlSession();
        return sqlSession.selectOne("krelve.ssm.db.mapper.UserMapper.findUserById", id);
    }

    public void insertUser(User user) throws Exception {

    }

    public void deleteUser(int id) throws Exception {

    }
}
