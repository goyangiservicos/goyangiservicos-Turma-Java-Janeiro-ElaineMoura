package codigoFonte;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ForkJoinPool;

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

			boolean letraOuNao;
			String opcaoCadastro;

			do {
				opcaoCadastro = validaOpcaoFouB(JOptionPane
						.showInputDialog("Digite F para jogador(a) de futsal ou B para jogador(a) de basquete"));

				letraOuNao = somenteLetras(opcaoCadastro);
			} while (!letraOuNao);

// equalsIgnoreCase- para aceitar minus/maisc
			if (opcaoCadastro.equalsIgnoreCase("F")) {
				JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal();// sendo iniciado aqui para ser um obj novo e
																		// nao sobrescrever o anterior

				do {

					String nome = JOptionPane.showInputDialog("Qual o nome do Jogador(a) de futsal: ");

					letraOuNao = somenteLetras(nome);

					if (letraOuNao) {
						jogadorFutsalObjeto.setNomeAtleta(nome);
					}

				} while (!letraOuNao);

				int idadeTemporaria;
				do {

					idadeTemporaria = validaInteiroRetornaInt(
							JOptionPane.showInputDialog("Digite a idade do jogador(a) de futsal: "));
					if (idadeTemporaria != 0) {
						jogadorFutsalObjeto.setIdade(idadeTemporaria);
					}
				} while (idadeTemporaria == 0);

				do {
					String pernaMaisForte = JOptionPane.showInputDialog("Qual a perna mais forte: ");

					letraOuNao = somenteLetras(pernaMaisForte);

					if (letraOuNao) {
						jogadorFutsalObjeto.setPernaMaisForte(pernaMaisForte);
					}

				} while (!letraOuNao);
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
							JOptionPane.showInputDialog("Digite a quantidade de pontos futsal: "));
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

				do {

					String nome = JOptionPane.showInputDialog("Qual o nome do Jogador(a) de bassquete: ");

					letraOuNao = somenteLetras(nome);

					if (letraOuNao) {
						jogadorBasqueteObjeto.setNomeAtleta(nome);
					}

				} while (!letraOuNao);
				int idadeTemporaria;
				do {

					idadeTemporaria = validaInteiroRetornaInt(
							JOptionPane.showInputDialog("Digite a idade do jogador(a) de Basquete: "));
					if (idadeTemporaria != 0) {
						jogadorBasqueteObjeto.setIdade(idadeTemporaria);
					}
				} while (idadeTemporaria == 0);

				do {
					String bracoMaisForte = JOptionPane.showInputDialog("Qual a braco mais forte: ");

					letraOuNao = somenteLetras(bracoMaisForte);

					if (letraOuNao) {
						jogadorBasqueteObjeto.setBracoMaisForte(bracoMaisForte);
					}

				} while (!letraOuNao);
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

		StringBuilder mensagem = new StringBuilder();

		mensagem.append("#######LISTA DE JOGADORES CADASTRADOS#######\n");

		for (JogadorFutsal jogadorFutsalLista : jogadoresFutsal) {

			mensagem.append("nome do jogador de futsal: ").append(jogadorFutsalLista.getNomeAtleta()).append("\n");

			mensagem.append("Idade do jogador de futsal: ").append(jogadorFutsalLista.getIdade()).append("\n");

			mensagem.append("------------------------------------\n");

			mensagem.append("Perna mais forte do jogador de futsal: ").append(jogadorFutsalLista.getPernaMaisForte())
					.append("\n");

			mensagem.append("Quantidadede gols do jogador de futsal: ").append(jogadorFutsalLista.getQtdGols())
					.append("\n");

			mensagem.append("Salario do jogador de futsal: ").append(jogadorFutsalLista.getSalario()).append("\n");

			mensagem.append("Valor do patrocinio: ").append(jogadorFutsalLista.getPatrocinio()).append("\n");

		}

		mensagem.append("------------------------------------\n");

		for (JogadorBasquete jogadorBasquetelLista : jogadoresBasquete) {

			mensagem.append("nome do jogador de Basquete: ").append(jogadorBasquetelLista.getNomeAtleta()).append("\n");

			mensagem.append("Idade do jogador de Basquete: ").append(jogadorBasquetelLista.getIdade()).append("\n");

			mensagem.append("------------------------------------\n");

			mensagem.append("Perna mais forte do jogador de Basquete: ")
					.append(jogadorBasquetelLista.getBracoMaisForte()).append("\n");

			mensagem.append("Quantidadede gols do jogador de Basquete: ").append(jogadorBasquetelLista.getQntPontos())
					.append("\n");

			mensagem.append("Salario do jogador de Basquete: ").append(jogadorBasquetelLista.getSalario()).append("\n");

			mensagem.append("Valor do patrocinio: ").append(jogadorBasquetelLista.getPatrocinio()).append("\n");
		}
		mensagem.append("#######FIM DA LISTA DE JOGADORES CADASTRADOS#######\n");
		JOptionPane.showMessageDialog(null, mensagem.toString(), "Lista de atletas", JOptionPane.INFORMATION_MESSAGE);

	}

	public static int validaInteiroRetornaInt(String numeroString) {
		int numeroInteiro = 0;

		if (numeroString == null || numeroString.isBlank()) {
			JOptionPane.showMessageDialog(null, "valor invalido");
		} else {
			try {
				numeroInteiro = Integer.parseInt(numeroString);

				if (numeroInteiro == 0) {
					JOptionPane.showMessageDialog(null, "Zero nao é permitido");
					numeroInteiro = 0;
				}

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

				if (numeroDecimal == 0.0) {
					JOptionPane.showMessageDialog(null, "Zero nao é permitido");
					numeroDecimal = 0.0;
				}

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

	public static boolean somenteLetras(String textoRecebido) {
		if (textoRecebido == null || textoRecebido.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Invalido");
			return false;
		}
		// for tradicional
		int qtdCaracterString = textoRecebido.length();

		for (int indice = 0; indice < qtdCaracterString; indice++) {

			char caracterAtual = textoRecebido.charAt(indice);

			if (!Character.isLetter(caracterAtual)) {
				JOptionPane.showMessageDialog(null, "Digite somente Letras!");
				return false;

			}

		}
		return true;
	}

}