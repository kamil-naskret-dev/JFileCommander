package com.jfilecommander.command;

import com.jfilecommander.operations.FileOperations;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class MoveFileCommand implements Command {
    private final Menu menu;
    private final Console console;
    private final FileOperations fileOperations;

    public MoveFileCommand(Menu menu, Console console, FileOperations fileOperations) {
        this.menu = menu;
        this.console = console;
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() {
        String sourcePath = menu.readText("Enter source file path: ");
        String targetPath = menu.readText("Enter target file path: ");
        try {
            fileOperations.moveFile(sourcePath, targetPath);
            console.printSuccess("File moved successfully.");
        } catch (IOException | IllegalArgumentException e) {
            console.printError("Failed to move file: " + e.getMessage());
        }
    }
}
