package space.modtest.world.blocks.power;

import arc.Core;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.type.Item;
import mindustry.type.Liquid;
import mindustry.world.blocks.power.ItemLiquidGenerator;
import mindustry.world.meta.*;

import static mindustry.Vars.*;

public class SingleLiquidGenerator extends ItemLiquidGenerator {

    public SingleLiquidGenerator(String name) {
        super(false, true, name);
        defaults = true;
        hasItems = false;
        hasLiquids = true;
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
        @Override
        public void updateTile(){

            //Note: Do not use this delta when calculating the amount of power or the power efficiency, but use it for resource consumption if necessary.
            //Power amount is delta'd by PowerGraph class already.
            float calculationDelta = delta();
            boolean cons = consValid();

            generateTime = 0.1f;

            heat = Mathf.lerpDelta(heat, generateTime >= 0.001f && enabled && cons ? 1f : 0f, 0.05f);

            if(!cons){
                productionEfficiency = 0.0f;
                return;
            }
            

            Liquid liquid = null;
            for(Liquid other : content.liquids()){
                if(hasLiquids && liquids.get(other) >= 0.001f && getLiquidEfficiency(other) >= minLiquidEfficiency){
                    liquid = other;
                    break;
                }
            }

            totalTime += heat * Time.delta;

            //liquid takes priority over solids
            if(hasLiquids && liquid != null && liquids.get(liquid) >= 0.001f){
                float baseLiquidEfficiency = getLiquidEfficiency(liquid);
                float maximumPossible = maxLiquidGenerate * calculationDelta;
                float used = Math.min(liquids.get(liquid) * calculationDelta, maximumPossible);

                liquids.remove(liquid, used * power.graph.getUsageFraction());
                productionEfficiency = baseLiquidEfficiency * used / maximumPossible;
                if (liquids.get(liquid)>=0f) {
                    //generateTime = 1f;
                }

                if(used > 0.001f && Mathf.chance(0.05 * delta())){
                    generateEffect.at(x + Mathf.range(3f), y + Mathf.range(3f));
                }
            }else if(hasItems){
                // No liquids accepted or none supplied, try using items if accepted
                if(generateTime <= 0f && items.total() > 0){
                    generateEffect.at(x + Mathf.range(3f), y + Mathf.range(3f));
                    Item item = items.take();
                    productionEfficiency = getItemEfficiency(item);
                    explosiveness = item.explosiveness;
                    generateTime = 1f;
                }

                if(generateTime > 0f){
                    generateTime -= Math.min(1f / itemDuration * delta() * power.graph.getUsageFraction(), generateTime);

                    if(randomlyExplode && state.rules.reactorExplosions && Mathf.chance(delta() * 0.06 * Mathf.clamp(explosiveness - 0.5f))){
                        //this block is run last so that in the event of a block destruction, no code relies on the block type
                        Core.app.post(() -> {
                            damage(Mathf.random(11f));
                            explodeEffect.at(x + Mathf.range(size * tilesize / 2f), y + Mathf.range(size * tilesize / 2f));
                        });
                    }
                }else{
                    productionEfficiency = 0.0f;
                }
            }
        }
    }

    //TODO - Add spinning top icon
}
