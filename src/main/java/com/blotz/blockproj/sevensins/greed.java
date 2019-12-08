package com.blotz.blockproj.sevensins;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.stream.Stream;

public class greed {
    @SubscribeEvent
    public void diamonds(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() != Blocks.DIAMOND_ORE) {
            return ;
        }
        event.getPlayer().sendMessage(new StringTextComponent("Greedy, eh? If it's diamonds you want, it's diamonds you'll get!"));

        if (!event.getWorld().isRemote()) {
            ZombieEntity z = new ZombieEntity(event.getWorld().getWorld());
            z.setPosition(event.getPos().getX(), event.getPos().getY(), event.getPos().getZ());
            z.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.DIAMOND_SWORD));
            z.setItemStackToSlot(EquipmentSlotType.HEAD, new ItemStack(Items.DIAMOND_HELMET));
            z.setItemStackToSlot(EquipmentSlotType.CHEST, new ItemStack(Items.DIAMOND_CHESTPLATE));
            z.setItemStackToSlot(EquipmentSlotType.LEGS, new ItemStack(Items.DIAMOND_LEGGINGS));
            z.setItemStackToSlot(EquipmentSlotType.FEET, new ItemStack(Items.DIAMOND_BOOTS));
            z.setItemStackToSlot(EquipmentSlotType.OFFHAND, new ItemStack(Items.DIAMOND_BLOCK));
            event.getWorld().addEntity(z);
        }
    }
}
