public class TaskManager {
    private int taskCount = 0;
    private Task[] tasks = new Task[100];

    public void addTask(String taskDescription) {
        tasks[taskCount] = new Task(taskDescription, taskCount+1); //the ID starts with 1
        taskCount++;
    }

    public void setAsDone(int taskId) {
        tasks[taskId-1].setDone(); //tasks array starts from 0 while task ID starts with 1
    }

    public void listTasks() {
        for (int i = 0; i < taskCount; i++) {
            System.out.println(tasks[i].taskId + ":" + "[" + tasks[i].getStatusIcon() + "]" + tasks[i].description);

        }
    }

}
