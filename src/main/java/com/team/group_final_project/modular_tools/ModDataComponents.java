package com.team.group_final_project.modular_tools;

import net.minecraft.core.component.DataComponentType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.minecraft.core.registries.Registries;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModDataComponents {

    public static final DeferredRegister.DataComponents DATA_COMPONENTS =
            DeferredRegister.createDataComponents(Registries.DATA_COMPONENT_TYPE, ModularTools.MODID);

    public static final DeferredHolder<DataComponentType<?>, DataComponentType<ModularToolParts>> MODULAR_TOOL_PARTS =
            DATA_COMPONENTS.registerComponentType("modular_tool_parts",
                    builder -> builder.persistent(ModularToolParts.CODEC));

    public static void register(IEventBus modEventBus) {
        DATA_COMPONENTS.register(modEventBus);
    }
}
