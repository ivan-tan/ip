package Ashley;

import java.io.IOException;

public class TaskManager {
    private Task[] tasks = new Task[100];
    private int taskCount = 0;
    private Storage storage;

    public TaskManager(Storage storage) {
        this.storage = storage;
        try {
            this.taskCount = storage.load(tasks); // Load existing data on startup
        } catch (IOException e) {
            System.out.println("Could not load data.");
        }
    }

    private void triggerSave() {
        try {
            storage.save(tasks, taskCount); // Tell storage to save current state
        } catch (IOException e) {
            System.out.println("Error saving to disk!");
        }
    }

    public void addTask(Task task) {
        tasks[taskCount] = task;
        taskCount++;
        triggerSave();
    }

    public void listTasks() {
        for (int taskNum = 1; taskNum < taskCount; taskNum++) {
            System.out.println(taskNum + ":" + tasks[taskNum].toString());
        }
    }

    public void markAsDone(int taskId) {
        validateMark(taskId);
        tasks[taskId].markAsDone();
        triggerSave();
    }

    public void markAsNotDone(int taskId) {
        validateMark(taskId);
        tasks[taskId].markAsNotDone();
        triggerSave();
    }

    public void validateMark(int taskId) throws IndexOutOfBoundsException {
        if (taskId < 1 || taskId > taskCount) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String getTaskToString(int taskId) {
        return tasks[taskId].toString();
    }

    public int getTaskCount() {
        return taskCount - 1;
    }

}
