package com.cleanroommc.relauncher;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiIngameMenu;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.client.event.GuiScreenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;


@Mod(modid = "cleanroom-relauncher", name = "Cleanroom Relauncher", version = "0.3.2")
public class OptionsMenuHandler {

    private static final int RELAUNCHER_BUTTON_ID = 989;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new OptionsMenuHandler());
        CleanroomRelauncher.LOGGER.info("Pre-Init Event has fired Relauncher");
    }


    @SubscribeEvent
    public void onGuiInit(GuiScreenEvent.InitGuiEvent.Post event) {
        GuiScreen gui = event.getGui();
        CleanroomRelauncher.LOGGER.info("Cleanroom Relauncher button has been Created!");
        if (gui instanceof GuiMainMenu || gui instanceof GuiIngameMenu) {

            String targetText = "Mods";

            List<GuiButton> buttons = event.getButtonList();
            for (GuiButton b : buttons) {
                if (targetText.equals(b.displayString)) {
                    buttons.removeIf(btn -> btn.id == RELAUNCHER_BUTTON_ID);

                    GuiButton relauncherBtn = new GuiButton(
                            RELAUNCHER_BUTTON_ID,
                            b.x - 24,
                            b.y,
                            20, 20, "§bB"
                    );

                    buttons.add(relauncherBtn);
                    return;
                }
            }
        }
    }
    @SubscribeEvent
    public void onActionPerformed(GuiScreenEvent.ActionPerformedEvent.Post event) {
        if (event.getButton().id == RELAUNCHER_BUTTON_ID) {
            new Thread(() -> {
            }).start();
        }
    }

}