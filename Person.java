import java.util.Scanner;
/**
 * Write a description of class Person here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Person
{
    private String name;

    protected int healthMax;
    protected int magicMax;
    protected int powerMax;

    protected int healthLeft;
    protected int magicspell;
    protected int powerC;

    
    protected Choice fire;
    protected Choice shocked;
    protected Choice healing;
    protected Choice attack;

    
    protected boolean alive;
    protected boolean isKnockedOut;
    

    public Person(String name, int healthMax, int magicMax, int powerMax) {
        this.name = name;
        this.healthMax = healthMax;
        this.magicMax = magicMax;
        this.powerMax = powerMax;

        this.healthLeft = healthMax;
        this.magicspell = magicMax;
        this.powerC = powerMax;

        
        attack = new Choice(this, "Attack", 1, 1, 1);
        fire = new Choice(this, "Fire Slash", 2, 1, 1);
        shocked = new Choice(this, "Shock", 1, 0.5, 2);
        healing = new Choice(this, "Healing", 1, 2, 3);
        
        
        
        alive = true;
        isKnockedOut = false;
        
    }

    @Override 
    public String toString() {
        String text = "";
        text += name + "\n";
        text += "Life:  " + healthLeft + " / " + healthMax + "\n";
        text += "Magic:  " + magicspell + " / " + magicMax + "\n";
        text += "Power: " + powerC + " / " + powerMax + "\n";
        return text; 
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return healthLeft;
    }

    public int getHealthMax() {
        return healthMax;
    }

    public int getMagic() {
        return magicspell;
    }

    public int getMagicMax() {
        return magicMax;
    }

    public int getPower() {
        return powerC;
    }

    public boolean isKnockedOut() {
        if(isKnockedOut) {
            Functions.println(name + " is knocked out and can't cast skills this round\n", 1000);
            isKnockedOut = false;
            return true;
        } else {
            return false;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void sustainDamage(int value) {
        if(value > 0) {
            healthLeft -= value;
            Functions.println(name + " has gotten " + value + " damage\n", 1000);
        }

        if (healthLeft <= 0) {
            alive = false;
        }
    }

    public boolean useMagic(int value) {
        if(value <= magicspell) {
            magicspell -= value;
            Functions.println(name + " has used " + value + " magic.", 1000);
            return true;
        } else {
            Functions.println(name + " doesn't have enough magic.", 1000);
            return false;
        }
    }

    public void cureLife(int value) {
        int difference = healthMax - healthLeft;
        if(value >= difference) {
            healthLeft = healthMax;
            Functions.println(name + " is fully healed.", 1000);
        } else {
            healthMax += value;
            Functions.println(name + " has healed " + value + " life points.", 1000);
        }
    }

    public void castAttack(Person enemy) {
        Functions.println(name + " casts " + attack.getName() + " on " + enemy.getName() + ".", 1000);
        if(useMagic(attack.getManaRequirement())) {
            enemy.sustainDamage(attack.getValue());
        }
    }
    
    public void castFire(Person enemy) {
        Functions.println(name + " casts " + fire.getName() + " on " + enemy.getName() + ".", 1000);
        if(useMagic(fire.getManaRequirement())) {
            enemy.sustainDamage(fire.getValue());
        }
    }

    public void castHealing() {
        Functions.println(name + " casts " + healing.getName() + ".", 1000);
        if(useMagic(healing.getManaRequirement())) {
            cureLife(healing.getValue());
        }
    }

    public void castShock(Person enemy) {
        Functions.println(name + " casts " + shocked.getName() + " on " + enemy.getName() + ".", 1000);
        if(useMagic(shocked.getManaRequirement())) {
            enemy.sustainDamage(shocked.getValue());
            enemy.isKnockedOut = true;
            Functions.println(enemy.getName() + " is knocked out.", 1000);
        }
    }
}
