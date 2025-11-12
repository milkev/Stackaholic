package net.milkev.stackaholic.common;

import com.google.common.base.Predicates;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.minecraft.component.DataComponentTypes;

public class Stackaholic implements ModInitializer {


	public static final String MOD_ID = "stackaholic";
	
	@Override
	public void onInitialize() {
		
		DefaultItemComponentEvents.MODIFY.register(context -> context.modify(Predicates.alwaysTrue(), ((builder, item) -> {
			if(item.getMaxCount() != 1) {
				builder.add(DataComponentTypes.MAX_STACK_SIZE, 64);
			}
		})));
		
		System.out.println(MOD_ID + " Initialized");
	}


}
