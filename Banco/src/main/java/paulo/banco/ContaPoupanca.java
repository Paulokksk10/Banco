package paulo.banco;

/**
 *
 * @author Paulo
 */
public class ContaPoupanca extends Conta {
    private double taxaJuros;

    public ContaPoupanca(String name, String id, double saldo, double taxaJuros) {
        super(name, id, saldo);
        this.taxaJuros = taxaJuros;
    }

    public double gettaxaJuros() {
        return taxaJuros;
    }

    public void settaxaJuros(double juros) {
        this.taxaJuros = taxaJuros;
    }

    
    @Override
    public void saque(double valor) {
        if (getSaldo() - valor < 0) {
            System.out.println("Não é possível sacar valor maior que o saldo.");
        } else {
            deposito(-valor);
            System.out.println("Saque bem-sucedida.");
        }
    }
    
        public void addJuros() {
        deposito(getSaldo() * taxaJuros);
    }
    @Override
        public String toString() {
        return super.toString() + "\nTaxa de juros: " + taxaJuros;
    }
}
