package bean;

public class PersonagemDiff {
	private Personagem personagemDiff = new Personagem();

	private Personagem pAmostra;
	private Personagem pDesconhecido;

	public PersonagemDiff(Personagem amostra, Personagem desconhecido) {
		this.pAmostra = amostra;
		this.pDesconhecido = desconhecido;
	}

	public Personagem constroi() {
		personagemDiff.setNome(pAmostra.getNome());
		personagemDiff.setCabelo(getDiffAttr(pDesconhecido.getCabelo(),
				pAmostra.getCabelo()));

		personagemDiff.setIdade(getDiffAttr(pDesconhecido.getIdade(),
				pAmostra.getIdade()));

		personagemDiff.setPeso(getDiffAttr(pDesconhecido.getPeso(),
				pAmostra.getPeso()));

		personagemDiff.setClasse(pAmostra.getClasse());

		return personagemDiff;

	}

	private double getDiffAttr(double attr1, double attr2) {
		if (Math.max(attr1, attr2) == attr1)
			return attr1 - attr2;
		else
			return attr2 - attr1;
	}

}
