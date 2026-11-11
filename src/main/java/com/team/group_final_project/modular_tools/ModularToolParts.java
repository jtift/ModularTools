package com.team.group_final_project.modular_tools;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

public record ModularToolParts(
        String head,
        String handle,
        String binding
) {
    public static final ModularToolParts EMPTY =
            new ModularToolParts("", "", "");

    public static final Codec<ModularToolParts> CODEC =
            RecordCodecBuilder.create(instance -> instance.group(
                    Codec.STRING.fieldOf("head").forGetter(ModularToolParts::head),
                    Codec.STRING.fieldOf("handle").forGetter(ModularToolParts::handle),
                    Codec.STRING.fieldOf("binding").forGetter(ModularToolParts::binding)
            ).apply(instance, ModularToolParts::new));
}
