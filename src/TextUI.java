import java.util.Scanner;

public class TextUI {
    Scanner sc = new Scanner(System.in);

    public void displayMsg(String... msg) {
        for (String s : msg) {
            System.out.println(s);
        }
    }

    public String stringInput(String... msg) {
        for (String s : msg) {
            System.out.println(s);
            return sc.nextLine();
        }
        return "";
    }}
