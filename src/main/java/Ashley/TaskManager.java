package Ashley;

import java.util.ArrayList;

public class TaskManager {
    private ArrayList<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void deleteTask(int taskId) {
        validateIndex(taskId);
        tasks.remove(taskId-1);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("dun hv any tasks");
        }
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i+1 + ":" + tasks.get(i).toString());
        }
    }

    public void markAsDone(int taskId) {
        validateIndex(taskId);
        tasks.get(taskId-1).markAsDone();
    }

    public void markAsNotDone(int taskId) {
        validateIndex(taskId);
        tasks.get(taskId-1).markAsNotDone();
    }

    public void validateIndex(int taskId) throws IndexOutOfBoundsException {
        if (taskId < 1 || taskId > tasks.size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    public String getTaskToString(int taskId) {
        return tasks.get(taskId-1).toString();
    }

    public int getTaskCount() {
        return tasks.size();
    }

}
