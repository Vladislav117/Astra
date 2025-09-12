package astradevelopment.asset.processors;

import astradevelopment.asset.Asset;
import astradevelopment.asset.processor.AssetProcessor;

public class AsepriteAssetProcessor extends AssetProcessor {
    @Override
    public boolean filter(Asset asset) {
        return asset.getSourceFile().extEquals("aseprite");
    }

    @Override
    public void process(Asset asset) {
        asset.exclude();
    }
}
