package impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import comparator.PersonagemCabeloComparator;
import comparator.PersonagemChainedComparator;
import comparator.PersonagemIdadeComparator;
import comparator.PersonagemPesoComparator;

import bean.Personagem;
import bean.PersonagemDiff;

public class KnnPersonagem {

	public static String getClasse(List<Personagem> conjPersonagem,
			Personagem desconhecido, int range) {

		List<Personagem> diffAttributes = getAttributesDiff(conjPersonagem,
				desconhecido);

		Collections.sort(diffAttributes, new PersonagemChainedComparator(
				new PersonagemIdadeComparator(),
				new PersonagemCabeloComparator(),
				new PersonagemPesoComparator()));

		return getClasseModa(diffAttributes, range);
	}

	/**
	 * 
	 * @param diffAttributes Lista com os objetos Personagem instanciados de acordo com a divergência entre os atributos do conjunto e objeto desconhecido.
	 * @param range Quantidade de exemplos do conjunto a serem utilizados como critério.
	 * @return Classe que mais aparece dentro do intervalo solicitado no conjunto de dados passado.
	 */
	private static String getClasseModa(List<Personagem> diffAttributes,
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
			List<Personagem> diffAttributes, int range) {
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
	private static List<Personagem> getAttributesDiff(
			List<Personagem> conjPersonagem, Personagem desconhecido) {
		List<Personagem> lstAtributes = new ArrayList<>();

		for (Personagem personagem : conjPersonagem) {
			lstAtributes.add(new PersonagemDiff(personagem, desconhecido)
					.constroi());
		}

		return lstAtributes;

	}

}
