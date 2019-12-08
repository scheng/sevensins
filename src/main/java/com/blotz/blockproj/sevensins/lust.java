package com.blotz.blockproj.sevensins;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class lust {
    @SubscribeEvent
    public void hoe(PlayerEvent.ItemCraftedEvent event) {
        if (!event.getCrafting().isItemEqual(new ItemStack(Items.DIAMOND_HOE))) {
            return;
        }

        if (!event.getPlayer().world.isRemote()) {
            event.getPlayer().sendMessage(new StringTextComponent("Lusting after hoes? I'll give you a bang you'll never forget."));
            double[] x_c = {-1, 0, 0, 1};
            double[] z_c = {0, -1, 1, 0};
            for (int i = 0; i < 4; i++) {
                CreeperEntity c = new CreeperEntity(EntityType.CREEPER, event.getPlayer().getEntityWorld());
                c.setPosition(event.getPlayer().posX + x_c[i], event.getPlayer().posY, event.getPlayer().posZ + z_c[i]);
                event.getPlayer().getEntityWorld().addEntity(c);
            }
        }
    }
}
