import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    void printMenu(){
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("  ------ JFileCommander ------  ");
        System.out.println("1. Copy file");
        System.out.println("2. Move file");
        System.out.println("3. Delete file");
        System.out.println("4. Search by name");
        System.out.println("5. Todo:");
        System.out.println("6. Todo:");
        System.out.println("7. Todo:");
        System.out.println("8. Exit");
    }

    String readText(String prompt){
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    int readChoice(){
        while(true) {
            System.out.print("Your choice : ");
            if(scanner.hasNextInt()) {
                int choice = scanner.nextInt();
                scanner.nextLine();
                return choice;
            } else {
                scanner.next();
                System.out.println("This isn't a number, try again.");
                }
            }
    }
}
