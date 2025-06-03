/**
 * @author victor.barbosa
 */

package com.victorbarbosa.dockergen.generator;

import com.victorbarbosa.dockergen.util.FileUtils;

import java.nio.file.Path;

public class MySqlGenerator implements DockerGenerator {

    @Override
    public String getNome() {
        return "mysql";
    }

    @Override
    public void FilesGen(Path target, String databaseName) throws Exception {
        String envContent = String.format("""
                MYSQL_ROOT_PASSWORD=root123
                MYSQL_DATABASE=%s
                MYSQL_USER=admin
                MYSQL_PASSWORD=admin123
                MYSQL_PORT=3306
                """, databaseName);

        String composeContent = """
                services:
                  db:
                    image: mysql:latest
                    container_name: mysql_container
                    ports:
                      - "${MYSQL_PORT}:3306"
                    environment:
                      MYSQL_ROOT_PASSWORD: ${MYSQL_ROOT_PASSWORD}
                      MYSQL_DATABASE: ${MYSQL_DATABASE}
                      MYSQL_USER: ${MYSQL_USER}
                      MYSQL_PASSWORD: ${MYSQL_PASSWORD}
                """;

        FileUtils.WriteFile(target.resolve(".env"), envContent);
        FileUtils.WriteFile(target.resolve("docker-compose.yml"), composeContent);
    }
}
