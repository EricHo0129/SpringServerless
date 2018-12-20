package eric.spring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sso")
public class ForwardController {

	@GetMapping("/login")
	public String login () throws Exception {
		return "rerect:https://tw.yahoo.com/";
	}
	
	@GetMapping("/logout")
	public String logout () throws Exception {
		return "rerect:https://24h.pchome.com.tw/";
	}
}
