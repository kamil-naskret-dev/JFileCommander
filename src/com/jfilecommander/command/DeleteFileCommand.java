package com.jfilecommander.command;

import com.jfilecommander.operations.FileOperations;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class DeleteFileCommand implements Command {
    private final Menu menu;
    private final Console console;
    private final FileOperations fileOperations;

    public DeleteFileCommand(Menu menu, Console console, FileOperations fileOperations) {
        this.menu = menu;
        this.console = console;
        this.fileOperations = fileOperations;
    }

    @Override
    public void execute() {
        String path = menu.readText("Enter file path to delete: ");
        try {
            fileOperations.deleteFile(path);
            console.printSuccess("File deleted successfully.");
        } catch (IOException | IllegalArgumentException e) {
            console.printError("Failed to delete file: " + e.getMessage());
        }
    }
}
