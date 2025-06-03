package com.victorbarbosa.dockergen.generator;

import java.nio.file.Path;

public interface DockerGenerator {
    String getNome();

    void FilesGen(Path target, String databaseName) throws Exception;
}
