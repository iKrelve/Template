package krelve.ssm.service;

import krelve.ssm.po.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by krelve on 2015/11/30.
 */
@Service
public class UserService {
    @Autowired(required = false)
    private UserRepository userRepository;

    public void add() {
        System.out.println("UserService add");
        userRepository.save();
    }
}
