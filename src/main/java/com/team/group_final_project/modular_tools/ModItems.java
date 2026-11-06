package com.team.group_final_project.modular_tools;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ModularTools.MODID);

    public static final DeferredItem<ModularToolItem> MODULAR_TOOL =
            ITEMS.registerItem("modular_tool",
                        properties -> new ModularToolItem(properties.stacksTo(1)));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
