package space.modtest.content;

import arc.graphics.Color;
import mindustry.content.Items;
import mindustry.ctype.ContentList;
import mindustry.type.Item;
import mindustry.type.Liquid;

public class TestItems implements ContentList {
    public static Item safiteore,crushedsafite,washedsafite,blastedsafite,purifiedsafite;

    @Override
    public void load() {
        safiteore = new Item("safite-ore"){{
            localizedName = "Safite Ore";
            description = "Ore that can be crushed";
            color = Color.valueOf("bfbfbf");
            alwaysUnlocked = true;
        }};

        crushedsafite = new Item("crushed-safite"){{
            localizedName = "Crushed Safite";
            description = "Crushed Safite that can be melted into ingots or sorted.";
            color = Color.valueOf("bfbfbf");
            alwaysUnlocked = false;
        }};

        washedsafite = new Item("washed-safite"){{
            localizedName = "Washed Safite";
            description = "Washed Safite that can be dryed/sorted or smelthed for 2x ingots.";
            color = Color.valueOf("bfbfbf");
            alwaysUnlocked = false;
        }};

        blastedsafite = new Item("blasted-safite"){{
            localizedName = "Blasted Safite";
            description = "Blasted Safite that can be mixed or smelthed for 3x ingots.";
            color = Color.valueOf("bfbfbf");
            alwaysUnlocked = false;
        }};

        purifiedsafite = new Item("purified-safite"){{
            localizedName = "Purified Safite";
            description = "Purifled Safite that can be smelthed for 5x ingots.";
            color = Color.valueOf("bfbfbf");
            alwaysUnlocked = false;
        }};

    }
}
