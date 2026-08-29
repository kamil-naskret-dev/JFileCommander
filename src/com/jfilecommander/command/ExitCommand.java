package com.jfilecommander.command;

public class ExitCommand implements Command {
    private final Runnable onExit;

    public ExitCommand(Runnable onExit) {
        this.onExit = onExit;
    }

    @Override
    public void execute() {
        System.out.println("Thanks for using JFileCommander.");
        onExit.run();
    }
}
