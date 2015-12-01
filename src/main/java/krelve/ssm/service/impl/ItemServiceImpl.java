package krelve.ssm.service.impl;

import krelve.ssm.mapper.UserMapper;
import krelve.ssm.po.User;
import krelve.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by krelve on 2015/11/30.
 */
public class ItemServiceImpl implements ItemService {
    @Autowired
    private UserMapper userMapper;

    public int insert(User record) {
        return userMapper.insert(record);
    }
}
