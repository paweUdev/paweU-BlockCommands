package pl.paweu.blockcommands.util;

import org.bukkit.ChatColor;

public final class ChatUtil {

    public static String fixColor(String message){
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
