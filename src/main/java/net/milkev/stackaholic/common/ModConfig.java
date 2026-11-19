package net.milkev.stackaholic.common;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.cloth.clothconfig.shadowed.blue.endless.jankson.Comment;

import java.util.ArrayList;
import java.util.List;

@Config(name="stackaholic")
public class ModConfig implements ConfigData {
    @Comment("Wether or not any item with a stack size over 1 will be changed to have a stack size of 64. Default: True")
    public boolean enableGlobalStackIncrease = true;
    @Comment("List of item ID's that will be forced to stack to 64 even if the items default stack size is 1. must match exactly. Default: none")
    public List<String> forcedStack64 = new ArrayList<>();
}
