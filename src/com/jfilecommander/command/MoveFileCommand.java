package com.jfilecommander.command;

import com.jfilecommander.operations.FileOperations;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class MoveFileCommand implements Command {
    private final Menu menu;

    public MoveFileCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        String sourcePath = menu.readText("Enter source file path: ");
        String targetPath = menu.readText("Enter target file path: ");
        try {
            FileOperations.moveFile(sourcePath, targetPath);
            System.out.println("File moved successfully.");
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Failed to move file: " + e.getMessage());
        }
    }
}
