/**
 * @author victor.barbosa
 */

package com.victorbarbosa.dockergen;

import com.victorbarbosa.dockergen.core.GeneratorFactory;
import com.victorbarbosa.dockergen.generator.DockerGenerator;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Locale;

public class DockerDBInit {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java -jar app.jar <banco> [nome_do_banco]");
            return;
        }

        String database = args[0].toLowerCase(Locale.ROOT);
        String databaseName = args.length >= 2 ? args[1] : "mydb";

        DockerGenerator generator = GeneratorFactory.getGenerator(database);

        if (generator == null) {
            System.out.println("Banco não suportado: " + database);
            return;
        }

        Path targetDir = Path.of(database + "-docker");
        try {
            Files.createDirectories(targetDir);
            generator.FilesGen(targetDir, databaseName);
            System.out.println("Arquivos gerados com sucesso em " + targetDir);
        } catch (Exception e) {
            System.out.println("Erro ao gerar arquivos: " + e.getMessage());
        }
    }
}
