package com.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String principal(Model model) {
		String nome = "Livraria Boa Noite";
		model.addAttribute("nome", nome);
		return "principal";
	}
	
	@GetMapping("/sobre")
	public String sobre(Model model) {
		String nome = "Livraria Boa Noite";
		model.addAttribute("nome", nome);
		return "sobre";
	}

	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

}
