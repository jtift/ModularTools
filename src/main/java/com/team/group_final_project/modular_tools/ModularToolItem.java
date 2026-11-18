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

    // This will set the stats of the tool when there is a pickaxe head
    public void applyPickaxeBehavior(ItemStack stack, ModularToolParts parts) {
        // We need to check what the tool head is and set the stats accordingly
        ItemStack toolStats;

        if (parts.head().contains("stone")) {
            toolStats = new ItemStack(Items.STONE_PICKAXE);
        } else if (parts.head().contains("copper")) {
            toolStats = new ItemStack(Items.COPPER_PICKAXE);
        } else if (parts.head().contains("gold")) {
            toolStats = new ItemStack(Items.GOLDEN_PICKAXE);
        } else if (parts.head().contains("iron")) {
            toolStats = new ItemStack(Items.IRON_PICKAXE);
        } else if (parts.head().contains("diamond")) {
            toolStats = new ItemStack(Items.DIAMOND_PICKAXE);
        } else if (parts.head().contains("netherite")) {
            toolStats = new ItemStack(Items.NETHERITE_PICKAXE);
        } else {
            toolStats = new ItemStack(Items.WOODEN_PICKAXE);
        }

        // Now we need to check what material the binding is made of to add extra durability
        applyBindingBuffs(toolStats, parts);
        applyHandleBuffs(toolStats, parts);

        // Set the stats of the modular tool to the stats in the variable toolStats
        copyComponent(toolStats, stack, DataComponents.MAX_DAMAGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE);
        copyComponent(toolStats, stack, DataComponents.REPAIRABLE);
        copyComponent(toolStats, stack, DataComponents.ENCHANTABLE);
        copyComponent(toolStats, stack, DataComponents.ATTRIBUTE_MODIFIERS);
        copyComponent(toolStats, stack, DataComponents.TOOL);
        copyComponent(toolStats, stack, DataComponents.WEAPON);
        copyComponent(toolStats, stack, DataComponents.ATTACK_RANGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE_TYPE);
        copyComponent(toolStats, stack, DataComponents.MINIMUM_ATTACK_CHARGE);
        copyComponent(toolStats, stack, DataComponents.PIERCING_WEAPON);
        copyComponent(toolStats, stack, DataComponents.KINETIC_WEAPON);
        copyComponent(toolStats, stack, DataComponents.USE_EFFECTS);
    }

    // This will set the stats of the tool when there is an axe head
    public void applyAxeBehavior(ItemStack stack, ModularToolParts parts) {
        // We need to check what the tool head is and set the stats accordingly
        ItemStack toolStats;

        if (parts.head().contains("stone")) {
            toolStats = new ItemStack(Items.STONE_AXE);
        } else if (parts.head().contains("copper")) {
            toolStats = new ItemStack(Items.COPPER_AXE);
        } else if (parts.head().contains("gold")) {
            toolStats = new ItemStack(Items.GOLDEN_AXE);
        } else if (parts.head().contains("iron")) {
            toolStats = new ItemStack(Items.IRON_AXE);
        } else if (parts.head().contains("diamond")) {
            toolStats = new ItemStack(Items.DIAMOND_AXE);
        } else if (parts.head().contains("netherite")) {
            toolStats = new ItemStack(Items.NETHERITE_AXE);
        } else {
            toolStats = new ItemStack(Items.WOODEN_AXE);
        }

        // Now we need to check what material the binding is made of to add extra durability
        applyBindingBuffs(toolStats, parts);
        applyHandleBuffs(toolStats, parts);

        // Set the stats of the modular tool to the stats in the variable toolStats
        copyComponent(toolStats, stack, DataComponents.MAX_DAMAGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE);
        copyComponent(toolStats, stack, DataComponents.REPAIRABLE);
        copyComponent(toolStats, stack, DataComponents.ENCHANTABLE);
        copyComponent(toolStats, stack, DataComponents.ATTRIBUTE_MODIFIERS);
        copyComponent(toolStats, stack, DataComponents.TOOL);
        copyComponent(toolStats, stack, DataComponents.WEAPON);
        copyComponent(toolStats, stack, DataComponents.ATTACK_RANGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE_TYPE);
        copyComponent(toolStats, stack, DataComponents.MINIMUM_ATTACK_CHARGE);
        copyComponent(toolStats, stack, DataComponents.PIERCING_WEAPON);
        copyComponent(toolStats, stack, DataComponents.KINETIC_WEAPON);
        copyComponent(toolStats, stack, DataComponents.USE_EFFECTS);
    }

    // This will set the stats of the tool when there is a shovel head
    public void applyShovelBehavior(ItemStack stack, ModularToolParts parts) {
        // We need to check what the tool head is and set the stats accordingly
        ItemStack toolStats;

        if (parts.head().contains("stone")) {
            toolStats = new ItemStack(Items.STONE_SHOVEL);
        } else if (parts.head().contains("copper")) {
            toolStats = new ItemStack(Items.COPPER_SHOVEL);
        } else if (parts.head().contains("gold")) {
            toolStats = new ItemStack(Items.GOLDEN_SHOVEL);
        } else if (parts.head().contains("iron")) {
            toolStats = new ItemStack(Items.IRON_SHOVEL);
        } else if (parts.head().contains("diamond")) {
            toolStats = new ItemStack(Items.DIAMOND_SHOVEL);
        } else if (parts.head().contains("netherite")) {
            toolStats = new ItemStack(Items.NETHERITE_SHOVEL);
        } else {
            toolStats = new ItemStack(Items.WOODEN_SHOVEL);
        }

        // Now we need to check what material the binding is made of to add extra durability
        applyBindingBuffs(toolStats, parts);
        applyHandleBuffs(toolStats, parts);

        // Set the stats of the modular tool to the stats in the variable toolStats
        copyComponent(toolStats, stack, DataComponents.MAX_DAMAGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE);
        copyComponent(toolStats, stack, DataComponents.REPAIRABLE);
        copyComponent(toolStats, stack, DataComponents.ENCHANTABLE);
        copyComponent(toolStats, stack, DataComponents.ATTRIBUTE_MODIFIERS);
        copyComponent(toolStats, stack, DataComponents.TOOL);
        copyComponent(toolStats, stack, DataComponents.WEAPON);
        copyComponent(toolStats, stack, DataComponents.ATTACK_RANGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE_TYPE);
        copyComponent(toolStats, stack, DataComponents.MINIMUM_ATTACK_CHARGE);
        copyComponent(toolStats, stack, DataComponents.PIERCING_WEAPON);
        copyComponent(toolStats, stack, DataComponents.KINETIC_WEAPON);
        copyComponent(toolStats, stack, DataComponents.USE_EFFECTS);
    }

    // This will set the stats of the tool when there is a sword head
    public void applySwordBehavior(ItemStack stack, ModularToolParts parts) {
        // We need to check what the tool head is and set the stats accordingly
        ItemStack toolStats;

        if (parts.head().contains("stone")) {
            toolStats = new ItemStack(Items.STONE_SWORD);
        } else if (parts.head().contains("copper")) {
            toolStats = new ItemStack(Items.COPPER_SWORD);
        } else if (parts.head().contains("gold")) {
            toolStats = new ItemStack(Items.GOLDEN_SWORD);
        } else if (parts.head().contains("iron")) {
            toolStats = new ItemStack(Items.IRON_SWORD);
        } else if (parts.head().contains("diamond")) {
            toolStats = new ItemStack(Items.DIAMOND_SWORD);
        } else if (parts.head().contains("netherite")) {
            toolStats = new ItemStack(Items.NETHERITE_SWORD);
        } else {
            toolStats = new ItemStack(Items.WOODEN_SWORD);
        }

        // Now we need to check what material the binding is made of to add extra durability
        applyBindingBuffs(toolStats, parts);
        applyHandleBuffs(toolStats, parts);

        // Set the stats of the modular tool to the stats in the variable toolStats
        copyComponent(toolStats, stack, DataComponents.MAX_DAMAGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE);
        copyComponent(toolStats, stack, DataComponents.REPAIRABLE);
        copyComponent(toolStats, stack, DataComponents.ENCHANTABLE);
        copyComponent(toolStats, stack, DataComponents.ATTRIBUTE_MODIFIERS);
        copyComponent(toolStats, stack, DataComponents.TOOL);
        copyComponent(toolStats, stack, DataComponents.WEAPON);
        copyComponent(toolStats, stack, DataComponents.ATTACK_RANGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE_TYPE);
        copyComponent(toolStats, stack, DataComponents.MINIMUM_ATTACK_CHARGE);
        copyComponent(toolStats, stack, DataComponents.PIERCING_WEAPON);
        copyComponent(toolStats, stack, DataComponents.KINETIC_WEAPON);
        copyComponent(toolStats, stack, DataComponents.USE_EFFECTS);
    }

    // This will set the stats of the tool when there is a spear head
    public void applySpearBehavior(ItemStack stack, ModularToolParts parts) {
        // We need to check what the tool head is and set the stats accordingly
        ItemStack toolStats;

        if (parts.head().contains("stone")) {
            toolStats = new ItemStack(Items.STONE_SPEAR);
        } else if (parts.head().contains("copper")) {
            toolStats = new ItemStack(Items.COPPER_SPEAR);
        } else if (parts.head().contains("gold")) {
            toolStats = new ItemStack(Items.GOLDEN_SPEAR);
        } else if (parts.head().contains("iron")) {
            toolStats = new ItemStack(Items.IRON_SPEAR);
        } else if (parts.head().contains("diamond")) {
            toolStats = new ItemStack(Items.DIAMOND_SPEAR);
        } else if (parts.head().contains("netherite")) {
            toolStats = new ItemStack(Items.NETHERITE_SPEAR);
        } else {
            toolStats = new ItemStack(Items.WOODEN_SPEAR);
        }

        // Now we need to check what material the binding is made of to add extra durability
        applyBindingBuffs(toolStats, parts);
        applyHandleBuffs(toolStats, parts);

        // Set the stats of the modular tool to the stats in the variable toolStats
        copyComponent(toolStats, stack, DataComponents.MAX_DAMAGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE);
        copyComponent(toolStats, stack, DataComponents.REPAIRABLE);
        copyComponent(toolStats, stack, DataComponents.ENCHANTABLE);
        copyComponent(toolStats, stack, DataComponents.ATTRIBUTE_MODIFIERS);
        copyComponent(toolStats, stack, DataComponents.TOOL);
        copyComponent(toolStats, stack, DataComponents.WEAPON);
        copyComponent(toolStats, stack, DataComponents.ATTACK_RANGE);
        copyComponent(toolStats, stack, DataComponents.DAMAGE_TYPE);
        copyComponent(toolStats, stack, DataComponents.MINIMUM_ATTACK_CHARGE);
        copyComponent(toolStats, stack, DataComponents.PIERCING_WEAPON);
        copyComponent(toolStats, stack, DataComponents.KINETIC_WEAPON);
        copyComponent(toolStats, stack, DataComponents.USE_EFFECTS);
    }

    private void applyBindingBuffs(ItemStack toolStats, ModularToolParts parts)
    {
        if (parts.binding().contains("stone")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 50);
        } else if (parts.binding().contains("copper")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 100);
        } else if (parts.binding().contains("iron")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 150);
        } else if (parts.binding().contains("diamond")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 400);
        } else if (parts.binding().contains("netherite")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 800);
        }
    }

    private void applyHandleBuffs(ItemStack toolStats, ModularToolParts parts)
    {
        if (parts.handle().contains("stone")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 50);
        } else if (parts.handle().contains("copper")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 100);
        } else if (parts.handle().contains("iron")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 150);
        } else if (parts.handle().contains("diamond")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 400);
        } else if (parts.handle().contains("netherite")) {
            toolStats.set(DataComponents.MAX_DAMAGE, toolStats.get(DataComponents.MAX_DAMAGE) + 800);
        }
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




