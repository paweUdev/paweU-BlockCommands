package pl.paweu.blockcommands.config;

import org.bukkit.configuration.file.FileConfiguration;
import pl.paweu.blockcommands.BlockCommandsPlugin;

import java.util.List;

public class Settings {

    private BlockCommandsPlugin plugin;

    public String permission;
    public String permissionError;
    public List<String> commands;

    public Settings(BlockCommandsPlugin plugin){
        this.plugin = plugin;
    }

    public void load(){
        FileConfiguration config = plugin.getConfig();
        plugin.saveDefaultConfig();
        permission = config.getString("permission");
        permissionError = config.getString("permissionError");
        commands = config.getStringList("commands");
    }
}
