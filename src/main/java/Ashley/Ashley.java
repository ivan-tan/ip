package Ashley;

import java.util.Scanner;

public class Ashley {
    public static final String LINE_SEPARATOR = "---------------------------------------------------";

    public static void main(String[] args) {
        printWelcomeMessage();
        Scanner in = new Scanner(System.in);
        TaskManager taskManager = new TaskManager();

        while (true) {
            String userInput = in.nextLine().trim();
            try {
                if (userInput.equalsIgnoreCase("bye")) {
                    printExitMessage();
                    break;
                }
                if (userInput.equalsIgnoreCase("list")) {
                    taskManager.listTasks();
                } else if (userInput.startsWith("delete")) {
                    handleDelete(userInput, taskManager);
                } else if (userInput.startsWith("mark")) {
                    handleMark(userInput, taskManager, true);
                } else if (userInput.startsWith("unmark")) {
                    handleMark(userInput, taskManager, false);
                } else if (userInput.startsWith("todo") || userInput.startsWith("deadline") || userInput.startsWith("event")) {
                    handleTaskCreation(userInput, taskManager);
                } else {
                    handleRubbishMessage();
                }
            } catch (AshleyException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("what task number you referring to?");
            } catch (IndexOutOfBoundsException e) {
                System.out.println("got no such task number");
            } finally {
                System.out.println(LINE_SEPARATOR);
            }
        }
    }

    private static void handleTaskCreation(String input, TaskManager taskManager) throws AshleyException {
        Task newTask = null;

        if (input.startsWith("todo")) {
            String description = input.replaceFirst("todo", "").trim();
            if (description.isEmpty()) {
                throw new AshleyException("todo what??");
            }
            newTask = new Todo(description);
        } else if (input.startsWith("deadline")) {
            String[] parts = input.substring(8).split(" by ");
            String description = parts[0].trim();
            if (description.isEmpty()) {
                throw new AshleyException("huh?? what kind of deadline is dis?");
            }
            if (!input.contains(" by ")) {
                throw new AshleyException("by when?");
            }
            if (parts.length < 2 || parts[1].trim().isEmpty()) {
                throw new AshleyException("by when?");
            }
            newTask = new Deadline(description, parts[1].trim());
        } else if (input.startsWith("event")) {
            String content = input.replaceFirst("event", "").trim();
            if (content.isEmpty()) {
                throw new AshleyException("simi event");
            }
            if (!content.contains(" from ") || !content.contains(" to ")) {
                throw new AshleyException("from when to when");
            }
            String[] parts = content.split(" from ");
            String description = parts[0].trim();
            if (description.isEmpty()) {
                throw new AshleyException("simi event");
            }
            String[] timeParts = parts[1].split(" to ");
            if (timeParts.length < 2) {
                throw new AshleyException("from when to when");
            }
            String from = timeParts[0].trim();
            String to = timeParts[1].trim();
            if (from.isEmpty() || to.isEmpty()) {
                throw new AshleyException("from when to when");
            }
            newTask = new Event(description, from, to);
        }
        if (newTask != null) {
            taskManager.addTask(newTask);
            System.out.println("Ok add liao:\n  " + newTask);
            System.out.println("Now have " + taskManager.getTaskCount() + " task(s)");
        }
    }

    private static void handleMark(String input, TaskManager taskManager, boolean isDone) {
        int taskId = Integer.parseInt(input.split(" ")[1]);
        if (isDone) {
            taskManager.markAsDone(taskId);
            System.out.println("Ok mark as done alr:\n  " + taskManager.getTaskToString(taskId));
        } else {
            taskManager.markAsNotDone(taskId);
            System.out.println("Ok mark as not done yet:\n  " + taskManager.getTaskToString(taskId));
        }
    }

    private static void handleDelete(String input, TaskManager taskManager) throws AshleyException {
        try {
            String[] parts = input.split(" ");
            if (parts.length < 2) {
                throw new AshleyException("delete which one?");
            }
            int taskId = Integer.parseInt(parts[1]);
            String taskDesc = taskManager.getTaskToString(taskId);
            taskManager.deleteTask(taskId);
            System.out.println("Noted. I've removed this task:\n  " + taskDesc);
            System.out.println("Now you have " + taskManager.getTaskCount() + " tasks in the list.");
        } catch (NumberFormatException e) {
            throw new AshleyException("give me a proper number to delete leh");
        }
    }


    private static void printWelcomeMessage() {
        System.out.println(LINE_SEPARATOR + "\nHello! I'm Ashley\nWhat can I do for you?\n" + LINE_SEPARATOR);
    }

    private static void printExitMessage() {
        System.out.println("bye ttyl");
    }

    private static void handleRubbishMessage() throws AshleyException {
        throw new AshleyException("what are you talking about?");
    }
}
