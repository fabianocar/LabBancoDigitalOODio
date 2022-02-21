import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		Cliente cliente = new Cliente();

		Conta cc = new ContaCorrente(cliente);
		Conta poupanca = new ContaPoupanca(cliente);

		System.out.println("####### BANK ######");
		System.out.printf("Digite \n 1: criar conta\n 2: Depositar\n 3: Transferir\n 4: Extrato\n 0: sair\n");
		int seleciona = scan.nextInt();

		switch (seleciona) {

		case 1:
			System.out.println("Digite o nome do cliente: ");
			scan.nextLine();
			String name = scan.nextLine();
			cliente.setNome(name);

		case 2:
			System.out.println("Digite um valor para depositar: ");
			double valorDep = scan.nextDouble();
			if (cc.cliente.getNome() != null) {
				cc.depositar(valorDep);
			} else {
				System.out.println("Repita operação, nome inválido!");
				System.out.println();
				break;
			}

		case 3:
			System.out.println("Digite um valor para transferir: ");
			double valorTrans = scan.nextDouble();
			if (cc.saldo > 0 && valorTrans < poupanca.saldo) {
				cc.transferir(valorTrans, poupanca);
			} else {
				System.out.println("Saldo Insufciente!");
				System.out.println();
			}

		case 4:
			cc.imprimirExtrato();
			poupanca.imprimirExtrato();
			break;

		default:
			System.out.println("finalizado");
			break;
		}

		scan.close();
	}

}
