package astradevelopment.task;

import astradevelopment.asset.Assets;
import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;

public class BuildAssetsTask extends DefaultTask {
    @TaskAction
    public void run() {
        Assets.build();
    }
}
