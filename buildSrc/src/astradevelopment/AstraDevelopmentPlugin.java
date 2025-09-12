package astradevelopment;

import astradevelopment.task.BuildAssetsTask;
import astradevelopment.task.DeployTask;
import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.jetbrains.annotations.NotNull;

public class AstraDevelopmentPlugin implements Plugin<Project> {
    @Override
    public void apply(@NotNull Project project) {
        AstraDevelopment.init(this, project);
        project.getTasks().register("buildAssets", BuildAssetsTask.class);
        project.getTasks().register("deploy", DeployTask.class);
    }
}
