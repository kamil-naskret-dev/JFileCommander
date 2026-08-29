package com.jfilecommander.command;

import com.jfilecommander.operations.FileOperations;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class CopyFileCommand implements Command {
    private final Menu menu;

    public CopyFileCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        String sourcePath = menu.readText("Enter source file path: ");
        String targetPath = menu.readText("Enter target file path: ");
        try {
            FileOperations.copyFile(sourcePath, targetPath);
            System.out.println("File copied successfully.");
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Failed to copy file: " + e.getMessage());
        }
    }
}
