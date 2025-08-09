public class Livro {
    private String titulo, autor;
    private int quantPaginas, ano;

    public Livro(String titulo, String autor, int ano, int quantPaginas) {
        this.titulo = titulo;
        this.ano = ano;
        this.autor = autor;
        this.quantPaginas = quantPaginas;
    }

    public String getTitulo() {
        return this.titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getAutor() {
        return this.autor;
    }
    public void setAutor(String autor){
        this.autor = autor;
    }

    public int getAno() {
        return this.ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    public int getQuantPaginas() {
        return this.quantPaginas;
    }
    public void setQuantpaginas(int paginas){
        this.quantPaginas = paginas;
    }

    @Override
    public String toString() {
        return "Titulo: " + titulo + "\n" +
                "Autor: " + autor + "\n" + 
                "Ano de publicação: " + ano + "\n" +
                "Quantidade de páginas: " + quantPaginas;
    }
}