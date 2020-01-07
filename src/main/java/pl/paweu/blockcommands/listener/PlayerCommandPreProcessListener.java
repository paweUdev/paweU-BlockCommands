package pl.paweu.blockcommands.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import pl.paweu.blockcommands.config.Settings;

import static pl.paweu.blockcommands.util.ChatUtil.fixColor;

public class PlayerCommandPreProcessListener implements Listener {

    private Settings settings;

    public PlayerCommandPreProcessListener(Settings settings){
        this.settings = settings;
    }

    @EventHandler
    public void onCommand(PlayerCommandPreprocessEvent event){
        Player player = event.getPlayer();
        String command = event.getMessage().split(" ")[0];
        if(player.hasPermission(this.settings.permission)) return;
        for(String cmd : this.settings.commands){
            if(command.startsWith(cmd)){
                event.setCancelled(true);
                player.sendMessage(fixColor(this.settings.permissionError.replace("{PERMISSION}", this.settings.permission)));
            }
        }
    }
}
