package sisPessoa;

public class Animal {

	public Animal(String matricula, String nome, String nomeTutor) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.nomeTutor = nomeTutor;
	}

	private String matricula;
	private String nome;
	private String nomeTutor;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeTutor() {
		return nomeTutor;
	}

	public void setNomeTutor(String nomeTutor) {
		this.nomeTutor = nomeTutor;
	}

}
