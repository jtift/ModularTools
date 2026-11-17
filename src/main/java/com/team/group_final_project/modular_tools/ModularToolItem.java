package com.team.group_final_project.modular_tools;

import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

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

    public void applyIronPickaxeBehavior(ItemStack stack) {
        ItemStack ironPickaxe = new ItemStack(Items.IRON_PICKAXE);

        copyComponent(ironPickaxe, stack, DataComponents.MAX_DAMAGE);

        copyComponent(ironPickaxe, stack, DataComponents.DAMAGE);

        copyComponent(ironPickaxe, stack, DataComponents.REPAIRABLE);

        copyComponent(ironPickaxe, stack, DataComponents.ENCHANTABLE);

        copyComponent(ironPickaxe, stack, DataComponents.TOOL);

        copyComponent(ironPickaxe, stack, DataComponents.ATTRIBUTE_MODIFIERS);

        copyComponent(ironPickaxe, stack, DataComponents.WEAPON);
    }

    private <T> void copyComponent(ItemStack source, ItemStack target, DataComponentType<T> componentType)
    {
        T value = source.get(componentType);

        if (value != null) {
            target.set(componentType, value);
        }
    }
    private String formatPartName(String id) {
        if (id == null || id.isBlank()) {
            return "None";
        }

        int colonIndex = id.indexOf(':');

        String path = colonIndex >= 0
                ? id.substring(colonIndex + 1)
                : id;

        String[] words = path.split("_");
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            if (!word.isEmpty()) {
                if (!result.isEmpty()) {
                    result.append(" ");
                }

                result.append(
                        Character.toUpperCase(word.charAt(0))
                );

                if (word.length() > 1) {
                    result.append(word.substring(1));
                }
            }
        }

        return result.toString();
    }
    @Override
    public void appendHoverText(ItemStack itemStack, TooltipContext context, TooltipDisplay display, Consumer<Component> builder, TooltipFlag tooltipFlag)
    {
        super.appendHoverText(itemStack, context, display, builder, tooltipFlag);

        ModularToolParts parts = getParts(itemStack);

        if (parts.equals(ModularToolParts.EMPTY)) {
            builder.accept(Component.literal("Unassembled"));
            return;
        }

        builder.accept(Component.literal("Head: " + formatPartName(parts.head())));

        builder.accept(Component.literal("Handle: " + formatPartName(parts.handle())));

        builder.accept(Component.literal("Binding: " + formatPartName(parts.binding())));
    }
}




