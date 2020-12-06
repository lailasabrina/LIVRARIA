package com.aula.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {
	
	@Autowired 
	  LivrariaDAO edao;
	  
	  public void inserte(Editora edit) {
	    edao.inserte(edit);
	  }
	  
	  public Map<String, Object> getEditora(int idEdit){
		  return edao.getEditora(idEdit);
	  }
	  
	  public List<Map<String, Object>> getEditoras(){
		  return edao.getEditoras();
	  }
	  
	  public void deletareEditora(int idEdit) {
		  edao.deleteEditora(idEdit);
	  }
	  
	  public void updateeEditora(int idEdit, Editora edit) {
		  edao.updateEditora(idEdit, edit);
	  }
}
