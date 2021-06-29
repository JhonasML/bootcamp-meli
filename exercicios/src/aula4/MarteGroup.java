package aula4;

import java.util.Arrays;
import java.util.List;

public class MarteGroup {
    public static void main(String[] args) {
        List<Convidado> convidados = Arrays.asList( new Convidado(), new Convidado(), new Convidado());
        List<ConvidadoMeli> convidadosMeli = Arrays.asList( new ConvidadoMeli(), new ConvidadoMeli(), new ConvidadoMeli());

        List<Fogos> fogosIndividuais = Arrays.asList(new FogosIndividuais(),new FogosIndividuais(),new FogosIndividuais(),new FogosIndividuais());
        List<Fogos>  fogos = Arrays.asList(new PacoteFogos(fogosIndividuais), new FogosIndividuais(), new FogosIndividuais(),new FogosIndividuais());

        var laChiqueEvento = new Evento(convidados, convidadosMeli, fogosIndividuais, fogos);

        laChiqueEvento.ApagaVelas();
    }
}

class Evento {
    List<Convidado> convidadosStandard;
    List<ConvidadoMeli> convidadoMeli;

    List<Fogos> fogosIndividuais;
    List<Fogos> fogos;

    public Evento(List<Convidado> convidadosStandard, List<ConvidadoMeli> convidadoMeli, List<Fogos> fogosIndividuais, List<Fogos> fogos) {
        this.convidadosStandard = convidadosStandard;
        this.convidadoMeli = convidadoMeli;
        this.fogosIndividuais = fogosIndividuais;
        this.fogos = fogos;
    }

    public void ApagaVelas() {
        System.out.println("Soltem os fogos individuais!");
        fogosIndividuais.forEach(Fogos::EstourarFogos);

        System.out.println("Soltem os pacotes de fogos!");
        fogos.forEach(Fogos::EstourarFogos);

        System.out.println("Convidados normais comam o bolo!");
        convidadosStandard.forEach(Convidado::ComerBolo);

        System.out.println("Convidados MELI comam o bolo!");
        convidadoMeli.forEach(Convidado::ComerBolo);

    }
}

class Convidado {
    public void ComerBolo(){
        System.out.println("Obrigado pelo bolo.");
    }
}

class ConvidadoMeli extends Convidado {
    @Override
    public void ComerBolo() {
        System.out.println("Viva la Chiqui !! Ai que tudo, ai que batista");
    }
}

interface Fogos {
    public void EstourarFogos();
}

class FogosIndividuais implements Fogos{
     public void EstourarFogos(){
         System.out.println(" *''*  \n" +
                            "*_\\/_*\n" +
                            "* /\\ *\n" +
                            " *..*\n" +
                            "BOOOM!\n");
     }
}

class PacoteFogos implements Fogos { //Como um Composite
    List<Fogos> pacotes;

    public PacoteFogos(List<Fogos> pacotes) {
        this.pacotes = pacotes;
    }

    @Override
    public void EstourarFogos() {
        pacotes.forEach(Fogos::EstourarFogos);
    }
}