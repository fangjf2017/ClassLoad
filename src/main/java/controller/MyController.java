package controller;

import jvm.IMiddlewareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by fan on 2018/12/28.
 */
@Controller
@RequestMapping("/demo")
public class MyController {

    @Autowired
    private IMiddlewareService middlewareService;

    @RequestMapping("/reverse")
    @ResponseBody
    public String echo(@RequestParam("s") String str) {
        return middlewareService.reverse(str);
    }
}