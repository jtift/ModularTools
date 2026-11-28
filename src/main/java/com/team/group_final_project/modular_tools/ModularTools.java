package com.team.group_final_project.modular_tools;

import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.neoforged.neoforge.client.event.RegisterSelectItemModelPropertyEvent;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(ModularTools.MODID)
public class ModularTools {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "modular_tools";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();


    // Create a Deferred Register to hold CreativeModeTabs which will all be registered under the "modular_tools" namespace
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID);

    // Added the Creative Tab
    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MODULAR_TOOLS_TAB =
            CREATIVE_MODE_TABS.register("modular_tools_tab", () -> CreativeModeTab.builder().title(Component.translatable("creativetab.modular_tools")).icon(() -> ModItems.MODULAR_TOOL.get().getDefaultInstance()).displayItems((parameters, output) -> {

                                // Main items
                                output.accept(ModItems.MODULAR_TOOL.get());
                                output.accept(ModItems.ASSEMBLY_TABLE.get());

                                // Handles
                                output.accept(ModItems.WOODEN_HANDLE.get());
                                output.accept(ModItems.STONE_HANDLE.get());
                                output.accept(ModItems.COPPER_HANDLE.get());
                                output.accept(ModItems.IRON_HANDLE.get());
                                output.accept(ModItems.GOLDEN_HANDLE.get());
                                output.accept(ModItems.DIAMOND_HANDLE.get());
                                output.accept(ModItems.NETHERITE_HANDLE.get());

                                // Bindings
                                output.accept(ModItems.WOODEN_BINDING.get());
                                output.accept(ModItems.STONE_BINDING.get());
                                output.accept(ModItems.COPPER_BINDING.get());
                                output.accept(ModItems.IRON_BINDING.get());
                                output.accept(ModItems.GOLDEN_BINDING.get());
                                output.accept(ModItems.DIAMOND_BINDING.get());
                                output.accept(ModItems.NETHERITE_BINDING.get());

                                // Pickaxe Heads
                                output.accept(ModItems.WOODEN_PICKAXE_HEAD.get());
                                output.accept(ModItems.STONE_PICKAXE_HEAD.get());
                                output.accept(ModItems.COPPER_PICKAXE_HEAD.get());
                                output.accept(ModItems.IRON_PICKAXE_HEAD.get());
                                output.accept(ModItems.GOLDEN_PICKAXE_HEAD.get());
                                output.accept(ModItems.DIAMOND_PICKAXE_HEAD.get());
                                output.accept(ModItems.NETHERITE_PICKAXE_HEAD.get());

                                // Axe Heads
                                output.accept(ModItems.WOODEN_AXE_HEAD.get());
                                output.accept(ModItems.STONE_AXE_HEAD.get());
                                output.accept(ModItems.COPPER_AXE_HEAD.get());
                                output.accept(ModItems.IRON_AXE_HEAD.get());
                                output.accept(ModItems.GOLDEN_AXE_HEAD.get());
                                output.accept(ModItems.DIAMOND_AXE_HEAD.get());
                                output.accept(ModItems.NETHERITE_AXE_HEAD.get());

                                // Shovel Heads
                                output.accept(ModItems.WOODEN_SHOVEL_HEAD.get());
                                output.accept(ModItems.STONE_SHOVEL_HEAD.get());
                                output.accept(ModItems.COPPER_SHOVEL_HEAD.get());
                                output.accept(ModItems.IRON_SHOVEL_HEAD.get());
                                output.accept(ModItems.GOLDEN_SHOVEL_HEAD.get());
                                output.accept(ModItems.DIAMOND_SHOVEL_HEAD.get());
                                output.accept(ModItems.NETHERITE_SHOVEL_HEAD.get());

                                // Sword Heads
                                output.accept(ModItems.WOODEN_SWORD_HEAD.get());
                                output.accept(ModItems.STONE_SWORD_HEAD.get());
                                output.accept(ModItems.COPPER_SWORD_HEAD.get());
                                output.accept(ModItems.IRON_SWORD_HEAD.get());
                                output.accept(ModItems.GOLDEN_SWORD_HEAD.get());
                                output.accept(ModItems.DIAMOND_SWORD_HEAD.get());
                                output.accept(ModItems.NETHERITE_SWORD_HEAD.get());

                                // Spear Heads
                                output.accept(ModItems.WOODEN_SPEAR_HEAD.get());
                                output.accept(ModItems.STONE_SPEAR_HEAD.get());
                                output.accept(ModItems.COPPER_SPEAR_HEAD.get());
                                output.accept(ModItems.IRON_SPEAR_HEAD.get());
                                output.accept(ModItems.GOLDEN_SPEAR_HEAD.get());
                                output.accept(ModItems.DIAMOND_SPEAR_HEAD.get());
                                output.accept(ModItems.NETHERITE_SPEAR_HEAD.get());
                            })
                            .build());

    private static void registerSelectItemModelProperties(RegisterSelectItemModelPropertyEvent event)
    {
        event.register(Identifier.fromNamespaceAndPath(MODID, "modular_tool_parts"), ModularToolModelProperty.TYPE);

        event.register(Identifier.fromNamespaceAndPath(MODID, "modular_tool_head"), ModularToolHeadModelProperty.TYPE);

        event.register(Identifier.fromNamespaceAndPath(MODID, "modular_tool_handle"), ModularToolHandleModelProperty.TYPE);

        event.register(Identifier.fromNamespaceAndPath(MODID, "modular_tool_binding"), ModularToolBindingModelProperty.TYPE);

        event.register(Identifier.fromNamespaceAndPath(MODID, "modular_tool_shovel"), ModularToolIsShovelModelProperty.TYPE);

        event.register(Identifier.fromNamespaceAndPath(MODID, "modular_tool_sword"), ModularToolsIsSwordModelProperty.TYPE);

        event.register(Identifier.fromNamespaceAndPath(MODID, "modular_tool_spear"),ModularToolsIsSpearProperty.TYPE);
    }

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public ModularTools(IEventBus modEventBus) {

        modEventBus.addListener(ModularTools::registerSelectItemModelProperties);
        // Register the Deferred Register to the mod event bus so blocks get registered
        ModBlocks.register(modEventBus);
        // Register the mod's items
        ModItems.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModDataComponents.register(modEventBus);
        // Register the Deferred Register to the mod event bus so tabs get registered
        CREATIVE_MODE_TABS.register(modEventBus);
    }
}
