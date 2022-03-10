package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 요청이 오면 Container 에 있는 Controller 부터 찾아보고 Mapping
    // 없으면 Static file에서 찾음
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
