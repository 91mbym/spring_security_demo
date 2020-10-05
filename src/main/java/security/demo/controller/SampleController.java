package security.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SampleController {

	@GetMapping("/")
	public String index(Model model,Principal principal){

		if(principal == null){
			model.addAttribute("message","hello");
		}else{
			model.addAttribute("message","hello " + principal.getName());
		}

		return "index";
	}

	@GetMapping("/dashboard")
	public String dashboard(Model model, Principal principal){
		model.addAttribute("message","hello " + principal.getName());
		return "dashboard";
	}

	@GetMapping("/admin")
	public String admin(Model model,Principal principal){
		model.addAttribute("message","hello " + principal.getName());
		return "admin";
	}
}
