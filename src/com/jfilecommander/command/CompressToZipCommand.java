package com.jfilecommander.command;

import com.jfilecommander.operations.ZipCompressor;
import com.jfilecommander.ui.Console;
import com.jfilecommander.ui.Menu;

import java.io.IOException;

public class CompressToZipCommand implements Command {
    private final Menu menu;
    private final Console console;
    private final ZipCompressor zipCompressor;

    public CompressToZipCommand(Menu menu, Console console, ZipCompressor zipCompressor) {
        this.menu = menu;
        this.console = console;
        this.zipCompressor = zipCompressor;
    }

    @Override
    public void execute() {
        String sourceDir = menu.readText("Enter source directory path: ");
        String zipFilePath = menu.readText("Enter target ZIP file path (e.g. C:\\backup.zip): ");
        try {
            zipCompressor.compressToZip(sourceDir, zipFilePath);
            console.printSuccess("Folder compressed successfully: " + zipFilePath);
        } catch (IOException | IllegalArgumentException e) {
            console.printError("Failed to compress folder: " + e.getMessage());
        }
    }
}
