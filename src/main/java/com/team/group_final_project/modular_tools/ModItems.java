package com.team.group_final_project.modular_tools;

import net.minecraft.world.item.BlockItem;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

    public static final DeferredRegister.Items ITEMS =
            DeferredRegister.createItems(ModularTools.MODID);

    // Add the modular tool item itself
    public static final DeferredItem<ModularToolItem> MODULAR_TOOL =
            ITEMS.registerItem("modular_tool",
                        properties -> new ModularToolItem(properties.stacksTo(1)
                                .component(ModDataComponents.MODULAR_TOOL_PARTS.get(),ModularToolParts.EMPTY)));

    // Add the different tiers of pickaxe heads
    public static final DeferredItem<ToolHeadItem> WOODEN_PICKAXE_HEAD =
            ITEMS.registerItem("wooden_pickaxe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.PICKAXE, ToolMaterialType.WOOD));

    public static final DeferredItem<ToolHeadItem> STONE_PICKAXE_HEAD =
            ITEMS.registerItem("stone_pickaxe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.PICKAXE, ToolMaterialType.STONE));

    public static final DeferredItem<ToolHeadItem> COPPER_PICKAXE_HEAD =
            ITEMS.registerItem("copper_pickaxe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.PICKAXE, ToolMaterialType.COPPER));

    public static final DeferredItem<ToolHeadItem> IRON_PICKAXE_HEAD =
            ITEMS.registerItem("iron_pickaxe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.PICKAXE, ToolMaterialType.IRON));

    public static final DeferredItem<ToolHeadItem> GOLD_PICKAXE_HEAD =
            ITEMS.registerItem("gold_pickaxe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.PICKAXE, ToolMaterialType.GOLD));

    public static final DeferredItem<ToolHeadItem> DIAMOND_PICKAXE_HEAD =
            ITEMS.registerItem("diamond_pickaxe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.PICKAXE, ToolMaterialType.DIAMOND));

    public static final DeferredItem<ToolHeadItem> NETHERITE_PICKAXE_HEAD =
            ITEMS.registerItem("netherite_pickaxe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.PICKAXE, ToolMaterialType.NETHERITE));

    // Add the different tiers of handles
    public static final DeferredItem<ToolHandleItem> WOODEN_HANDLE =
            ITEMS.registerItem("wooden_handle",
                    properties -> new ToolHandleItem(properties, ToolMaterialType.WOOD));

    public static final DeferredItem<ToolHandleItem> STONE_HANDLE =
            ITEMS.registerItem("stone_handle",
                    properties -> new ToolHandleItem(properties, ToolMaterialType.STONE));

    public static final DeferredItem<ToolHandleItem> COPPER_HANDLE =
            ITEMS.registerItem("copper_handle",
                    properties -> new ToolHandleItem(properties, ToolMaterialType.COPPER));

    public static final DeferredItem<ToolHandleItem> IRON_HANDLE =
            ITEMS.registerItem("iron_handle",
                    properties -> new ToolHandleItem(properties, ToolMaterialType.IRON));

    public static final DeferredItem<ToolHandleItem> GOLD_HANDLE =
            ITEMS.registerItem("gold_handle",
                    properties -> new ToolHandleItem(properties, ToolMaterialType.GOLD));

    public static final DeferredItem<ToolHandleItem> DIAMOND_HANDLE =
            ITEMS.registerItem("diamond_handle",
                    properties -> new ToolHandleItem(properties, ToolMaterialType.DIAMOND));

    public static final DeferredItem<ToolHandleItem> NETHERITE_HANDLE =
            ITEMS.registerItem("netherite_handle",
                    properties -> new ToolHandleItem(properties, ToolMaterialType.NETHERITE));

    // Add the different tiers of bindings
    public static final DeferredItem<ToolBindingItem> WOODEN_BINDING =
            ITEMS.registerItem("wooden_binding",
                    properties -> new ToolBindingItem(properties, ToolMaterialType.WOOD));

    public static final DeferredItem<ToolBindingItem> STONE_BINDING =
            ITEMS.registerItem("stone_binding",
                    properties -> new ToolBindingItem(properties, ToolMaterialType.STONE));

    public static final DeferredItem<ToolBindingItem> COPPER_BINDING =
            ITEMS.registerItem("copper_binding",
                    properties -> new ToolBindingItem(properties, ToolMaterialType.COPPER));

    public static final DeferredItem<ToolBindingItem> IRON_BINDING =
            ITEMS.registerItem("iron_binding",
                    properties -> new ToolBindingItem(properties, ToolMaterialType.IRON));

    public static final DeferredItem<ToolBindingItem> GOLD_BINDING =
            ITEMS.registerItem("gold_binding",
                    properties -> new ToolBindingItem(properties, ToolMaterialType.GOLD));

    public static final DeferredItem<ToolBindingItem> DIAMOND_BINDING =
            ITEMS.registerItem("diamond_binding",
                    properties -> new ToolBindingItem(properties, ToolMaterialType.DIAMOND));

    public static final DeferredItem<ToolBindingItem> NETHERITE_BINDING =
            ITEMS.registerItem("netherite_binding",
                    properties -> new ToolBindingItem(properties, ToolMaterialType.NETHERITE));

    // Add the assembly table block
    public static final DeferredItem<BlockItem> ASSEMBLY_TABLE =
            ITEMS.registerSimpleBlockItem("assembly_table", ModBlocks.ASSEMBLY_TABLE);


    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }
}
