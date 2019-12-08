package com.blotz.blockproj.setup;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.item.minecart.MinecartCommandBlockEntity;
import net.minecraft.world.World;

public class ClientProxy implements IProxy {
    @Override
    public World getClientWorld() {
        return Minecraft.getInstance().world;
    }
}
