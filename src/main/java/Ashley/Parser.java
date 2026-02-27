package Ashley;

import java.io.IOException;

public class Parser {

    public static void parse(String fullCommand, TaskManager taskManager, Ui ui) throws AshleyException {
        String[] words = fullCommand.trim().split(" ", 2);
        String commandWord = words[0].toLowerCase();
        String arguments = words.length > 1 ? words[1].trim() : "";

        try {
            switch (commandWord) {
            case "list":
                taskManager.listTasks();
                break;
            case "mark":
                handleMark(arguments, taskManager, ui, true);
                break;
            case "unmark":
                handleMark(arguments, taskManager, ui, false);
                break;
            case "todo":
                handleTodo(arguments, taskManager, ui);
                break;
            case "deadline":
                handleDeadline(arguments, taskManager, ui);
                break;
            case "event":
                handleEvent(arguments, taskManager, ui);
                break;
            case "delete":
                handleDelete(arguments, taskManager, ui);
                break;
            default:
                throw new AshleyException("what are you talking about?");
            }
        } catch (IOException e) {
            ui.showError("cannot save changes sia" + e.getMessage());
        } catch (NumberFormatException | IndexOutOfBoundsException e) {
            ui.showError("what task you referring to sia");
        }
    }

    private static void handleTodo(String args, TaskManager tm, Ui ui) throws AshleyException, IOException {
        if (args.isEmpty()) {
            throw new AshleyException("todo what??");
        }
        Task newTask = new Todo(args);
        tm.addTask(newTask);
        ui.showTaskAdded(newTask, tm.getTaskCount());
    }

    private static void handleDeadline(String args, TaskManager tm, Ui ui) throws AshleyException, IOException {
        if (!args.contains(" by ")) {
            throw new AshleyException("by when leh? Use by");
        }
        String[] parts = args.split(" by ", 2);
        if (parts[0].trim().isEmpty() || parts[1].trim().isEmpty()) {
            throw new AshleyException("description and time cannot be empty la!");
        }
        Task newTask = new Deadline(parts[0].trim(), parts[1].trim());
        tm.addTask(newTask);
        ui.showTaskAdded(newTask, tm.getTaskCount());
    }

    private static void handleEvent(String args, TaskManager tm, Ui ui) throws AshleyException, IOException {
        if (!args.contains(" from ") || !args.contains(" to ")) {
            throw new AshleyException("from when to when leh? Use from and to");
        }
        String[] parts = args.split(" from ", 2);
        String description = parts[0].trim();
        String[] timeParts = parts[1].split(" to ", 2);

        if (description.isEmpty() || timeParts[0].trim().isEmpty() || timeParts[1].trim().isEmpty()) {
            throw new AshleyException("event details cannot be empty la!");
        }

        Task newTask = new Event(description, timeParts[0].trim(), timeParts[1].trim());
        tm.addTask(newTask);
        ui.showTaskAdded(newTask, tm.getTaskCount());
    }

    private static void handleMark(String args, TaskManager tm, Ui ui, boolean isDone) throws IOException {
        int index = Integer.parseInt(args);
        if (isDone) {
            tm.markAsDone(index);
            ui.sendMessage("Ok mark as done alr:\n  " + tm.getTaskToString(index));
        } else {
            tm.markAsNotDone(index);
            ui.sendMessage("Ok mark as not done yet:\n  " + tm.getTaskToString(index));
        }
    }

    private static void handleDelete(String args, TaskManager tm, Ui ui) throws IOException {
        int index = Integer.parseInt(args);
        String desc = tm.getTaskToString(index);
        tm.deleteTask(index);
        ui.showTaskDeleted(desc, tm.getTaskCount());
    }
}
