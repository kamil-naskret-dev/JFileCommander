package com.jfilecommander;

import com.jfilecommander.command.CommandDispatcher;
import com.jfilecommander.ui.Menu;

public class Application {
    private final Menu menu = new Menu();
    private final CommandDispatcher dispatcher = new CommandDispatcher(menu, this::stop);
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
