
/**
 * Write a description of class Choice here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Choice
{
    private Person caster;
    private String name;
    private int level;
    private double value;
    private int manaRequirement;

    public Choice(Person caster, String name, int level, double value, int manaRequirement) {
        this.caster = caster;
        this.name = name;
        this.level = level;
        
        this.value = value;
        
        this.manaRequirement = manaRequirement;
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return (int)(caster.getPower() * value * level);
    }

    public int getLevel() {
        return level;
    }

    public int getManaRequirement() {
        return manaRequirement * level;
    }
}
