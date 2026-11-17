package com.team.group_final_project.modular_tools;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;

public class AssemblyTableScreen extends AbstractContainerScreen<AssemblyTableMenu> {

    public AssemblyTableScreen(AssemblyTableMenu menu, Inventory inventory, Component title)
    {
        super(menu, inventory, title, 176, 184);

        // Hide the default labels because we draw our own below.
        this.titleLabelX = -1000;
        this.inventoryLabelX = -1000;
    }

    @Override
    protected void init() {
        super.init();

        this.addRenderableWidget(Button.builder(Component.literal("Assemble"), button -> {
            if (this.minecraft != null && this.minecraft.gameMode != null) {

                this.minecraft.gameMode.handleInventoryButtonClick(this.menu.containerId, AssemblyTableMenu.ASSEMBLE_BUTTON_ID);
            }
        }
        ).bounds(this.leftPos + 53, this.topPos + 72, 70, 20).build());
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor graphics, int mouseX, int mouseY, float partialTick)
    {
        int left = this.leftPos;
        int top = this.topPos;

        // Main GUI background
        graphics.fill(left, top, left + this.imageWidth, top + this.imageHeight, 0xFFF1F1F1);

        // Outer border
        graphics.outline(left, top, this.imageWidth, this.imageHeight, 0xFF4A4A4A);

        // Title bar
        graphics.fill(left + 1, top + 1, left + this.imageWidth - 1, top + 24, 0xFF454545);

        // Assembly section
        graphics.fill(left + 12, top + 27, left + 164, top + 66, 0xFFD3D3D3);

        graphics.outline(left + 12, top + 27, 152, 39, 0xFF777777);

        // Assembly slots
        drawSlotBackground(graphics, left + 26, top + 42);
        drawSlotBackground(graphics, left + 62, top + 42);
        drawSlotBackground(graphics, left + 98, top + 42);
        drawSlotBackground(graphics, left + 134, top + 42);

        // Player inventory: 3 rows of 9
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 9; column++) {
                drawSlotBackground(graphics, left + 8 + column * 18, top + 102 + row * 18);
            }
        }

        // Player hotbar: 1 row of 9
        for (int column = 0; column < 9; column++) {
            drawSlotBackground(graphics, left + 8 + column * 18, top + 160);
        }

        // Render Minecraft's slots/items/tooltips/widgets.
        super.extractRenderState(graphics, mouseX, mouseY, partialTick);

        // Custom visible title
        graphics.text(this.font, Component.literal("Assembly Table"), left + 8, top + 8, 0xFFFFFFFF, true);

        // Assembly labels
        drawCenteredSlotLabel(graphics, "Tool", left + 34, top + 29);

        drawCenteredSlotLabel(graphics, "Head", left + 70, top + 29);

        drawCenteredSlotLabel(graphics, "Handle", left + 106, top + 29);

        drawCenteredSlotLabel(graphics, "Bind", left + 142, top + 29);

        // Custom inventory label
        graphics.text(this.font, Component.literal("Inventory"), left + 8, top + 91, 0xFF202020, false);
    }

    private void drawSlotBackground(GuiGraphicsExtractor graphics, int slotX, int slotY)
    {
        // Dark outer frame
        graphics.fill(slotX - 1, slotY - 1, slotX + 17, slotY + 17, 0xFF555555);

        // Light slot interior
        graphics.fill(slotX, slotY, slotX + 16, slotY + 16, 0xFFB8B8B8);
    }
    private void drawCenteredSlotLabel(GuiGraphicsExtractor graphics, String label, int slotCenterX, int y)
    {
        int textWidth = this.font.width(label);
        int textX = slotCenterX - textWidth / 2;

        graphics.text(this.font, Component.literal(label), textX, y, 0xFF202020, false);
    }
}