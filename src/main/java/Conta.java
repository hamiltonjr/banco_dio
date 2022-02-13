import jdk.swing.interop.SwingInterOpUtils;

/** Representa uma conta genérica, da qual as contas-correntes
  * e contas-poupança herdarão caracteristicas básicas.
  */
public abstract class Conta {

	/** Inicialmente somente um banco será aceito
	 *  no sistema.
	 */
	private static final int AGENCIA_PADRAO = 1;

	/** as contas serão geradas automaticamente. */
	private static int SEQUENCIAL = 1;

	/** número da agência. */
	private int agencia;

	/** número da conta */
	private int numero;

	/** saldo da conta */
	private double saldo;

	/** cliente (associação da classe Cliente */
	private Cliente cliente;

	/**
	 * Inicializa a conta já com todas as
	 * informações necessárias.
	 */
	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
	}

	/**
	 * Retorna o objeto cliente.
	 */
	public Cliente getCliente() {
		return cliente;
	}

	/**
	 * Retorna o saldo.
	 */
	public double getSaldo() {
		return saldo;
	}

	/**
	 * Retorma o número da agência.
	 * @return
	 */
	public int getAgencia() {
		return agencia;
	}

	/**
	 * Retorna o número da conta.
	 * @return
	 */
	public int getNumero() {
		return numero;
	}

	/**
	 * Implementa o saque com validação de valor
	 * e retorna de status da operação.
	 */
	public boolean sacar(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException();
		}

		if (saldo < valor) {
			return false;
		}

		saldo -= valor;
		return true;
	}

	/**
	 * Implementa o depósito com validação de valor.
	 */
	public void depositar(double valor) {
		if (valor <= 0) {
			throw new IllegalArgumentException();
		}

		saldo += valor;
	}

	/**
	 * Implementa a transferência entre contas
	 * com validação baseada no status do saque.
	 * @param valor
	 * @param contaDestino
	 * @return
	 */
	public boolean transferir(double valor, Conta contaDestino) {
		if (this.sacar(valor)) {
			contaDestino.depositar(valor);
			return true;
		}
		return false;
	}

	/**
	 * Implementa o output do objeto.
	 * @return
	 */
	@Override
	public String toString() {
		return  "Titular..: " + cliente.getNome() + "\n" +
				"Agência..: " + agencia + "\n" +
				"Número...: " + numero + "\n" +
				"Saldo....: " + String.format("%.2f", saldo)  + "\n";
	}
}
