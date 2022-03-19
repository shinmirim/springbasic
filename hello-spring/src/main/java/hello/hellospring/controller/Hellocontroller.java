package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hellocontroller {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data", "hello!!"); //data를 hello 로 넘길 것이다. //모델의 키값
        return "hello"; //hello.html에 가서 렌더링 해라 제일 먼저 resource/templates의 밑에 있는 걸 먼저 찾는다.

    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name); //컨트롤러를 통해 파라미터 받은것이 이동//입력된 것은 모델이 담긴 뒤 템플릿으로 넘어감//name에 입력된 값이 치환되어 나타남

        return "hello-template";

    }//파라이터를 통해 외부에서 데이를 받음

    @GetMapping("hello-string")
    @ResponseBody //http 바디에 직접 넣어주겠다는 뜻 //뷰가 없이 데이터 그대로 문자가 간다.html태그가 따로 없다.(템플릿엔진과 다른점)
    public String helloString(@RequestParam("name") String name){
        return  "hello" +name;
    }

    @GetMapping("hello-api")
    @ResponseBody //json방식으로 넘겨줌

    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello(); //커맨드 시프트 엔터 자동완성
        hello.setName(name); //받아온 name을 이곳에서 처리
        return hello; // 객체를 넘겨줌
    }//위의 헬로 컨트롤러와 같음

    static class Hello{
        private String name;//getter,setter -프라이빗으로 선언된 변수를 보안때문에 다른 곳에서 호출이 안되기 때문에 getter, setter라는 메서드를 각각 선언 해준다.
        //getter의 기능은 그 변수에 있는 값을 가져오고, setter해당하는 변수의 값을 설정할 수 있다.


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

