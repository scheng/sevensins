package com.blotz.blockproj.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class block1 extends Block {
    public block1 () {
        super(Properties.create(Material.IRON)
                .sound(SoundType.ANVIL)
                .hardnessAndResistance(2.0f)
                .lightValue(1)
        );
        setRegistryName("block1");
    }
}
