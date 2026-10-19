package com.jfilecommander.operations;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FolderSizeCalculator {
    public long calculateSize(String dir) throws IOException {
        if (dir.isBlank()) {
            throw new IllegalArgumentException("Directory path must not be empty.");
        }

        Path root = Path.of(dir).toAbsolutePath().normalize();

        if (!Files.isDirectory(root)) {
            throw new IOException("Not a directory: " + root);
        }

        try (var paths = Files.walk(root)) {
            return paths
                    .filter(Files::isRegularFile)
                    .mapToLong(path -> {
                        try {
                            return Files.size(path);
                        } catch (IOException e) {
                            return 0L;
                        }
                    })
                    .sum();
        } catch (UncheckedIOException e) {
            throw new IOException("Error while walking directory tree: " + e.getCause().getMessage(), e);
        }
    }

    public String formatSize(long bytes) {
        if (bytes < 1024) {
            return bytes + " B";
        } else if (bytes < 1024 * 1024) {
            return String.format("%.1f KB", bytes / 1024.0);
        } else {
            return String.format("%.1f MB", bytes / (1024.0 * 1024));
        }
    }
}
