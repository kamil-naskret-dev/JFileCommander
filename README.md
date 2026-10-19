# JFileCommander

A console-based file manager written in Java, built with Java Core (`java.nio.file`, `java.util.zip`) — no external dependencies, no build tools.

## Features

| # | Feature | API used |
|---|---------|----------|
| 1 | Copy file | `Files.copy`, `StandardCopyOption` |
| 2 | Move file | `Files.move` |
| 3 | Delete file | `Files.delete` |
| 4 | Search files by name | `Files.walk`, `Stream` |
| 5 | Filter files by extension | `Files.walk`, `String.endsWith` |
| 6 | Calculate folder size | `Files.walk`, `Files.size`, `mapToLong` |
| 7 | Compress folder to ZIP | `ZipOutputStream`, `ZipEntry` |

## How to run

**IntelliJ IDEA:** open the project, run `Main.java`.

**Command line:**
```bash
javac -d out src/com/jfilecommander/**/*.java src/com/jfilecommander/*.java
java -cp out com.jfilecommander.Main
```

## Example usage

```
----------------------------------------
  ------ JFileCommander ------
1. Copy file
2. Move file
3. Delete file
4. Search by name
5. Filter by extension
6. Folder size
7. Compress to ZIP
8. Exit
Your choice : 6
Enter directory path: C:\Users\user\Documents
Folder size: 3.2 MB
```

## Project structure

```
src/com/jfilecommander/
├── Main.java                        # entry point
├── Application.java                 # app lifecycle, wires dependencies
├── ui/
│   ├── Menu.java                    # displays menu, reads user input
│   └── Console.java                 # formats and prints output
├── operations/
│   ├── FileOperations.java          # copy, move, delete
│   ├── FileSearcher.java            # search by name, filter by extension
│   ├── FolderSizeCalculator.java    # recursive size calculation
│   └── ZipCompressor.java           # folder compression
└── command/
    ├── Command.java                 # interface
    ├── CommandDispatcher.java       # maps menu choices to commands
    ├── CopyFileCommand.java
    ├── MoveFileCommand.java
    ├── DeleteFileCommand.java
    ├── SearchByNameCommand.java
    ├── FilterByExtensionCommand.java
    ├── FolderSizeCommand.java
    ├── CompressToZipCommand.java
    └── ExitCommand.java
```

## Architecture

The project follows the **Command Pattern** — each menu option is a separate class implementing the `Command` interface. Adding a new feature means adding one class and one line in `CommandDispatcher`, without touching anything else.

Dependencies are injected via constructors. Business logic (`operations/`) is fully separated from user interaction (`ui/`, `command/`).
