package com.team.group_final_project.modular_tools;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.item.properties.select.SelectItemModelProperty;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import org.jspecify.annotations.Nullable;

public record ModularToolModelProperty() implements SelectItemModelProperty<String> {

    public static final SelectItemModelProperty.Type<ModularToolModelProperty, String> TYPE =
            SelectItemModelProperty.Type.create(
                    MapCodec.unit(new ModularToolModelProperty()),
                    Codec.STRING
            );

    @Nullable
    @Override
    public String get(
            ItemStack stack,
            @Nullable ClientLevel level,
            @Nullable LivingEntity entity,
            int seed,
            ItemDisplayContext displayContext
    ) {
        ModularToolParts parts =
                stack.get(ModDataComponents.MODULAR_TOOL_PARTS.get());

        if (parts == null || parts.equals(ModularToolParts.EMPTY)) {
            return null;
        }

        return parts.head()
                + "|"
                + parts.handle()
                + "|"
                + parts.binding();
    }
    @Override
    public Codec<String> valueCodec() {
        return Codec.STRING;
    }

    @Override
    public SelectItemModelProperty.Type<ModularToolModelProperty, String> type() {
        return TYPE;
    }
}