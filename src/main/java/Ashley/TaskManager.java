package Ashley;

import java.util.ArrayList;
import java.io.IOException;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();
    private Storage storage;

    public TaskManager(Storage storage) throws IOException {
        this.storage = storage;
        this.tasks = storage.load();
    }

    public TaskManager(Storage storage, ArrayList<Task> emptyList) {
        this.storage = storage;
        this.tasks = emptyList;
    }

    public void addTask(Task task) {
        tasks.add(task);
        triggerSave();
    }

    public void deleteTask(int taskId) {
        validateIndex(taskId);
        tasks.remove(taskId - 1);
        triggerSave();
    }

    private void triggerSave() {
        try {
            storage.save(tasks);
        } catch (IOException e) {
            System.out.println("Cannot save to disk leh");
        }
    }


    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("dun hv any tasks");
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + 1 + ":" + tasks.get(i).toString());
        }
    }

    public void markAsDone(int taskId) {
        validateIndex(taskId);
        tasks.get(taskId - 1).markAsDone();
        triggerSave();
    }

    public void markAsNotDone(int taskId) {
        validateIndex(taskId);
        tasks.get(taskId - 1).markAsNotDone();
        triggerSave();
    }

    public void validateIndex(int taskId) throws IndexOutOfBoundsException {
        if (taskId < 1 || taskId > tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String getTaskToString(int taskId) {
        return tasks.get(taskId - 1).toString();
    }

    public int getTaskCount() {
        return tasks.size();
    }

}
