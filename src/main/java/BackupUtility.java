//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Iterator;

public class BackupUtility {
    public BackupUtility() {
    }

    public static void main(String[] args) {
        try {
            createBackup("./source", "./backup");
        } catch (IOException var2) {
            IOException e = var2;
            e.printStackTrace();
        }

    }

    public static void createBackup(String sourceDir, String backupDir) throws IOException {
        Path sourcePath = Paths.get(sourceDir);
        Path backupPath = Paths.get(backupDir);
        if (!Files.exists(backupPath, new LinkOption[0])) {
            Files.createDirectories(backupPath);
        }

        DirectoryStream<Path> stream = Files.newDirectoryStream(sourcePath);

        try {
            Iterator var5 = stream.iterator();

            while(var5.hasNext()) {
                Path entry = (Path)var5.next();
                if (Files.isRegularFile(entry, new LinkOption[0])) {
                    copyFile(entry, backupPath.resolve(entry.getFileName()));
                }
            }
        } catch (Throwable var8) {
            if (stream != null) {
                try {
                    stream.close();
                } catch (Throwable var7) {
                    var8.addSuppressed(var7);
                }
            }

            throw var8;
        }

        if (stream != null) {
            stream.close();
        }

    }

    private static void copyFile(Path source, Path destination) throws IOException {
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}
