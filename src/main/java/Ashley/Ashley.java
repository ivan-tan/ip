package Ashley;

import java.io.IOException;
import java.util.ArrayList;

/**
 * The main starting point where the chatbot runs.
 * The class initializes the user interface, storage, user command parser and task manager.
 */
public class Ashley {
    private Ui ui;
    private Storage storage;
    private TaskManager taskManager;

    public Ashley(String filepath) {
        ui = new Ui();
        storage = new Storage(filepath);
        try {
            taskManager = new TaskManager(storage);
        } catch (IOException e) {
            ui.showLoadingError();
            taskManager = new TaskManager(storage, new ArrayList<Task>());
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String userCommand = ui.readCommand();
                ui.showLine();
                if (userCommand.equalsIgnoreCase("bye")) {
                    isExit = true;
                    ui.showExit();
                } else {
                    Parser.parse(userCommand, taskManager, ui);
                }
            } catch (AshleyException e) {
                ui.showError(e.getMessage());
            } catch (Exception e) {
                ui.showError("Something went wrong sia: " + e.getMessage());
            } finally {
                if (!isExit) ui.showLine();
            }
        }
    }


    public static void main(String[] args) {
        new Ashley("./data/ashley.txt").run();
    }
}
