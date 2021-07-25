package space.modtest.content;

import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.Liquid;
import mindustry.world.Block;
import mindustry.world.consumers.Consumers;
import mindustry.world.meta.BlockGroup;
import mindustry.world.meta.BuildVisibility;
import space.modtest.world.blocks.power.SingleLiquidGenerator;

import java.security.acl.Group;
import java.util.function.Consumer;

import static mindustry.type.ItemStack.with;

public class TestBlocks implements ContentList {

    // power
    public static Block steamengine;

    @Override
    public void load() {
        steamengine = new SingleLiquidGenerator("steam-engine"){{
            health = 150;
            requirements(Category.power,with(Items.lead,15,Items.silicon,10));
            buildVisibility = BuildVisibility.shown;
            group = BlockGroup.power;
            consumes.liquid(TestLiquids.steam,1);
            outputsPower = true;
            consumesPower = false;
            hasPower = true;
            size = 3;
            powerProduction = 10;

        }};
    }
}
