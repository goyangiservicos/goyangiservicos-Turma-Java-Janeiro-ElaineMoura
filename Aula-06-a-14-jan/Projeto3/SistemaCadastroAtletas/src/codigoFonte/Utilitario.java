package codigoFonte;

public class Utilitario {
public void verificaNumeroNegativo(Double valor) {
	if(valor <0) {
		throw new IllegalArgumentException("O valor nao pode ser negativo!");
	}
}
}
