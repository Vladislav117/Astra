package astradevelopment.asset.processor;

import astradevelopment.asset.Asset;

public abstract class AssetProcessor {
    public AssetProcessor() {
        AssetProcessors.addAssetProcessor(this);
    }

    public abstract boolean filter(Asset asset);

    public abstract void process(Asset asset);
}
