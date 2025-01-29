import java.util.Arrays;
import java.util.Scanner;


public class Ashley {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Ashley");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------------------");

        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        String[] tasks = new String[100];
        int taskCounter = 0;
        while (line != null) {
            if (line.equals("bye")) {
                System.out.println("        " + "Bye. Hope to see you again soon!");
                break;
            }
            if (line.equals("list")) {
                int x = 1;
                String[] listToBePrinted = Arrays.copyOf(tasks, taskCounter);
                for (String task : listToBePrinted) {
                    System.out.println(x + ":" + task);
                    x++;
                }
                line = in.nextLine();
            } else {
                tasks[taskCounter] = line;
                taskCounter++;
                System.out.println("        " + "Added:" + line);
                line = in.nextLine();
            }
        }
    }
}
