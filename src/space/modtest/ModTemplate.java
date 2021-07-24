package space.modtest;

import arc.util.Log;
import mindustry.mod.Mod;

public class ModTemplate extends Mod{

    public ModTemplate() {
        Log.info("I need help otherwise?");
    }

    @Override
    public void init(){
        Log.info("I need help");
    }

    @Override
    public void loadContent(){

    }
}
