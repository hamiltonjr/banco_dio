import jdk.swing.interop.SwingInterOpUtils;

/**
 * Testa todas as classes com seus atributos e métodos.
 */
public class Main {

	public static void main(String[] args) {

		// criando o banco
		System.out.println("\n==== CRIAÇÃO DO VABCO");
		Banco b = new Banco("Banco de Java");

		// criando alguns clientes
		System.out.println("\n==== CRIAÇÃO DOS CLIENTES ====");
		Cliente cli1 = new Cliente("John Dev");
		Cliente cli2 = new Cliente("Jane P. O.");
		Cliente cli3 = new Cliente("Willian S. M.");

		// abrindo as contas para os clientes
		System.out.println("\n==== ABERTURA DE CONTAS PARA CLIENTES ====");
		ContaCorrente cc1 = new ContaCorrente(cli1);
		ContaPoupanca cp1 = new ContaPoupanca(cli1);
		ContaCorrente cc2 = new ContaCorrente(cli2);
		ContaPoupanca cp2 = new ContaPoupanca(cli2);
		ContaCorrente cc3 = new ContaCorrente(cli3);
		ContaPoupanca cp3 = new ContaPoupanca(cli3);

		// depósito inicial em conta corrente é de R$1.000,00
		System.out.println("\n==== DEPÓSITOS INICIAIS EM CONTA-CORRENTE ====");
		cc1.depositar(1000.00);
		cc2.depositar(1000.00);
		cc3.depositar(1000.00);

		// depósito inicial em conta poupança é de R$500,00
		System.out.println("\n==== DEPÓSITOS INICIAIS EM CONTA-POUPANÇA ====");
		cp1.depositar(500.00);
		cp2.depositar(500.00);
		cp3.depositar(500.00);

		// incluindo as novas contas no cadastro do banco
		System.out.println();
		b.setConta(cc1);
		b.setConta(cc2);
		b.setConta(cc3);
		b.setConta(cp1);
		b.setConta(cp2);
		b.setConta(cp3);

		// resumo de contas e saldos
		System.out.println("==== RESUMO DE CONTAS DO BANCO ====");
		resumo(b);

		// extratos após depósitos
		System.out.println("==== EXTRATOS APÓS DEPÓSITOS");
		for (Conta c: b.getContas()) {
			System.out.println(c);
		}

		// transferindo valores para as poupanças
		System.out.println("\n==== TRANSFERÊNCIAS DE SALDO ====");
		efetuaTransferencia(cc1, cp1, 100.00);
		efetuaTransferencia(cc2, cp2, 100.00);
		efetuaTransferencia(cc3, cp3, 100.00);

		// exceções de teste
		// cc1.depositar(-1); // lança a exceção IllegalArgumentException
		// cc2.sacar(-1);     // lança a exceção IllegalArgumentException
		efetuaSaque(cc3, 1000000);

	}

	/**
	 * Método estático auxiliar do método principal.
	 * Implementa o saque com todos os avisos para o
	 * usuário.
	 * @param conta
	 * @param valor
	 */
	public static void efetuaSaque(Conta conta, double valor) {
		System.out.println("==== SAQUE ====");
		System.out.println("Sacado.....: " +
				conta.getNumero() + "\nSaldo......: " +
				String.format("%.2f", conta.getSaldo()) +
				"\nValor......: " + String.format("%.2f", valor));

		if (conta.sacar(valor)) {
			System.out.println("Transferência efetuada com sucesso");
			System.out.println(conta);
		} else {
			System.out.println("Saque não efetuado. Saldo insuficiente.");
		}
	}

	/**
	 * Método estático auxiliar do método principal.
	 * Implementa a transferência com todos os avisos
	 * para o usuário.
	 * @param contaOrigem
	 * @param contaDestino
	 * @param valor
	 */
	public static void efetuaTransferencia(Conta contaOrigem, Conta contaDestino, double valor) {
		System.out.println("==== TRANSFERÊNCIA ====");
		System.out.println("Sacado.....: " +
				contaOrigem.getNumero() +
				"\nSaldo: " + String.format("%.2f", contaOrigem.getSaldo()));

		System.out.println("Depositado.: " +
				contaDestino.getNumero() +
				"\nSaldo: " + String.format("%.2f", contaDestino.getSaldo()));

		if (contaOrigem.transferir(valor, contaDestino)) {
			System.out.println("Transferência efetuada com sucesso");
			System.out.println(contaOrigem);
			System.out.println(contaDestino);
		} else {
			System.out.println("Transferência não efetuada. Saldo insuficiente.");
		}
	}

	/**
	 * Método estático auxiliar do método principal para
	 * implermentação de um resumo de contas e saldos.
	 * @param b (objeto banco)
	 */
	public static void resumo(Banco b) {
		double total = 0.0;

		for (Conta c: b.getContas()) {
			System.out.println(c.getNumero() + ": " +
					String.format("%.2f", c.getSaldo()));
			total += c.getSaldo();
		}

		System.out.println("\nTotal: " +
				String.format("%.2f%n", total));
	}

}
