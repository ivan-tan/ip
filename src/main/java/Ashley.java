import java.util.Scanner;

public class Ashley {
    public static final String LINE_SEPARATOR = "---------------------------------------------------";

    public static void main(String[] args) {
        printWelcomeMessage();

        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            String userInput = in.nextLine();

            if (userInput.equalsIgnoreCase("bye")) {
                printExitMessage();
                break;
            }
            if (userInput.equalsIgnoreCase("list")) {
                taskManager.listTasks();
            } else if (userInput.startsWith("mark ")) {
                handleMark(userInput, taskManager, true);
            } else if (userInput.startsWith("unmark ")) {
                handleMark(userInput, taskManager, false);
            } else {
                handleTaskCreation(userInput, taskManager);
            }
        }
    }

    private static void handleTaskCreation(String input, TaskManager taskManager) {
        Task newTask = null;

        if (input.startsWith("todo ")) {
            newTask = new Todo(input.substring(5).trim());
        } else if (input.startsWith("deadline ")) {
            String[] parts = input.substring(9).split(" by ");
            if (parts.length == 2) {
                newTask = new Deadline(parts[0].trim(), parts[1].trim());
            }
        } else if (input.startsWith("event ")) {
            // Format: event project meeting /from Mon 2pm /to 4pm
            String[] parts = input.substring(6).split(" from ");
            String description = parts[0].trim();
            String[] timeParts = parts[1].split(" to ");
            newTask = new Event(description, timeParts[0].trim(), timeParts[1].trim());
        }

        if (newTask != null) {
            taskManager.addTask(newTask);
            System.out.println("Got it. I've added this task:\n  " + newTask);
            System.out.println("Now you have " + taskManager.getTaskCount() + " task(s) in the list.");
        }
    }

    private static void handleMark(String input, TaskManager taskManager, boolean isDone) {
        int taskId = Integer.parseInt(input.split(" ")[1]);
        if (isDone) {
            taskManager.markAsDone(taskId);
            System.out.println("Nice! I've marked this task as done:\n  " + taskManager.getTaskToString(taskId));
        } else {
            taskManager.markasNotDone(taskId);
            System.out.println("OK, I've marked this task as not done yet:\n  " + taskManager.getTaskToString(taskId));
        }
    }


    private static void printWelcomeMessage() {
        System.out.println(LINE_SEPARATOR + "\nHello! I'm Ashley\nWhat can I do for you?\n" + LINE_SEPARATOR);
    }

    private static void printExitMessage() {
        System.out.println(LINE_SEPARATOR + "\nBye. Hope to see you again soon!\n" + LINE_SEPARATOR);
    }
}
