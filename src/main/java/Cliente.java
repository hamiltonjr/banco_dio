/**
 * Representa o cliente do banco, com um nome.
 */
public class Cliente {

	/** nome do cliente do banco. */
	private String nome;

	/**
	 * Inicializa o cliente já com o nome.
	 * @param nome
	 */
	public Cliente(String nome) {
		this.nome = nome;
		System.out.println("Novo cliente criado: " + nome);
	}

	/** Retorna o nome do cliente. */
	public String getNome() {
		return nome;
	}

}
