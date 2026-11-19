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

    // Add the different tiers of axe heads
    public static final DeferredItem<ToolHeadItem> WOODEN_AXE_HEAD =
            ITEMS.registerItem("wooden_axe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.AXE, ToolMaterialType.WOOD));

    public static final DeferredItem<ToolHeadItem> STONE_AXE_HEAD =
            ITEMS.registerItem("stone_axe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.AXE, ToolMaterialType.STONE));

    public static final DeferredItem<ToolHeadItem> COPPER_AXE_HEAD =
            ITEMS.registerItem("copper_axe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.AXE, ToolMaterialType.COPPER));

    public static final DeferredItem<ToolHeadItem> IRON_AXE_HEAD =
            ITEMS.registerItem("iron_axe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.AXE, ToolMaterialType.IRON));

    public static final DeferredItem<ToolHeadItem> GOLD_AXE_HEAD =
            ITEMS.registerItem("gold_axe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.AXE, ToolMaterialType.GOLD));

    public static final DeferredItem<ToolHeadItem> DIAMOND_AXE_HEAD =
            ITEMS.registerItem("diamond_axe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.AXE, ToolMaterialType.DIAMOND));

    public static final DeferredItem<ToolHeadItem> NETHERITE_AXE_HEAD =
            ITEMS.registerItem("netherite_axe_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.AXE, ToolMaterialType.NETHERITE));

    // Add the different tiers of shovel heads
    public static final DeferredItem<ToolHeadItem> WOODEN_SHOVEL_HEAD =
            ITEMS.registerItem("wooden_shovel_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SHOVEL, ToolMaterialType.WOOD));

    public static final DeferredItem<ToolHeadItem> STONE_SHOVEL_HEAD =
            ITEMS.registerItem("stone_shovel_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SHOVEL, ToolMaterialType.STONE));

    public static final DeferredItem<ToolHeadItem> COPPER_SHOVEL_HEAD =
            ITEMS.registerItem("copper_shovel_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SHOVEL, ToolMaterialType.COPPER));

    public static final DeferredItem<ToolHeadItem> IRON_SHOVEL_HEAD =
            ITEMS.registerItem("iron_shovel_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SHOVEL, ToolMaterialType.IRON));

    public static final DeferredItem<ToolHeadItem> GOLD_SHOVEL_HEAD =
            ITEMS.registerItem("gold_shovel_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SHOVEL, ToolMaterialType.GOLD));

    public static final DeferredItem<ToolHeadItem> DIAMOND_SHOVEL_HEAD =
            ITEMS.registerItem("diamond_shovel_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SHOVEL, ToolMaterialType.DIAMOND));

    public static final DeferredItem<ToolHeadItem> NETHERITE_SHOVEL_HEAD =
            ITEMS.registerItem("netherite_shovel_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SHOVEL, ToolMaterialType.NETHERITE));

    // Add the different tiers of sword heads
    public static final DeferredItem<ToolHeadItem> WOODEN_SWORD_HEAD =
            ITEMS.registerItem("wooden_sword_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SWORD, ToolMaterialType.WOOD));

    public static final DeferredItem<ToolHeadItem> STONE_SWORD_HEAD =
            ITEMS.registerItem("stone_sword_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SWORD, ToolMaterialType.STONE));

    public static final DeferredItem<ToolHeadItem> COPPER_SWORD_HEAD =
            ITEMS.registerItem("copper_sword_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SWORD, ToolMaterialType.COPPER));

    public static final DeferredItem<ToolHeadItem> IRON_SWORD_HEAD =
            ITEMS.registerItem("iron_sword_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SWORD, ToolMaterialType.IRON));

    public static final DeferredItem<ToolHeadItem> GOLD_SWORD_HEAD =
            ITEMS.registerItem("gold_sword_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SWORD, ToolMaterialType.GOLD));

    public static final DeferredItem<ToolHeadItem> DIAMOND_SWORD_HEAD =
            ITEMS.registerItem("diamond_sword_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SWORD, ToolMaterialType.DIAMOND));

    public static final DeferredItem<ToolHeadItem> NETHERITE_SWORD_HEAD =
            ITEMS.registerItem("netherite_sword_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SWORD, ToolMaterialType.NETHERITE));

    // Add the different tiers of spear heads
    public static final DeferredItem<ToolHeadItem> WOODEN_SPEAR_HEAD =
            ITEMS.registerItem("wooden_spear_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SPEAR, ToolMaterialType.WOOD));

    public static final DeferredItem<ToolHeadItem> STONE_SPEAR_HEAD =
            ITEMS.registerItem("stone_spear_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SPEAR, ToolMaterialType.STONE));

    public static final DeferredItem<ToolHeadItem> COPPER_SPEAR_HEAD =
            ITEMS.registerItem("copper_spear_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SPEAR, ToolMaterialType.COPPER));

    public static final DeferredItem<ToolHeadItem> IRON_SPEAR_HEAD =
            ITEMS.registerItem("iron_spear_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SPEAR, ToolMaterialType.IRON));

    public static final DeferredItem<ToolHeadItem> GOLD_SPEAR_HEAD =
            ITEMS.registerItem("gold_spear_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SPEAR, ToolMaterialType.GOLD));

    public static final DeferredItem<ToolHeadItem> DIAMOND_SPEAR_HEAD =
            ITEMS.registerItem("diamond_spear_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SPEAR, ToolMaterialType.DIAMOND));

    public static final DeferredItem<ToolHeadItem> NETHERITE_SPEAR_HEAD =
            ITEMS.registerItem("netherite_spear_head",
                    properties -> new ToolHeadItem(properties, ToolHeadType.SPEAR, ToolMaterialType.NETHERITE));

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
