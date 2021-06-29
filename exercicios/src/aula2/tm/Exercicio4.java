package aula2.tm;

/*
Crie uma classe Fracao com métodos necessários para adicionar, subtrair, multiplicar e dividir frações.
Todos os métodos devem ser sobrecarregados para que também possam ser usados ​​
para operar entre frações e números inteiros (por exemplo: ⅗ + 2 ou ⅝ * 4).
 */
public class Exercicio4 {
    public static void main(String[] args) {
        var f = new Fracao(1, 2);
        var f2 = new Fracao(1, 2);

        System.out.println(f.adicionar(f2).multiplicar(2));
    }
}

class Fracao {
    int numerador;
    int denomoniador;

    public Fracao(int numerador, int denomoniador) {
        this.numerador = numerador;
        this.denomoniador = denomoniador;
    }

    public Fracao adicionar(Fracao fracao) {
        var mc = mmc(this.denomoniador, fracao.denomoniador);
        var numeradorFinal = mc / this.denomoniador * this.numerador + mc / fracao.denomoniador * fracao.numerador;

        return new Fracao(numeradorFinal, mc);
    }

    public Fracao subtrair(Fracao fracao) {
        var mc =  mmc(this.denomoniador, fracao.denomoniador);
        var numeradorFinal = mc / this.denomoniador * this.numerador - mc / fracao.denomoniador * fracao.numerador;

        return new Fracao(numeradorFinal, mc);
    }

    public Fracao multiplicar(Fracao fracao) {
        return new Fracao(this.numerador * fracao.numerador, this.denomoniador * fracao.denomoniador);
    }

    public Fracao dividir(Fracao fracao) {
        return new Fracao(this.numerador * fracao.denomoniador, this.denomoniador * this.numerador);

    }

    public Fracao adicionar(int inteiro) {
        return adicionar(new Fracao(inteiro, 1));
    }

    public Fracao subtrair(int inteiro) {
        return subtrair(new Fracao(inteiro, 1));
    }

    public Fracao multiplicar(int inteiro) {
        return multiplicar(new Fracao(inteiro, 1));
    }

    public Fracao dividir(int inteiro) {
        return dividir(new Fracao(inteiro, 1));
    }

    @Override
    public String toString() {
        return numerador + "/" + denomoniador;
    }

    private int mmc(int n1, int n2) {
        int resto;
        int a = n1;
        int b = n2;
        while (b != 0) {
            resto = a % b;
            a = b;
            b = resto;
        }

        return (n1 * n2) / a;
    }
}