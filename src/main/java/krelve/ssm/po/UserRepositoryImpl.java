package krelve.ssm.po;

import org.springframework.stereotype.Repository;

/**
 * Created by krelve on 2015/11/30.
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository {
    public void save() {
        System.out.println("UserRepository save");
    }
}
