import java.util.Scanner;
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Player extends Person
{
    private static Scanner input = new Scanner(System.in);

    public Player(String name, int lifeMax, int magicMax, int powerMax) {
        super(name, lifeMax, magicMax, powerMax);
    }   

    public void chooseSkill(Person enemy) {
        if(!isKnockedOut()) {
            System.out.println("[1] Attack");
            System.out.println("[2] Fire Slash");
            System.out.println("[3] Shocked");
            System.out.println("[4] Healing");
            System.out.println("[5] Give up");
            System.out.print("Input: ");
            String command = input.next();

            if(command.equals("1")) {
                castAttack(enemy);
            } else if (command.equals("2")) {
                castFire(enemy);
            } else if (command.equals("3")) {
                castShock(enemy);
            } else if (command.equals("4")) {
                castHealing();
            } else if (command.equals("5")) {
                healthLeft = 0;
            }
        }
    }

    public void getStronger() {
        healthMax += 5;
        magicMax += 2;
        powerMax += 1;

        healthLeft = healthMax;
        magicspell = magicMax;
        powerC = powerMax;

        isKnockedOut = false;
    }
}
