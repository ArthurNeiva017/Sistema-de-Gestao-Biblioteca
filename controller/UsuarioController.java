package controller;
import java.util.ArrayList;
import java.util.List;	
import model.Livro;
import model.Usuario;
import service.UsuarioService;

public class UsuarioController {
    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public void cadastrar(Usuario usuario) {
    	if(usuario.getNome() != "" && usuario.getCpf() != "") {
    		usuarioService.cadastrar(usuario);
    	}else { 
    		System.out.println("Erro coloque o Nome ou CPF incorretos!");
    	}
    }

    public Usuario buscarPorId(int id) {
    	Usuario usuario = usuarioService.buscarPorId(id);
        return usuario;
        
    }

    public Usuario buscarPorCpf(String cpf) {
    	Usuario usuario = usuarioService.buscarPorCpf(cpf);
        return usuario;
    }

    public Usuario buscarPorEmail(String email) {
    	Usuario usuario = usuarioService.buscarPorEmail(email);
        return usuario;
    }

    public List<Usuario> buscarPorNome(String nome) {
    	if(nome != "" && nome != null) {
    		return usuarioService.buscarPorNome(nome);
    	} else {
    		return new ArrayList<Usuario>();
    	}
       
    }

    public List<Usuario> listarTodos() {
    	return usuarioService.listarTodos();
      
    }

    public void alterar(Usuario usuario) {
    	usuarioService.alterar(usuario);
    }

    public void remover(int id) {
    	usuarioService.remover(id);
    }
}