package com.jfilecommander.command;

import com.jfilecommander.operations.ZipDecompressor;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class DecompressZipCommand implements Command {
    private final Menu menu;
    private final Console console;
    private final ZipDecompressor zipDecompressor;

    public DecompressZipCommand(Menu menu, Console console, ZipDecompressor zipDecompressor) {
        this.menu = menu;
        this.console = console;
        this.zipDecompressor = zipDecompressor;
    }

    @Override
    public void execute() {
        String zipFilePath = menu.readText("Enter ZIP file path: ");
        String targetDir = menu.readText("Enter target directory path: ");
        try {
            zipDecompressor.decompressZip(zipFilePath, targetDir);
            console.printSuccess("Archive extracted successfully to: " + targetDir);
        } catch (IOException | IllegalArgumentException e) {
            console.printError("Failed to extract archive: " + e.getMessage());
        }
    }
}
