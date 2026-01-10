package codigoFonte;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args){
		System.out.println("#################Inicio Cadastro de Atletas############");
		Scanner entradaDeDados = new Scanner(System.in);
//JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal(); quando feito fora, sempre vai sobrescrever na lista nao é o ideal.
		
		
		String opcaoNovoCadastro;
		
		List<JogadorFutsal> jogadoresFutsal = new ArrayList<JogadorFutsal>();//lista dos cadastrados
		List<JogadorBasquete> jogadoresBasquete = new ArrayList<JogadorBasquete>();
		do {
		System.out.println("Digite F para jogador(a) de futsal ou B para jogador(a) de basquete");
		String opcao = entradaDeDados.next();
		
		if(opcao.equals("F")){
		JogadorFutsal jogadorFutsalObjeto = new JogadorFutsal();//sendo iniciado aqui para ser um obj novo e nao sobrescrever o anterior
		System.out.println("Digite o nome do jogador(a) de Futsal: ");
		jogadorFutsalObjeto.setNomeAtleta(entradaDeDados.next());
		
		System.out.println("Digite a idade do jogador(a) de Futsal: ");
		jogadorFutsalObjeto.setIdade(entradaDeDados.nextInt());
		
		System.out.println("Digite a perna mais forte do jogador(a) de Futsal: ");
		jogadorFutsalObjeto.setPernaMaisForte(entradaDeDados.next());
		
		System.out.println("Digite o valor por gol do jogador(a): ");
		jogadorFutsalObjeto.setValorPorGols(entradaDeDados.nextDouble());
		
		System.out.println("Digite quantidade de gols marcardos: ");
		jogadorFutsalObjeto.setQtdGols(entradaDeDados.nextInt());
		
		jogadorFutsalObjeto.setSalario(jogadorFutsalObjeto.calcularPagamento());
		jogadorFutsalObjeto.setPatrocinio(jogadorFutsalObjeto.calculoPatrocinio());
		
		jogadoresFutsal.add(jogadorFutsalObjeto); //jogar na lista
		
		System.out.println("O valor: "+jogadorFutsalObjeto.calcularPagamento());
		System.out.println("O valor: "+jogadorFutsalObjeto.calculoPatrocinio());
		
		System.out.println("Nome do jogador(a) é: " + jogadorFutsalObjeto.getNomeAtleta());
		System.out.println("A idade do jogador(a) é: " +jogadorFutsalObjeto.getIdade () );
		System.out.println("Perna mais forte do jogador(a) é: " + jogadorFutsalObjeto.getPernaMaisForte());
		System.out.println("Valor por gols do jogador(a) é: " + jogadorFutsalObjeto.getValorPorGols());
		System.out.println("Quantidade de gols do jogador(a) é: " + jogadorFutsalObjeto.getQtdGols());
		System.out.println("O valor do calculo de pagamento é: " + jogadorFutsalObjeto.calcularPagamento());
		System.out.println("Quantidade treinos semana: " + jogadorFutsalObjeto.qtdTreinoSemana());	
		System.out.println("Valor calculo patrocinio: " + jogadorFutsalObjeto.calculoPatrocinio());	
	        }
	
		if(opcao.equals("B")){
	    JogadorBasquete jogadorBasqueteObjeto = new JogadorBasquete(); 
		System.out.println("Digite o nome do jogador(a) de Basquete: ");
		
		jogadorBasqueteObjeto.setNomeAtleta(entradaDeDados.next());
		
		System.out.println("Digite a idade do jogador(a) de Basquete: ");
		jogadorBasqueteObjeto.setIdade(entradaDeDados.nextInt());
		
		System.out.println("Digite a braco mais forte do jogador(a) de Basquete: ");
		jogadorBasqueteObjeto.setBracoMaisForte(entradaDeDados.next());

		System.out.println("Digite o valor por ponto do Basquete: ");
		jogadorBasqueteObjeto.setValorPorPontos(entradaDeDados.nextDouble()); 
		
		System.out.println("Digite quantidade de pontos marcardos: ");
		jogadorBasqueteObjeto.setQntPontos(entradaDeDados.nextInt());
		
		jogadorBasqueteObjeto.setSalario(jogadorBasqueteObjeto.calcularPagamento());
		jogadorBasqueteObjeto.setPatrocinio(jogadorBasqueteObjeto.calculoPatrocinio());
		
		jogadoresBasquete.add(jogadorBasqueteObjeto); 
			
		System.out.println("Nome do jogador(a) é: " + jogadorBasqueteObjeto.getNomeAtleta() );
		System.out.println("A idade do jogador(a) é: " + jogadorBasqueteObjeto.getIdade() );
		System.out.println("Braco mais forte do jogador(a) é: " + jogadorBasqueteObjeto.getBracoMaisForte());
		System.out.println("Valor por pontos do jogador(a) é: " + jogadorBasqueteObjeto.getValorPorPontos());
		System.out.println("Valor por pontos do jogador(a) é: " + jogadorBasqueteObjeto.getQntPontos());
		System.out.println("O valor do salario: " + jogadorBasqueteObjeto.calcularPagamento());
		System.out.println("Quantidade treinos semana: " + jogadorBasqueteObjeto.qtdTreinoSemana());
		System.out.println("Valor calculo patrocinio: " + jogadorBasqueteObjeto.calculoPatrocinio());	
		}
		
		System.out.println("Deseja cadastrar mais um atleta (S/N)?");
		opcaoNovoCadastro = entradaDeDados.next();
		
		}while(opcaoNovoCadastro.equals("S"));
		
	System.out.println("#################Fim do Cadastro de Atletas############");
	}

} 
