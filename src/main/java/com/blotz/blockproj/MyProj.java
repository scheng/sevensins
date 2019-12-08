package com.blotz.blockproj;

import com.blotz.blockproj.blocks.*;
import com.blotz.blockproj.setup.ClientProxy;
import com.blotz.blockproj.setup.IProxy;
import com.blotz.blockproj.setup.ServerProxy;
import com.blotz.blockproj.sevensins.*;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("blockproj")
public class MyProj
{
    public static IProxy proxy = DistExecutor.runForDist(() ->() -> new ClientProxy(), () -> () -> new ServerProxy());
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public MyProj() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new greed());
        MinecraftForge.EVENT_BUS.register(new envy());
        MinecraftForge.EVENT_BUS.register(new lust());
        MinecraftForge.EVENT_BUS.register(new gluttony());
        MinecraftForge.EVENT_BUS.register(new pride());
    }

    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            event.getRegistry().register(new block1());
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            event.getRegistry().register(new BlockItem(ModBlocks.BLOCK1, new Item.Properties()).setRegistryName("block1"));
        }
    }
}
