package space.modtest.world.blocks.power;

import arc.Core;
import arc.graphics.Texture;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.TextureRegion;
import arc.math.Mathf;
import arc.util.Time;
import mindustry.graphics.Drawf;
import space.modtest.content.TestLiquids;
import arc.Core.*;

import static arc.Core.atlas;

public class SteamEngineGenerator extends SingleLiquidGenerator{

    public TextureRegion topRegion;
    public TextureRegion liquidRegion = Core.atlas.find(name+"-liquid");

    private float timeDrilled = 0;
    private float rotateSpeed = 0;

    public SteamEngineGenerator(String name) {
        super(name);
    }

    @Override
    public void load() {
        super.load();
        topRegion = atlas.find("steam-engine-top");
    }

    public class SteamEngineGeneratorBuild extends SingleLiquidGeneratorBuild {
        @Override
        public void updateTile() {
            super.updateTile();
            float calculationDelta = delta();
            if (liquids.get(TestLiquids.steam) >= 0.001f) {
                timeDrilled+=calculationDelta;
            }
        }

        @Override
        public void draw(){
            super.draw();
            //Drawf.liquid(liquidRegion, x, y, liquids.total() / liquidCapacity, liquids.current().color);
            Draw.rect(topRegion, x, y, 45);
        }
    }
}
