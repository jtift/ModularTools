package com.team.group_final_project.modular_tools;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;

public class AssemblyTableBlockEntity extends BlockEntity implements MenuProvider {

    public static final int TOOL_SLOT = 0;
    public static final int HEAD_SLOT = 1;
    public static final int HANDLE_SLOT = 2;
    public static final int BINDING_SLOT = 3;

    private final SimpleContainer inventory = new SimpleContainer(4);

    public AssemblyTableBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.ASSEMBLY_TABLE.get(), pos, state);
    }
    public SimpleContainer getInventory() {
        return inventory;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Assembly Table");
    }

    @Override
    public AbstractContainerMenu createMenu(int containerId, Inventory playerInventory, Player player)
    {
        return new AssemblyTableMenu(containerId, playerInventory, inventory, ContainerLevelAccess.create(this.getLevel(), this.getBlockPos()));
    }

    @Override
    protected void loadAdditional(ValueInput input) {
        super.loadAdditional(input);

        ValueInput.TypedInputList<ItemStack> items =
                input.listOrEmpty("Items", ItemStack.OPTIONAL_CODEC);

        inventory.fromItemList(items);
    }

    @Override
    protected void saveAdditional(ValueOutput output) {
        super.saveAdditional(output);

        ValueOutput.TypedOutputList<ItemStack> items =
                output.list("Items", ItemStack.OPTIONAL_CODEC);

        inventory.storeAsItemList(items);
    }
}