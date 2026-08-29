package com.jfilecommander.command;

import com.jfilecommander.operations.FileOperations;
import com.jfilecommander.operations.FileSearcher;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {
    private final Map<Integer, Command> commands = new HashMap<>();
    private final Console console;

    public CommandDispatcher(Menu menu, Console console, FileOperations fileOperations, FileSearcher fileSearcher, Runnable onExit) {
        this.console = console;
        commands.put(1, new CopyFileCommand(menu, console, fileOperations));
        commands.put(2, new MoveFileCommand(menu, console, fileOperations));
        commands.put(3, new DeleteFileCommand(menu, console, fileOperations));
        commands.put(4, new SearchByNameCommand(menu, console, fileSearcher));
        commands.put(8, new ExitCommand(console, onExit));
    }

    public void dispatch(int choice) {
        Command command = commands.get(choice);
        if (command != null) {
            command.execute();
        } else {
            console.printError("We don't manage this option choice. Try again.");
        }
    }
}
