package com.blotz.blockproj.sevensins;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class envy {
    boolean wear = false; //what if the player is already wearing elytra? oh well
    //turns it out works anyway? Maybe the armor is equipped as part of the init process or something

    @SubscribeEvent
    public void flight(TickEvent.PlayerTickEvent event) {
        final PlayerEntity p = event.player;
        if (p.getItemStackFromSlot(EquipmentSlotType.CHEST).isItemEqual(new ItemStack(Items.ELYTRA))) {
            p.setSprinting(false);
        }
    }

    @SubscribeEvent
    public void change(TickEvent.PlayerTickEvent event) {
        if (!event.player.world.isRemote) {
            final PlayerEntity p = event.player;
            if (!wear && p.getItemStackFromSlot(EquipmentSlotType.CHEST).isItemEqual(new ItemStack(Items.ELYTRA))) {
                p.sendMessage(new StringTextComponent("Envious of the birds? Then stay away from the ground!"));
                wear = true;
            } else if (wear && !p.getItemStackFromSlot(EquipmentSlotType.CHEST).isItemEqual(new ItemStack(Items.ELYTRA))) {
                p.sendMessage(new StringTextComponent("Welcome back to land."));
                wear = false;
            }
        }
    }
}
