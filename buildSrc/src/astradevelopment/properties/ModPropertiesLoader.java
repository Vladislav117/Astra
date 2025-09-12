package astradevelopment.properties;

import arc.files.Fi;
import org.gradle.api.Project;

import java.util.*;

public class ModPropertiesLoader {
    protected Fi file;

    public ModPropertiesLoader(Fi file) {
        this.file = file;
    }

    public void load(Project project) {
        if (!file.exists()) {
            project.getLogger().error("[!] Mod properties file {} does not exists", file);
            return;
        }
        Map<String, String> modConfiguration = new HashMap<>();
        // TODO 11.09.2025: Read file as hjson instead of this
        String[] lines = file.readString().split("\n");
        for (String line : lines) {
            if (!line.contains(": ")) continue;
            String[] keyValuePair = line.split(": ", 2);
            String key = keyValuePair[0];
            String value = keyValuePair[1];
            if (value.startsWith("\"") && value.endsWith("\"")) {
                value = value.substring(1, value.length() - 1);
            }
            modConfiguration.put(key, value);
        }

        project.getExtensions().getExtraProperties().set("modName", modConfiguration.get("name"));
        project.getExtensions().getExtraProperties().set("modVersion", modConfiguration.get("version"));
        project.getExtensions().getExtraProperties().set("modGameVersion", modConfiguration.get("minGameVersion"));
        project.getExtensions().getExtraProperties().set("modMainClass", modConfiguration.get("main"));

        project.getExtensions().getExtraProperties().set("modDisplayName", modConfiguration.get("displayName"));
        project.getExtensions().getExtraProperties().set("modAuthor", modConfiguration.get("author"));
        project.getExtensions().getExtraProperties().set("modDescription", modConfiguration.get("description"));
    }
}
