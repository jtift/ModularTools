package com.team.group_final_project.modular_tools;

import net.minecraft.world.item.ItemStack;
import net.minecraft.core.registries.BuiltInRegistries;

public class ModularToolAssembler {

    public static boolean isValidAssembly(
            ItemStack headStack,
            ItemStack handleStack,
            ItemStack bindingStack
    ) {
        if (!(headStack.getItem() instanceof ToolPartItem head)) {
            return false;
        }

        if (!(handleStack.getItem() instanceof ToolPartItem handle)) {
            return false;
        }

        if (!(bindingStack.getItem() instanceof ToolPartItem binding)) {
            return false;
        }

        return head.getPartType() == ToolPartType.HEAD
                && handle.getPartType() == ToolPartType.HANDLE
                && binding.getPartType() == ToolPartType.BINDING;
    }

    public static ModularToolParts createParts(
            ItemStack headStack,
            ItemStack handleStack,
            ItemStack bindingStack
    ) {
        if (!isValidAssembly(headStack, handleStack, bindingStack)) {
            return ModularToolParts.EMPTY;
        }

        String headId = BuiltInRegistries.ITEM.getKey(headStack.getItem()).toString();
        String handleId = BuiltInRegistries.ITEM.getKey(handleStack.getItem()).toString();
        String bindingId = BuiltInRegistries.ITEM.getKey(bindingStack.getItem()).toString();

        return new ModularToolParts(
                headId,
                handleId,
                bindingId
        );
    }
    public static boolean assemble(
            ItemStack toolStack,
            ItemStack headStack,
            ItemStack handleStack,
            ItemStack bindingStack
    ) {
        if (!(toolStack.getItem() instanceof ModularToolItem modularTool)) {
            return false;
        }

        if (!isValidAssembly(headStack, handleStack, bindingStack)) {
            return false;
        }

        ModularToolParts parts =
                createParts(headStack, handleStack, bindingStack);

        modularTool.setParts(toolStack, parts);

        return true;
    }
}