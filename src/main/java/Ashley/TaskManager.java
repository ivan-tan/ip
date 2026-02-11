package Ashley;

public class TaskManager {
    private Task[] tasks = new Task[100];
    private static int taskCount = 1;

    public void addTask(Task task) {
        tasks[taskCount] = task;
        taskCount++;
    }

    public void listTasks() {
        for (int taskNum = 1; taskNum < taskCount; taskNum++) {
            System.out.println(taskNum + ":" + tasks[taskNum].toString());
        }
    }

    public void markAsDone(int taskId) {
        validateMark(taskId);
        tasks[taskId].markAsDone();
    }

    public void markAsNotDone(int taskId) {
        validateMark(taskId);
        tasks[taskId].markAsNotDone();
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
