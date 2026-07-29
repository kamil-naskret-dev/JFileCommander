import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean isRunning = true;
        FileOperations fileOperations = new FileOperations();

        while(isRunning) {
            menu.printMenu();
            int userChoice = menu.readChoice();

           switch(userChoice) {
               case 1: {
                   fileOperations.copyFile("folder","folder2");
               }
               break;
               case 2: {
                   System.out.println("TODO :");
               }
               break;
               case 3: {
                   System.out.println("TODO :");
               }
               break;
               case 4: {
                   System.out.println("TODO :");
               }
               break;
               case 5: {
                   System.out.println("TODO :");
               }
               break;
               case 6: {
                   System.out.println("TODO :");
               }
               break;
               case 7: {
                   System.out.println("TODO :");
               }
               break;
               case 8: {
                   System.out.println("Thanks for using JFileCommander.");
                   isRunning = false;
               }
               break;
               default: {
                   System.out.println("We don't manage this option choice. Try again.");
               }
           }
        }
    }
}