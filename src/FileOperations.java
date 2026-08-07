import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileOperations {
    static void copyFile(String sourcePath, String targetPath) throws IOException {
        Path[] paths = validatePaths(sourcePath, targetPath);
        Files.copy(paths[0], paths[1], StandardCopyOption.REPLACE_EXISTING);
    }

    static void moveFile(String sourcePath, String targetPath) throws IOException {
        Path[] paths = validatePaths(sourcePath, targetPath);
        Files.move(paths[0], paths[1], StandardCopyOption.REPLACE_EXISTING);
    }

    static void deleteFile(String path) throws IOException {
        Path target = resolvePath(path);
        requireRegularFile(target);
        Files.delete(target);
    }

    private static Path[] validatePaths(String sourcePath, String targetPath) throws IOException {
        Path source = resolvePath(sourcePath);
        Path target = resolvePath(targetPath);

        if (source.equals(target)) {
            throw new IllegalArgumentException("Source and target paths must be different.");
        }

        requireRegularFile(source);

        return new Path[] { source, target };
    }

    private static Path resolvePath(String path) {
        if (path.isBlank()) {
            throw new IllegalArgumentException("Path must not be empty.");
        }
        return Path.of(path).toAbsolutePath().normalize();
    }

    private static void requireRegularFile(Path path) throws IOException {
        if (!Files.isRegularFile(path)) {
            throw new IOException("Not a regular file: " + path);
        }
    }
}
