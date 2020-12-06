package com.aula;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.aula.model.Autor;
import com.aula.model.AutorService;
import com.aula.model.Editora;
import com.aula.model.EditoraService;
import com.aula.model.Livro;
import com.aula.model.LivroService;

@Controller
public class LivrariaUpdController {
	@Autowired 
	private ApplicationContext context;
	
	/*Editar Livros*/
	@GetMapping("/upd/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		LivroService ldao = context.getBean(LivroService.class);
		Map<String, Object> antigo = ldao.getLivro(id);
		Livro livro = new Livro((String)antigo.get("nome"),(String)antigo.get("edicao"), (Float)antigo.get("valor"));
		model.addAttribute("antigo", livro);
		model.addAttribute("id", id);
		return "formlivrupd";
	}
	
	@PostMapping("/upd/{id}")
	public String update(@PathVariable("id") int id, @ModelAttribute Livro livro, Model model) {
		LivroService ldao = context.getBean(LivroService.class);
		ldao.updateLivro(id, livro);
		return "redirect:/livros";
	}
	
	/*Editar Editoras*/
	@GetMapping("/upde/{idEdit}")
	public String reade(@PathVariable("idEdit") int idEdit, Model model) {
		EditoraService edao = context.getBean(EditoraService.class);
		Map<String, Object> outro = edao.getEditora(idEdit);
		Editora edit = new Editora((String)outro.get("nomeEdit"), (String)outro.get("telefone"), (String)outro.get("emailEdit"));
		model.addAttribute("outro", edit);
		model.addAttribute("idEdit", idEdit);
		return "formeditupd";
	}
	
	@PostMapping("/upde/{idEdit}")
	public String updatee(@PathVariable("idEdit") int idEdit, @ModelAttribute Editora edit, Model model) {
		EditoraService edao = context.getBean(EditoraService.class);
		edao.updateeEditora(idEdit, edit);
		return "redirect:/editoras";
	}
	
	/*Editar Autores*/
	@GetMapping("/upda/{idAut}")
	public String reada(@PathVariable("idAut") int idAut, Model model) {
		AutorService adao = context.getBean(AutorService.class);
		Map<String, Object> novo = adao.getAutor(idAut);
		Autor aut = new Autor((String)novo.get("nomeAut"), (String)novo.get("emailAut"));
		model.addAttribute("novo", aut);
		model.addAttribute("idAUt", idAut);
		return "formautorupd";
	}
	
	@PostMapping("/upda/{idAut}")
	public String updatea(@PathVariable("idAut") int idAut, @ModelAttribute Autor autor, Model model) {
		AutorService adao = context.getBean(AutorService.class);
		adao.updateaAutor(idAut, autor);
		return "redirect:/autores";
	}
}
