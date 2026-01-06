import java.util.Date; //importacao da classe Date

	public class DataAtual{

		public static void main(String [] args){
			System.out.println("Rodou no JAVA - Receba Asp.net");
			Date data = new Date(); 
	
			long tempo = data.getTime();
			int mes = data.getMonth()+1;
			int ano = data.getYear()+1900;

			System.out.println("Tempo: " + tempo);
			System.out.println("Mes: " + mes);
			System.out.println("Ano: " + ano);
	
		}
	}