package service;
import java.util.List;

import model.Livro;
import repository.LivroRepository;

public class LivroService {
    private LivroRepository livroRepository;

    public LivroService() {
        this.livroRepository = new LivroRepository();
    }

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro) {
        return livroRepository.salvar(livro);
    }

    public Livro buscarPorId(int id) {
        return livroRepository.buscarPorId(id);
    }

    public List<Livro> buscarPorNome(String nome) {
        return livroRepository.buscarPorNome(nome);
    }

    public List<Livro> listarTodos() {
        return livroRepository.listarTodos();
    }

    public void alterar(Livro livro) {
    	livroRepository.atualizar(livro);
    }

    public void remover(int id) {
    	livroRepository.deletar(id);
    }
}