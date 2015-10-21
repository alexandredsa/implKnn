package impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import bean.Personagem;
import bean.PersonagemDiff;
import bean.PersonagemDiffBuilder;

import comparator.PersonagemDiffChainedComparator;
import comparator.PersonagemDiffDistanciaComparator;

public class KnnPersonagem {

	public static String getClasse(List<Personagem> conjPersonagem,
			Personagem desconhecido, int range) {

		List<PersonagemDiff> diffAttributes = getAttributesDiff(conjPersonagem,
				desconhecido);

		Collections.sort(diffAttributes, new PersonagemDiffChainedComparator(new PersonagemDiffDistanciaComparator()));

		return getClasseModa(diffAttributes, range);
	}

	/**
	 * 
	 * @param diffAttributes Lista com os objetos Personagem instanciados de acordo com a divergência entre os atributos do conjunto e objeto desconhecido.
	 * @param range Quantidade de exemplos do conjunto a serem utilizados como critério.
	 * @return Classe que mais aparece dentro do intervalo solicitado no conjunto de dados passado.
	 */
	private static String getClasseModa(List<PersonagemDiff> diffAttributes,
			int range) {
		HashMap<String, Integer> mClasse = getSomaAttributesClasse(
				diffAttributes, range);
		Entry<String, Integer> classe = null;

		for (Entry<String, Integer> entry : mClasse.entrySet()) {
			if (classe == null || entry.getValue() > classe.getValue()) {
				classe = entry;
			}
		}

		return classe.getKey();
	}

	private static HashMap<String, Integer> getSomaAttributesClasse(
			List<PersonagemDiff> diffAttributes, int range) {
		HashMap<String, Integer> mClasse = new HashMap<>();

		for (int i = 0; i < range; i++) {
			if (mClasse.get(diffAttributes.get(i).getClasse()) != null) {
				mClasse.put(diffAttributes.get(i).getClasse(),
						mClasse.get(diffAttributes.get(i).getClasse()) + 1);
			} else {
				mClasse.put(diffAttributes.get(i).getClasse(), 1);
			}
		}

		return mClasse;

	}

	/**
	 * 
	 * @param conjPersonagem
	 *            Lista com objetos Personagem a seres comparados. Conjunto de
	 *            dados.
	 * @param desconhecido
	 *            Objeto Personagem desconhecido que deverá ser comparado ao
	 *            conjunto de dados passado.
	 * @return Lista com objetos contendo a diferença entre o objeto de cada
	 *         junto comparado ao objeto Personagem desconhecido.
	 */
	private static List<PersonagemDiff> getAttributesDiff(
			List<Personagem> conjPersonagem, Personagem desconhecido) {
		List<PersonagemDiff> lstAtributes = new ArrayList<>();

		for (Personagem personagem : conjPersonagem) {
			lstAtributes.add(new PersonagemDiffBuilder(personagem, desconhecido)
					.constroi());
		}

		return lstAtributes;

	}

}
