package furama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

    @GetMapping("/test-aspect")
    public String testAspectMethod() {
        return "abc";
    }

    @GetMapping("/test-throwing")
    public String goEx(String abc) throws Exception {
        throw new Exception("abc");
    }

}
