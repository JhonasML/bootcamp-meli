package aula2.tm;

import java.util.Arrays;
import java.util.List;

/*
Crie uma classe Book com os métodos:
empréstimo, devolver e toString, cujo protótipo deve ser: public String toString ().
 Este método deve retornar uma string que representa o objeto.
 Por exemplo: se a classe tiver os atributos: título, isbn e autor, uma string representando um livro poderia ser: "Harry Potter, 9780545582889, Rowling, J. K.".
  A classe conterá um construtor padrão, um construtor com parâmetros e os métodos de acesso.
Adicione a linha @Override logo acima do cabeçalho do método toString. Em seguida, renomeie o método para: tostring (tudo em letras minúsculas). O que acontece?
 */
public class Exercicio3 {

    public static void main(String[] args) {
        var book = new Book("O Senhor dos Anéis: O Retorno do Rei", "1955", "1 edição", "J.R.R Tolkien", 9780007144082L, Arrays.asList("Romance", "Fantasia", "Aventura", "Literatura Fantástica"));

        System.out.println(book);
    }
}

class Book {
    private String titulo;
    private String anoLancamento;
    private String edicao;
    private String autor;
    private long isbn;
    private List<String> generos;
    private boolean estaEmprestado;

    public Book(String titulo, String anoLancamento, String edicao, String autor, long isbn, List<String> generos) {
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.edicao = edicao;
        this.autor = autor;
        this.isbn = isbn;
        this.generos = generos;
        this.estaEmprestado = false;
    }

    public Book() {
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }

    public List<String> getGeneros() {
        return generos;
    }

    public void setGeneros(List<String> generos) {
        this.generos = generos;
    }

    public boolean estaEmprestado() {
        return estaEmprestado;
    }

    public void emprestimo() {
        this.estaEmprestado = true;
    }

    public void devolver() {
        this.estaEmprestado = false;
    }

    @Override
    public String toString() {
        return
                "'" + titulo + '\'' +
                ", '" + anoLancamento + '\'' +
                ", '" + edicao + '\'' +
                ", '" + autor + '\'' +
                ", " + isbn +
                ", " + generos;
    }
}