package com.aula;

import java.util.List;
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
public class LivrariaController {
	@Autowired
	private ApplicationContext context;
	
	/*Adicionar Livros*/
	@GetMapping("/livro")
	public String cadastrar(Model model) {
		model.addAttribute("livro", new Livro());
		return "formlivr";
	}
	
	@PostMapping("/livro")
	public String acao(@ModelAttribute Livro livro, Model model) {
		model.addAttribute("livro", livro);
		LivroService ldao = context.getBean(LivroService.class);
		ldao.insert(livro);
		return "sucesso";
	}
	
	/*Desc dos Livros*/
	@GetMapping("descr/{id}")
	public String read(@PathVariable("id") int id, Model model) {
		LivroService lpao = context.getBean(LivroService.class);
		Map<String, Object> livro = lpao.getLivro(id);
		Livro livro1 = new Livro((String)livro.get("nome"),(String)livro.get("edicao"),(Float)livro.get("valor"));
		model.addAttribute("livro", livro1);
		return "sucesso";
	}
	
	/*Lista de livros*/
	@GetMapping("/livros")
	public String listar(Model model) {
		LivroService ldao = context.getBean(LivroService.class);
		List<Map<String, Object>> livros = ldao.getLivros();
		model.addAttribute("livros", livros);
		return "formlista";
	}
	
	/*Apagar livros*/
	@PostMapping("/apagar/{id}")
	public String deletar(@PathVariable("id") int id, Model model) {
		LivroService ldao = context.getBean(LivroService.class);
		ldao.deleteLivro(id);
		return "redirect:/livros";
	}
	
	/*Adicionar Editoras*/
	@GetMapping("/editora")
	public String cadastrare(Model model) {
		model.addAttribute("edit", new Editora());
		return "formedit";
	}
	
	@PostMapping("/editora")
	public String acaoe(@ModelAttribute Editora edit, Model model) {
		model.addAttribute("edit", edit);
		EditoraService edao = context.getBean(EditoraService.class);
		edao.inserte(edit);
		return "sucessoedit";
	}
	
	/*Desc	 das Editoras*/
	@GetMapping("descre/{idEdit}")
	public String reade(@PathVariable("idEdit") int idEdit, Model model) {
		EditoraService epao = context.getBean(EditoraService.class);
		Map<String, Object> editora = epao.getEditora(idEdit);
		Editora edit = new Editora((String)editora.get("nomeEdit"),(String)editora.get("telefone"),(String)editora.get("emailEdit"));
		model.addAttribute("edit", edit);
		return "sucessoedit";
	}
	
	/*Lista de editoras*/
	@GetMapping("/editoras")
	public String listare(Model model) {
		EditoraService edao = context.getBean(EditoraService.class);
		List<Map<String, Object>> edits = edao.getEditoras();
		model.addAttribute("edits", edits);
		return "formlistaedits";
	}
	
	
	/*Apagar editoras*/
	@PostMapping("/apagare/{idEdit}")
	public String deletare(@PathVariable("idEdit") int idEdit, Model model) {
		EditoraService edao = context.getBean(EditoraService.class);
		edao.deletareEditora(idEdit);
		return "redirect:/editoras";
	}
	
	/*Adicionar Autores*/
	@GetMapping("/autor")
	public String cadastrara(Model model) {
		model.addAttribute("autor", new Autor());
		return "formautor";
	}
	
	@PostMapping("/autor")
	public String acaoa(@ModelAttribute Autor autor, Model model) {
		model.addAttribute("autor", autor);
		AutorService adao = context.getBean(AutorService.class);
		adao.inserta(autor);
		return "sucessoautor";
	}
	
	/*Desc dos autores */
	@GetMapping("descra/{idAut}")
	public String reada(@PathVariable("idAut") int idAut, Model model) {
		AutorService apao = context.getBean(AutorService.class);
		Map<String, Object> autor = apao.getAutor(idAut);
		Autor aut = new Autor((String)autor.get("nomeAut"),(String)autor.get("emailAut"));
		model.addAttribute("autor", aut);
		return "sucessoautor";
	}
	
	/*Lista de autores*/
	@GetMapping("/autores")
	public String listara(Model model) {
		AutorService adao = context.getBean(AutorService.class);
		List<Map<String, Object>> autores = adao.getAutores();
		model.addAttribute("autores", autores);
		return "formlistaautores";
	}
	
	
	/*Apagar autores*/
	@PostMapping("/apagara/{idAut}")
	public String deletara(@PathVariable("idAut") int idAut, Model model) {
		AutorService adao = context.getBean(AutorService.class);
		adao.deletarAutor(idAut);
		return "redirect:/autores";
	}
}
