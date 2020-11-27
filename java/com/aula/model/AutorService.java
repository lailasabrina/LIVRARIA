package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorService {
	
	@Autowired 
	  LivrariaDAO adao;
	  
	  public void inserta(Autor autor) {
	    adao.inserta(autor);
	  }
	  
	  public Map<String, Object> getAutor(int idAut){
		  return adao.getAutor(idAut);
	  }
	  
	  public List<Map<String, Object>> getAutores(){
		  return adao.getAutores();
	  }
	  
	  public void deletarAutor(int idAut) {
		  adao.deleteAutor(idAut);
	  }
	  
	  public void updateaAutor(int idAut, Autor autor) {
		  adao.updateAutor(idAut, autor);
	  }
}
