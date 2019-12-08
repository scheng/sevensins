package com.blotz.blockproj.sevensins;

import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class gluttony {
    int level = -1;
    @SubscribeEvent
    public void fat(TickEvent.PlayerTickEvent event) {
        if (level < 20 && event.player.getFoodStats().getFoodLevel() == 20) {
            event.player.sendMessage(new StringTextComponent("Gluttony? Suffer the consequences of your insatiable appetite!"));
            event.player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 1800));
        }
        level = event.player.getFoodStats().getFoodLevel();
    }
}
