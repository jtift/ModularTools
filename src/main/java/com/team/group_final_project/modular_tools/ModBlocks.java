package com.team.group_final_project.modular_tools;

import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocks {

    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(ModularTools.MODID);

    public static final DeferredBlock<AssemblyTableBlock> ASSEMBLY_TABLE =
            BLOCKS.registerBlock("assembly_table", AssemblyTableBlock::new, properties -> properties.mapColor(MapColor.WOOD).strength(2.5F));
    public static void register(IEventBus modEventBus) {
        BLOCKS.register(modEventBus);
    }
}
