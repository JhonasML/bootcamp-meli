package aula1.tm;

public class Exercicio2 {
    public static void main(String[] args) {
        final double TAXA_CRESCIMENTO_X = 1.48;
        final double  TAXA_CRESCIMENTO_Y = 0.32;

        var valorEmpresaX =1.13;
        var valorEmpresaY =18.4;

        for (int ano = 2021; valorEmpresaX < valorEmpresaY ; ano++)  {
            valorEmpresaX += valorEmpresaX*TAXA_CRESCIMENTO_X;
            valorEmpresaY += valorEmpresaY*TAXA_CRESCIMENTO_Y;
            System.out.printf("Empresa X - 01/01/%s - Valor da empresa: %.2fm\n", ano, valorEmpresaX);
            System.out.printf("Empresa Y - 01/01/%s - Valor da empresa: %.2fm\n\n", ano, valorEmpresaY);
        }
    }
}
