package com.jfilecommander.operations;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompressor {
    public void compressToZip(String sourceDir, String zipFilePath) throws IOException {
        if (sourceDir.isBlank()) {
            throw new IllegalArgumentException("Source directory must not be empty.");
        }
        if (zipFilePath.isBlank()) {
            throw new IllegalArgumentException("ZIP file path must not be empty.");
        }

        Path source = Path.of(sourceDir).toAbsolutePath().normalize();
        Path zipFile = Path.of(zipFilePath).toAbsolutePath().normalize();

        if (!Files.isDirectory(source)) {
            throw new IOException("Not a directory: " + source);
        }

        try (ZipOutputStream zip = new ZipOutputStream(Files.newOutputStream(zipFile));
             var paths = Files.walk(source)) {

            paths.filter(Files::isRegularFile).forEach(file -> {
                String entryName = source.relativize(file).toString().replace("\\", "/");
                try {
                    zip.putNextEntry(new ZipEntry(entryName));
                    Files.copy(file, zip);
                    zip.closeEntry();
                } catch (IOException e) {
                    throw new UncheckedIOException(e);
                }
            });

        } catch (UncheckedIOException e) {
            throw new IOException("Error while compressing: " + e.getCause().getMessage(), e);
        }
    }
}
