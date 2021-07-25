package space.modtest.content;

import arc.graphics.g2d.TextureRegion;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.entities.Effect;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.consumers.Consumers;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;
import space.modtest.world.blocks.power.SingleLiquidGenerator;

import java.security.acl.Group;
import java.util.function.Consumer;

import static mindustry.type.ItemStack.with;

public class TestBlocks implements ContentList {

    // power
    public static Block steamengine, boiler;

    @Override
    public void load() {
        steamengine = new SingleLiquidGenerator("steam-engine"){

            {
                minLiquidEfficiency = 0f;
                maxLiquidGenerate = 1f;
                health = 150;
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
            LiquidStack steam = new LiquidStack(TestLiquids.steam,90);
            outputLiquid = steam;
            craftEffect = Fx.cloudsmoke;
            size = 2;
            liquidCapacity = 100;
            consumes.liquid(Liquids.water,0.5f);
            consumes.item(Items.coal,1);
            craftTime = 30;
        }};
    }
}
