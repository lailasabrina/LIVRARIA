package com.aula.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LivrariaDAO {
	@Autowired 
    DataSource dataSource;
    
	JdbcTemplate jdbc;
	
    @PostConstruct
    private void initialize(){
        jdbc = new JdbcTemplate(dataSource);
    }
    
    /*Livros*/
    public void insert(Livro livro) {
        String sql = "INSERT INTO livro " + "(nome,edicao,valor) VALUES (?,?,?)" ;
       jdbc.update(sql, new Object[]{
        		livro.getNome(), livro.getEdicao(), livro.getValor()
        });
    }
    
    public Map<String, Object> getLivro(int id){
    	String sql = "SELECT * FROM livro WHERE livro.id = ?";
    	return jdbc.queryForMap(sql, new Object[] {id});
    }
    
    public List<Map<String, Object>> getLivros() {
    	String sql = "SELECT * FROM livro";
    	List<Map<String, Object>> livros = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return livros;
    }
    
    public void deleteLivro(int id) {
        String sql = "DELETE FROM livro WHERE id = ?";
       jdbc.update(sql, new Object[] {id});
    } 
    
    public void updateLivro(int id, Livro livro) {
    	String sql = "UPDATE livro SET nome=?, edicao=?, valor=? WHERE  id=?";
    	 jdbc.update(sql, new Object[]{
         		livro.getNome(), livro.getEdicao(), livro.getValor(), id
         });
    }
    
    /*Editoras*/
    public void inserte(Editora edit) {
        String sql = "INSERT INTO editora " + "(nomeEdit,telefone,emailEdit) VALUES (?,?,?)" ;
       jdbc.update(sql, new Object[]{
        		edit.getNomeEdit(), edit.getTelefone(), edit.getEmailEdit()
        });
    }
    
    public Map<String, Object> getEditora(int idEdit){
    	String sql = "SELECT * FROM editora WHERE editora.id = ?";
    	return jdbc.queryForMap(sql, new Object[] {idEdit});
    }
    
    public List<Map<String, Object>> getEditoras() {
    	String sql = "SELECT * FROM editora";
    	List<Map<String, Object>> editoras = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return editoras;
    }
    
    public void deleteEditora(int idEdit) {
        String sql = "DELETE FROM editora WHERE id = ?";
       jdbc.update(sql, new Object[] {idEdit});
    }
    
    public void updateEditora(int idEdit, Editora edit) {
    	String sql = "UPDATE editora SET nomeEdit=?, telefone=?, emailEdit=? WHERE  id=?";
    	 jdbc.update(sql, new Object[]{
         		edit.getNomeEdit(), edit.getTelefone(), edit.getEmailEdit(), idEdit
         });
    }
    
    /*Autores*/
    public void inserta(Autor autor) {
        String sql = "INSERT INTO autor " + "(nomeAut,emailAut) VALUES (?,?)" ;
       jdbc.update(sql, new Object[]{
        		autor.getNomeAut(), autor.getEmailAut()
        });
    }
    
    public Map<String, Object> getAutor(int idAut){
    	String sql = "SELECT * FROM autor WHERE autor.idAut = ?";
    	return jdbc.queryForMap(sql, new Object[] {idAut});
    }
    
    public List<Map<String, Object>> getAutores() {
    	String sql = "SELECT * FROM autor";
    	List<Map<String, Object>> autores = (List<Map<String, Object>>) jdbc.queryForList(sql);
    	return autores;
    }
    
    public void deleteAutor(int idAut) {
        String sql = "DELETE FROM autor WHERE idAut = ?";
       jdbc.update(sql, new Object[] {idAut});
    }
    
    public void updateAutor(int idAut, Autor autor) {
    	String sql = "UPDATE autor SET nomeAut=?, emailAut=? WHERE  idAut=?";
    	 jdbc.update(sql, new Object[]{
         		autor.getNomeAut(), autor.getEmailAut(), idAut
         });
    }
}
