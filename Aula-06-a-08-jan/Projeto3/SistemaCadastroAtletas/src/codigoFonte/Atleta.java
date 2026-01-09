package codigoFonte;

public abstract class Atleta{

	private String nomeAtleta;
	private int idade;
	
	
	//aqui polimorfismo- obrigamos os filhos a implementar o @Override com seus retornos (para esse caso, pois pode ser void)
	protected abstract Double calcularPagamento();//assinatura
	protected abstract int qtdTreinoSemana();
	protected abstract Double calculoPatrocinio();
	
	//aqui temos herança 
	public void verificaNumeroNegativo(Double valor) {
		if(valor <0) {
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
		if(idadeChegando < 0 ) {
		throw new IllegalArgumentException("A idade não pode ser negativa");
		}
		
		this.idade = idadeChegando;
	}
	
};