package com.demo.jgen;

import io.swagger.v3.oas.models.media.Schema;
import java.io.IOException;

public class DTOCodeGenerator implements BaseCodeGenerator {

    @Override
    public void generateCode(String packageName, String resourceName, String packageDir, Schema schema) throws IOException {
        StringBuilder dtoCode = new StringBuilder();
        dtoCode.append("package ").append(packageName).append(";\n\n")
                .append("import lombok.*;\n")
                .append("import jakarta.validation.constraints.*;\n\n")
                .append("@Getter\n@Setter\n@NoArgsConstructor\n@AllArgsConstructor\n@Builder\n")
                .append("public class ").append(resourceName).append("Dto {\n");

        schema.getProperties().forEach((name, property) -> {
            String javaType = OpenApiCodeGenerator.mapSchemaTypeToJavaType(((Schema<?>) property).getType());
            dtoCode.append("    private ").append(javaType).append(" ").append(name).append(";\n");
        });

        dtoCode.append("}\n");
        writeToFile(packageDir + resourceName + "Dto.java", dtoCode.toString());
    }
}
