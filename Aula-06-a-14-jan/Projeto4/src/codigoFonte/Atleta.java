package codigoFonte;

public abstract class Atleta {

	private String nomeAtleta;
	private int idade;
	private long identificador;
	
	public long getIdentificador() {
		return identificador;
	}

	public Atleta(long identificador) {
		super();
		this.identificador = identificador;
	}

	private Double patrocinio;
	private Double salario;
	
	public Double getPatrocinio() {
		return patrocinio;
	}

	public void setPatrocinio(Double patrocinio) {
		this.patrocinio = patrocinio;
	}

	// aqui polimorfismo- obrigamos os filhos a implementar o @Override com seus
	// retornos (para esse caso, pois pode ser void)
	// todas as subclasses sao obrigadas a implementar os metodos de acordo com a
	// sua necessidade.
	protected abstract Double calcularPagamento();// assinatura

	protected abstract int qtdTreinoSemana();

	protected abstract Double calculoPatrocinio();

	// Construtor de Atleta - inicalizando o objeto com nome e idade
/*	public Atleta(String nomeAtletaConstrutor, int idadeAtletaConstrutor) {
		this.nomeAtleta = nomeAtletaConstrutor;
		this.idade = idadeAtletaConstrutor;

	}

	// construtor vazio - quando faz isso autoriza usar o contrutor vazio
	public Atleta() {

	}
	
	public Atleta(String nomeConstrutor) {
		this.nomeAtleta = nomeConstrutor;
	}
*/
	// aqui temos herança - todas as subclasses herdam 100% o comportmaento do
	// metodo
	public void verificaNumeroNegativo(Double valor) {
		if (valor < 0) {

			throw new IllegalArgumentException("o valor nao pode ser negativo");
		}
	}

	public String getNomeAtleta() {
		return nomeAtleta;
	}

	public void setNomeAtleta(String nomeAtletaChegando) {
		this.nomeAtleta = nomeAtletaChegando;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idadeChegando) {
		if (idadeChegando < 0) {
			throw new IllegalArgumentException("A idade não pode ser negativa");
		}

		this.idade = idadeChegando;
	}

	public Double getSalario() {
		return salario;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}

};