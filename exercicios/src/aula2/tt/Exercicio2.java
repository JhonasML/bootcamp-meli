package aula2.tt;

import java.util.Arrays;

/*
Crie a classe GeometricFigure, abstrata e com o método: public abstract double area ();

Substitua corretamente o método toString. Discussão em grupo: faz sentido substituir o método toString em uma classe abstrata?

Crie as classes Círculo, Triângulo e Retângulo, todas subclasses de Figura Geométrica. Que erro de compilação aparece? Como você resolveria isso?

Adicione os atributos (variáveis ​​de instância) que correspondem em cada caso e substitua adequadamente o método de área em todas as subclasses de GeometricFigure.

Crie uma classe de utilidade com um método estático: public static double areaMedia (GeometricFigure arr []), que calcula e retorna a área média das figuras contidas no array. Crie um programa, instancie um array de GeometricFigure [], carregue os dados nele e execute o método areaMedia para obter a área média. Mostre o resultado.
 */
public class Exercicio2 {

    public static double areaMedia(GeometricFigure[] arr) {
        return Arrays.stream(arr).mapToDouble(GeometricFigure::area).average().orElse(0);
    }

    public static void main(String[] args) {
        GeometricFigure[] geometricFigures = new GeometricFigure[5];

        geometricFigures[0] = new Circulo(20);
        geometricFigures[1] = new Circulo(400);
        geometricFigures[2] = new Retangulo(2, 20);
        geometricFigures[3] = new Triangulo(30, 30);
        geometricFigures[4] = new Retangulo(2, 20);

        System.out.println(areaMedia(geometricFigures));
    }
}


abstract class GeometricFigure {
    public abstract double area();
}

class Circulo extends GeometricFigure {
    private double raio;

    public Circulo(double raio) {
        this.raio = raio;
    }

    @Override
    public double area() {
        return Math.PI * (this.raio * this.raio);
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }
}

class Triangulo extends GeometricFigure {
    private double base;
    private double altura;

    public Triangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return this.base * this.altura / 2;
    }

}

class Retangulo extends GeometricFigure {
    private double base;
    private double altura;

    public Retangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double area() {
        return this.base * this.altura;
    }

}