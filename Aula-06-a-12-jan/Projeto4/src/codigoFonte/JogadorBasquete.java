package codigoFonte;

public class JogadorBasquete extends Atleta {

	private String bracoMaisForte;
	private Double valorPorPontos;
	private int qntPontos;

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
		verificaNumeroNegativo(valorPorPontosChegando);
		this.valorPorPontos = valorPorPontosChegando;
	}

	@Override
	protected Double calcularPagamento() {

		return valorPorPontos * 30;
	}

	@Override
	protected int qtdTreinoSemana() {

		return 3;
	}

	public int getQntPontos() {
		return qntPontos;
	}

	public void setQntPontos(int qntPontos) {
		verificaNumeroNegativo((double) qntPontos);
		this.qntPontos = qntPontos;
	}

	@Override
	protected Double calculoPatrocinio() {
		Double trintaPorCentoSalario = getSalario() * 0.3;
		Double trintaPorCentoQtdPontosxTres = (qntPontos * 0.3) * 4;
		return trintaPorCentoSalario + trintaPorCentoQtdPontosxTres;
	}

}
