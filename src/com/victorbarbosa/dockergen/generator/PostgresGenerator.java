/**
 * @author victor.barbosa
 */

package com.victorbarbosa.dockergen.generator;

import com.victorbarbosa.dockergen.util.FileUtils;

import java.nio.file.Path;

public class PostgresGenerator implements DockerGenerator {

    @Override
    public String getNome() {
        return "postgres";
    }

    @Override
    public void FilesGen(Path target, String databaseName) throws Exception {
        String envContent = String.format("""
                POSTGRES_VERSION=latest
                POSTGRES_USER=postgres
                POSTGRES_PASSWORD=postgres123
                POSTGRES_DB=%s
                POSTGRES_PORT=5432              
                """, databaseName);

        String composeContent = """
                services:
                          db:
                            image: postgres:latest
                            container_name: postgres_container
                            ports:
                              - "${POSTGRES_PORT}:5432"
                            environment:
                              POSTGRES_USER: ${POSTGRES_USER}
                              POSTGRES_PASSWORD: ${POSTGRES_PASSWORD}
                              POSTGRES_DB: ${POSTGRES_DB}
                """;

        FileUtils.WriteFile(target.resolve(".env"), envContent);
        FileUtils.WriteFile(target.resolve("docker-compose.yml"), composeContent);
    }
}
