package space.modtest.content;

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
        }};
    }
}
