package space.modtest;

import arc.struct.Seq;
import arc.util.Log;
import mindustry.Vars;
import mindustry.ctype.ContentList;
import mindustry.mod.Mod;
import space.modtest.content.TestBlocks;
import space.modtest.content.TestItems;
import space.modtest.content.TestLiquids;
import space.modtest.world.blocks.power.SingleLiquidGenerator;


public class Main extends Mod{
    public static final String modname = "YeaTest";

    public static final Seq<ContentList> contentLists = Seq.with(
            new TestLiquids(),
            new TestItems(),
            new TestBlocks()
    );


    public Main() {
        super();
        Log.info("I need help otherwise?");
        //I need help D:
    }

    @Override
    public void init(){
        Vars.enableConsole = true;
        Log.info("I need help");
    }

    @Override
    public void loadContent(){
        for(ContentList list : contentLists) {
            list.load();
        }
    }
}
