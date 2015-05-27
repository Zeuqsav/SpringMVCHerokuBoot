package demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Level up lunch!";
    }
    
    @RequestMapping("/jsontest") 
    public @ResponseBody Map<String, String> callSomething () {
    	
    	Map<String, String> map = new HashMap<String, String>();
    	map.put("url", "http://www.leveluplunch.com");
    	
    	return map;
    }
    
	//  @RequestMapping("/jsptest")
	//    public String test(ModelAndView modelAndView) {
	    	
	//    return "jsp-spring-boot";
	//  }
}