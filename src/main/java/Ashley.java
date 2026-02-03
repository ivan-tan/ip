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
        TaskManager taskManager = new TaskManager();

        while (true) {
            String userInput = in.nextLine();
            if (userInput.equalsIgnoreCase("bye")) {
                System.out.println(LINE_SEPARATOR);
                System.out.println("Bye. Hope to see you again soon!");
                System.out.println(LINE_SEPARATOR);
                break;
            } else if (userInput.startsWith("Todo ")) {
                String taskDescription = userInput.substring(5).trim();
                taskManager.addTask(new Todo(taskDescription));
                System.out.println("added: " + taskDescription);
            } else if (userInput.startsWith("deadline ")) {
                // Example format: deadline return [description] by [time]
                String[] parts = userInput.substring(9).split(" by ");
                taskManager.addTask(new Deadline(parts[0], parts[1]));
                System.out.println("Got it. I've added this deadline: " + parts[0]);
            } else if (userInput.startsWith("event ")) {
                // Example format: event [description] from [start] to [end]
                String content = userInput.substring(6);
                String[] parts = content.split(" from ");
                String description = parts[0];
                String[] timeParts = parts[1].split(" to ");
                String from = timeParts[0];
                String to = timeParts[1];

                Event newEvent = new Event(description, from, to);
                taskManager.addTask(newEvent);

                System.out.println("Got it. I've added this event:");
                System.out.println("  " + newEvent);
            } else if (userInput.equalsIgnoreCase("list")) {
                taskManager.listTasks();
            } else if (userInput.startsWith("mark ")) {
                int taskId = Integer.parseInt(userInput.substring(5).trim());
                taskManager.markAsDone(taskId);
                System.out.println("marked " + taskManager.getTaskDescription(taskId) + " as done!");
            } else if (userInput.startsWith("unmark ")) {
                int taskId = Integer.parseInt(userInput.substring(7).trim());
                taskManager.markasNotDone(taskId);
                System.out.println("unmarked " + taskManager.getTaskDescription(taskId) + " as done!");
            }

        }

    }
}
