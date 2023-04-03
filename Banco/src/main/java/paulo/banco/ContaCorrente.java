package paulo.banco;

/**
 *
 * @author Paulo
 */
public class ContaCorrente extends Conta {
    private double limite;

    public ContaCorrente(String name, String id, double saldo, double limite) {
        super(name, id, saldo);
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }

    public void setLimite(double limite) {
        this.limite = limite;
    }

    
    @Override
    public void saque(double valor) {
        if (getSaldo() - valor < -limite) {
            System.out.println("Não é possível sacar valor maior que o limite da conta.");
        } else {
            deposito(-valor);
            System.out.println("Saque bem-sucedida.");
        }
    }
    
    @Override
    public String toString() {
        return super.toString() + "\nLimite da conta: " + limite;
    }
    
    
}
