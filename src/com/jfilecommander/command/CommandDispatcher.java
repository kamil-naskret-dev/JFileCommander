package com.jfilecommander.command;

import com.jfilecommander.operations.FileOperations;
import com.jfilecommander.operations.FileSearcher;
import com.jfilecommander.operations.FolderSizeCalculator;
import com.jfilecommander.operations.ZipCompressor;
import com.jfilecommander.operations.ZipDecompressor;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcher {
    private final Map<Integer, Command> commands = new HashMap<>();
    private final Console console;

    public CommandDispatcher(Menu menu, Console console, FileOperations fileOperations, FileSearcher fileSearcher, FolderSizeCalculator folderSizeCalculator, ZipCompressor zipCompressor, ZipDecompressor zipDecompressor, Runnable onExit) {
        this.console = console;
        commands.put(1, new CopyFileCommand(menu, console, fileOperations));
        commands.put(2, new MoveFileCommand(menu, console, fileOperations));
        commands.put(3, new DeleteFileCommand(menu, console, fileOperations));
        commands.put(4, new SearchByNameCommand(menu, console, fileSearcher));
        commands.put(5, new FilterByExtensionCommand(menu, console, fileSearcher));
        commands.put(6, new FolderSizeCommand(menu, console, folderSizeCalculator));
        commands.put(7, new CompressToZipCommand(menu, console, zipCompressor));
        commands.put(8, new DecompressZipCommand(menu, console, zipDecompressor));
        commands.put(9, new ExitCommand(console, onExit));
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
