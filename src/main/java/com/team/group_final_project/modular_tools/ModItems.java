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

    public static final DeferredItem<ToolHeadItem> IRON_PICKAXE_HEAD =
            ITEMS.registerItem("iron_pickaxe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.PICKAXE, ToolMaterialType.IRON));

    public static final DeferredItem<ToolHandleItem> WOODEN_HANDLE =
            ITEMS.registerItem("wooden_handle",
                    properties -> new ToolHandleItem(properties, ToolMaterialType.WOOD));

    public static final DeferredItem<ToolBindingItem> WOODEN_BINDING =
            ITEMS.registerItem("wooden_binding",
                    properties -> new ToolBindingItem(properties, ToolMaterialType.WOOD));

    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
