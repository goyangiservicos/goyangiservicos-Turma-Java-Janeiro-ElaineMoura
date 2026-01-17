package validacaoTela;

public class ValidacaoTela {
	 private String cpf;

	    public void setCpf(String cpf) {
	        this.cpf = cpf;
	    }

	    public boolean validaCampoCpf() {

	        if (cpf == null) { //nao aceita vazio
	            return false;
	        }

	        cpf = cpf.trim(); //conta os caracteres 

	       
	        return cpf.matches("\\d{11}"); // se tiver 11 e for valido passa
	    }
	}