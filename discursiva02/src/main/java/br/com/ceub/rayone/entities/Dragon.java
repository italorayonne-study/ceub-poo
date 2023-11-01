package br.com.ceub.rayone.entities;

public class Dragon extends Monster {
    public Dragon(String name, double health, double attack) {
        super(name, health, attack);
    }

    @Override
    protected void bout(Creature target, String skillCasted) {
        super.bout(target, skillCasted);
    }

    public String castFire() {
        return "Esfera Flamejante";
    }
}
