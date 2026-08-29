package com.jfilecommander.command;

import com.jfilecommander.ui.Console;

public class ExitCommand implements Command {
    private final Console console;
    private final Runnable onExit;

    public ExitCommand(Console console, Runnable onExit) {
        this.console = console;
        this.onExit = onExit;
    }

    @Override
    public void execute() {
        console.print("Thanks for using JFileCommander.");
        onExit.run();
    }
}
