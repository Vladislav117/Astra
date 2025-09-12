package astradevelopment.properties;

import arc.files.Fi;
import org.gradle.api.Project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class PropertiesLoader {
    protected Fi file;

    public PropertiesLoader(Fi file) {
        this.file = file;
    }

    public void load(Project project) {
        if (!file.exists()) {
            project.getLogger().error("[!] Properties file {} does not exists", file);
            return;
        }
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(file.file())) {
            properties.load(fileInputStream);
            properties.forEach((key, value) -> project.getExtensions().getExtraProperties().set(Objects.toString(key), Objects.toString(value)));
        } catch (IOException exception) {
            throw new RuntimeException("[!] Failed to load " + file, exception);
        }
    }
}