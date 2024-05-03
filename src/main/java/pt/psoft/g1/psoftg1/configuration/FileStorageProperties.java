package pt.psoft.g1.psoftg1.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

/**
 * <p>
 * code based on
 * https://github.com/callicoder/spring-boot-file-upload-download-rest-api-example
 *
 *
 */
@ConfigurationProperties(prefix = "file")
@Data
public class FileStorageProperties {
    private String uploadDir;
}