package security.demo.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import security.demo.service.DashboardService;

@Controller
@RequiredArgsConstructor
public class SampleController {

	private final DashboardService dashboardService;

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
		dashboardService.securityTest();
		return "dashboard";
	}

	@GetMapping("/admin")
	public String admin(Model model,Principal principal){
		model.addAttribute("message","hello " + principal.getName());
		return "admin";
	}
}
