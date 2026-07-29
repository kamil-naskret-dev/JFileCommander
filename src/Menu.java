import java.util.Scanner;

public class Menu {
    private final Scanner scanner = new Scanner(System.in);

    void printMenu(){
        System.out.println();
        System.out.println("----------------------------------------");
        System.out.println("  ------ JFileCommander ------  ");
        System.out.println("1. Todo:");
        System.out.println("2. Todo:");
        System.out.println("3. Todo:");
        System.out.println("4. Todo:");
        System.out.println("5. Todo:");
        System.out.println("6. Todo:");
        System.out.println("7. Todo:");
        System.out.println("8. Exit");
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
