import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileOperations {
    static void copyFile(String sourcePath, String targetPath) throws IOException {
        Path source = Path.of(sourcePath);
        Path target = Path.of(targetPath);

        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }
}
