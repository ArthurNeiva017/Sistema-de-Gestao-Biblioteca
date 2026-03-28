package service;
import java.util.List;

import model.Emprestimo;
import repository.EmprestimoRepository;
import repository.LivroRepository;
import repository.UsuarioRepository;

public class EmprestimoService {
    private EmprestimoRepository emprestimoRepository;
    private UsuarioRepository usuarioRepository;
    private LivroRepository livroRepository;
    private static int proximoId = 1;

    public EmprestimoService() {
        this.emprestimoRepository = new EmprestimoRepository();
        this.usuarioRepository = new UsuarioRepository();
        this.livroRepository = new LivroRepository();
    }

    public EmprestimoService(EmprestimoRepository emprestimoRepository, 
                            UsuarioRepository usuarioRepository, 
                            LivroRepository livroRepository) {
        this.emprestimoRepository = emprestimoRepository;
        this.usuarioRepository = usuarioRepository;
        this.livroRepository = livroRepository;
    }

    public Emprestimo realizarEmprestimo(int usuarioId, int livroId, int diasEmprestimo) {
		return emprestimoRepository.salvar(null);
    }

    public void devolverLivro(int emprestimoId) {
    	List<Emprestimo> emprestimos = emprestimoRepository.listarEmprestimosAtivos();
    	for (Emprestimo e: emprestimos) {
    		if (e.getId() == emprestimoId) {
    			e.setAtivo(false);
    		}
    	}
    }

    public List<Emprestimo> buscarEmprestimosDoUsuario(int usuarioId) {
        return emprestimoRepository.buscarPorUsuario(usuarioId);
    }

    public List<Emprestimo> buscarEmprestimosAtivosDoUsuario(int usuarioId) {
        return emprestimoRepository.buscarEmprestimosAtivos(usuarioId);
    }

    public List<Emprestimo> listarTodosEmprestimos() {
        return emprestimoRepository.listarTodos();
    }

    public List<Emprestimo> listarEmprestimosAtivos() {
        return emprestimoRepository.listarEmprestimosAtivos();
    }

    public Emprestimo buscarPorId(int id) {
        return emprestimoRepository.buscarPorId(id);
    }

    public boolean verificarAtraso(int emprestimoId) {
    	List<Emprestimo> emprestimos = emprestimoRepository.listarEmprestimosAtivos();
    	for (Emprestimo e: emprestimos) {
    		if (e.getId() == emprestimoId) {
    			if (e.getDataDevolucaoPrevista() != null) {
                    e.setAtivo(true);
                    e.setDataDevoluçaoReal(null);
                    return true;
                } else {
                    e.setDataDevolucaoPrevista(null);
                    return false;
               }
    		}
    	}
    	return false;
    }
    
}