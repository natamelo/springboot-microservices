package project.selection.services.uaa.web;

import java.security.Principal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UAAController {
	
	@GetMapping({ "/me" })
	public Map<String, String> user(Principal principal) {
		Map<String, String> map = new LinkedHashMap<>();
		System.out.println(">> principal: " + principal);
		if (principal != null) {
			map.put("name", principal.getName());
		}
		return map;
	}
	
	@PostMapping({"/entra"})
	public String entra() {
		return "Entrou";
	}
	
}
