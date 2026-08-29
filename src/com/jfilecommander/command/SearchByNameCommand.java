package com.jfilecommander.command;

import com.jfilecommander.operations.FileSearcher;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class SearchByNameCommand implements Command {
    private final Menu menu;
    private final Console console;
    private final FileSearcher fileSearcher;

    public SearchByNameCommand(Menu menu, Console console, FileSearcher fileSearcher) {
        this.menu = menu;
        this.console = console;
        this.fileSearcher = fileSearcher;
    }

    @Override
    public void execute() {
        String rootDir = menu.readText("Enter directory to search in: ");
        String query = menu.readText("Enter name to search for: ");
        try {
            console.printResults(fileSearcher.searchByName(rootDir, query));
        } catch (IOException | IllegalArgumentException e) {
            console.printError("Search failed: " + e.getMessage());
        }
    }
}
