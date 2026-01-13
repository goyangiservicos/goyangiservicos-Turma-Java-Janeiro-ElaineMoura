package codigoFonte;

public class JogadorFutsal extends Atleta {

	private String pernaMaisForte;
	private Double valorPorGols;
	private int qtdGols;

	public String getPernaMaisForte() {
		return pernaMaisForte;
	}

	public void setPernaMaisForte(String pernaMaisForteChegando) {
		this.pernaMaisForte = pernaMaisForteChegando;
	}

	public Double getValorPorGols() {
		return valorPorGols;
	}

	public void setValorPorGols(Double valorPorGolsChegando) {
		verificaNumeroNegativo(valorPorGolsChegando);
		this.valorPorGols = valorPorGolsChegando;

	}

	// metodo que a superclasse (classe pai) obriga a classe jogador futebol
	// implementar
	@Override // sobrepor, sobrescrever
	protected Double calcularPagamento() {

		return valorPorGols * 50;
	}

	@Override
	protected int qtdTreinoSemana() {

		return 5;
	}

	public int getQtdGols() {
		return qtdGols;
	}

	public void setQtdGols(int qtdGols) {
		verificaNumeroNegativo((double) qtdGols);
		this.qtdGols = qtdGols;
	}

	@Override
	protected Double calculoPatrocinio() {
		Double vintePorCentoSalario = getSalario() * 0.2;
		Double vintePorCentoQtdPontosx = (qtdGols * 0.2) * 3;
		// double pagamento = calcularPagamento();
		// double bonusGols = getQtdGols() * 4;
		// double resultado = (pagamento * 0.30) + (bonusGols * 0.30);

		return vintePorCentoSalario + vintePorCentoQtdPontosx;
	}

}