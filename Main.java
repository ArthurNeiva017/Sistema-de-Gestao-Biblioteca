import java.util.List;
import java.util.Scanner;
import controller.LivroController;
import model.Livro;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA =====\n");
        
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;
        
        while(continuar) {
        	System.out.println("1. Cadastrar Livro");
        	System.out.println("2. Listar Livros");
        	System.out.println("3. Nome do Livro");
        	System.out.println("4. Sair\n");
        	System.out.println("Escolha a Opção:");
        	String opcao1 = scanner.next();
        	
        	LivroController livroController = new LivroController();
        	
        	switch(opcao1) {
            case "1":
                System.out.println("Cadastro do Livro");
                Livro l1 = new Livro(1, "Arthur Neiva", "Aventura", 10, 1000);
                livroController.cadastrar(l1);
                break;
                
            case "2":
            	System.out.println("Listar Livros");
            	List<Livro>listaLivros =  livroController.listarTodos();
            	for(Livro p: listaLivros) {
            		System.out.println(p.getId() + " - " + p.getNome());
            	}
            	break;
            case "3":
            	System.out.println("Livro");
            	System.out.println("nome do livro:  " + livroController.buscarPorNome(opcao1));
            	break;
            case "4":
            	continuar = false;
            	break;
            default:
            	System.out.println("Opção Inválida");
        
        	}    
        } 
        
        scanner.close();
    }
}