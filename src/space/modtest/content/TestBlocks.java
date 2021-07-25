package space.modtest.content;

import mindustry.ctype.ContentList;
import mindustry.world.Block;
import space.modtest.world.blocks.power.SingleLiquidGenerator;

public class TestBlocks implements ContentList {

    // power
    public static Block SingleLiquidGenerator;

    @Override
    public void load() {
        SingleLiquidGenerator = new SingleLiquidGenerator("SingleLiquidGenerator"){{
            
        }};
    }
}
