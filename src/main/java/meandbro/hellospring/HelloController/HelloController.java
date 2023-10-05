package meandbro.hellospring.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String Hello(Model model){
        // Model 객체에 Attribute 추가
        model.addAttribute("data", "spring!!!!");
        // Controller 에서 return 되는 문자열은 viewResolver 를 통해 "resources:templates/{ViewName}.html"의 형식으로 매핑 됨
        // (ViewName = return 되는 문자열)
        return "hello";
    }
}
