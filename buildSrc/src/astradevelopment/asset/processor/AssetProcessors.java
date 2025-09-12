package astradevelopment.asset.processor;

import astradevelopment.asset.Asset;
import astradevelopment.asset.processors.AsepriteAssetProcessor;
import astradevelopment.asset.processors.AutotileAssetProcessor;

import java.util.ArrayList;
import java.util.List;

public final class AssetProcessors {
    static List<AssetProcessor> assetProcessors = new ArrayList<>();

    public static void addAssetProcessor(AssetProcessor assetProcessor) {
        assetProcessors.add(assetProcessor);
    }

    public static void process(Asset asset) {
        for (AssetProcessor assetProcessor : assetProcessors) {
            if (assetProcessor.filter(asset)) assetProcessor.process(asset);
        }
    }

    public static AssetProcessor autotile, aseprite;

    public static void init() {
        autotile = new AutotileAssetProcessor();
        aseprite = new AsepriteAssetProcessor();
    }
}
