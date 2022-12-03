import java.util.concurrent.ThreadLocalRandom;
/**
 * Write a description of class NPC here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class NPC extends Person
{
    public NPC(String name, int lifeMax, int magicMax, int powerMax) {
        super(name, lifeMax, magicMax, powerMax);
    }

    
    public void chooseSkill(Person enemy) {
        if(isKnockedOut()) {
            return;
        }

        if (magicspell == 0) {
            healthLeft = 0;
            Functions.println(getName() + " gives up because they have no magic.", 1000);
            return;
        }

        int decision;
        while(true) {
            decision = ThreadLocalRandom.current().nextInt(0, 4);

            if((decision == 1 && healing.getManaRequirement() > magicspell) || (decision == 1 && healthMax == healthLeft) || (decision == 2 && shocked.getManaRequirement() > magicspell)) {
                continue;
            } else {
                break;
            }
        }

        if(decision == 0) {
            castFire(enemy);
        } else if (decision == 1) {
            castHealing();
        } else if (decision == 2) {
            castShock(enemy);
        }
    }

    public void getStronger(double factor) {
        healthMax *= factor;
        magicMax *= factor;
        magicMax += 3;
        powerMax += factor;

        healthLeft = healthMax;
        magicspell = magicMax;
        powerC = powerMax;

        isKnockedOut = false;
        
    }
}
