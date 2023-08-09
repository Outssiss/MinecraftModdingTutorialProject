package net.outssiss.tutorialmod.item;

import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.outssiss.tutorialmod.TutorialMod;

@Mod.EventBusSubscriber(modid = TutorialMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab TUTORIAL_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        TUTORIAL_TAB = event.registerCreativeModeTab(new ResourceLocation(TutorialMod.MODID, "tutorial_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.BLACK_OPAL.get()))
                        .title(Component.translatable("creativemodetab.balls")));
    }
}