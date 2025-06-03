/**
 * @author victor.barbosa
 */

package com.victorbarbosa.dockergen.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {
    public static void WriteFile(Path path, String content) throws IOException {
        Files.writeString(path, content);
    }
}
