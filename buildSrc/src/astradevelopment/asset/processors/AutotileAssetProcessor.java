package astradevelopment.asset.processors;

import astradevelopment.asset.Asset;
import astradevelopment.asset.processor.AssetProcessor;
import astradevelopment.image.AutotileGenerator;

public class AutotileAssetProcessor extends AssetProcessor {
    @Override
    public boolean filter(Asset asset) {
        return asset.getSourceFile().name().endsWith("-autotile.png");
    }

    @Override
    public void process(Asset asset) {
        asset.exclude();
        asset.createOutputDirectory();
        AutotileGenerator.generate(asset.getSourceFile(), asset.getSourceFile().nameWithoutExtension().replace("-autotile", ""), asset.getOutputDirectory());
    }
}
