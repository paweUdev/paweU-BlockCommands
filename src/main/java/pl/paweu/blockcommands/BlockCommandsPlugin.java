package pl.paweu.blockcommands;

import org.bukkit.plugin.java.JavaPlugin;
import pl.paweu.blockcommands.config.Settings;
import pl.paweu.blockcommands.listener.PlayerCommandPreProcessListener;

public final class BlockCommandsPlugin extends JavaPlugin {

    private Settings settings;

    @Override
    public void onEnable() {
        this.settings = new Settings(this);
        this.settings.load();
        this.getServer().getPluginManager().registerEvents(new PlayerCommandPreProcessListener(this.settings), this);
    }
}
