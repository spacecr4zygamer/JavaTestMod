package space.modtest.content;

import arc.graphics.Color;
import mindustry.ctype.ContentList;
import mindustry.type.Liquid;

public class TestLiquids implements ContentList {
    public static Liquid steam;

    @Override
    public void load() {
        steam = new Liquid("Steam"){{
           flammability = 0;
           explosiveness = 0.2f;
           viscosity = 0.01f;
           color = Color.valueOf("bfbfbf");
           barColor = Color.valueOf("8f8f8f");
           lightColor = Color.valueOf("e6e6e6");
        }};
    }
}
