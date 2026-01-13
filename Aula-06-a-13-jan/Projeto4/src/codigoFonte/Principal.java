package codigoFonte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Principal {

	public static void main(String[] args) {

		System.out.println("#################Inicio Cadastro de Atletas############");
		String opcao;
		// JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal(); quando feito fora,
		// sempre vai sobrescrever na lista nao é o ideal.

		List<JogadorFutsal> jogadoresFutsal = new ArrayList<JogadorFutsal>();// lista dos cadastrados
		List<JogadorBasquete> jogadoresBasquete = new ArrayList<JogadorBasquete>();

		do {
//JOptionPa - Classe do java swing - pacote de interface grafica nativa do java 
//showInputDialog - recebe uma string como parametro e retorna essa strig digitada pelo usuario
			String opcaoCadastro;
			do {
			    opcaoCadastro = validaOpcaoFouB(
			        JOptionPane.showInputDialog("Digite F para jogador(a) de futsal ou B para jogador(a) de basquete")
			    );
			} while (opcaoCadastro == null);

			if (opcaoCadastro.equalsIgnoreCase("F")) {
			    JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal();// sendo iniciado aqui para ser um obj novo e
			                                                            // nao sobrescrever o anterior

				jogadorFutsalObjeto
						.setNomeAtleta(JOptionPane.showInputDialog("Digite o nome do jogador(a) de Futsal: "));

				int idadeTemporaria;
				do {

					idadeTemporaria = validaInteiroRetornaInt(
							JOptionPane.showInputDialog("Digite a idade do jogador(a) de Basquete: "));
					if (idadeTemporaria != 0) {
						jogadorFutsalObjeto.setIdade(idadeTemporaria);
					}
				} while (idadeTemporaria == 0);

				jogadorFutsalObjeto.setPernaMaisForte(
						JOptionPane.showInputDialog("Digite a perna mais forte do jogador(a) de Futsal: "));

				Double valorPorGolTemporaria;
				do {

					valorPorGolTemporaria = validaDoubleEretornaDouble(
							JOptionPane.showInputDialog("Digite o valor por gol do jogador(a): "));
					if (valorPorGolTemporaria != 0.0) {
						jogadorFutsalObjeto.setValorPorGols(valorPorGolTemporaria);
					}
				} while (valorPorGolTemporaria == 0);

				int quantidadeGols;
				do {

					quantidadeGols = validaInteiroRetornaInt(
							JOptionPane.showInputDialog("Digite a quantidade de pontos Basquete: "));
					if (quantidadeGols != 0) {
						jogadorFutsalObjeto.setQtdGols(quantidadeGols);
					}
				} while (quantidadeGols == 0);

				jogadorFutsalObjeto.setSalario(jogadorFutsalObjeto.calcularPagamento());
				jogadorFutsalObjeto.setPatrocinio(jogadorFutsalObjeto.calculoPatrocinio());

				jogadoresFutsal.add(jogadorFutsalObjeto); // jogar na lista

			}

			if (opcaoCadastro.equalsIgnoreCase("B")) {
				JogadorBasquete jogadorBasqueteObjeto = new JogadorBasquete();
				// System.out.println("Digite o nome do jogador(a) de Basquete: ");

				jogadorBasqueteObjeto
						.setNomeAtleta(JOptionPane.showInputDialog("Digite o nome do jogador(a) de Basquete: "));
				int idadeTemporaria;
				do {

					idadeTemporaria = validaInteiroRetornaInt(
							JOptionPane.showInputDialog("Digite a idade do jogador(a) de Basquete: "));
					if (idadeTemporaria != 0) {
						jogadorBasqueteObjeto.setIdade(idadeTemporaria);
					}
				} while (idadeTemporaria == 0);

				jogadorBasqueteObjeto.setBracoMaisForte(
						JOptionPane.showInputDialog("Digite a braco mais forte do jogador(a) de Basquete: "));

				Double valorPorPontoTemporaria;
				do {

					valorPorPontoTemporaria = validaDoubleEretornaDouble(
							JOptionPane.showInputDialog("Digite o valor por ponto do Basquete: "));
					if (valorPorPontoTemporaria != 0.0) {
						jogadorBasqueteObjeto.setValorPorPontos(valorPorPontoTemporaria);
					}
				} while (valorPorPontoTemporaria == 0);

				int qtdPorPontoTemporaria;
				do {

					qtdPorPontoTemporaria = validaInteiroRetornaInt(
							JOptionPane.showInputDialog("Digite o valor por ponto do Basquete: "));
					if (qtdPorPontoTemporaria != 0) {
						jogadorBasqueteObjeto.setQntPontos(qtdPorPontoTemporaria);
					}
				} while (qtdPorPontoTemporaria == 0);

				// jogadorBasqueteObjeto.setQntPontos(JOptionPane.showInputDialog("Digite
				// quantidade de pontos marcardos: "));

				jogadorBasqueteObjeto.setSalario(jogadorBasqueteObjeto.calcularPagamento());
				jogadorBasqueteObjeto.setPatrocinio(jogadorBasqueteObjeto.calculoPatrocinio());

				jogadoresBasquete.add(jogadorBasqueteObjeto);

			}

			opcao = JOptionPane.showInputDialog("Deseja cadastrar mais um atleta (S/N)?");

		} while (opcao.equalsIgnoreCase("S"));
		System.out.println("#######LISTA DE JOGADORES DE FUTSAL CADASTRADOS#######");
		for (JogadorFutsal jogadorFutsalLista : jogadoresFutsal) {
			System.out.println("nome do jogador de futsal: " + jogadorFutsalLista.getNomeAtleta());
			System.out.println("Idade do jogador de futsal: " + jogadorFutsalLista.getIdade());
			System.out.println("Perna mais forte do jogador de futsal: " + jogadorFutsalLista.getPernaMaisForte());
			System.out.println("Quantidadede gols do jogador de futsal: " + jogadorFutsalLista.getQtdGols());
			System.out.println("Idade do jogador de futsal: " + jogadorFutsalLista.getSalario());
			System.out.println("Valor do patrocinio: " + jogadorFutsalLista.getPatrocinio());

			System.out.println("-------------------------------------------");
		}

		System.out.println("#######LISTA DE JOGADORES DE BASQUETE CADASTRADOS#######");
		// Tipo do obj que vai tratar no for - nome do obj que será manipulado -- lista
		// que vai ser escrita
		for (JogadorBasquete jogadorBasquetelLista : jogadoresBasquete) {
			System.out.println("nome do jogador de Basquete: " + jogadorBasquetelLista.getNomeAtleta());
			System.out.println("Idade do jogador de Basquete: " + jogadorBasquetelLista.getIdade());
			System.out.println("Perna mais forte do jogador de Basquete: " + jogadorBasquetelLista.getIdade());
			System.out.println("Quantidadede pontos do jogador de Basquete: " + jogadorBasquetelLista.getQntPontos());
			System.out.println("Idade do jogador de Basquete: " + jogadorBasquetelLista.getSalario());
			System.out.println("Valor do patrocinio: " + jogadorBasquetelLista.getPatrocinio());

			System.out.println("-------------------------------------------");
		}
		System.out.println("#################Fim do Cadastro de Atletas############");

	}

	public static int validaInteiroRetornaInt(String numeroString) {
		int numeroInteiro = 0;

		if (numeroString == null || numeroString.isBlank()) {
			JOptionPane.showMessageDialog(null, "valor invalido");
		} else {
			try {
				numeroInteiro = Integer.parseInt(numeroString);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Apenas numeros");
				System.out.println("O valor:" + e.getMessage() + "nao pode ser convertido para inteiro");
			}

		}
		return numeroInteiro;
	}

	public static Double validaDoubleEretornaDouble(String numeroString) {
		Double numeroDecimal = 0.0;

		if (numeroString == null || numeroString.isBlank()) {
			JOptionPane.showMessageDialog(null, "Valor inválido");
		} else {

			try {
				numeroDecimal = Double.parseDouble(numeroString);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Apenas Numeros.");// Comunica para o usuario
				System.out.println("O valor: " + e.getMessage() + "Não pode ser convertido para inteiro."); // Comunica
																											// para o
																											// DEV
			}
		}

		return numeroDecimal;
	}
	
	public static String validaOpcaoFouB(String opcao) {

	    if (opcao == null || opcao.isBlank()) {
	        JOptionPane.showMessageDialog(null, "Opção inválida. Digite apenas B ou F.");
	        return null;
	    }

	    if (!opcao.equalsIgnoreCase("F") && !opcao.equalsIgnoreCase("B")) {
	        JOptionPane.showMessageDialog(null, "Opção inválida. Digite apenas B ou F.");
	        return null;
	    }

	    return opcao.toUpperCase();
	}
	
	
	
}