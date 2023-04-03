package paulo.banco;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Paulo
 */
public class Banco {
     private ArrayList<Conta> contas;
     private Scanner entrada;
     public Banco(){
     contas = new ArrayList<>();
     entrada = new Scanner(System.in);
     
}
    public void abrirConta(){
         System.out.print("Digite seu nome: ");
         String nome = entrada.nextLine();
         System.out.print("Digite o número da sua conta: ");
         String id = entrada.nextLine();
         for (Conta conta : contas) {
            if (conta.getId().equals(id)) {
                System.out.println("O número da conta já existe!");
                return;
            }
        }
         double saldo = 0;
         System.out.print("Digite o tipo de conta (1 para Corrente, 2 para Poupança): ");
         int tipo = entrada.nextInt();
         entrada.nextLine();
         if (tipo == 1) {
            System.out.print("Digite o limite da sua conta: ");
            double limite = entrada.nextDouble();
            contas.add(new ContaCorrente(nome, id, saldo, limite));
        } else if (tipo == 2) {
            System.out.print("Digite sua taxa de juros: ");
            double taxaJuros = entrada.nextDouble();
            contas.add(new ContaPoupanca(nome, id, saldo, taxaJuros));
        } else {
            System.out.println("Tipo de conta inválido.");
        }
    }
    public void deposito() {
        System.out.print("Digite o número da sua conta: ");
        String id = entrada.nextLine();
        System.out.print("Digite o valor que deseja depositar: ");
        double valor = entrada.nextDouble();
        for (Conta conta : contas) {
            if (conta.getId().equals(id)) {
                conta.deposito(valor);
                System.out.println("Depósito bem-sucedido.");
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
    public void saque() {   
        System.out.print("Digite o número da sua conta: ");
        String id = entrada.nextLine();
        System.out.print("Digite o valor que deseja sacar: ");
        double valor = entrada.nextDouble();
        for (Conta conta : contas) {
            if (conta.getId().equals(id)) {
                conta.saque(valor);
                return;
            }
        }
        System.out.println("Conta não encontrada.");
    }
    public void exibirTodos() {
        for (Conta conta : contas) {
            System.out.println(conta);
        }
    }
     public static void main(String[] args) {
        Banco banco  = new Banco ();
        int escolha;
        do {
            System.out.println("Menu Sistema Bancário:");
            System.out.println("1. Criar conta");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Mostrar todas as contas");
            System.out.println("0. Sair");
            System.out.print("Digite uma opção: ");
            escolha = banco.entrada.nextInt();
            banco.entrada.nextLine();
            switch (escolha) {
                case 1:
                    banco.abrirConta();
                    break;
                case 2:
                    banco.deposito();
                    break;
                case 3:
                    banco.saque();
                    break;
                case 4:
                    banco.exibirTodos();
                    break;
                case 0:
                    System.out.println("Adeus!");
                    break;
                default:
                    System.out.println("Opção Invalida!");
                    break;
            }
        } while (escolha != 0);
    }
    
}
