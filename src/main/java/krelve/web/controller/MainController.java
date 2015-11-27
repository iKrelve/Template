package krelve.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by krelve on 2015/11/27.
 */
@Controller
public class MainController {
    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
