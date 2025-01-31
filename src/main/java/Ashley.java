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
        TaskManager taskManager = new TaskManager();

        while (line != null) {
            if (line.equals("bye")) {
                System.out.println("        " + "Bye. Hope to see you again soon!");
                break;
            }
            else if (line.contains("mark")) {
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        int taskId = Integer.parseInt(Character.toString(c));
                        taskManager.setAsDone(taskId);
                        System.out.println("Task " + taskId + " has been marked as done.");
                        break; // Exit loop as soon as a digit is found
                    }
                }
            }
            else if (line.equals("list")) {
                taskManager.listTasks();
            } else {
                taskManager.addTask(line);
                System.out.println("        " + "Added:" + line);

            }
            line = in.nextLine();
        }
    }
}
