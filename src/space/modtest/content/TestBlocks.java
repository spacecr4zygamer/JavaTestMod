package space.modtest.content;

import arc.graphics.g2d.TextureRegion;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.content.TechTree;
import mindustry.ctype.ContentList;
import mindustry.entities.Effect;
import mindustry.gen.Sounds;
import mindustry.type.*;
import mindustry.world.Block;
import mindustry.world.blocks.environment.OreBlock;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.consumers.ConsumePower;
import mindustry.world.consumers.Consumers;
import mindustry.world.draw.DrawAnimation;
import mindustry.world.draw.DrawRotator;
import mindustry.world.draw.DrawWeave;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;
import space.modtest.world.blocks.power.SingleLiquidGenerator;

import java.util.function.Consumer;

import static mindustry.type.ItemStack.with;

public class TestBlocks implements ContentList {

    // power
    public static Block steamengine, boiler, safite, burnerfurnace, crusher, washingplant, blastfurnace;

    @Override
    public void load() {
        steamengine = new SingleLiquidGenerator("steam-engine"){
            {
                minLiquidEfficiency = 0f;
                maxLiquidGenerate = 1f;
                health = 150;
                ambientSound = Sounds.machine;
                ambientSoundVolume = 0.03f;
                requirements(Category.power,with(Items.lead,15,Items.silicon,10));
                buildVisibility = BuildVisibility.shown;
                group = BlockGroup.power;
                consumes.liquid(TestLiquids.steam,0.25f);
                outputsPower = true;
                consumesPower = false;
                hasPower = true;
                size = 3;
                powerProduction = 10;
                liquidCapacity = 180;
                randomlyExplode = false;
        }};
        boiler = new GenericCrafter("boiler"){{
            health = 100;
            requirements(Category.crafting,with(Items.lead,20,Items.copper,15));
            buildVisibility = BuildVisibility.shown;
            group = BlockGroup.none;
            outputsLiquid = true;
            drawer = new DrawRotator();
            LiquidStack steam = new LiquidStack(TestLiquids.steam,90);
            outputLiquid = steam;
            craftEffect = Fx.cloudsmoke;
            ambientSound = Sounds.combustion;
            ambientSoundVolume = 0.04f;
            size = 2;
            liquidCapacity = 100;
            consumes.liquid(Liquids.water,0.5f);
            consumes.item(Items.coal,1);
            craftTime = 30;
        }};

        crusher = new GenericCrafter("crusher"){{
            localizedName = "Crusher";
            health = 100;
            outputsPower = false;
            consumesPower = false;
            hasPower = false;
            drawer = new DrawRotator();
            ambientSound = Sounds.grinding;
            ambientSoundVolume = 0.04f;
            requirements(Category.crafting,with(Items.lead,20,Items.copper,15));
            buildVisibility = BuildVisibility.shown;
            group = BlockGroup.none;
            alwaysUnlocked = true;
            outputsLiquid = false;
            ItemStack crushedsafite = new ItemStack(TestItems.crushedsafite, 1);
            outputItem = crushedsafite;
            craftEffect = Fx.cloudsmoke;
            size = 2;
            liquidCapacity = 0;
            consumes.items(with(Items.coal, 1, TestItems.safiteore, 2));
            craftTime = 30;
        }};

        washingplant = new GenericCrafter("washing-plant"){{
            localizedName = "Washing Plant";
            health = 100;
            outputsPower = false;
            consumesPower = true;
            hasPower = true;
            ambientSound = Sounds.splash;
            ambientSoundVolume = 0.04f;
            requirements(Category.crafting,with(Items.lead,20,Items.copper,15));
            buildVisibility = BuildVisibility.shown;
            group = BlockGroup.none;
            alwaysUnlocked = false;
            outputsLiquid = false;
            ItemStack washedsafite = new ItemStack(TestItems.washedsafite, 1);
            outputItem = washedsafite;
            craftEffect = Fx.cloudsmoke;
            size = 3;
            liquidCapacity = 100;
            consumes.liquid(Liquids.water,0.5f);
            consumes.power(0.5f);
            consumes.item(TestItems.crushedsafite, 2);
            craftTime = 30;
        }};

        blastfurnace = new GenericCrafter("blast-furnace"){{
            localizedName = "Blast Furnace";
            health = 100;
            outputsPower = false;
            consumesPower = true;
            hasPower = true;
            ambientSound = Sounds.fire;
            ambientSoundVolume = 0.04f;
            requirements(Category.crafting,with(Items.lead,20,Items.copper,15));
            buildVisibility = BuildVisibility.shown;
            group = BlockGroup.none;
            alwaysUnlocked = false;
            outputsLiquid = false;
            ItemStack blastedsafite = new ItemStack(TestItems.blastedsafite, 1);
            outputItem = blastedsafite;
            craftEffect = Fx.cloudsmoke;
            size = 4;
            liquidCapacity = 100;
            consumes.liquid(TestLiquids.sulfuricacid,0.5f);
            consumes.power(0.5f);
            consumes.item(TestItems.washedsafite, 2);
            craftTime = 30;
        }};

        burnerfurnace = new SingleLiquidGenerator("burner-furnace"){{
            localizedName = "Burner Furnace";
            minLiquidEfficiency = 0f;
            maxLiquidGenerate = 0f;
            health = 50;
            ambientSound = Sounds.fire;
            ambientSoundVolume = 0.04f;
            requirements(Category.power,with(Items.lead,15,Items.silicon,10));
            buildVisibility = BuildVisibility.shown;
            alwaysUnlocked = true;
            group = BlockGroup.power;
            consumes.item(Items.coal, 2);
            outputsPower = true;
            consumesPower = false;
            hasPower = true;
            size = 3;
            powerProduction = 10;
            liquidCapacity = 0;
            randomlyExplode = false;
        }};

        safite = new OreBlock("safite"){{
            localizedName = "Safite";
            oreDefault = true;
            oreThreshold = 0.78f;
            oreScale = 20;
            playerUnmineable = false;
            itemDrop = TestItems.safiteore;
            variants = 3;
        }};
    }
}
