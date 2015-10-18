package bean;

import java.text.MessageFormat;

public class Personagem {
	private String nome;
	private double cabelo;
	private double idade;
	private double peso;
	private String classe;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getCabelo() {
		return cabelo;
	}

	public void setCabelo(double cabelo) {
		this.cabelo = cabelo;
	}

	public double getIdade() {
		return idade;
	}

	public void setIdade(double idade) {
		this.idade = idade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getClasse() {
		return classe;
	}

	public void setClasse(String classe) {
		this.classe = classe;
	}

	@Override
	public String toString() {
		return MessageFormat.format(
				"Nome:{0}\nCabelo:{1}\nPeso:{2}\nIdade:{3}\nClasse:{4}",
				this.nome, this.cabelo, this.peso,this.idade, this.classe);
	}

}
