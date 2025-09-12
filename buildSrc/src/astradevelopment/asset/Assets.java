package astradevelopment.asset;

import arc.files.Fi;
import astradevelopment.AstraDevelopment;
import astradevelopment.asset.processor.AssetProcessors;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class Assets {
    public static final Fi sourceAssetsDirectory = AstraDevelopment.getProjectFile("assets");
    public static final Fi outputAssetsDirectory = AstraDevelopment.getProjectFile("build/assets");

    static List<Asset> findAssetsInDirectory(@Nullable String localAssetsDirectoryPath) {
        Fi assetsDirectory = localAssetsDirectoryPath == null ? sourceAssetsDirectory : sourceAssetsDirectory.child(localAssetsDirectoryPath);

        List<Asset> assets = new ArrayList<>();
        for (Fi entry : assetsDirectory.list()) {
            String localEntryPath = localAssetsDirectoryPath == null ? entry.name() : localAssetsDirectoryPath + "/" + entry.name();
            if (entry.isDirectory()) {
                assets.addAll(findAssetsInDirectory(localEntryPath));
            } else {
                assets.add(new Asset(entry, outputAssetsDirectory.child(localEntryPath)));
            }
        }

        return assets;
    }

    public static void init() {
        if (!sourceAssetsDirectory.exists()) return;
    }

    public static void build() {
        if (!sourceAssetsDirectory.exists()) return;

        if (outputAssetsDirectory.exists()) outputAssetsDirectory.deleteDirectory();
        outputAssetsDirectory.mkdirs();

        List<Asset> assets = findAssetsInDirectory(null);
        for (Asset asset : assets) {
            AssetProcessors.process(asset);
            if (!asset.isExcluded()) {
                asset.createOutputDirectory();
                asset.getSourceFile().copyTo(asset.getOutputFile());
            }
        }
    }
}
