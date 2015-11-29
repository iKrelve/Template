package krelve.ssm.db.dao;


import krelve.ssm.po.User;

/**
 * Created by krelve on 2015/11/28.
 */
public interface UserDao {
    //根据id查询用户信息
    public User findUserById(int id) throws Exception;

    //添加用户信息
    public void insertUser(User user) throws Exception;

    //删除用户信息
    public void deleteUser(int id) throws Exception;
}
