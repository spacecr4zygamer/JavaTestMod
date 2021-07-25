package space.modtest.world.blocks.power;

import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.world.blocks.power.ItemLiquidGenerator;

public class SingleLiquidGenerator extends ItemLiquidGenerator {

    public SingleLiquidGenerator(String name) {
        super(name);
        defaults = true;
    }

    @Override
    protected float getItemEfficiency(Item item){
        return 0f;
    }

    @Override
    protected float getLiquidEfficiency(Liquid liquid){
        return 1f;
    }

}
