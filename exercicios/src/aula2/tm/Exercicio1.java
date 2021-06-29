package aula2.tm;

/*
Crie uma classe Conta Corrente, com os métodos: depósito, saque, devolução e transferência.
A classe conterá um construtor padrão, um com parâmetros e outro que receberá uma conta corrente da qual copiará todos os seus dados.
 Além disso, os métodos de acesso devem ser desenvolvidos para cada variável de instância da classe, desenvolvendo um método set e outro método get.
 Por exemplo: se a classe tem uma variável double saldo, seus métodos de acesso serão: double getSaldo () e void setSaldo (double s)
Os protótipos dos métodos e construtores devem ser discutidos e projetados em equipe.
 */
public class Exercicio1 {
    public static void main(String[] args) {
        var conta1 = new ContaCorrente("Bruce Wayne", 58745, 0001, 13700000000000000.0);
        var conta2 = new ContaCorrente("Alfred Pennyworth", 24545, 0001, 10000.0);

        var saldo = conta2.deposito(600.0);
        System.out.println("Saldo do Alfred depois do auxilio: R$" + saldo);

        saldo = conta2.saque(800.0);
        System.out.println("Saldo do Alfred depois do saque auxilio: R$" + saldo);

        conta1.transferencia(conta2, 3000.0);
        saldo = conta2.getSaldo();
        System.out.println("Saldo do Alfred depois do salário: R$" + saldo);

        conta2.devolucao( 3000.0);
        saldo = conta2.getSaldo();
        System.out.println("Saldo do Alfred depois de devolver salário: R$" + saldo);
    }
}

class ContaCorrente {

    private String usuario;
    private int conta;
    private int agencia;

    private double saldo;


    public ContaCorrente(String usuario, int conta, int agencia, double saldo) {
        this.usuario = usuario;
        this.conta = conta;
        this.agencia = agencia;
        this.saldo = saldo;
    }

    public ContaCorrente(ContaCorrente contaCorrente) {
        this.usuario = contaCorrente.usuario;
        this.conta = contaCorrente.conta;
        this.agencia = contaCorrente.agencia;
        this.saldo = contaCorrente.saldo;
    }

    public double deposito(double valor) {
        saldo+=valor;
        return saldo;
    }

    public double saque(double valor) {
        saldo-=valor;
        return saldo;
    }

    public double devolucao(double valor) {
        saldo-=valor;
        return saldo;
    }

    public void transferencia(ContaCorrente destino, double valor) {
        saldo-=valor;
        destino.deposito(valor);
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}