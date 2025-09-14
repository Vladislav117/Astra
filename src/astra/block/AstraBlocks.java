package astra.block;

import astra.blocks.LaserReflectionWall;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import mindustry.world.blocks.defense.Wall;
import mindustry.world.blocks.environment.Floor;

public final class AstraBlocks {
    public static Block yellowPavement, whitePavement, pavement, blackPavement,

    laserReflectionWall,

    copperWallHuge, copperWallGigantic, titaniumWallHuge, titaniumWallGigantic,

    plastaniumWallHuge, plastaniumWallGigantic, phaseWallHuge, phaseWallGigantic,

    thoriumWallHuge, thoriumWallGigantic, surgeWallHuge, surgeWallGigantic,

    berylliumWallHuge, berylliumWallGigantic, tungstenWallHuge, tungstenWallGigantic,

    carbideWallHuge, carbideWallGigantic, reinforcedSurgeWallHuge, reinforcedSurgeWallGigantic;

    public static void init() {
        yellowPavement = new Floor("pavement-yellow", 0);
        whitePavement = new Floor("pavement-white", 0);
        pavement = new Floor("pavement", 0);
        blackPavement = new Floor("pavement-black", 0);

        laserReflectionWall = new LaserReflectionWall("laser-reflection-wall") {{
            requirements(Category.defense, ItemStack.with(Items.metaglass, 10, Items.lead, 5));
            health = Blocks.plastaniumWall.health;
        }};

        copperWallHuge = new Wall("copper-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.copperWall.requirements, size * size));
            health = Blocks.copperWall.health * size * size;
        }};

        copperWallGigantic = new Wall("copper-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.copperWall.requirements, size * size));
            health = Blocks.copperWall.health * size * size;
        }};

        titaniumWallHuge = new Wall("titanium-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.titaniumWall.requirements, size * size));
            health = Blocks.titaniumWall.health * size * size;
        }};

        titaniumWallGigantic = new Wall("titanium-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.titaniumWall.requirements, size * size));
            health = Blocks.titaniumWall.health * size * size;
        }};

        plastaniumWallHuge = new Wall("plastanium-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.plastaniumWall.requirements, size * size));
            health = Blocks.plastaniumWall.health * size * size;
            insulated = Blocks.plastaniumWall.insulated;
            absorbLasers = Blocks.plastaniumWall.absorbLasers;
            schematicPriority = Blocks.plastaniumWall.schematicPriority;
        }};

        plastaniumWallGigantic = new Wall("plastanium-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.plastaniumWall.requirements, size * size));
            health = Blocks.plastaniumWall.health * size * size;
            insulated = Blocks.plastaniumWall.insulated;
            absorbLasers = Blocks.plastaniumWall.absorbLasers;
            schematicPriority = Blocks.plastaniumWall.schematicPriority;
        }};

        phaseWallHuge = new Wall("phase-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.phaseWall.requirements, size * size));
            health = Blocks.phaseWall.health * size * size;
            chanceDeflect = ((Wall) Blocks.phaseWall).chanceDeflect;
            flashHit = ((Wall) Blocks.phaseWall).flashHit;
        }};

        phaseWallGigantic = new Wall("phase-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.phaseWall.requirements, size * size));
            health = Blocks.phaseWall.health * size * size;
            chanceDeflect = ((Wall) Blocks.phaseWall).chanceDeflect;
            flashHit = ((Wall) Blocks.phaseWall).flashHit;
        }};

        thoriumWallHuge = new Wall("thorium-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.thoriumWall.requirements, size * size));
            health = Blocks.thoriumWall.health * size * size;
        }};

        thoriumWallGigantic = new Wall("thorium-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.thoriumWall.requirements, size * size));
            health = Blocks.thoriumWall.health * size * size;
        }};

        surgeWallHuge = new Wall("surge-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.surgeWall.requirements, size * size));
            health = Blocks.surgeWall.health * size * size;
            lightningChance = ((Wall) Blocks.surgeWall).lightningChance;
        }};

        surgeWallGigantic = new Wall("surge-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.surgeWall.requirements, size * size));
            health = Blocks.surgeWall.health * size * size;
            lightningChance = ((Wall) Blocks.surgeWall).lightningChance;
        }};

        berylliumWallHuge = new Wall("beryllium-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.berylliumWall.requirements, size * size));
            health = Blocks.berylliumWall.health * size * size;
            armor = Blocks.berylliumWall.armor;
            // TODO 13.09.2025: Add buildCostMultiplier
        }};

        berylliumWallGigantic = new Wall("beryllium-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.berylliumWall.requirements, size * size));
            health = Blocks.berylliumWall.health * size * size;
            armor = Blocks.berylliumWall.armor;
            // TODO 13.09.2025: Add buildCostMultiplier
        }};

        tungstenWallHuge = new Wall("tungsten-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.tungstenWall.requirements, size * size));
            health = Blocks.tungstenWall.health * size * size;
            armor = Blocks.tungstenWall.armor;
            // TODO 13.09.2025: Add buildCostMultiplier
        }};

        tungstenWallGigantic = new Wall("tungsten-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.tungstenWall.requirements, size * size));
            health = Blocks.tungstenWall.health * size * size;
            armor = Blocks.tungstenWall.armor;
            // TODO 13.09.2025: Add buildCostMultiplier
        }};

        carbideWallHuge = new Wall("carbide-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.carbideWall.requirements, size * size));
            health = Blocks.carbideWall.health * size * size;
            armor = Blocks.carbideWall.armor;
        }};

        carbideWallGigantic = new Wall("carbide-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.carbideWall.requirements, size * size));
            health = Blocks.carbideWall.health * size * size;
            armor = Blocks.carbideWall.armor;
        }};

        reinforcedSurgeWallHuge = new Wall("reinforced-surge-wall-huge") {{
            size = 3;
            requirements(Category.defense, ItemStack.mult(Blocks.reinforcedSurgeWall.requirements, size * size));
            health = Blocks.reinforcedSurgeWall.health * size * size;
            armor = Blocks.reinforcedSurgeWall.armor;
            lightningChance = ((Wall) Blocks.reinforcedSurgeWall).lightningChance;
            lightningDamage = ((Wall) Blocks.reinforcedSurgeWall).lightningDamage;
        }};

        reinforcedSurgeWallGigantic = new Wall("reinforced-surge-wall-gigantic") {{
            size = 4;
            requirements(Category.defense, ItemStack.mult(Blocks.reinforcedSurgeWall.requirements, size * size));
            health = Blocks.reinforcedSurgeWall.health * size * size;
            armor = Blocks.reinforcedSurgeWall.armor;
            lightningChance = ((Wall) Blocks.reinforcedSurgeWall).lightningChance;
            lightningDamage = ((Wall) Blocks.reinforcedSurgeWall).lightningDamage;
        }};

        // TODO 13.09.2025: Add walls to research tree
    }
}
