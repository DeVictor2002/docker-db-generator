/**
 * @author victor.barbosa
 */

package com.victorbarbosa.dockergen.core;

import com.victorbarbosa.dockergen.generator.DockerGenerator;
import com.victorbarbosa.dockergen.generator.MySqlGenerator;
import com.victorbarbosa.dockergen.generator.PostgresGenerator;

import java.util.Map;

public class GeneratorFactory {
    private static final Map<String, DockerGenerator> SUPPORTED = Map.of(
            "postgres", new PostgresGenerator(),
            "mysql", new MySqlGenerator()
    );

    public static DockerGenerator getGenerator(String name) {
        return SUPPORTED.get(name.toLowerCase());
    }
}
