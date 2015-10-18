
package main;

import impl.KnnPersonagem;

import java.util.Arrays;

import bean.Personagem;

public class Main {

	public static void main(String[] args) {
			Personagem p1 = new Personagem();
			p1.setCabelo(5.1);
			p1.setClasse("Iris-setosa");
			p1.setIdade(3.5);
			p1.setPeso(1.4);
			p1.setNome("Alex");
			
			Personagem p2 = new Personagem();
			p2.setCabelo(7);
			p2.setClasse("Iris-versicolor");
			p2.setIdade(3.2);
			p2.setPeso(4.7);
			p2.setNome("Shela");
			
			Personagem p3 = new Personagem();
			p3.setCabelo(6.3);
			p3.setClasse("Iris-versicolor");
			p3.setIdade(3.3);
			p3.setPeso(4.7);
			p3.setNome("Courtney");
			
			Personagem ds = new Personagem();
			ds.setCabelo(6.1);			
			ds.setIdade(2.8);
			ds.setPeso(4.0);
			ds.setNome("Coiso");
			
			String classe = KnnPersonagem.getClasse(Arrays.asList(p1, p2, p3), ds, 1);
			
			ds.setClasse(classe);
			System.out.println(ds);
			

	}

}
