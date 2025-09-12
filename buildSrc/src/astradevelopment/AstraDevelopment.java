package astradevelopment;

import arc.files.Fi;
import astradevelopment.asset.Assets;
import astradevelopment.asset.processor.AssetProcessors;
import astradevelopment.properties.ModPropertiesLoader;
import astradevelopment.properties.PropertiesLoader;
import org.gradle.api.Project;

public final class AstraDevelopment {
    static AstraDevelopmentPlugin plugin;
    static Project project;

    public static AstraDevelopmentPlugin getPlugin() {
        return plugin;
    }

    public static Project getProject() {
        return project;
    }

    public static Fi getProjectFile(String path) {
        return new Fi(project.getProjectDir()).child(path);
    }

    public static void init(AstraDevelopmentPlugin plugin, Project project) {
        AstraDevelopment.plugin = plugin;
        AstraDevelopment.project = project;

        // Loading properties
        new PropertiesLoader(getProjectFile("local.properties")).load(project);
        new ModPropertiesLoader(getProjectFile("mod.hjson")).load(project);

        // Initializing modules
        Assets.init();
        AssetProcessors.init();
    }
}
