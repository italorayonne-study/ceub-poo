package br.com.ceub.rayone.discursiva03;

import java.util.ArrayList;
import java.util.List;

import br.com.ceub.rayone.discursiva03.utils.Historic;
import br.com.ceub.rayone.discursiva03.utils.Page;

public class Discursiva03Application {

	public static void main(String[] args) {

		Historic browsingHistory = new Historic();

		List<Page> pages = new ArrayList<Page>() {
			{
				add(0, new Page("Página Inicial", 1));
				add(1, new Page("Página de Livros", 2));
				add(2, new Page("Detalhes", 3));
			}
		};

		for (Page page : pages) {
			browsingHistory.next(page);
		}

		browsingHistory.previous(); // Go back to "Página de Livros"
		browsingHistory.previous(); // Go back to "Página Inicial"

	}

}
