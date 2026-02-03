public class TaskManager {
    private Task[] tasks = new Task[100];
    private static int taskCount = 1;

    public void addTask(Task t) {
        tasks[taskCount] = t;
        taskCount++;
    }

    public void listTasks() {
        for (int taskNum = 1; taskNum < taskCount; taskNum++) {
            System.out.println(taskNum + ":" + tasks[taskNum].toString() );
        }
    }

    public void markAsDone(int taskId) {
        tasks[taskId].markAsDone();
    }

    public void markasNotDone(int taskId) {
        tasks[taskId].markAsNotDone();
    }

    public String getTaskDescription(int taskId) {
        return tasks[taskId].getDescription();
    }

}
