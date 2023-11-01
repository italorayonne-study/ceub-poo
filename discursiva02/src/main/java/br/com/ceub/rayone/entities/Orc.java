package br.com.ceub.rayone.entities;

public class Orc extends Monster{
    public Orc(String name, double health, double attack) {
        super(name, health, attack);
    }

    @Override
    public void bout(Creature target, String castedSkill) {
        super.bout(target, castedSkill);
    }

    public String attackWithClave() {
        return "Esmagamento Brutal.";
    }
}
