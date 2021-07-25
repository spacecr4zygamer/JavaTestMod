package space.modtest.content;

import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.world.Block;
import space.modtest.world.blocks.power.SingleLiquidGenerator;

import static mindustry.type.ItemStack.with;

public class TestBlocks implements ContentList {

    // power
    public static Block steamengine;

    @Override
    public void load() {
        steamengine = new SingleLiquidGenerator("Steam Engine"){{
            health = 150;
            requirements(Category.power,with(Items.lead,15,Items.silicon,10));
            outputsPower = true;
            consumesPower = false;
            hasPower = true;
            size = 2;
            powerProduction = 10;
        }};
    }
}
