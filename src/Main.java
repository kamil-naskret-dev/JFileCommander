import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean isRunning = true;

        while(isRunning) {
            menu.printMenu();
            int userChoice = menu.readChoice();

            switch(userChoice) {
                case 1: {
                    String sourcePath = menu.readText("Enter source file path: ");
                    String targetPath = menu.readText("Enter target file path: ");
                    try {
                        FileOperations.copyFile(sourcePath, targetPath);
                        System.out.println("File copied successfully.");
                    } catch (IOException | IllegalArgumentException e) {
                        System.out.println("Failed to copy file: " + e.getMessage());
                    }
                }
                break;
                case 2: {
                    String sourcePath = menu.readText("Enter source file path: ");
                    String targetPath = menu.readText("Enter target file path: ");
                    try {
                        FileOperations.moveFile(sourcePath, targetPath);
                        System.out.println("File moved successfully.");
                    } catch (IOException | IllegalArgumentException e) {
                        System.out.println("Failed to move file: " + e.getMessage());
                    }
                }
                break;
                case 3: {
                    String path = menu.readText("Enter file path to delete: ");
                    try {
                        FileOperations.deleteFile(path);
                        System.out.println("File deleted successfully.");
                    } catch (IOException | IllegalArgumentException e) {
                        System.out.println("Failed to delete file: " + e.getMessage());
                    }
                }
                break;
                case 4: {
                    String rootDir = menu.readText("Enter directory to search in: ");
                    String query = menu.readText("Enter name to search for: ");
                    try {
                        List<Path> results = FileSearcher.searchByName(rootDir, query);
                        if (results.isEmpty()) {
                            System.out.println("No matches found.");
                        } else {
                            results.forEach(System.out::println);
                        }
                    } catch (IOException | IllegalArgumentException e) {
                        System.out.println("Search failed: " + e.getMessage());
                    }
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