import java.util.ArrayList;
import java.util.List;

/**
 * A class <code>Banco</code></code> representa o banco. Tem um
 * nome e uma lista de contas de clientes.
 */
public class Banco {

	/** nome do banco */
	private String nome;

	/** lista de contas de clientes. */
	private List<Conta> contas;

	/**
	 * Inicializa um novo banco com nome e uma lista
	 * inicializada de contas de clientes.
	 * @param nome
	 */
	public Banco(String nome) {
		this.nome = nome;
		this.contas = new ArrayList<>();
		System.out.println("Novo banco criado: " + nome);
	}

	/**
	 * Retorna o nome do banco, necessário em alguns
	 * pontos do código.
	 * @return nome
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Retorna a lista de contas do banco.
	 * @return
	 */
	public List<Conta> getContas() { return contas; }

	/**
	 * Cadastra a conta do cliente no banco. Mostra algumas
	 * informações na tela para orientar o usuário. Esse
	 * método é usado apenas uma vez para cada conta inserida
	 * no banco.
	 * @param conta
	 */
	public void setConta(Conta conta) {
		System.out.println("Nova conta adicionada ao cadastro do banco: ");
		System.out.println("Número: " + conta.getNumero() +
				" Cliente: " + conta.getCliente().getNome() + "\n");
		this.contas.add(conta);
	}

}
