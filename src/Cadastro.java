import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {
    private static ArrayList<Livro> ListaDeLivros = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao;

        do {
            System.out.println("---------MENU---------");
            System.out.println("1. Cadastrar livros");
            System.out.println("2. Listar livros");
            System.out.println("3. Excluir livros por posição");
            System.out.println("4. Alterar dados");
            System.out.println("0. Sair");
            System.out.println("----Escolha uma opção: ");
            opcao = sc.nextInt();
            sc.nextLine(); 

            switch (opcao) {
                case 1:
                    CadastrarLivro();
                    break;
                case 2:
                    ListarLivros();
                    break;
                case 3:
                    ExcluirLivro();
                    break;
                case 4:
                    AlterarDados();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static void CadastrarLivro() {
        System.out.println("Digite o título: ");
        String titulo = sc.nextLine();
        System.out.println("Digite o autor: ");
        String autor = sc.nextLine();
        System.out.println("Digite o ano de publicação: ");
        int ano = sc.nextInt();
        System.out.println("Digite a quantidade de páginas: ");
        int quantPaginas = sc.nextInt();
        sc.nextLine(); 
        Livro livro = new Livro(titulo, autor, ano, quantPaginas);
        ListaDeLivros.add(livro);
        System.out.println("Livro cadastrado com sucesso!");
    }

    private static void ListarLivros() {
        if (ListaDeLivros.isEmpty()) {
            System.out.println("Nenhum livro cadastrado!");
        } else {
            System.out.println("---Lista de Livros Cadastrados---");
            for (int i = 0; i < ListaDeLivros.size(); i++) {
                System.out.println((i + 1) + ". " + ListaDeLivros.get(i));
            }
        }
    }

    private static void ExcluirLivro() {
        ListarLivros();
        if (!ListaDeLivros.isEmpty()) {
            System.out.println("Digite a posição do livro que deseja excluir: ");
            int posicao = sc.nextInt();
            sc.nextLine();

            if (posicao >= 1 && posicao <= ListaDeLivros.size()) {
                ListaDeLivros.remove(posicao - 1);
                System.out.println("Livro excluido com sucesso!");
            } else {
                System.out.println("Posição inválida! Por favor selecione uma posição válida.");
            }
        }
    }

    private static void AlterarDados (){
        int alt;
        
        if(ListaDeLivros.isEmpty()){
            System.out.println("Nenhum livro cadastrado");
            return;
        }
        System.out.println("---Lista de Livros Cadastrados---");
        for(int i = 0; i < ListaDeLivros.size(); i++){
            System.out.println((i + 1) + ". " + ListaDeLivros.get(i).getTitulo());
        }
        System.out.println("Selecione a posição do livro que deseja alterar");
        int i = sc.nextInt();
        sc.nextLine();
        if (i < 1 || i > ListaDeLivros.size()){
            System.out.println("Opção inválida!");
            return;
        }

        Livro livro = ListaDeLivros.get(i - 1);

        do{
            System.out.println("Informe o dado que deseja alterar");
            System.out.println("1. Título");
            System.out.println("2. Autor");
            System.out.println("3. Quantidade de páginas");
            System.out.println("4. Ano de publicação");
            System.out.println("0. Sair do menu");
            alt = sc.nextInt();
            sc.nextLine();
            switch (alt) {
                case 1:
                    System.out.println("Informe o novo título do livro: ");
                    String nome = sc.nextLine();
                    if (!nome.equals(livro.getTitulo())){
                        livro.setTitulo(nome); 
                        System.out.println("Titulo atualizado com sucesso!");
                    } else {
                        System.out.println("O titulo é igual ao anterior. Nenhuma alteração feita");
                    }
                break;
                case 2: 
                    System.out.println("Informe o novo nome do Autor do livro: ");
                    String nomeAutor = sc.nextLine();
                    if (!nomeAutor.equals(livro.getAutor())){
                        livro.setAutor(nomeAutor);
                        System.out.println("Nome do autor atualizado com sucesso!");
                    } else {
                        System.out.println("O nome do autor é igual ao anterior. Nenhuma alteração feita");
                    }
                break;
                case 3:
                    System.out.println("Informe a nova quantidade de páginas do livro: ");
                    int quantPag = sc.nextInt(); 
                    if (quantPag != livro.getQuantPaginas()){
                        livro.setQuantpaginas(quantPag);
                        System.out.println("Quantidade de páginas atualizada com sucesso!");
                    } else {
                        System.out.println("A quantidade de páginas é igual ao anterior. Nenhuma alteração feita");
                    }
                break;
                case 4:
                    System.out.println("Informe o novo ano de publicação do livro: ");
                    int novoAno = sc.nextInt(); 
                    if (novoAno != livro.getAno()){
                        livro.setAno(novoAno);
                        System.out.println("Ano de publicação atualizado com sucesso!");
                    } else {
                        System.out.println("O ano de publicação é igual ao anterior. Nenhuma alteração feita");
                    }
                break;
                case 0: 
                    System.out.println("Saindo do sistema...");
                break;
                default: 
                    System.out.println("Favor selecionar uma opção válida!");
                break;
            }
        
        } while (alt != 0);
    }
}
