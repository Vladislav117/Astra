package astra;

import astra.block.AstraBlocks;
import mindustry.mod.Mod;

public class AstraMod extends Mod {
    public AstraMod() {
    }

    @Override
    public void loadContent() {
        AstraBlocks.init();
    }
}
