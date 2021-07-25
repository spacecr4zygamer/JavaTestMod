package space.modtest.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Liquid;

public class TestLiquids implements ContentList {
    public static Liquid steam,compackedsteam,sulfuricacid,mud;

    @Override
    public void load() {
        steam = new Liquid("steam"){{
           flammability = 0;
           explosiveness = 0.2f;
           viscosity = 0.01f;
           color = Color.valueOf("bfbfbf");
           barColor = Color.valueOf("8f8f8f");
           lightColor = Color.valueOf("e6e6e6");
        }};

        compackedsteam = new Liquid("compacked-steam"){{
            localizedName = "Compacked Steam";
            flammability = 0;
            explosiveness = 0.2f;
            viscosity = 0.01f;
            color = Color.valueOf("757575");
            barColor = Color.valueOf("757575");
            lightColor = Color.valueOf("8a8a8a");
        }};

        sulfuricacid = new Liquid("sulfuric-acid"){{
            localizedName = "Sulfuric Acid";
            flammability = 0;
            explosiveness = 0;
            viscosity = 0;
            color = Color.valueOf("f0e032");
            barColor = Color.valueOf("f0e032");
            lightColor = Color.valueOf("ffee33");
        }};

        mud = new Liquid("Mud"){{
            localizedName = "Mud";
            flammability = 0;
            explosiveness = 0.2f;
            viscosity = 0.01f;
            color = Color.valueOf("7a5910");
            barColor = Color.valueOf("7a5910");
            lightColor = Color.valueOf("967120");
        }};
    }
}
