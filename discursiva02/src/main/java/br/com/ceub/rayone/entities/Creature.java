package br.com.ceub.rayone.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Creature {
    protected String name;
    protected double health;
    protected double attack;

    protected void bout(Creature target, String skillCasted) {

        target.health -= this.getAttack();

        System.out.println(this.name + " atacou " + target.getName() + " com a habilidade " + skillCasted);
    }
}
