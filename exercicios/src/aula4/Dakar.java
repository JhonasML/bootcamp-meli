package aula4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Dakar {
    public static void main(String[] args) {
        var corrida = new Corrida(100, 1000000.0, "Gran Prix Monza", 5);
        corrida.registrarCarro(100, 20.0, 10.0, "ABC-123");
        corrida.registrarCarro(10, 2.0, 1.0, "ABC-456");
        corrida.registrarMoto(10, 2.0, 1.0, "ABC-45345");
        corrida.registrarMoto(250, 40.0, 18.0, "ABC-34534");

        corrida.socorrerCarro("ABC-123");

        var vencedor = corrida.getVencedor();
        System.out.println("Vencedor é:" + vencedor);
    }
}

abstract class Veiculo {
    private int velocidade;
    private double aceleracao;
    private double anguloDeGiro;
    private String placa;
    private double peso;
    private int rodas;

    public Veiculo(int velocidade, double aceleracao, double anguloDeGiro, String placa, double peso, int rodas) {
        this.velocidade = velocidade;
        this.aceleracao = aceleracao;
        this.anguloDeGiro = anguloDeGiro;
        this.placa = placa;
        this.peso = peso;
        this.rodas = rodas;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public double getAceleracao() {
        return aceleracao;
    }

    public void setAceleracao(double aceleracao) {
        this.aceleracao = aceleracao;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getRodas() {
        return rodas;
    }

    public void setRodas(int rodas) {
        this.rodas = rodas;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "velocidade=" + velocidade +
                ", aceleracao=" + aceleracao +
                ", anguloDeGiro=" + anguloDeGiro +
                ", placa='" + placa + '\'' +
                ", peso=" + peso +
                ", rodas=" + rodas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Veiculo)) return false;

        Veiculo veiculo = (Veiculo) o;

        if (getVelocidade() != veiculo.getVelocidade()) return false;
        if (Double.compare(veiculo.getAceleracao(), getAceleracao()) != 0) return false;
        if (Double.compare(veiculo.getAnguloDeGiro(), getAnguloDeGiro()) != 0) return false;
        if (Double.compare(veiculo.getPeso(), getPeso()) != 0) return false;
        if (getRodas() != veiculo.getRodas()) return false;
        return getPlaca().equals(veiculo.getPlaca());
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getVelocidade();
        temp = Double.doubleToLongBits(getAceleracao());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getAnguloDeGiro());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getPlaca().hashCode();
        temp = Double.doubleToLongBits(getPeso());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getRodas();
        return result;
    }
}

class Corrida {
    private double distancia;
    private double premioEmDolares;
    private String nome;
    private int quantidadeVeiculosPermitidos;
    private List<Veiculo> listaVeiculos;
    private SocorristaCarro socorristaCarro;
    private SocorristaMoto socorristaMoto;

    public Corrida(double distancia, double premioEmDolares, String nome, int quantidadeVeiculosPermitidos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.quantidadeVeiculosPermitidos = quantidadeVeiculosPermitidos;
        this.listaVeiculos = new ArrayList<>();
        this.socorristaCarro = new SocorristaCarro();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void registrarCarro(int velocidade, double aceleracao, double anguloDeGiro, String patente) {
        if (quantidadeVeiculosPermitidos > listaVeiculos.size()) {
            listaVeiculos.add(new Carro(velocidade, aceleracao, anguloDeGiro, patente));
        }
    }

    public void registrarMoto(int velocidade, double aceleracao, double anguloDeGiro, String patente) {
        if (quantidadeVeiculosPermitidos > listaVeiculos.size()) {
            listaVeiculos.add(new Moto(velocidade, aceleracao, anguloDeGiro, patente));
        }
    }

    public void removerVeiculoo(Veiculo veiculo) {
        listaVeiculos.remove(veiculo);
    }

    public void removerVeiculoPorPlaca(String placa) {
        listaVeiculos = listaVeiculos.stream().filter(v -> !v.getPlaca().equals(placa)).collect(Collectors.toList());
    }

    public Veiculo getVencedor() {
        Veiculo veiculoVencedor = null;
        double valorMaximo = 0;

        for (Veiculo veiculo : listaVeiculos) {
            double valor = veiculo.getVelocidade() * veiculo.getAceleracao() / (veiculo.getAnguloDeGiro() * (veiculo.getPeso() - veiculo.getRodas() * 100));
            if (valor > valorMaximo) {
                valorMaximo = valor;
                veiculoVencedor = veiculo;
            }
        }

        return veiculoVencedor;
    }

    public void socorrerCarro(String documento) {
        var veiculo = listaVeiculos.stream().filter(v -> v.getPlaca().equals(documento)).findFirst();
        veiculo.ifPresent(v -> socorristaCarro.socorrer((Carro) v));
    }

    public void socorrerMoto(String documento) {
        var veiculo = listaVeiculos.stream().filter(v -> v.getPlaca().equals(documento)).findFirst();
        veiculo.ifPresent(v -> socorristaMoto.socorrer((Moto) v));
    }
}

class Carro extends Veiculo {
    private final static double PESO = 1000.0;
    private final static int RODAS = 4;

    public Carro(int velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, PESO, RODAS);
    }
}

class Moto extends Veiculo {
    private final static double PESO = 300.0;
    private final static int RODAS = 2;

    public Moto(int velocidade, double aceleracao, double anguloDeGiro, String placa) {
        super(velocidade, aceleracao, anguloDeGiro, placa, PESO, RODAS);
    }
}

class SocorristaCarro {
    public void socorrer(Carro carro) {
        System.out.println("Socorrendo carro " + carro.getPlaca());
    }
}

class SocorristaMoto {
    public void socorrer(Moto moto) {
        System.out.println("Socorrendo moto " + moto.getPlaca());
    }
}