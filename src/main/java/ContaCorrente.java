/**
 * Representa uma conta-corrente. Extende a class
 * Conta.
 */
public class ContaCorrente extends Conta {

	/**
	 * inicializa uma conta-corrente. Mostra algumas
	 * informações na tela para orientação do usuário.
	 * @param cliente
	 */
	public ContaCorrente(Cliente cliente) {
		super(cliente);
		System.out.println("Nova conta corrente criada");
		System.out.println("==== DADOS DA CONTA ====");
		System.out.println(this);
	}

}
