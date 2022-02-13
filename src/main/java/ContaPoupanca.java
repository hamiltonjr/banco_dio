/**
 * Representa uma conta-poupança. Extende a class
 * Conta.
 */
public class ContaPoupanca extends Conta {

	/**
	 * inicializa uma conta-poupança. Mostra algumas
	 * informações na tela para orientação do usuário.
	 * @param cliente
	 */
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
		System.out.println("Nova conta poupança criada");
		System.out.println("==== DADOS DA CONTA ====");
		System.out.println(this);
	}

}
