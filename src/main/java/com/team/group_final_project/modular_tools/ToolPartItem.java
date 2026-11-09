package com.team.group_final_project.modular_tools;

import net.minecraft.world.item.Item;

public class ToolPartItem extends Item {

    private final ToolPartType partType;
    private final ToolMaterialType materialType;

    public ToolPartItem(Properties properties, ToolPartType partType, ToolMaterialType materialType) {
        super(properties);
        this.partType = partType;
        this.materialType = materialType;
    }

    public ToolPartType getPartType() {
        return partType;
    }

    public ToolMaterialType getMaterialType() {
        return materialType;
    }
}
