package com.jfilecommander.command;

import com.jfilecommander.operations.FolderSizeCalculator;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class FolderSizeCommand implements Command {
    private final Menu menu;
    private final Console console;
    private final FolderSizeCalculator calculator;

    public FolderSizeCommand(Menu menu, Console console, FolderSizeCalculator calculator) {
        this.menu = menu;
        this.console = console;
        this.calculator = calculator;
    }

    @Override
    public void execute() {
        String dir = menu.readText("Enter directory path: ");
        try {
            long bytes = calculator.calculateSize(dir);
            console.printSuccess("Folder size: " + calculator.formatSize(bytes));
        } catch (IOException | IllegalArgumentException e) {
            console.printError("Failed to calculate folder size: " + e.getMessage());
        }
    }
}
