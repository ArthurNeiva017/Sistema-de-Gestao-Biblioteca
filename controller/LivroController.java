package controller;
import java.util.ArrayList;
import java.util.List;

import model.Livro;
import service.LivroService;

public class LivroController {
    private LivroService livroService;

    public LivroController() {
        this.livroService = new LivroService();
    }

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }
    
    public void cadastrar(Livro livro) {
    	if(livro.getNome() != "" && livro.getAutor() != "") {
    		livroService.cadastrar(livro);
    	}else { 
    		System.out.println("Erro coloque o nome certo do livro!");
    	}
    }

    public Livro buscarPorId(int id) {
    	Livro livro = livroService.buscarPorId(id);
        return livro;
    }

    
    public List<Livro> buscarPorNome(String nome) {
        return livroService.buscarPorNome(nome);
    }

    public List<Livro> listarTodos() {
    	
        return livroService.listarTodos();
    }

    public void alterar(Livro livro) {
    	livroService.alterar(livro);
    }

    public void remover(int id) {
    	livroService.remover(id);
    }
}
