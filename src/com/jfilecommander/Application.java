package com.jfilecommander;

import com.jfilecommander.command.CommandDispatcher;
import com.jfilecommander.operations.FileOperations;
import com.jfilecommander.operations.FileSearcher;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

public class Application {
    private final Menu menu = new Menu();
    private final Console console = new Console();
    private final FileOperations fileOperations = new FileOperations();
    private final FileSearcher fileSearcher = new FileSearcher();
    private final CommandDispatcher dispatcher = new CommandDispatcher(menu, console, fileOperations, fileSearcher, this::stop);
    private boolean isRunning = true;

    public void start() {
        while (isRunning) {
            menu.printMenu();
            dispatcher.dispatch(menu.readChoice());
        }
    }

    private void stop() {
        isRunning = false;
    }
}
