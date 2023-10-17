package br.com.ceub.rayone;

import java.util.Scanner;

import br.com.ceub.rayone.repositories.DrinkRepository;
import br.com.ceub.rayone.entities.Drink;
import br.com.ceub.rayone.helper.Formatter;

public class Main {

    public static void main(String[] args) {
        DrinkRepository repository = new DrinkRepository();

        Scanner input = new Scanner(System.in); 

        System.out.println("╔══════════════════════════╗");
        System.out.println("║      Menu de Bebidas     ║");
        System.out.println("╠══════════════════════════╣");

        for (Drink drink : repository.getAll()) {
            System.out.println("║ " + drink.getId() + ". " + drink.getName()
                    + Formatter.addSpaces(22 - drink.getName().length()) + "║");
        }
        System.out.println("╚══════════════════════════╝");
        System.out.println("Escolha o número da bebida desejada:");

        int optionDrink = input.nextInt();

        if (repository.getPriceById(optionDrink) == null) {
            System.out.println("Não foram encontradas bebidas para esta opção");
        } else {

            System.out.println("R$ " + repository.getPriceById(optionDrink));
        }

        input.close();

    }
}