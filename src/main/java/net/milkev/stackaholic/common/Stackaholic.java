package net.milkev.stackaholic.common;

import com.google.common.base.Predicates;
import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.registry.Registries;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Stackaholic implements ModInitializer {


	public static final String MOD_ID = "stackaholic";
	
	@Override
	public void onInitialize() {
        
		AutoConfig.register(ModConfig.class, JanksonConfigSerializer::new);
		ModConfig config = AutoConfig.getConfigHolder(ModConfig.class).getConfig();
        
        DefaultItemComponentEvents.MODIFY.register(context -> context.modify(Predicates.alwaysTrue(), ((builder, item) -> {
            if ((config.enableGlobalStackIncrease && item.getMaxCount() != 1 && item.getMaxCount() != 64) 
                    || (config.forcedStack64.contains(Registries.ITEM.getId(item).toString()))) {
                builder.add(DataComponentTypes.MAX_STACK_SIZE, 64);
            }
        })));
        
    }
    
}
