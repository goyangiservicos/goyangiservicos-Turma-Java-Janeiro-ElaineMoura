package codigoFonte;

public class JogadorBasquete extends Atleta{

	private String bracoMaisForte;
	private Double valorPorPontos;

	public String getBracoMaisForte() {
		return bracoMaisForte;
	}
	
	public void setBracoMaisForte(String bracoMaisForteChegando) {
		this.bracoMaisForte = bracoMaisForteChegando;
	}
	
	public Double getValorPorPontos() {
		return valorPorPontos;
	}
	
	public void setValorPorPontos(Double valorPorPontosChegando) {
		Utilitario util = new Utilitario();
		util.verificaNumeroNegativo(valorPorPontosChegando);
		this.valorPorPontos = valorPorPontosChegando;
	}
}

