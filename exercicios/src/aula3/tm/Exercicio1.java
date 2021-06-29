package aula3.tm;

import java.util.Arrays;
import java.util.List;

/*
Crie a interface Precedente<T> com um método public int precedeA (T t).

Crie a classe Pessoa, com os atributos String nome e cpf, seus métodos de acesso e os construtores que você considera apropriados.

Criar uma classe Pessoa que implemente Precedente<Pessoa>, logo sobrescrever o método int precedeA(Pessoa p).

Defina um critério de precedência para implementar o método acima. Pode ser que uma pessoa preceda outra se o seu CPF for inferior, ou o nome for alfabeticamente inferior e assim por diante.

Crie a classe SortUtil com o método:
 public static <T> void sort (List<Precedente <T>> arr[]).


Dentro do método anterior, desenvolva o algoritmo de bolha (bubble sort) para ordenar a matriz.

Discussão: O método de classificação pode classificar uma matriz de qualquer tipo de dados?

Crie um programa, declare um array com várias pessoas, classifique-o e exiba-o.

Crie a classe Celular, com os atributos: number e holder, implemente Precedente<Celular> e proceda da mesma forma que fizemos com Pessoa do ponto anterior.
 */
public class Exercicio1 {
    public static void main(String[] args) {
        Pessoa[] pessoas = new Pessoa[3];
        pessoas[0] = new Pessoa("AAA", "1234234");
        pessoas[1] = new Pessoa("A", "1234234");
        pessoas[2] = new Pessoa("AAAAA", "1234234");

        SortUtil.sort(pessoas);
        Arrays.stream(pessoas).forEach(System.out::println);

        Celular[] celulars = new Celular[3];
        celulars[0] = new Celular(10000, "Claro");
        celulars[1] = new Celular(100, "Claro");
        celulars[2] = new Celular(10000000, "Claro");

        SortUtil.sort(celulars);
        Arrays.stream(celulars).forEach(System.out::println);

    }
}

interface Precedente<T> {
    public int procedeA(T t);
}

class Pessoa implements Precedente<Pessoa>{
    private String nome;
    private String cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int procedeA(Pessoa pessoa) {
        if (this.nome.length() >= pessoa.nome.length()){
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
               "nome='" + nome + '\'' +
               ", cpf='" + cpf + '\'' +
               '}';
    }
}

class Celular implements Precedente<Celular> {
    private int numero;
    private String holder;

    @Override
    public int procedeA(Celular celular) {
        if (this.numero > celular.numero){
            return 1;
        }
        return 0;
    }

    public Celular(int numero, String holder) {
        this.numero = numero;
        this.holder = holder;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    @Override
    public String toString() {
        return "Celular{" +
               "numero=" + numero +
               ", holder='" + holder + '\'' +
               '}';
    }
}


class SortUtil {
    public static <T> void sort (Precedente<T>[] v) {
        for(int i = 0; i < v.length - 1; i++) {
            for(int j = 0; j < v.length - 1 - i; j++) {
                if(v[j].procedeA((T) v[j + 1]) > 0) {
                    Precedente<T> aux = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = aux;
                }
            }
        }
    }
}