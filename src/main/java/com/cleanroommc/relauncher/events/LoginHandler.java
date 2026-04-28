package com.cleanroommc.relauncher.events;

import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;

import static com.cleanroommc.relauncher.CleanroomRelauncher.CONFIG;

public class LoginHandler {
    @SubscribeEvent
    public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if(!CONFIG.getLatestCleanroomVersion().equals(CONFIG.getCleanroomVersion()) && CONFIG.getLoginNotifications()) {
            ITextComponent textComponent = new TextComponentString(TextFormatting.AQUA + "[CleanroomRelauncher] " + TextFormatting.WHITE + "A new version of Cleanroom is available!");
            event.player.sendMessage(textComponent);
        }
    }
}
