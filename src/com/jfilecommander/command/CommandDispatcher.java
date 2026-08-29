package com.jfilecommander.command;

import com.jfilecommander.ui.Menu;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {
    private final Map<Integer, Command> commands = new HashMap<>();

    public CommandDispatcher(Menu menu, Runnable onExit) {
        commands.put(1, new CopyFileCommand(menu));
        commands.put(2, new MoveFileCommand(menu));
        commands.put(3, new DeleteFileCommand(menu));
        commands.put(4, new SearchByNameCommand(menu));
        commands.put(8, new ExitCommand(onExit));
    }

    public void dispatch(int choice) {
        commands.getOrDefault(choice, () -> System.out.println("We don't manage this option choice. Try again."))
                .execute();
    }
}
