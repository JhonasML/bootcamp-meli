package aula1.tm;

import java.util.Arrays;
import java.util.Comparator;

public class Exercicio1 {
    public static void main(String[] args) {
        Integer[] vetor = {52, 10, 85, 1324, 1, 13, 62, 30, 12, 127};
        Arrays.sort(vetor);

        System.out.println("Ordem crescente:");
        Arrays.stream(vetor).forEach(System.out::println);

        Arrays.sort(vetor, Comparator.reverseOrder());

        System.out.println("Ordem decrescente:");
        Arrays.stream(vetor).forEach(System.out::println);

    }
}
