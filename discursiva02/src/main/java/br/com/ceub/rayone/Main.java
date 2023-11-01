package br.com.ceub.rayone;

import br.com.ceub.rayone.entities.Dragon;
import br.com.ceub.rayone.entities.Elf;
import br.com.ceub.rayone.entities.Orc;
import br.com.ceub.rayone.entities.Warrior;

public class Main {
    public static void main(String[] args) {
        Elf elf = new Elf("Eventrix", 150.00, 65.00);
        Warrior warrior = new Warrior("Garloc", 350.00, 85);

        Dragon dragon = new Dragon("Alcôra", 400, 110);
        Orc orc = new Orc("Hulavor", 380, 75);

        elf.bout(dragon, elf.shootArrows());
        warrior.bout(orc, orc.attackWithClave());

    }
}