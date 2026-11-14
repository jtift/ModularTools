package com.team.group_final_project.modular_tools;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class ModularToolItem extends Item {
    public ModularToolItem(Properties properties) {
        super(properties);
    }
    public ModularToolParts getParts(ItemStack stack) {
        ModularToolParts parts =
                stack.get(ModDataComponents.MODULAR_TOOL_PARTS.get());

        return parts != null ? parts : ModularToolParts.EMPTY;
    }
    public void setParts(ItemStack stack, ModularToolParts parts) {
        stack.set(ModDataComponents.MODULAR_TOOL_PARTS.get(), parts);
    }
}




