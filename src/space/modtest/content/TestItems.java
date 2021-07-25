package space.modtest.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Item;
import mindustry.type.Liquid;

public class TestItems implements ContentList {
    public static Item safiteore;

    @Override
    public void load() {
    safiteore = new Item("safite-ore"){{
        localizedName = "Safite Ore";
        description = "Ore that can be crushed";
        color = Color.valueOf("bfbfbf");
        alwaysUnlocked = true;
    }};

    }
}
