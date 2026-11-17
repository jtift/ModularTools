package com.team.group_final_project.modular_tools;

import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class AssemblyTableMenu extends AbstractContainerMenu {

    public static final int ASSEMBLE_BUTTON_ID = 0;
    private final ContainerLevelAccess access;

    public AssemblyTableMenu(int containerId, Inventory inventory) {
        this(containerId, inventory, new SimpleContainer(4), ContainerLevelAccess.NULL);
    }

    public AssemblyTableMenu(int containerId, Inventory playerInventory, Container container, ContainerLevelAccess access)
    {
        super(ModMenuTypes.ASSEMBLY_TABLE.get(), containerId);

        this.access = access;

        checkContainerSize(container, 4);

        // Modular Tool slot
        this.addSlot(new Slot(container, AssemblyTableBlockEntity.TOOL_SLOT, 26, 42)
        {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof ModularToolItem;
            }
        });

        // Head slot
        this.addSlot(new Slot(container, AssemblyTableBlockEntity.HEAD_SLOT, 62, 42)
        {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof ToolPartItem part && part.getPartType() == ToolPartType.HEAD;
            }
        });

        // Handle slot
        this.addSlot(new Slot(container, AssemblyTableBlockEntity.HANDLE_SLOT, 98, 42)
        {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof ToolPartItem part && part.getPartType() == ToolPartType.HANDLE;
            }
        });

        // Binding slot
        this.addSlot(new Slot(container, AssemblyTableBlockEntity.BINDING_SLOT, 134, 42)
        {
            @Override
            public boolean mayPlace(ItemStack stack) {
                return stack.getItem() instanceof ToolPartItem part && part.getPartType() == ToolPartType.BINDING;
            }
        });

        // Player inventory and hotbar
        this.addStandardInventorySlots(playerInventory, 8, 102);
    }

    @Override
    public boolean stillValid(Player player) {
        return stillValid(this.access,player, ModBlocks.ASSEMBLY_TABLE.get());
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        Slot sourceSlot = this.slots.get(index);

        if (!sourceSlot.hasItem()) {
            return ItemStack.EMPTY;
        }

        ItemStack sourceStack = sourceSlot.getItem();
        ItemStack originalStack = sourceStack.copy();

        // Shift-clicking from an Assembly Table slot
        // sends the item back into the player's inventory.
        if (index >= 0 && index < 4) {
            if (!this.moveItemStackTo(sourceStack, 4, this.slots.size(), true))
            {
                return ItemStack.EMPTY;
            }
        }

        // Shift-clicking from the player's inventory.
        else {
            boolean moved;

            if (sourceStack.getItem() instanceof ModularToolItem) {
                moved = this.moveItemStackTo(sourceStack, AssemblyTableBlockEntity.TOOL_SLOT, AssemblyTableBlockEntity.TOOL_SLOT + 1, false);
            }

            else if (sourceStack.getItem() instanceof ToolPartItem part) {
                moved = switch (part.getPartType()) {
                    case HEAD -> this.moveItemStackTo(sourceStack, AssemblyTableBlockEntity.HEAD_SLOT, AssemblyTableBlockEntity.HEAD_SLOT + 1, false);

                    case HANDLE -> this.moveItemStackTo(sourceStack, AssemblyTableBlockEntity.HANDLE_SLOT, AssemblyTableBlockEntity.HANDLE_SLOT + 1, false);

                    case BINDING -> this.moveItemStackTo(sourceStack, AssemblyTableBlockEntity.BINDING_SLOT, AssemblyTableBlockEntity.BINDING_SLOT + 1, false);
                };
            }

            else {
                moved = false;
            }

            if (!moved) {
                return ItemStack.EMPTY;
            }
        }

        if (sourceStack.isEmpty()) {
            sourceSlot.setByPlayer(ItemStack.EMPTY);
        } else {
            sourceSlot.setChanged();
        }

        sourceSlot.onTake(player, sourceStack);

        return originalStack;
    }

    @Override
    public boolean clickMenuButton(Player player, int id) {
        if (id != ASSEMBLE_BUTTON_ID) {
            return false;
        }

        ItemStack toolStack =
                this.getSlot(AssemblyTableBlockEntity.TOOL_SLOT).getItem();

        ItemStack headStack =
                this.getSlot(AssemblyTableBlockEntity.HEAD_SLOT).getItem();

        ItemStack handleStack =
                this.getSlot(AssemblyTableBlockEntity.HANDLE_SLOT).getItem();

        ItemStack bindingStack =
                this.getSlot(AssemblyTableBlockEntity.BINDING_SLOT).getItem();

        if (toolStack.getItem() instanceof ModularToolItem modularTool) {
            ModularToolParts existingParts = modularTool.getParts(toolStack);

            if (!existingParts.equals(ModularToolParts.EMPTY)) {
                return false;
            }
        }

        boolean assembled = ModularToolAssembler.assemble(toolStack, headStack, handleStack, bindingStack);

        if (assembled) {
            headStack.shrink(1);
            handleStack.shrink(1);
            bindingStack.shrink(1);

            this.getSlot(AssemblyTableBlockEntity.HEAD_SLOT).setChanged();
            this.getSlot(AssemblyTableBlockEntity.HANDLE_SLOT).setChanged();
            this.getSlot(AssemblyTableBlockEntity.BINDING_SLOT).setChanged();

            this.broadcastChanges();
        }

        return assembled;
    }
}