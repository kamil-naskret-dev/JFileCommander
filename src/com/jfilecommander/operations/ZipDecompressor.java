package com.jfilecommander.operations;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipDecompressor {
    public void decompressZip(String zipFilePath, String targetDir) throws IOException {
        if (zipFilePath.isBlank()) {
            throw new IllegalArgumentException("ZIP file path must not be empty.");
        }
        if (targetDir.isBlank()) {
            throw new IllegalArgumentException("Target directory must not be empty.");
        }

        Path zipFile = Path.of(zipFilePath).toAbsolutePath().normalize();
        Path target = Path.of(targetDir).toAbsolutePath().normalize();

        if (!Files.isRegularFile(zipFile)) {
            throw new IOException("Not a file: " + zipFile);
        }

        Files.createDirectories(target);

        try (ZipInputStream zip = new ZipInputStream(Files.newInputStream(zipFile))) {
            ZipEntry entry;
            while ((entry = zip.getNextEntry()) != null) {
                Path entryPath = target.resolve(entry.getName()).normalize();

                if (!entryPath.startsWith(target)) {
                    throw new IOException("ZIP entry outside of target directory: " + entry.getName());
                }

                if (entry.isDirectory()) {
                    Files.createDirectories(entryPath);
                } else {
                    Files.createDirectories(entryPath.getParent());
                    Files.copy(zip, entryPath);
                }

                zip.closeEntry();
            }
        }
    }
}
