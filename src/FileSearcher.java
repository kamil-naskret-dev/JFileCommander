import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class FileSearcher {
    static List<Path> searchByName(String rootDir, String query) throws IOException {
        if (rootDir.isBlank()) {
            throw new IllegalArgumentException("Root directory must not be empty.");
        }
        if (query.isBlank()) {
            throw new IllegalArgumentException("Search query must not be empty.");
        }

        Path root = Path.of(rootDir).toAbsolutePath().normalize();

        if (!Files.isDirectory(root)) {
            throw new IOException("Not a directory: " + root);
        }

        String lowerCaseQuery = query.toLowerCase();

        try (var paths = Files.walk(root)) {
            return paths
                    .filter(path -> path.getFileName().toString().toLowerCase().contains(lowerCaseQuery))
                    .collect(Collectors.toList());
        }
    }
}
