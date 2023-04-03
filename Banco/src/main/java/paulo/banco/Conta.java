package paulo.banco;

/**
 * Classe para criar uma conta
 * @author Paulo
 */
public abstract class Conta {
    String name;
    String id;
    double saldo;

    
    public Conta(String name, String id, double saldo) {
        this.name = name;
        this.id = id;
        this.saldo = saldo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void deposito(double valor) {
        saldo += valor;
    }
    
    /**
     * Método que permite usar cheques para sacar dinheiro
     * @param valor 
     */
    public abstract void saque(double valor);
    
    @Override
    public String toString() {
        return "Nome: " + name + "\nNúmero da conta: " + id + "\nSaldo: " + saldo;
    }
}
