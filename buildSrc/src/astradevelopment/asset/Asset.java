package astradevelopment.asset;

import arc.files.Fi;

public class Asset {
    protected Fi sourceFile;
    protected Fi outputFile;
    protected boolean excluded = false;

    public Asset(Fi sourceFile, Fi outputFile) {
        this.sourceFile = sourceFile;
        this.outputFile = outputFile;
    }

    public Fi getSourceFile() {
        return sourceFile;
    }

    public Fi getSourceDirectory() {
        return sourceFile.parent();
    }

    public Fi getOutputFile() {
        return outputFile;
    }

    public Fi getOutputDirectory() {
        return outputFile.parent();
    }

    public void createOutputDirectory() {
        if (!getOutputDirectory().exists()) getOutputDirectory().mkdirs();
    }

    public boolean isExcluded() {
        return excluded;
    }

    public void setExcluded(boolean excluded) {
        this.excluded = excluded;
    }

    public void exclude() {
        setExcluded(true);
    }
}
