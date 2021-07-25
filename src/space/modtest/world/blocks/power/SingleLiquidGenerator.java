package space.modtest.world.blocks.power;

import arc.graphics.g2d.TextureRegion;
import arc.util.Nullable;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.world.blocks.power.ItemLiquidGenerator;
import mindustry.world.meta.Stat;
import mindustry.world.meta.StatUnit;

public class SingleLiquidGenerator extends ItemLiquidGenerator {

    public SingleLiquidGenerator(String name) {
        super(false,true,name);
        defaults = true;
        hasItems = false;
        hasLiquids = true;
    }

    @Override
    public void setStats() {
        super.setStats();

        if (hasLiquids){
            stats.add(Stat.productionTime,powerProduction*60.0f, StatUnit.seconds);
        }
    }

    @Override
    protected float getItemEfficiency(Item item){
        return 0f;
    }

    @Override
    protected float getLiquidEfficiency(Liquid liquid){
        return 1f;
    }

    public class SingleLiquidGeneratorBuild extends ItemLiquidGeneratorBuild {

    }

    //TODO - Add spinning top icon
}
