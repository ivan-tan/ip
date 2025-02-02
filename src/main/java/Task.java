public class Task {
    private String description;
    private boolean isDone;
    private int taskId;

    public Task(String description, int taskId) {
        this.description = description;
        this.isDone = false;
        this.taskId = taskId;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " "); // mark done task with X
    }

    public void setDone(){
        isDone = true;
    }

    public String getDescription() {
        return description;
    }
}