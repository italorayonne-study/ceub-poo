package br.com.ceub.rayone.Repositories;

import java.util.ArrayList;
import java.util.List;

import br.com.ceub.rayone.entities.Drink;

public class DrinkRepository {

    List<Drink> drinks = new ArrayList<Drink>() {
        {
            add(0, new Drink(1, "Refrigerante", 3.50));
            add(1, new Drink(2, "Água Mineral", 2.00));
            add(2, new Drink(3, "Suco de Laranja", 4.00));
            add(3, new Drink(4, "Café", 2.50));
        }
    };

    public List<Drink> getAll() {

        return drinks;
    }

    public Object getPriceById(int id) {

        for (Drink drink : drinks) {
            if (drink.getId() == id)

                return drink.getPrice();
        }

        return null;
    }
}
