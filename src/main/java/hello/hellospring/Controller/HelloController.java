package hello.hellospring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello")// 경로 /hello
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello"; // resources/template에서 hello.html 찾아 model 넘겨줌
    }

    @GetMapping("hello-mvc")// 경로 /hello-mvc
    //parameter /hello-mvc?name= XXX 로 넘어올때 동작
    public String helloMvc(@RequestParam( "name") String name,Model model){
        model.addAttribute("name",name);
        return "hello-template";// resources/template에서 hello-template.html 찾아 model 넘겨줌
    }

    @GetMapping("hello-string")
    @ResponseBody// http protocol에 body 에 내용 넣고싶을때 사용. // data 만 전달
    public String helloString (@RequestParam( "name") String name){
        return "hello" + name;// hello + X 로 Data 변환 .
    }

    @GetMapping("hello-api")
    @ResponseBody // data 만 전달 // 기본은 json으로 반환.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;// 객체로 전달 (json 형식)
    }

    static class Hello{
        private String name;

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
