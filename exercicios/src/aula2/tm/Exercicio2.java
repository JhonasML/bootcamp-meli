package aula2.tm;

public class Exercicio2 {
    public static void main(String[] args) {
        var counter = new Counter(0);
        while (counter.getValor() < 10){
            System.out.println(counter.getValor());
            counter.Increment();
        }

        while (counter.getValor() >= 0){
            System.out.println(counter.getValor());
            counter.Decrement();
        }
    }
}

class Counter{
    int valor;

    public Counter() {
        this.valor = 0;
    }

    public Counter(Counter counter) {
        this.valor = counter.getValor();
    }

    public Counter(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int Increment(){
        valor++;
        return valor;
    }

    public int Decrement(){
        valor--;
        return valor;
    }

    public int Increment(int sum){
        valor+=sum;
        return valor;
    }

    public int Decrement(int sub){
        valor-=sub;
        return valor;
    }
}