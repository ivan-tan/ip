package Ashley;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * Handles loading tasks and saving tasks to disk, so tasks remain when user reloads the chatbot.
 */
public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(ArrayList<Task> tasks) throws IOException {
        File f = new File(filePath);
        if (!f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }

        FileWriter fw = new FileWriter(filePath);
        for (Task t : tasks) {
            String type = t instanceof Todo ? "T" : t instanceof Deadline ? "D" : "E";
            int status = t.getStatusIcon().equals("X") ? 1 : 0;
            String line = type + " | " + status + " | " + t.getDescription();

            if (t instanceof Deadline) {
                line += " | " + ((Deadline) t).getBy();
            } else if (t instanceof Event) {
                line += " | " + ((Event) t).from + " | " + ((Event) t).to;
            }
            fw.write(line + System.lineSeparator());
        }
        fw.close();
    }

    public ArrayList<Task> load() throws IOException {
        ArrayList<Task> loadedTasks = new ArrayList<>();
        File f = new File(filePath);
        if (!f.exists()) return loadedTasks;

        Scanner s = new Scanner(f);
        while (s.hasNext()) {
            String[] parts = s.nextLine().split(" \\| ");
            Task task = null;
            if (parts[0].equals("T")) task = new Todo(parts[2]);
            else if (parts[0].equals("D")) task = new Deadline(parts[2], parts[3]);
            else if (parts[0].equals("E")) task = new Event(parts[2], parts[3], parts[4]);

            if (task != null) {
                if (parts[1].equals("1")) task.markAsDone();
                loadedTasks.add(task);
            }
        }
        return loadedTasks;
    }
}