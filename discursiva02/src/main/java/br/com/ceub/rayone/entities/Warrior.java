package br.com.ceub.rayone.entities;

public class Warrior extends Humanoid {

    public Warrior(String name, double health, double attack) {
        super(name, health, attack);
    }

    @Override
    public void bout(Creature target, String skillCasted) {
        super.bout(target, skillCasted);
    }

    public String attackWithSword() {
        return "Lâmina Resplendor.";
    }
}
