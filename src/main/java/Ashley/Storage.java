package Ashley;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Storage {
    private String filePath;

    public Storage(String filePath) {
        this.filePath = filePath;
    }

    public void save(Task[] tasks, int taskCount) throws IOException {
        File f = new File(filePath);
        if (f.getParentFile() != null && !f.getParentFile().exists()) {
            f.getParentFile().mkdirs();
        }

        FileWriter fw = new FileWriter(f);
        for (int i = 0; i < taskCount; i++) {
            Task t = tasks[i];
            String type = (t instanceof Todo) ? "T" : (t instanceof Deadline) ? "D" : "E";
            String isDone = t.getStatusIcon().equals("X") ? "1" : "0";
            String line = type + " | " + isDone + " | " + t.getDescription();

            // Append extra date info based on task type
            if (t instanceof Deadline) {
                line += " | " + ((Deadline) t).getBy();
            } else if (t instanceof Event) {
                line += " | " + ((Event) t).getFrom() + " | " + ((Event) t).getTo();
            }

            fw.write(line + System.lineSeparator());
        }
        fw.close();
    }

    public int load(Task[] tasks) throws IOException {
        File f = new File(filePath);
        if (!f.exists()) return 0;

        int count = 0;
        Scanner s = new Scanner(f);
        while (s.hasNext() && count < 100) {
            String line = s.nextLine();
            String[] parts = line.split(" \\| ");
            Task t = null;

            if (parts[0].equals("T")) {
                t = new Todo(parts[2]);
            } else if (parts[0].equals("D")) {
                t = new Deadline(parts[2], parts[3]); // Load 'by' date
            } else if (parts[0].equals("E")) {
                t = new Event(parts[2], parts[3], parts[4]); // Load 'from' and 'to'
            }

            if (t != null) {
                if (parts[1].equals("1")) t.markAsDone();
                tasks[count] = t;
                count++;
            }
        }
        s.close();
        return count;
    }
}