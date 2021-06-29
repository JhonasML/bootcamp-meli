package aula4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SaveTheRopa {
    public static void main(String[] args) {
        var roupas = new ArrayList<Vestuario>();

        roupas.add(new Vestuario("Gucci", "Calça saru uél"));
        roupas.add(new Vestuario("Riachuelo", "Camiseta barata"));

        var guardaRoupa = new GuardaRoupa();

        var id = guardaRoupa.guardarVestuarios(roupas);

        guardaRoupa.mostrarVestuarios();

        var roupasGuardadas = guardaRoupa.devolverVestuarios(id);
        System.out.println("Roupas resgatadas:");
        roupasGuardadas.forEach(System.out::println);

    }
}

class Vestuario {
    private String marca;
    private String modelo;

    public Vestuario(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vestuario{" +
                "marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}

class GuardaRoupa {
    private Map<Integer, List<Vestuario>> portas;
    private Integer identificadorCount;

    public GuardaRoupa() {
        this.portas = new HashMap<>();
        this.identificadorCount = 0;
    }

    public Integer guardarVestuarios(List<Vestuario> listaDeVestuario) {
        var chave = identificadorCount;
        this.portas.put(chave, listaDeVestuario);

        identificadorCount++;

        return chave;
    }

    public void mostrarVestuarios() {
        portas.forEach((key, value) -> System.out.println("Id:" + key + " Roupas:" + value));
    }

    public List<Vestuario> devolverVestuarios(Integer id) {
        var roupas = portas.get(id);
        portas.remove(id);
        return roupas;
    }
}