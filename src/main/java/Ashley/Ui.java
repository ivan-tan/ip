package Ashley;

import java.util.Scanner;

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
        System.out.println(LINE_SEPARATOR + "\nHello! I'm Ashley\nWhat can I do for you?\n" + LINE_SEPARATOR);
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
}
