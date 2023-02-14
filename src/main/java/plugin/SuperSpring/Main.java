package plugin.SuperSpring;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Loaded.");
        Bukkit.getPluginManager().registerEvents(new MoveListener(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
