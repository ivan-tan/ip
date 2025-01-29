import java.util.Scanner;


public class Ashley {
    public static void main(String[] args) {
        System.out.println("Hello! I'm Ashley");
        System.out.println("What can I do for you?");
        System.out.println("---------------------------------------------------");
        String line;
        Scanner in = new Scanner(System.in);
        line = in.nextLine();
        while (line != null){
            if (line.equals("bye")){
                System.out.println("        Bye. Hope to see you again soon!");
                break;
            }
            System.out.println("        " + line);
            line = in.nextLine();
        }
    }
}
