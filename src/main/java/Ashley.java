import java.util.Scanner;

public class Ashley {
    public static final String LINE_SEPARATOR = "---------------------------------------------------";

    public static void echo(String text) {
        System.out.println(LINE_SEPARATOR + "\n" + text + "\n" + LINE_SEPARATOR);
    }

    public static void main(String[] args) {
        System.out.println(LINE_SEPARATOR);
        System.out.println("Hello! I'm Ashley");
        System.out.println("What can I do for you?");
        System.out.println(LINE_SEPARATOR);

        Scanner in = new Scanner(System.in);

        while (true) {
            String line = in.nextLine();
            if (line.equalsIgnoreCase("bye")) {
                System.out.println(LINE_SEPARATOR);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(LINE_SEPARATOR);
                break;
            }
            echo(line);
        }
    }
}
