package com.jfilecommander.command;

import com.jfilecommander.operations.FileOperations;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class DeleteFileCommand implements Command {
    private final Menu menu;

    public DeleteFileCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
        String path = menu.readText("Enter file path to delete: ");
        try {
            FileOperations.deleteFile(path);
            System.out.println("File deleted successfully.");
        } catch (IOException | IllegalArgumentException e) {
            System.out.println("Failed to delete file: " + e.getMessage());
        }
    }
}
