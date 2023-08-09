package net.outssiss.tutorialmod;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.outssiss.tutorialmod.item.ModCreativeModeTabs;
import net.outssiss.tutorialmod.item.ModItems;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TutorialMod.MODID)
public class TutorialMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tutorialmod";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public TutorialMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    private void addCreative(CreativeModeTabEvent.BuildContents event)
    {
        if (event.getTab() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.BLACK_OPAL);
            event.accept(ModItems.RAW_BLACK_OPAL);

        }
        if(event.getTab() == ModCreativeModeTabs.TUTORIAL_TAB) {
            event.accept(ModItems.BLACK_OPAL);
            event.accept(ModItems.RAW_BLACK_OPAL);
        }
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
