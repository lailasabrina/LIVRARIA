package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LivroService {
	@Autowired 
	  LivrariaDAO ldao;
	  
	  public void insert(Livro livro) {
	    ldao.insert(livro);
	  }
	  
	  public Map<String, Object> getLivro(int id){
		  return ldao.getLivro(id);
	  }
	  
	  public List<Map<String, Object>> getLivros(){
		  return ldao.getLivros();
	  }
	  
	  public void deleteLivro(int id) {
		  ldao.deleteLivro(id);
	  }
	  
	  public void updateLivro(int id, Livro livro) {
		  ldao.updateLivro(id, livro);
	  }
	  
}
