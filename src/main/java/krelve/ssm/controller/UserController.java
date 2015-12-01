package krelve.ssm.controller;

import krelve.ssm.po.User;
import krelve.ssm.service.ItemService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by krelve on 2015/11/30.
 */
@Controller
public class UserController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/getUser")
    public void getUser() {
        itemService.insert(new User());
        System.out.println("UserController execute");
    }
}
