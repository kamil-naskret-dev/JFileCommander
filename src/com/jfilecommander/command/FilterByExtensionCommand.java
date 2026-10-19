package com.jfilecommander.command;

import com.jfilecommander.operations.FileSearcher;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class FilterByExtensionCommand implements Command {
    private final Menu menu;
    private final Console console;
    private final FileSearcher fileSearcher;

    public FilterByExtensionCommand(Menu menu, Console console, FileSearcher fileSearcher) {
        this.menu = menu;
        this.console = console;
        this.fileSearcher = fileSearcher;
    }

    @Override
    public void execute() {
        String rootDir = menu.readText("Enter directory path: ");
        String extension = menu.readText("Enter file extension (e.g. txt, .jpg): ");
        try {
            console.printResults(fileSearcher.filterByExtension(rootDir, extension));
        } catch (IOException | IllegalArgumentException e) {
            console.printError("Failed to filter files: " + e.getMessage());
        }
    }
}
