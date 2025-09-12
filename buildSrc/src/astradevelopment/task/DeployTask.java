package astradevelopment.task;

import arc.files.Fi;
import astradevelopment.AstraDevelopment;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class DeployTask extends DefaultTask {
    public DeployTask() {
        dependsOn("fullJar");
    }

    @TaskAction
    public void run() {
        String modJar = getProject().getProperties().get("modJar").toString();
        Fi modsDirectory = null;
        if (getProject().getProperties().get("modsDirectory") != null) {
            modsDirectory = new Fi(getProject().getProperties().get("modsDirectory").toString());
        }
        if (modsDirectory != null && modsDirectory.exists()) {
            AstraDevelopment.getProjectFile("build/libs/" + modJar).copyTo(modsDirectory.child(modJar));
        }
    }
}
