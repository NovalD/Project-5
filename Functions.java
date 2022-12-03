
/**
 * Write a description of class UF here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Functions
{
    public static void println(String text, int time) {
        System.out.println(text);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static String displayGraphical(int value1, int value2, String symbol) {
        if(value2 < value1) {
            return "error";
        }

        String text = "[";
        int numberOfSymbols = 0;
        int numberOfWhiteSpace = 20;

        float filledOut = (float)value1 / (float)value2;
        numberOfSymbols = (int)(filledOut * 20);
        for(int i = 0; i < numberOfSymbols; i++) {
            text += symbol;
        }
        numberOfWhiteSpace -= numberOfSymbols;
        for(int i = 0; i < numberOfWhiteSpace; i++) {
            text += " ";
        }
        text += "] (" + value1 + " / " + value2 + ")";
        return text;
    }
}
