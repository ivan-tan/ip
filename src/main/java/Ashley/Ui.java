package Ashley;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Deals with the frontend of the chatbot.
 * Prints formatted messages and error notifications to the console.
 */
public class Ui {
    public static final String LINE_SEPARATOR = "---------------------------------------------------";
    private final Scanner in;

    public Ui() {
        this.in = new Scanner(System.in);
    }

    public String readCommand() {
        return in.nextLine();
    }

    public void showWelcome() {
        System.out.println(LINE_SEPARATOR + "\nhello what you want?\n" + LINE_SEPARATOR);
    }

    public void showLine() {
        System.out.println(LINE_SEPARATOR);
    }

    public void showError(String message) {
        System.out.println(message);
    }

    public void showLoadingError() {
        System.out.println("Cannot load tasks leh, starting with empty list.");
    }

    public void showExit() {
        System.out.println("bye ttyl");
    }

    public void sendMessage(String message) {
        System.out.println(message);
    }

    public void showTaskAdded(Task task, int totalTasks) {
        System.out.println("Ok add liao:\n  " + task);
        System.out.println("Now have " + totalTasks + " task(s)");
    }

    public void showTaskDeleted(String taskDescription, int totalTasks) {
        System.out.println("Ok I remove this task liao:\n  " + taskDescription);
        System.out.println("Now have " + totalTasks + " task(s)");
    }

    public void showSearchResults(ArrayList<Task> matchingTasks) {
        if (matchingTasks.isEmpty()) {
            System.out.println("got no such tasks with that keyword");
            return;
        }
        System.out.println("oh i found some tasks with that keyword");
        for (int i = 0; i < matchingTasks.size(); i++) {
            System.out.println((i + 1) + "." + matchingTasks.get(i).toString());
        }
    }
}
