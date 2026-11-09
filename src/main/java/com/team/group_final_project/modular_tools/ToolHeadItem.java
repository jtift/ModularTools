package com.team.group_final_project.modular_tools;

public class ToolHeadItem extends ToolPartItem {

    private final ToolHeadType headType;

    public ToolHeadItem(Properties properties, ToolHeadType headType, ToolMaterialType materialType) {
        super(properties, ToolPartType.HEAD, materialType);
        this.headType = headType;
    }

    public ToolHeadType getHeadType() {
        return headType;
    }
}
