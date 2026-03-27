import java.util.List;
import java.util.Scanner;

import controller.LivroController;
import model.Livro;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== SISTEMA DE GERENCIAMENTO DE BIBLIOTECA =====\n");

        Scanner scanner = new Scanner(System.in);
        LivroController livroController = new LivroController();
        boolean continuar = true;

        while (continuar) {
            System.out.println("1. Cadastrar Livro");
            System.out.println("2. Listar Livros");
            System.out.println("3. Buscar Livro por Nome");
            System.out.println("4. Sair");
            System.out.print("Escolha a opção: ");

            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1":
                    System.out.println("\n=== Cadastro de Livro ===");

                    System.out.print("Id: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nome do livro: ");
                    String nome = scanner.nextLine();

                    System.out.print("Autor: ");
                    String autor = scanner.nextLine();

                   
                    Livro livro = new Livro(id, nome, autor, id, id);
                    livroController.cadastrar(livro);

                    System.out.println("Livro cadastrado com sucesso.\n");
                    break;

                case "2":
                    System.out.println("\n=== Lista de Livros ===");
                    List<Livro> listaLivros = livroController.listarTodos();

                    if (listaLivros.size() == 0) {
                        System.out.println("Nenhum livro cadastrado.\n");
                    } else {
                        for (Livro l : listaLivros) {
                            System.out.println("Id: " + l.getId());
                            System.out.println("Nome: " + l.getNome());
                            System.out.println("Autor: " + l.getAutor());
                            System.out.println("Edição: " + l.getEdicao());
                            System.out.println("Quantidade: " + l.getQuantidade());
                            System.out.println();
                        }
                    }
                    break;

                case "3":
                    System.out.println("\n=== Buscar Livro por Nome ===");
                    System.out.print("Digite o nome do livro: ");
                    String nomeBusca = scanner.nextLine();

                    List<Livro> livrosEncontrados = livroController.buscarPorNome(nomeBusca);

                    if (livrosEncontrados.size() == 0) {
                        System.out.println("Nenhum livro encontrado.\n");
                    } else {
                        for (Livro l : livrosEncontrados) {
                            System.out.println("Id: " + l.getId());
                            System.out.println("Nome: " + l.getNome());
                            System.out.println("Autor: " + l.getAutor());
                            System.out.println("Edição: " + l.getEdicao());
                            System.out.println("Quantidade: " + l.getQuantidade());
                            System.out.println();
                        }
                    }
                    break;

                case "4":
                    continuar = false;
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida.\n");
            }
        }

        scanner.close();
    }
}