package com.jfilecommander.command;

import com.jfilecommander.operations.FileSearcher;
import com.jfilecommander.ui.Menu;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class SearchByNameCommand implements Command {
    private final Menu menu;

    public SearchByNameCommand(Menu menu) {
        this.menu = menu;
    }

    @Override
    public void execute() {
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
}
