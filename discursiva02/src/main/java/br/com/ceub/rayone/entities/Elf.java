package br.com.ceub.rayone.entities;

public class Elf extends Humanoid {

    public Elf(String name, double health, double attack) {
        super(name, health, attack);
    }

    @Override
    public void bout(Creature target, String castedSkill) {
        super.bout(target, castedSkill);
    }

    public String shootArrows() {
        return "Flechas à distância.";
    }
}
