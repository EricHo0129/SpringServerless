package eric.spring;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RestController
@EnableWebMvc
public class UserController {

	@GetMapping("/user/{pid}")
	public Map<String, Object> getUser(@PathVariable("pid") Long pid) throws Exception {
		Map<String, Object> result = new HashMap();
		result.put("pid", pid);
		result.put("name", "編號"+pid+"會員");
		return result;
	}
	
	@GetMapping("/user")
	public Map<String, Object> getUser() throws Exception {
		return getUser(123456L);
	}
}
