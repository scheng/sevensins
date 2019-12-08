package com.blotz.blockproj.sevensins;

import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class pride {
    @SubscribeEvent
    public void lol(BlockEvent.EntityPlaceEvent event) {
        PlayerEntity p;
        if (event.getEntity() instanceof PlayerEntity) {
            p = (PlayerEntity) event.getEntity();
        }
        else {
            return;
        }
        if (!(event.getPlacedBlock().getBlock().equals(Blocks.DIAMOND_BLOCK) ||
                event.getPlacedBlock().getBlock().equals(Blocks.GOLD_BLOCK) ||
                event.getPlacedBlock().getBlock().equals(Blocks.EMERALD_BLOCK))) {
            return;
        }
        if (!p.getEntityWorld().isRemote()) {
            p.sendMessage(new StringTextComponent("Your pride is nothing but unneeded vanity. Find another place to brag."));
            p.getEntityWorld().setBlockState(event.getPos(), Blocks.COAL_BLOCK.getDefaultState());
        }
    }
}
