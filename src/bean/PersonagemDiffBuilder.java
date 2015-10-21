package bean;

import java.util.HashMap;

import utils.DistanciaEuclidiana;

public class PersonagemDiffBuilder {
	private PersonagemDiff personagemDiff = new PersonagemDiff();

	private Personagem pAmostra;
	private Personagem pDesconhecido;
	private DistanciaEuclidiana distanciaEuclidiana;

	public PersonagemDiffBuilder(Personagem amostra, Personagem desconhecido) {
		this.pAmostra = amostra;
		this.pDesconhecido = desconhecido;
		distanciaEuclidiana = new DistanciaEuclidiana(getAtributos());
	}

	public PersonagemDiff constroi() {
		personagemDiff.setDistancia(distanciaEuclidiana.getDistancia());
		personagemDiff.setClasse(pAmostra.getClasse());
		personagemDiff.setNome(pAmostra.getNome());

		return personagemDiff;
	}

	private HashMap<Double, Double> getAtributos() {
		HashMap<Double, Double> atributos = new HashMap<>();

		atributos.put(pAmostra.getCabelo(), pDesconhecido.getCabelo());
		atributos.put(pAmostra.getIdade(), pDesconhecido.getIdade());
		atributos.put(pAmostra.getPeso(), pDesconhecido.getPeso());

		return atributos;
	}

	@Deprecated
	private double getDiffAttr(double attr1, double attr2) {
		if (Math.max(attr1, attr2) == attr1)
			return attr1 - attr2;
		else
			return attr2 - attr1;
	}

}
