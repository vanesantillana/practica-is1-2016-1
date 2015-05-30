package controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/")
	String home(ModelMap model, @RequestParam String name ) {
		 model.addAttribute("name", name);
		return "hello";
	}

}
