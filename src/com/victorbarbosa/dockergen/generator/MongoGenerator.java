/**
 * @author victor.barbosa
 */

package com.victorbarbosa.dockergen.generator;

import com.victorbarbosa.dockergen.util.FileUtils;

import java.nio.file.Path;

public class MongoGenerator implements DockerGenerator {

    @Override
    public String getNome() {
        return "mongodb";
    }

    @Override
    public void FilesGen(Path target, String databaseName) throws Exception {
        String envContent = String.format("""
                MONGO_INITDB_ROOT_USERNAME=admin
                MONGO_INITDB_ROOT_PASSWORD=admin123
                MONGO_INITDB_DATABASE=%s
                MONGO_PORT=27017
                """, databaseName);

        String composeContent = """
                services:
                  mongo:
                    image: mongo:latest
                    container_name: mongo_container
                    ports:
                      - "${MONGO_PORT}:27017"
                    environment:
                      MONGO_INITDB_ROOT_USERNAME: ${MONGO_INITDB_ROOT_USERNAME}
                      MONGO_INITDB_ROOT_PASSWORD: ${MONGO_INITDB_ROOT_PASSWORD}
                      MONGO_INITDB_DATABASE: ${MONGO_INITDB_DATABASE}
                """;

        FileUtils.WriteFile(target.resolve(".env"), envContent);
        FileUtils.WriteFile(target.resolve("docker-compose.yml"), composeContent);
    }
}
